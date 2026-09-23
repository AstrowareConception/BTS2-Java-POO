# Installer et vérifier l’environnement

## Outils

- JDK 21 LTS ;
- Maven 3.9 ou supérieur ;
- Git ;
- IntelliJ IDEA, Eclipse ou VS Code avec extensions Java ;
- pour les séries 4 et 5 : un outil d’inspection SQLite et un client HTTP.

Le projet Spring Boot du dépôt utilise une version stable compatible avec Java 21. Les postes de la salle, la CI et la machine de démonstration doivent employer la même version majeure du JDK.

## Vérifications

```bash
java --version
javac --version
mvn --version
git --version
```

`java` et `javac` doivent annoncer la même famille de version. Si Maven utilise un autre JDK, vérifier `JAVA_HOME` dans la configuration du poste et de l’IDE.

## Premier build

À la racine :

```bash
mvn -DskipTests package
```

Les dépendances sont téléchargées lors du premier lancement. Les tests pédagogiques sont désactivés initialement ; chaque énoncé indique ceux qu’il faut activer.

## Problèmes fréquents

### « release version 21 not supported »

Maven utilise un JDK trop ancien. Lire la ligne « Java version » produite par `mvn --version`.

### Les accents sont altérés

Tous les fichiers sont en UTF-8. Vérifier l’encodage du projet, du terminal, de la base et des fichiers CSV.

### JavaFX ne démarre pas

Lancer la série 4 par Maven afin que les modules natifs adaptés soient résolus :

```bash
cd exercices/serie-04-javafx-jdbc/starter
mvn javafx:run
```

### Le port de l’API est déjà utilisé

Identifier le processus occupant le port ou configurer un autre port dans un profil local. Ne pas tuer un processus sans vérifier à qui il appartient.

## Règle de sécurité

Ne jamais committer de mot de passe, jeton, fichier `.env`, base contenant des données personnelles ou certificat privé. Les fichiers d’exemple doivent contenir uniquement de fausses valeurs.
