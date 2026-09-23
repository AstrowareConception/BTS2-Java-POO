# Méthode de résolution et de débogage

## Avant le code

1. Reformuler le résultat attendu en une phrase.
2. Identifier entrées, sorties, règles et cas d’échec.
3. Écrire un exemple nominal et deux cas limites.
4. Découper le travail en transformations observables.
5. Choisir le plus petit test qui prouvera la première étape.

## Boucle de travail

```text
comprendre → prédire → coder peu → exécuter → observer → corriger → commit
```

Une modification massive suivie de vingt erreurs est beaucoup plus difficile à diagnostiquer que dix modifications minuscules validées une à une.

## Lire une erreur Java

- Identifier le type : compilation, exception ou résultat faux.
- Pour une erreur de compilation, commencer par la première ligne signalée.
- Pour une exception, lire son type, son message et la première ligne de votre propre code dans la pile.
- Reproduire avec les données les plus petites possibles.
- Ne modifier qu’une hypothèse à la fois.

## Utiliser le débogueur

1. Placer le point d’arrêt juste avant que l’état devienne incohérent.
2. Observer les valeurs, pas seulement la ligne courante.
3. Avancer instruction par instruction.
4. Vérifier les branches réellement empruntées.
5. Après correction, écrire un test de non-régression.

## Tests : discipline minimale

- Un nom de test décrit le comportement et la situation.
- Arrange : préparer.
- Act : exécuter une seule action principale.
- Assert : observer le résultat public.
- Un test ne dépend ni de l’heure réelle, ni de l’ordre d’un autre test, ni d’une base partagée.

## Demander de l’aide efficacement

Fournir : objectif, code minimal, commande exécutée, erreur complète, hypothèse déjà testée. « Ça ne marche pas » n’est pas un diagnostic.
