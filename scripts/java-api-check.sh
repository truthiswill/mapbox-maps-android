#!/usr/bin/env bash

set -Eeuxo pipefail

# Usage:
#   ./java-api-check.sh <current release tag (empty for branches)> <path to current aar> <module name> <optional, path to previously released aar>
#

if [[ ! -f $2 ]]
then
  # Assembled aar located under moduleName/build/outputs/aar/moduleName-release.aar
  echo "$2 does not exists, please provide path to the current sdk-release.aar file, current dir: $(dirname "$0")"
  exit 1
fi

MODULE_NAME=$3

if [ -z "$MODULE_NAME" ]
then
  echo "Please provide the module name"
  exit 1
fi

CURRENT_DIR=$(dirname "$0")
TMPDIR=`mktemp -d`
REPORT_DIR=${CURRENT_DIR}/../api_compat_report/$MODULE_NAME
mkdir -p "${REPORT_DIR}"
mkdir -p "${TMPDIR}"

if ! [ -x "$(command -v revapi.sh)" ]; then
    echo "Revapi is not installed. Please install revapi before running this script"
    exit 1
fi
# Fetched by parent script from circle-ci CIRCLE_TAG env variable,
# if CIRCLE_TAG is not set, TAGGED_RELEASE_VERSION would be empty (branch build).
TAGGED_RELEASE_VERSION=$1
TAGGED_RELEASE_VERSION=${TAGGED_RELEASE_VERSION:8}

mkdir "${TMPDIR}"/current "${TMPDIR}"/previous
cp "$2" "${TMPDIR}"/current/sdk-release.aar
CURRENT_RELEASE=${TMPDIR}/current/sdk-release.aar
PREVIOUS_RELEASE=${TMPDIR}/previous/sdk-release.aar
CURRENT_RELEASE_DIR=$(dirname "${CURRENT_RELEASE}")
PREVIOUS_RELEASE_DIR=$(dirname "${PREVIOUS_RELEASE}")

if [[ -z ${TAGGED_RELEASE_VERSION} ]]; then
# If it is not a tagged release (branch), use LAST_VERSION as a last tag.
    LAST_VERSION=$(git describe --tags --abbrev=0)
else
# Circle-CI release job will have tag that points to the HEAD
# Previous version is last version before current tag.
    LAST_VERSION=$(git describe HEAD~1 --tags --abbrev=0)
fi
LAST_VERSION=${LAST_VERSION:9}

RELEASE_TAG=${4-""}
if [[ -z $RELEASE_TAG ]]; then
  echo "Path to previous version of aar is not set, using ${LAST_VERSION}"
  AAR_PATH="s3://mapbox-api-downloads-production/v2/mobile-maps-android-"${MODULE_NAME}"/releases/android/"${LAST_VERSION}"/maven/maps-"${MODULE_NAME}"-"${LAST_VERSION}".aar"
  if [[ $MODULE_NAME == sdk ]]; then
    AAR_PATH="s3://mapbox-api-downloads-production/v2/mobile-maps-android/releases/android/"${LAST_VERSION}"/maven/android-"${LAST_VERSION}".aar"
  elif [[ $MODULE_NAME == sdk-base ]]; then
    AAR_PATH="s3://mapbox-api-downloads-production/v2/mobile-maps-android-base/releases/android/"${LAST_VERSION}"/maven/base-"${LAST_VERSION}".aar"
  fi
  echo "aar path is: $AAR_PATH, checking file"
  #todo check if file exists on s3
#  aws s3 ls "$AAR_PATH" >/dev/null 2>&1
  echo "Downloading file from s3"
  aws s3 cp "$AAR_PATH" "${PREVIOUS_RELEASE}"
else
    echo "Using the set path for previous release"
  cp "$RELEASE_TAG" "${TMPDIR}"/previous/sdk-release.aar
fi

extract_classess_jar() {
    aar=$1

    tmpdir=$(mktemp -d)
    unzip -qq -d "${tmpdir}" "${aar}" classes.jar

    output=$(mktemp)
    mv "${tmpdir}/classes.jar" "${output}"
    rm -rf "${tmpdir}"

    echo "${output}"
}

parse_json_report() {
    node - <<'EOF' "$1"
const fs = require('fs');

const data = fs.readFileSync(process.argv[2]).toString();
const report = JSON.parse(data);

const issues = report.reduce((acc, r) => {
    const binary = r.classification.find(e => e.compatibility === "BINARY");
    const source = r.classification.find(e => e.compatibility === "SOURCE");
    const semantic = r.classification.find(e => e.compatibility === "SEMANTIC");

    if (binary && binary.severity === "BREAKING") {
        acc.major++;
    } else if (source) {
        if (source.severity === "BREAKING" && semantic && semantic.severity === "BREAKING") {
            acc.major++;
        } else if (source.severity === "BREAKING" && semantic && semantic.severity === "POTENTIALLY_BREAKING") {
            acc.minor++;
        }
    }

    return acc;
}, {minor: 0, major: 0});

console.log(`MAJOR_PROBLEMS=${issues.major}`);
console.log(`MINOR_PROBLEMS=${issues.minor}`);
EOF
}

compare_aars() {
    aar1=$1
    aar2=$2

    if [ -z "$aar1" ] || [ -z "$aar2" ]; then
        echo "Invalid argument. usage: ${FUNCNAME[0]} <old aar> <new aar>"
        exit 1
    fi

    jar1=$(extract_classess_jar "${aar1}")
    jar2=$(extract_classess_jar "${aar2}")
    json_report=$(mktemp)

    revapi.sh \
        --extensions=org.revapi:revapi-java:0.21.0,org.revapi:revapi-reporter-json:0.1.0,org.revapi:revapi-reporter-text:0.11.0 \
        -o "${jar1}" -n "${jar2}" \
        -D revapi.java.missing-classes.behavior=report \
        -D revapi.java.missing-classes.ignoreMissingAnnotations=false \
        -D revapi.java.non-public-part-of-api.report-unchanged=false \
        -D revapi.java.filter.packages.include=\[com.mapbox.maps\] \
        -D revapi.reporter.json.minSeverity=EQUIVALENT \
        -D revapi.reporter.json.output="${json_report}" \
        -D revapi.reporter.text.minSeverity=NON_BREAKING \
        -D revapi.reporter.text.output="${REPORT_DIR}/api_compat.txt" \
        -c ${CURRENT_DIR}/java-api-check.json \
        >&2

    eval "$(parse_json_report "${json_report}")"

    if ((MAJOR_PROBLEMS > 0)); then
        echo major
    elif ((MINOR_PROBLEMS > 0)); then
        echo minor
    else
        echo patch
    fi

    rm "${jar1}" "${jar2}" "${json_report}"
}

api_compat=$(compare_aars "${PREVIOUS_RELEASE}" "${CURRENT_RELEASE}")
rm -rf "${TMPDIR}"
echo "Compare result: $api_compat"
"${CURRENT_DIR}"/semver-check.sh "${TAGGED_RELEASE_VERSION}" "${LAST_VERSION}" "${api_compat}"