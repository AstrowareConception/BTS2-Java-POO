# Guide enseignant

## Philosophie

Les starters donnent juste assez de structure pour éviter une heure perdue sur la configuration. Ils ne donnent pas l’algorithme ni la conception centrale. Certaines activités ne fournissent aucun code afin d’obliger les étudiants à créer, nommer et organiser.

## Mise en œuvre conseillée

- Distribuer un atelier à la fois.
- Exiger une prédiction écrite avant l’exécution des exercices de débogage.
- Faire expliquer une solution par un étudiant qui n’en est pas l’auteur.
- Tirer au sort un cas limite supplémentaire lors de la recette.
- Refuser les démonstrations dépendant d’un poste déjà configuré sans procédure.

## Tests fournis

Les classes de tests sont initialement annotées `@Disabled`. L’étudiant retire l’annotation au moment indiqué. Le dépôt enseignant peut conserver une branche privée avec des tests supplémentaires ; ne pas publier les corrections complètes sur la branche principale.

## Évaluation possible

| Critère | Insuffisant | Attendu | Très satisfaisant |
|---|---|---|---|
| Compréhension | ne peut pas expliquer | explique choix et flux | compare plusieurs solutions |
| Conception | responsabilités mélangées | séparation cohérente | dépendances et compromis maîtrisés |
| Tests | absents ou contournés | cas nominaux et limites | non-régression et intégration |
| Qualité | noms opaques, duplication | code lisible et formaté | refactorisation argumentée |
| Git | un commit final | historique progressif | tickets et revues traçables |
| Documentation | lancement impossible | procédure reproductible | limites et diagnostic documentés |

## Anti-copie

Varier par groupe : seuils tarifaires, contraintes d’âge, genres, taille des données, règle de doublon et évolution surprise. Pendant la soutenance, demander une modification minuscule accompagnée d’un test.
