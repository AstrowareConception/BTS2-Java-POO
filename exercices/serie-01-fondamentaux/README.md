# Série 01 — Fondamentaux Java et algorithmique

**Durée indicative : 12 heures**
**Livrable final : catalogue CinéDesk en console**

Cette série impose d’écrire, tracer et expliquer des algorithmes. Le starter contient quelques signatures et tests désactivés ; plusieurs productions doivent être créées sans squelette.

## Atelier 1 — Autopsie de programmes Java

**Durée : 1 h 15 — difficulté : découverte — modalité : code défectueux fourni**

### Contexte

Une équipe a laissé six petits programmes impossibles à compiler ou produisant un mauvais résultat. Votre mission n’est pas seulement de les réparer : vous devez classer chaque défaut et expliquer le diagnostic.

### Travail

1. Créer `DiagnosticLab.java` dans le package `fr.bts.sio.fundamentals`.
2. Reproduire successivement six défauts : point-virgule absent, casse incorrecte, variable non initialisée, division entière involontaire, comparaison de chaînes avec `==`, indice hors limites.
3. Avant chaque exécution, prédire : compilation impossible, exception ou résultat logique faux.
4. Copier le message exact dans `diagnostic.md`, puis le traduire en français courant.
5. Réparer sans modifier le résultat fonctionnel demandé.
6. Utiliser le débogueur pour l’erreur d’indice et fournir une capture des valeurs.

### Recette

- Les six catégories sont correctement identifiées.
- Le rapport contient symptôme, cause, correction et prévention.
- Aucun `catch (Exception)` ne masque les problèmes.

### Défi

Construire une « erreur mystère » pour un autre binôme. Celui-ci doit la diagnostiquer sans voir votre correction.

## Atelier 2 — Billetterie du cinéma Lumière

**Durée : 1 h 30 — difficulté : facile à intermédiaire — modalité : sans code fourni**

### Contexte culturel

Les frères Lumière organisent en 1895 l’une des premières projections publiques payantes. Vous allez produire un calculateur moderne de billetterie, en conservant des règles parfaitement traçables.

### Règles

- Tarif normal : 12,00 €.
- Moins de 14 ans : 7,50 €.
- Étudiant : remise de 20 % sur le tarif normal.
- Séance du matin : remise supplémentaire de 2,00 €.
- Le prix ne peut jamais être négatif.
- Une seule réduction liée au profil est appliquée ; la séance du matin se cumule.

### Travail

1. Écrire le tableau de décision avant le code.
2. Saisir âge, statut étudiant et heure de séance.
3. Refuser âge négatif et heure hors de `[0, 23]`.
4. Calculer avec des variables nommées et des constantes.
5. Afficher un ticket détaillant tarif initial, réductions et total.
6. Tester au minimum les âges 13 et 14, puis les heures 11 et 12.

### Interdictions

- Valeurs tarifaires recopiées à plusieurs endroits.
- Condition géante impossible à commenter oralement.
- Résultat pré-calculé selon un exemple.

### Défi

Utiliser `BigDecimal` et expliquer ce que cela change pour l’argent.

## Atelier 3 — Menus robustes et validation

**Durée : 1 h 45 — difficulté : intermédiaire — modalité : squelette partiel**

### Mission

Compléter `ConsoleInput` et créer un menu qui ne s’arrête jamais sur une saisie invalide.

### Fonctionnalités

- Afficher : ajouter un film, calculer une durée, afficher une recommandation, quitter.
- Lire avec `nextLine()`, puis convertir.
- Redemander une valeur après erreur avec un message précis.
- Utiliser une clause de garde pour les titres vides.
- Utiliser un `switch` moderne pour le menu.
- Quitter uniquement sur confirmation explicite.

### Cas à vérifier

- texte à la place d’un nombre ;
- espaces avant et après ;
- option inconnue ;
- chaîne vide ;
- durée zéro, négative ou supérieure à 600.

### Recette croisée

Un autre binôme dispose de deux minutes pour tenter de faire planter votre programme. Chaque plantage reproductible devient un test à ajouter.

