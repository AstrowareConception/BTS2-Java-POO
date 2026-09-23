# Série 02 — Programmation orientée objet et UML

**Durée indicative : 13 heures**
**Livrable final : modèle métier CinéDesk cohérent et testé**

La série commence par des objets très simples et termine par un domaine collaboratif. Toute décision d’héritage doit être justifiée ; « éviter de recopier du code » n’est pas une justification suffisante.

## Atelier 1 — Objets, références et identité

**Durée : 1 h 45 — difficulté : découverte — modalité : expériences guidées**

### Expériences

1. Créer deux objets `LegacyMovie` avec les mêmes valeurs.
2. Comparer avec `==`, modifier l’un et observer l’autre.
3. Affecter une référence à une seconde variable puis modifier par cette variable.
4. Écrire un schéma mémoire avec variables, références et objets.
5. Proposer une règle d’identité : identifiant technique, titre + année, ou toutes les propriétés.
6. Implémenter et tester `equals`, `hashCode` et `toString` dans une classe d’essai.

### Questions

- Une variable objet contient-elle l’objet lui-même ?
- Pourquoi deux films identiques à l’écran peuvent-ils être deux objets distincts ?
- Quel risque crée un attribut utilisé par `hashCode` s’il est modifiable dans un `HashSet` ?

### Livrable

Un court compte rendu illustré, sans reprendre une définition copiée d’Internet.

## Atelier 2 — Encapsulation et invariants

**Durée : 2 h — difficulté : intermédiaire — modalité : squelette et tests fournis**

### Mission

Implémenter `Movie` pour qu’un objet invalide ne puisse jamais être observé.

### Invariants

- Identifiant strictement positif pour un film restauré.
- Titre non nul, non blanc, normalisé par `strip()` et limité à 200 caractères.
- Année comprise entre 1888 et l’année courante + 5.
- Durée comprise entre 1 et 600 minutes.
- Genre obligatoire.

### Travail

- Créer deux fabriques nommées : nouveau film sans identifiant et restauration avec identifiant.
- N’exposer aucun setter générique.
- Fournir `rename`, `changeDuration`, `archive` et `isLong`.
- Interdire une modification métier incohérente après archivage, puis justifier ce choix.
- Retirer `@Disabled` de `MovieTest` et ajouter cinq tests frontières.

### Piège volontaire

Un simple couple getters/setters ne constitue pas une encapsulation si toutes les valeurs restent acceptées.

## Atelier 3 — Cartographier le domaine en UML

**Durée : 2 h 15 — difficulté : intermédiaire — modalité : aucun code fourni**

### Contexte

CinéDesk gère des films, réalisateurs, genres, critiques, séances et salles.

### Travail

1. Établir un glossaire de 12 termes.
2. Construire un diagramme de classes avec attributs essentiels et multiplicités.
3. Choisir navigabilité, association ou composition.
4. Ajouter au moins six contraintes textuelles non exprimables par une simple multiplicité.
5. Construire un diagramme de séquence « programmer une séance ».
6. Faire relire le modèle par un autre groupe jouant le client.

### Contraintes métier à intégrer

- Une séance projette exactement un film dans une salle.
- Deux séances d’une même salle ne se chevauchent pas.
- Une critique appartient à un film et possède une note de 0 à 10.
- La capacité d’une salle est strictement positive.
- Un film peut exister sans séance.

### Recette orale

Chaque étudiant doit expliquer un symbole UML et une décision de modélisation sans lire ses notes.

## Atelier 4 — Polymorphisme sans `if` sur les types

**Durée : 2 h 30 — difficulté : difficile — modalité : interfaces fournies**

### Problème

Le prix d’une location dépend de politiques variables : standard, nouveauté, festival et gratuité pédagogique. Une première version contient un `switch` sur un code de tarif dans `Movie`.

### Mission

- Définir `PricingPolicy` comme contrat.
- Écrire quatre implémentations.
- Injecter la politique dans le service de location.
- Ajouter une politique « fidélité » sans modifier les précédentes.
- Tester toutes les politiques avec un test paramétré.
- Dessiner le diagramme Strategy correspondant.

### Héritage raisonné

Créer ensuite une hiérarchie volontairement discutable `Content → Movie / Episode / Trailer`. Repérer une violation du principe de substitution puis proposer une composition plus cohérente.

### Interdiction

Aucun `instanceof` dans le calcul final.

## Atelier 5 — Sauver le God Object

**Durée : 2 h — difficulté : difficile — modalité : code legacy à produire puis refactorer**

### Situation

Une classe `CinemaManager` lit la console, valide les films, calcule les prix, écrit un CSV, construit du SQL et affiche les erreurs.

### Travail

1. Écrire une version minimale de ce mauvais design afin de ressentir ses problèmes.
2. Relever au moins huit odeurs de code.
3. Proposer un découpage par responsabilités.
4. Extraire domaine, service, exporteur et repository.
5. Introduire les dépendances par constructeur.
6. Comparer le diagramme avant/après et le nombre de raisons de changer.

### Règle

Les résultats visibles doivent rester identiques pendant la refactorisation. Ajouter des tests de caractérisation avant de déplacer le code.

## Atelier 6 — Domaine CinéDesk

**Durée : 2 h 30 — difficulté : synthèse — modalité : projet autonome à partir des tests**

### Fonctionnalités

- `Movie`, `Director`, `Genre`, `Review`, `Catalog` et objets-valeurs pertinents.
- Ajout refusé en cas de doublon selon une règle documentée.
- Recherche insensible à la casse sans exposer la collection interne.
- Calcul d’une note moyenne ignorant les films sans critique.
- Archivage d’un film et exclusion par défaut des résultats actifs.
- Export via une interface, avec au moins une implémentation.

### Livrables

- diagramme de classes Mermaid ou PlantUML versionné ;
- diagramme de séquence d’un ajout ;
- au moins 20 tests ;
- note de conception justifiant trois décisions ;
- démonstration d’une nouvelle stratégie ajoutée sans modifier le service appelant.

### Défi expert

Créer `MovieId`, `Title` et `Duration` comme objets-valeurs immuables. Comparer la lisibilité avec des paramètres primitifs.
