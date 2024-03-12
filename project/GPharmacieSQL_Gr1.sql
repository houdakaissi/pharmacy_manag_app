-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : mer. 13 avr. 2022 à 20:54
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `dbnote`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `id_client` varchar(15) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `genre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id_commande` varchar(15) NOT NULL,
  `numero` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `id_client` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `Etage`
--

CREATE TABLE `Etage` (
  `numero_detage` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `ligne_cmd`
--

CREATE TABLE `ligne_cmd` (
  `quantité` varchar(50) NOT NULL,
  `id_commande` varchar(50) NOT NULL,
  `id_produit` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `Produit`
--

CREATE TABLE `Produit` (
  `id_produit` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  `id_rayon` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `Rayon`
--

CREATE TABLE `Rayon` (
  `id_rayon` varchar(50) NOT NULL,
  `nbr_etage` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `vnote`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `vnote` (
);

-- --------------------------------------------------------

--
-- Structure de la vue `vnote`
--
DROP TABLE IF EXISTS `vnote`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vnote`  AS SELECT `tbnote`.`numetu` AS `numetu`, `tbnote`.`nom` AS `nom`, `tbnote`.`prenom` AS `prenom`, `tbnote`.`math` AS `math`, `tbnote`.`pc` AS `pc`, `tbnote`.`svt` AS `svt`, `tbnote`.`anglais` AS `anglais`, `tbnote`.`francais` AS `francais`, round((`tbnote`.`math` * 4 + `tbnote`.`pc` * 3 + `tbnote`.`svt` * 3 + `tbnote`.`anglais` * 2 + `tbnote`.`francais` * 3) / 15,2) AS `moyenne` FROM `tbnote` ;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
