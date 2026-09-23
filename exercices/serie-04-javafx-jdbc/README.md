# Série 04 — JavaFX, JDBC et application desktop

**Durée indicative : 13 heures**
**Livrable final : CinéDesk Desktop installable**

Le starter fournit une fenêtre vide, une structure de packages et les contrats de persistance. L’interface, les requêtes et la majorité des comportements restent à construire.

## Atelier 1 — Concevoir avant de dessiner

**Durée : 2 h — difficulté : intermédiaire — modalité : papier puis JavaFX**

### Besoin

Un bénévole doit retrouver, ajouter et corriger un film sans connaître le vocabulaire technique du logiciel.

### Travail UX

- Définir trois profils d’utilisateurs et leurs tâches prioritaires.
- Dessiner deux variantes de l’écran principal.
- Tester chaque maquette avec un autre groupe : « trouver un film », « corriger une durée », « archiver ».
- Relever hésitations et erreurs, puis choisir une variante.
- Définir navigation clavier, messages, confirmations et états vides.

### Construction JavaFX

- Reproduire le wireframe avec des layouts, jamais avec des coordonnées absolues.
- Ajouter libellés, raccourcis et styles CSS.
- Simuler données, chargement, absence de résultat et erreur.
- Vérifier que la fenêtre reste utilisable après redimensionnement.

### Critère

La beauté n’est pas le critère principal : chaque élément doit soutenir une tâche identifiable.

## Atelier 2 — FXML, contrôleurs et couches

**Durée : 2 h 15 — difficulté : intermédiaire — modalité : starter fourni**

### Mission

Compléter `catalog-view.fxml` et `CatalogController` sans introduire de logique SQL ou de règle métier dans le contrôleur.

### Travail

- Configurer les colonnes de `TableView`.
- Lier une `ObservableList` et une `FilteredList`.
- Injecter un `CatalogService` par constructeur ou fabrique de contrôleurs.
- Ouvrir un formulaire d’ajout et transmettre une commande.
- Afficher validation et résultat sans stack trace.
- Désactiver les actions impossibles en l’absence de sélection.

### Audit de responsabilités

Pour chaque méthode du contrôleur, écrire une phrase : « Cette méthode adapte… ». Si la phrase contient « calcule la règle », « construit du SQL » ou « ouvre la base », déplacer la responsabilité.

## Atelier 3 — De l’UML au schéma relationnel

**Durée : 2 h 30 — difficulté : difficile — modalité : modèle à concevoir**

### Modèle minimal

`movie`, `genre`, `director`, relation film–réalisateur, `review`.

### Travail

1. Construire le MCD ou diagramme entité-association.
2. Justifier clés, nullabilité, unicité et règles de suppression.
3. Écrire un script de création idempotent pour une base de test neuve.
4. Ajouter contraintes `NOT NULL`, `CHECK`, `UNIQUE` et clés étrangères.
5. Écrire huit requêtes : CRUD, recherche, agrégation et jointure.
6. Examiner le plan d’une recherche et proposer un index utile.

### Cas culturels

Un film peut avoir plusieurs réalisateurs ; un titre peut contenir apostrophe, accent ou point-virgule. Le modèle et les requêtes doivent le supporter.

## Atelier 4 — Repository JDBC et transactions

**Durée : 2 h 30 — difficulté : difficile — modalité : interface et schéma fournis**

### Mission

Implémenter `JdbcMovieRepository` :

- connexion via `ConnectionFactory` ;
- requêtes préparées uniquement ;
- mapping isolé ;
- récupération de clé générée ;
- vérification du nombre de lignes modifiées ;
- traduction des erreurs techniques ;
- fermeture par `try-with-resources`.

### Incident transactionnel

L’ajout d’un film doit enregistrer simultanément une ligne d’audit. Provoquer l’échec de l’audit puis vérifier qu’aucun film partiel ne demeure. Implémenter commit et rollback.

### Point sécurité

Tester une recherche contenant `' OR 1=1 --` : elle doit être traitée comme une valeur de recherche, jamais comme du SQL.

## Atelier 5 — Tester et livrer le desktop

**Durée : 1 h 45 — difficulté : intermédiaire — modalité : protocole fourni**

### Tests

- tests unitaires du domaine ;
- services avec repository mémoire ;
- repository avec base SQLite temporaire ;
- recette manuelle de l’interface ;
- redémarrage prouvant la persistance ;
- restauration d’une sauvegarde.

### Livraison

- `mvn clean verify` ;
- version visible ;
- base d’exemple sans donnée personnelle ;
- guide d’installation ;
- paquet créé par `jpackage` ou procédure équivalente ;
- test sur un poste propre.

### Rapport

Indiquer environnement, scénario, attendu, obtenu et preuve. « Ça fonctionne » n’est pas un rapport de test.

## Atelier 6 — CinéDesk Desktop

**Durée : 2 h — difficulté : synthèse — modalité : jalon projet**

### Périmètre obligatoire

- catalogue paginé ou limité raisonnablement ;
- formulaire accessible avec validations ;
- recherche et filtres ;
- ajout, modification et archivage ;
- statistiques simples ;
- base versionnée par scripts de migration ;
- export et sauvegarde ;
- logs sans données sensibles.

### Preuves

- diagrammes de classes, séquence et données ;
- matrice exigences–tests ;
- historique Git ;
- procédure de construction ;
- démonstration d’un échec contrôlé ;
- liste de limites et évolution vers une API distante.

### Défi expert

Effectuer import ou recherche lourde dans une `Task` JavaFX avec progression, annulation et état d’erreur, sans bloquer le thread graphique.
