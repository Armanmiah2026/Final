#!/bin/sh
APP_HOME=$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)
if ! command -v gradle >/dev/null 2>&1; then
  echo "ERROR: Gradle is not installed/on PATH. Use the included GitHub Actions workflow, which installs Gradle 8.13." >&2
  exit 1
fi
exec gradle -p "$APP_HOME" "$@"
