**GestionMissions**

**Présentation du projet**

GestionMissions est une application de bureau développée en Java dans le cadre de ma deuxième année de BTS SIO, option SLAM.

L'application permet de gérer des agents, des missions et les participations des agents aux différentes missions.

**Fonctionnalités**

L'application propose plusieurs fonctionnalités :

**- Gestion des agents :** ajouter, consulter et modifier des agents.

**- Gestion des missions :** ajouter, consulter et modifier des missions.

**- Gestion des participations :** ajouter, consulter et modifier les participations entre les agents et les missions.

**Technologies utilisées**

**- Java :** langage de programmation.

**- Java Swing :** création des interfaces graphiques.

**- MySQL :** système de gestion de base de données.

**- JDBC :** connexion entre l'application Java et la base de données.

**- NetBeans :** environnement de développement.

**- Git et GitHub :** gestion des versions et hébergement du code source.

**Architecture du projet**

Le projet est organisé en plusieurs packages :

- Connexion : gestion de la connexion à la base de données.

- DAO : accès aux données et exécution des requêtes SQL.

- Metier : classes représentant les objets du projet (Agent, Mission, Participation).

- IHM : interfaces graphiques de l'application.

**Base de données**

L'application utilise une base de données MySQL nommée gestion_mission.

Elle contient trois tables principales :

- agent

- mission

- participation

La table participation permet de relier les agents aux missions.

**Installation et lancement**

Récupérer le projet depuis ce dépôt GitHub.

Ouvrir le projet dans NetBeans.

Créer la base de données MySQL gestion_mission et importer le script SQL fourni avec le projet.

Vérifier les paramètres de connexion à la base de données dans ConnexionBDD.java.

Vérifier que le pilote JDBC MySQL est disponible dans le projet.

Compiler et lancer l'application depuis NetBeans.

**Auteur**

Projet réalisé dans le cadre du BTS SIO, option SLAM.
