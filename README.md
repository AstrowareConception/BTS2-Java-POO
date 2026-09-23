# BTS SIO SLAM 2 — Java, POO et applications métiers

Ce dépôt accompagne les cinq supports du cours Java de BTS SIO SLAM. Il propose **30 ateliers**, soit environ **64 heures de pratique**, depuis les premiers programmes jusqu’à une application JavaFX connectée à une API Spring Boot.

Le fil rouge est **CinéDesk**, un outil de gestion de catalogue cinématographique. Il évolue volontairement par étapes : console, modèle objet, noyau testé, application desktop, puis architecture distribuée.

## Parcours

| Série | Thème | Durée | Production principale |
|---|---|---:|---|
| 01 | Fondamentaux et algorithmique | 12 h | Catalogue console |
| 02 | POO et UML | 13 h | Modèle métier CinéDesk |
| 03 | Collections, exceptions, tests et qualité | 12 h | Noyau applicatif testé |
| 04 | JavaFX, JDBC et SQLite | 13 h | Application desktop |
| 05 | REST, Spring Boot, sécurité et E5 | 14 h | Application distribuée |
|  | **Total indicatif** | **64 h** |  |

Chaque série mélange :

- exercices guidés ;
- programmes à écrire sans squelette ;
- code défectueux à diagnostiquer ;
- tests à activer et compléter ;
- modélisation UML ou relationnelle ;
- refactorisations ;
- défis algorithmiques ;
- jalon du projet fil rouge.

## Démarrage rapide

Prérequis recommandés : JDK 21 LTS, Maven 3.9 ou supérieur, Git et un IDE Java.

```bash
java --version
mvn --version
git --version
```

Compiler tous les starters sans exécuter les tests pédagogiques :

```bash
mvn -DskipTests package
```

Travailler sur une série précise :

```bash
cd exercices/serie-01-fondamentaux/starter
mvn test
```

Les classes de tests fournies portent initialement `@Disabled`. L’énoncé indique quand retirer cette annotation. Un test qui devient rouge est une information de travail, pas un échec honteux.

## Structure

```text
.
├── docs/                   repères étudiants et enseignants
├── exercices/              cinq séries, énoncés et starters
├── bin/                    contrôles du dépôt
├── .github/workflows/      validation continue
└── pom.xml                 agrégateur Maven
```

## Méthode attendue

1. Lire l’atelier entier avant d’ouvrir l’IDE.
2. Reformuler le problème et écrire au moins trois exemples.
3. Faire un petit commit cohérent par étape terminée.
4. Activer les tests annoncés, puis travailler en boucle rouge–vert–refactorisation.
5. Ne pas contourner un test en le supprimant ou en codant une valeur en dur.
6. Documenter les choix, limites et difficultés réellement rencontrées.
7. Être capable d’expliquer chaque ligne présentée au jury.

## Documents utiles

- [Installer l’environnement](docs/ENVIRONNEMENT.md)
- [Méthode de résolution](docs/METHODE.md)
- [Plan des 64 heures](docs/PARCOURS_64H.md)
- [Correspondance avec les compétences BTS](docs/COMPETENCES_BTS.md)
- [Guide enseignant](docs/GUIDE_ENSEIGNANT.md)
- [Journal de bord étudiant](docs/JOURNAL_DE_BORD.md)
- [Recette commune du projet](docs/RECETTE_PROJET.md)
- [Références officielles et techniques](docs/REFERENCES.md)

## Positionnement BTS SIO

Ces activités contribuent principalement au bloc **« Conception et développement d’applications »** : analyse, architecture, modélisation, composants logiciels, accès aux données, tests, documentation, intégration continue, maintenance, gestion des données et cybersécurité.

Une réalisation riche ne remplace pas à elle seule les exigences officielles de l’épreuve E5 : les deux réalisations présentées doivent couvrir ensemble les compétences du bloc 2 SLAM et s’inscrire dans un environnement technologique conforme.

## Tester une seule série

```bash
bash bin/test-series.sh 3
```

Retirer d’abord l’annotation `@Disabled` des tests indiqués par l’énoncé concerné.
