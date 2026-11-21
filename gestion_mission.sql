-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 21 nov. 2026 à 20:58
-- Version du serveur : 8.4.7
-- Version de PHP : 8.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_mission`
--

-- --------------------------------------------------------

--
-- Structure de la table `agent`
--

CREATE TABLE IF NOT EXISTS `agent` (
  `id_agent` int NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nom` varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  `specialite` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `niveau` int NOT NULL,
  `actif` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_agent`),
  UNIQUE KEY `pseudo` (`pseudo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `agent`
--

INSERT INTO `agent` (`id_agent`, `pseudo`, `nom`, `specialite`, `niveau`, `actif`) VALUES
(1, 'julien', 'Dupont', 'Développement web', 2, 1),
(2, 'alex', 'Leroy', 'Développement web', 2, 1),
(3, 'marie', 'Martin', 'Cybersécurité', 3, 1),
(4, 'thomas', 'Bernard', 'Réseau', 2, 1),
(5, 'sophie', 'Petit', 'Développement', 4, 1);

-- --------------------------------------------------------

--
-- Structure de la table `mission`
--

CREATE TABLE IF NOT EXISTS `mission` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `statut` enum('A_PREPARER','EN_COURS','TERMINEE','ANNULEE') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `priorite` enum('BASSE','NORMALE','HAUTE','CRITIQUE') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `budget` decimal(10,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `mission`
--

INSERT INTO `mission` (`id`, `titre`, `description`, `date_debut`, `date_fin`, `statut`, `priorite`, `budget`) VALUES
(1, 'Audit du réseau', 'Cartographier le réseau et identifier les éventuelles failles de sécurité.', '2026-11-23', '2026-11-27', 'A_PREPARER', 'HAUTE', 2500.00),
(2, 'Durcissement du serveur web', 'Renforcer la configuration du serveur web et vérifier les règles de sécurité.', '2026-11-30', '2026-12-04', 'A_PREPARER', 'CRITIQUE', 1800.00),
(3, 'Sensibilisation au phishing', 'Préparer une campagne de sensibilisation et rédiger un bilan pour les utilisateurs.', '2026-12-07', '2026-12-11', 'A_PREPARER', 'NORMALE', 900.00),
(4, 'Déploiement d’une solution de sauvegarde', 'Installer et configurer une solution de sauvegarde pour les fichiers de l’entreprise.', '2026-12-14', '2026-12-18', 'A_PREPARER', 'HAUTE', 1250.00),
(5, 'Mise à jour du parc informatique', 'Planifier et réaliser les mises à jour des postes de travail.', '2026-12-01', '2026-12-04', 'A_PREPARER', 'NORMALE', 1250.00),
(6, 'Gestion des comptes utilisateurs', 'Mettre en place une organisation des comptes et des droits d’accès.', '2026-12-07', '2026-12-10', 'A_PREPARER', 'HAUTE', 1500.00),
(7, 'Développement d’un portail interne', 'Créer une interface web permettant aux collaborateurs de consulter des informations internes.', '2027-01-04', '2027-01-15', 'A_PREPARER', 'HAUTE', 3200.00),
(8, 'Audit des droits utilisateurs', 'Contrôler les autorisations et proposer des corrections si nécessaire.', '2027-01-18', '2027-01-22', 'A_PREPARER', 'CRITIQUE', 2100.00),
(9, 'Rédaction de la documentation réseau', 'Rassembler les informations techniques et rédiger la documentation du réseau.', '2027-01-25', '2027-01-29', 'A_PREPARER', 'BASSE', 700.00),
(10, 'Migration de la base de données', 'Préparer et réaliser la migration de la base de données vers un nouvel environnement.', '2027-02-01', '2027-02-05', 'A_PREPARER', 'HAUTE', 2800.00),
(11, 'Création d’un tableau de bord', 'Développer un tableau de bord pour suivre les indicateurs d’activité.', '2027-02-08', '2027-02-12', 'A_PREPARER', 'NORMALE', 1600.00),
(12, 'Maintenance de l’application interne', 'Corriger les anomalies et améliorer le fonctionnement de l’application interne.', '2027-02-15', '2027-02-19', 'A_PREPARER', 'NORMALE', 1250.00);

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

CREATE TABLE IF NOT EXISTS `participation` (
  `id_agent` int NOT NULL,
  `id_mission` int NOT NULL,
  `role` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_affectation` date NOT NULL,
  PRIMARY KEY (`id_agent`,`id_mission`),
  KEY `fk_participation_mission` (`id_mission`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `participation`
--

INSERT INTO `participation` (`id_agent`, `id_mission`, `role`, `date_affectation`) VALUES
(1, 2, 'Développeur web', '2026-11-21'),
(1, 3, 'Chargé de sensibilisation', '2026-11-21'),
(3, 1, 'Auditrice sécurité', '2026-11-21'),
(4, 4, 'Administrateur réseau', '2026-11-21'),
(5, 5, 'Développeuse', '2026-11-21');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `participation`
--
ALTER TABLE `participation`
  ADD CONSTRAINT `fk_participation_agent` FOREIGN KEY (`id_agent`) REFERENCES `agent` (`id_agent`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_participation_mission` FOREIGN KEY (`id_mission`) REFERENCES `mission` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
