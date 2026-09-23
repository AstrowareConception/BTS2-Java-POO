# Série 05 — REST, Spring Boot, sécurité et préparation E5

**Durée indicative : 14 heures**
**Livrable final : client JavaFX + API Spring Boot + dossier de preuves**

Cette série transforme CinéDesk en solution distribuée. Elle ne demande pas d’empiler les annotations : chaque endpoint doit correspondre à un besoin, un contrat, une autorisation et des tests.

## Atelier 1 — Concevoir une API sur papier

**Durée : 2 h — difficulté : intermédiaire — modalité : aucun code fourni**

### Mission

Définir le contrat HTTP de CinéDesk avant d’ouvrir Spring Initializr.

### Ressources

- films ;
- genres ;
- critiques ;
- utilisateurs et rôles, uniquement pour les opérations nécessaires.

### Travail

- écrire 10 opérations avec méthode, URL, paramètres, corps, réponse et statuts ;
- distinguer `POST`, `PUT`, `PATCH` et `DELETE` ;
- prévoir pagination, recherche et tri contrôlé ;
- produire deux exemples JSON nominaux et quatre erreurs uniformes ;
- expliquer `400`, `401`, `403`, `404`, `409` et `500` ;
- dessiner une séquence client–API–service–repository–base.

### Jeu de rôle

Un groupe joue les développeurs du client et tente d’utiliser le contrat d’un autre groupe. Toute question sans réponse révèle une ambiguïté à corriger.

### Défi

Rejouer deux fois la même requête et discuter l’idempotence et les effets observables.

## Atelier 2 — Construire l’API Spring Boot

**Durée : 3 h — difficulté : difficile — modalité : starter fourni**

### Mission

Compléter le backend fourni avec une architecture claire : contrôleur Web, service applicatif, domaine, port repository et adaptateur de persistance.

### Endpoints minimaux

- `GET /api/movies` avec page et taille ;
- `GET /api/movies/{id}` ;
- `POST /api/movies` avec `201` et `Location` ;
- `PUT /api/movies/{id}` ;
- `PATCH /api/movies/{id}/archive` ;
- recherche par titre et genre.

### Contraintes

- DTO distincts de l’entité JPA ;
- injection par constructeur ;
- transaction dans le service ;
- migrations versionnées ;
- aucune `SQLException` ou entité JPA dans le contrat HTTP ;
- OpenAPI ou documentation de contrat tenue à jour.

### Question de conception

Comparer repository Spring Data directement injecté dans le service et port métier adapté par une classe d’infrastructure. Choisir en connaissance du coût, pas par dogme.

## Atelier 3 — Validation, erreurs et pagination

**Durée : 2 h — difficulté : intermédiaire à difficile — modalité : incidents fournis**

### Incidents

- un titre de 50 000 caractères sature les logs ;
- une page de taille un million épuise la mémoire ;
- un doublon retourne `500` ;
- un identifiant absent retourne `200` avec `null` ;
- le client reçoit quatre structures d’erreur différentes.

### Travail

- annotations de validation sur les requêtes ;
- invariants maintenus dans le domaine ;
- taille de page plafonnée ;
- `@RestControllerAdvice` ;
- réponses Problem Details cohérentes ;
- traduction doublon → `409`, absent → `404` ;
- tests de chaque chemin d’erreur.

### Recette

Un script ou une collection de requêtes doit rejouer au moins 15 scénarios sans manipulation manuelle.

## Atelier 4 — Brancher le client JavaFX

**Durée : 2 h — difficulté : difficile — modalité : contrat repository existant**

### Mission

Remplacer `JdbcMovieRepository` côté client par `HttpMovieRepository` sans réécrire l’interface graphique ni les règles métier locales.

### Travail

- `HttpClient` avec délais de connexion et de réponse ;
- sérialisation/désérialisation via DTO ;
- appel asynchrone hors thread JavaFX ;
- retour sur `Platform.runLater` pour la vue ;
- gestion de `401`, `403`, `404`, `409`, `5xx` et timeout ;
- indicateur de chargement et possibilité d’annulation.

### Panne simulée

Couper l’API pendant une création. L’interface doit expliquer l’incertitude sans annoncer faussement le succès et sans dupliquer aveuglément la requête.

### Défi

Mettre en cache la dernière liste consultée tout en signalant clairement qu’elle peut être périmée.

## Atelier 5 — Sécurité, tests et déploiement

**Durée : 2 h 30 — difficulté : difficile — modalité : audit en équipe**

### Modèle de menace

Identifier actifs, acteurs, frontières et scénarios : vol de compte, accès horizontal, injection, secret committé, logs sensibles, saturation et dépendance vulnérable.

### Mesures attendues

- authentification gérée par un composant éprouvé ;
- mots de passe hachés avec fonction dédiée ;
- rôles `USER` et `ADMIN` contrôlés serveur ;
- requêtes paramétrées ;
- secrets hors Git ;
- TLS pour l’environnement distant ;
- logs minimisés et corrélés ;
- endpoints d’administration protégés.

### Tests

- tests unitaires domaine/service ;
- tests Web du contrat ;
- intégration avec base isolée ;
- accès anonyme, utilisateur et administrateur ;
- dépendances et build vérifiés par CI.

### Déploiement

Produire un JAR versionné ou une image conteneur non privilégiée, configuration externalisée, endpoint de santé et procédure de retour arrière.

## Atelier 6 — Changement imposé et soutenance E5

**Durée : 2 h 30 — difficulté : synthèse — modalité : simulation de jury**

### Tirage au sort

Chaque étudiant reçoit une évolution circonscrite, par exemple :

- classification `COURT`, `STANDARD`, `LONG` avec seuils configurables ;
- interdiction d’archiver un film programmé dans une séance future ;
- filtre par décennie ;
- champ facultatif de pays d’origine ;
- journal d’audit consultable seulement par un administrateur.

### Préparation

1. Reformuler et poser les questions manquantes.
2. Identifier impacts domaine, API, données, client, tests et documentation.
3. Écrire ou adapter les tests avant l’implémentation.
4. Réaliser de petits commits.
5. Exécuter la suite complète et montrer le diff.

### Soutenance

- 2 min : besoin et périmètre ;
- 3 min : architecture et modèle ;
- 5 min : démonstration nominale et erreur contrôlée ;
- 3 min : tests, sécurité et CI ;
- 2 min : changement réalisé, limites et suite.

### Dossier de preuves

- fiche de réalisation renseignée avec exactitude ;
- ressources et modalités d’accès vérifiées ;
- sources, schémas, migrations, tests et documentations ;
- contributions personnelles identifiables ;
- matrice compétence–preuve ;
- rappel : deux réalisations couvrent ensemble le bloc 2 SLAM.

### Questions jury possibles

- Pourquoi ce framework et cette architecture ?
- Que se passe-t-il si la base ou le réseau tombe ?
- Où la règle métier est-elle garantie ?
- Comment empêchez-vous une injection ?
- Quel test prouve votre correction ?
- Quelle limite connaissez-vous et comment la traiteriez-vous ?
