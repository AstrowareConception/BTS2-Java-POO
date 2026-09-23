# Série 03 — Collections, exceptions, tests et qualité

**Durée indicative : 12 heures**
**Livrable final : noyau applicatif CinéDesk construit et testé par Maven**

Cette série fait passer du « programme qui fonctionne » à un composant reproductible, testable et maintenable. Les choix de collection, les chemins d’échec et les cas limites doivent être explicités.

## Atelier 1 — Le marché des collections

**Durée : 2 h — difficulté : intermédiaire — modalité : cartes de besoins et code libre**

### Mission

Pour chacune des situations suivantes, choisir `List`, `Set` ou `Map`, puis une implémentation. Justifier en termes d’ordre, unicité, clé, coût et contrat :

- file de films à visionner ;
- genres associés à un film sans doublon ;
- film retrouvé par identifiant ;
- historique conservant l’ordre d’insertion ;
- classement maintenu par titre ;
- regroupement de films par réalisateur.

### Développement

Créer `CatalogCollectionsLab` avec :

- ajout refusant un identifiant déjà utilisé ;
- index par identifiant ;
- regroupement par genre ;
- suppression sûre pendant un parcours ;
- vue non modifiable retournée au client ;
- comparaison de l’ordre de `HashSet`, `LinkedHashSet` et `TreeSet`.

### Incident à diagnostiquer

Un film utilisé dans un `HashSet` devient introuvable après modification d’un champ participant à `hashCode`. Reproduire, expliquer et corriger la conception.

## Atelier 2 — Génériques, lambdas et streams

**Durée : 2 h — difficulté : intermédiaire à difficile — modalité : signatures fournies**

### Travail

Implémenter dans `CatalogAnalytics` :

- `filter` recevant un `Predicate<MovieData>` ;
- tri multi-critères par année décroissante puis titre ;
- moyenne des durées avec cas vide explicite ;
- regroupement par genre ;
- top N des mieux notés ;
- transformation vers un résumé immuable.

### Comparaison obligatoire

Écrire d’abord une boucle claire, puis une version stream. Garder la version que le groupe juge la plus lisible et justifier le choix. L’objectif n’est pas de produire la chaîne la plus longue.

### Défi générique

Créer `Result<T>` capable de représenter réussite ou erreur sans valeur `null`, puis discuter ses limites par rapport aux exceptions.

## Atelier 3 — Import CSV sous haute surveillance

**Durée : 2 h — difficulté : difficile — modalité : fichiers piégés fournis à créer**

### Format

```text
id;title;releaseYear;duration;genre;rating
```

Créer quatre jeux de données : nominal, accents, ligne incomplète, titre contenant le séparateur entre guillemets.

### Exigences

- UTF-8 explicite ;
- `try-with-resources` ;
- numéro de ligne dans chaque erreur ;
- aucune modification du catalogue si une erreur critique survient ;
- rapport séparant avertissements et erreurs ;
- export réimportable sans perte.

### Exceptions

Créer une exception métier `CatalogImportException` conservant la cause technique. Ne jamais afficher directement une stack trace à l’utilisateur final.

### Culture

Rechercher pourquoi « découper sur `;` » n’est pas un parseur CSV complet. Documenter le choix : périmètre réduit assumé ou bibliothèque spécialisée.

## Atelier 4 — TDD avec JUnit

**Durée : 2 h 30 — difficulté : intermédiaire — modalité : tests fournis puis tests à écrire**

### Partie guidée

Retirer `@Disabled` de `CatalogAnalyticsTest` méthode par méthode :

1. observer l’échec attendu ;
2. écrire le minimum ;
3. faire passer le test ;
4. refactorer ;
5. committer.

### Partie autonome

Développer en TDD un service de recommandations :

- exclure les archivés ;
- note minimale configurable ;
- exclure les films déjà vus ;
- limiter le nombre de résultats ;
- ordre déterministe en cas d’égalité.

### Tests imposés

- partitions valides/invalides ;
- frontières ;
- catalogue vide ;
- exception attendue ;
- test paramétré ;
- test utilisant un fake repository.

## Atelier 5 — Enquête de maintenance

**Durée : 1 h 30 — difficulté : intermédiaire — modalité : ticket correctif**

### Ticket

« Depuis la dernière version, une recherche `amelie` ne trouve plus `Le Fabuleux Destin d’Amélie Poulain`. Certaines moyennes affichent `NaN`. »

### Procédure exigée

- créer une branche courte ;
- reproduire chaque défaut avec un test ;
- identifier la cause avec débogueur ou traces ciblées ;
- appliquer un correctif minimal ;
- refactorer sans mélanger une nouvelle fonctionnalité ;
- rédiger un message de commit et une note de version.

### Revue croisée

Le relecteur vérifie que les tests échouaient réellement avant la correction et qu’ils décrivent le comportement attendu.

## Atelier 6 — Noyau CinéDesk industrialisé

**Durée : 2 h — difficulté : synthèse — modalité : projet avec critères de qualité**

### Production

- domaine séparé de l’infrastructure ;
- repository en mémoire ;
- services d’ajout, recherche, archivage et statistiques ;
- import/export ;
- exceptions traduites au bon niveau ;
- au moins 30 tests rapides ;
- build Maven reproductible.

### Intégration continue

Créer un workflow qui exécute `mvn verify` sur chaque push et pull request. Introduire volontairement une régression, observer l’échec, puis la corriger.

### Documentation

Un tiers doit pouvoir cloner, construire, tester et lancer sans explication orale. Le README indique aussi limites, choix de données et stratégie d’erreur.

### Défi expert

Ajouter une analyse de complexité et un petit benchmark raisonnable pour comparer recherche linéaire et index `Map`, sans présenter le résultat comme une preuve scientifique universelle.
