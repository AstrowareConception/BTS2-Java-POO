# Recette commune du projet CinéDesk

## Informations

- Version ou commit :
- Environnement :
- Testeur :
- Date :

## Scénarios fonctionnels minimaux

| ID | Scénario | Données | Attendu | Obtenu | Statut |
|---|---|---|---|---|---|
| R01 | ajouter un film valide | titre, année, durée, genre | film visible et conservé |  |  |
| R02 | refuser un titre vide | espaces | message près du champ |  |  |
| R03 | refuser un doublon | même titre et année | erreur explicite |  |  |
| R04 | rechercher avec casse différente | `alien` / `Alien` | même résultat |  |  |
| R05 | rechercher un titre accentué | `amelie` / `Amélie` | règle documentée |  |  |
| R06 | archiver | film actif | absent des actifs, conservé |  |  |
| R07 | redémarrer | données existantes | données retrouvées |  |  |
| R08 | panne de stockage | accès refusé | erreur contrôlée |  |  |
| R09 | sauvegarder/restaurer | base de démonstration | catalogue identique |  |  |
| R10 | droit insuffisant | utilisateur simple | refus sans fuite |  |  |

## Exigences non fonctionnelles

- [ ] build reproductible ;
- [ ] aucune donnée sensible dans Git ou les logs ;
- [ ] interface utilisable au clavier ;
- [ ] requêtes préparées ;
- [ ] timeouts réseau définis ;
- [ ] tests automatiques verts ;
- [ ] procédure d’installation vérifiée sur un poste propre ;
- [ ] version affichée et reliée à un commit.

## Anomalies

Chaque anomalie doit comporter étapes de reproduction, attendu, obtenu, gravité, environnement et preuve. Après correction, ajouter un test de non-régression lorsque c’est pertinent.
