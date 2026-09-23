#!/usr/bin/env bash
set -euo pipefail

root_dir="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$root_dir"

required=(
  "README.md"
  "pom.xml"
  "docs/PARCOURS_64H.md"
  "exercices/serie-01-fondamentaux/README.md"
  "exercices/serie-02-poo-uml/README.md"
  "exercices/serie-03-collections-tests/README.md"
  "exercices/serie-04-javafx-jdbc/README.md"
  "exercices/serie-05-rest-spring-e5/README.md"
)

for path in "${required[@]}"; do
  if [[ ! -f "$path" ]]; then
    echo "Fichier requis absent : $path" >&2
    exit 1
  fi
done

atelier_count="$(grep -R --include='README.md' -h '^## Atelier [1-6] —' exercices | wc -l | tr -d ' ')"
if [[ "$atelier_count" != "30" ]]; then
  echo "30 ateliers attendus, $atelier_count trouvés" >&2
  exit 1
fi

echo "Structure pédagogique valide : 5 séries et 30 ateliers."

if command -v mvn >/dev/null 2>&1; then
  mvn -q -DskipTests package
  echo "Compilation Maven réussie."
else
  echo "Maven absent : compilation ignorée." >&2
fi
