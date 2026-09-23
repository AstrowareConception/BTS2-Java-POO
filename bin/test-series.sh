#!/usr/bin/env bash
set -euo pipefail

if [[ $# -ne 1 || ! "$1" =~ ^0?[1-5]$ ]]; then
  echo "Usage : $0 <1|2|3|4|5>" >&2
  exit 2
fi

if ! command -v mvn >/dev/null 2>&1; then
  echo "Maven est requis. Consultez docs/ENVIRONNEMENT.md." >&2
  exit 1
fi

series_number="$(printf '%02d' "$((10#$1))")"
case "$series_number" in
  01) module="exercices/serie-01-fondamentaux/starter" ;;
  02) module="exercices/serie-02-poo-uml/starter" ;;
  03) module="exercices/serie-03-collections-tests/starter" ;;
  04) module="exercices/serie-04-javafx-jdbc/starter" ;;
  05) module="exercices/serie-05-rest-spring-e5/starter" ;;
esac

root_dir="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$root_dir/$module"
mvn test