## Atelier 4 — Musée des algorithmes

**Durée : 2 h 30 — difficulté : intermédiaire à difficile — modalité : signatures et tests fournis**

### Culture algorithmique

- La suite de Fibonacci est décrite en Europe au XIIIe siècle, mais des travaux indiens plus anciens étudient déjà cette suite.
- Le crible d’Ératosthène date de l’Antiquité et reste une excellente méthode pour produire les nombres premiers jusqu’à une borne.
- La recherche dichotomique illustre l’intérêt d’une donnée triée.

### Fonctions à réaliser dans `CinemaAlgorithms`

1. `formatDuration(int)` transforme 142 en `2 h 22`.
2. `fibonacci(int)` retourne le terme d’indice `n`, avec `F(0)=0` et `F(1)=1`.
3. `sieve(int)` retourne tous les nombres premiers jusqu’à la borne incluse.
4. `binarySearch(int[], int)` retourne l’indice ou `-1`.
5. `isPalindrome(String)` ignore espaces, ponctuation, casse et diacritiques.

### Méthode obligatoire

- Écrire trois exemples sur papier.
- Évaluer ordre de grandeur du nombre d’opérations.
- Retirer `@Disabled` de `CinemaAlgorithmsTest` par petits groupes de tests.
- Corriger sans regarder tous les échecs à la fois.

### Défis

- Comparer Fibonacci itératif et récursif avec un compteur d’appels.
- Produire les nombres premiers jusqu’à un million et mesurer le temps.
- Expliquer pourquoi la dichotomie exige un tableau trié.

## Atelier 5 — Statistiques d’un catalogue

**Durée : 2 h 15 — difficulté : intermédiaire — modalité : données fournies, code libre**

### Données

Utiliser deux tableaux synchronisés pour cette étape volontairement procédurale : titres et durées. Le défaut de cette représentation sera analysé dans la série POO.

### Travail

- calculer durée totale, moyenne, minimum et maximum ;
- retrouver tous les films de durée supérieure à un seuil ;
- trier une copie sans modifier l’ordre original ;
- normaliser un titre pour une recherche insensible à la casse ;
- construire un rapport avec `StringBuilder` ;
- traiter proprement un catalogue vide.

### Contraintes

- Une méthode par intention.
- Aucun affichage dans les méthodes de calcul.
- Pas d’état global.
- Les tableaux d’entrée ne doivent pas être modifiés sans l’annoncer dans le contrat.

### Question d’analyse

Que se passe-t-il si le tableau des titres contient 8 éléments et celui des durées 7 ? Proposer une conception qui rendrait cette incohérence impossible.

## Atelier 6 — Récursivité et projet console

**Durée : 2 h 45 — difficulté : difficile — modalité : mini-projet autonome**

### Partie A — Comprendre la récursivité

Implémenter et tracer :

- somme des entiers de 1 à `n` ;
- factorielle avec détection d’entrée invalide ;
- palindrome récursif ;
- exploration d’un labyrinthe représenté par une grille de caractères.

Pour chaque fonction, identifier le cas de base, la réduction du problème et le risque de dépassement de pile. Une version itérative doit être fournie pour au moins deux fonctions.

### Partie B — CinéDesk Console

Construire une application sans copier un projet existant :

- ajouter jusqu’à 100 films ;
- lister avec numéro, titre, année, durée et note ;
- rechercher par fragment de titre ;
- produire statistiques et classement ;
- exporter un rapport texte ;
- ne jamais perdre le contrôle après une saisie invalide.

### Livrables

- code source organisé en méthodes ;
- `README.md` avec lancement et exemples ;
- plan de tests comportant au moins 12 cas ;
- historique Git d’au moins 6 commits cohérents ;
- note de 10 lignes : « Pourquoi les tableaux parallèles vont nous limiter ».

### Recette finale

Le professeur fournit trois films inconnus, une saisie erronée et un titre accentué. L’étudiant doit démontrer le scénario puis modifier en direct le seuil d’un film long.
