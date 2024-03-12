-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le : Ven 12 Novembre 2021 à 19:41
-- Version du serveur: 5.5.16
-- Version de PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `dbnote`
--

-- --------------------------------------------------------

--
-- Structure de la table `tbnote`
--

CREATE TABLE IF NOT EXISTS `client` (
  `numetu` varchar(15) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `math` decimal(4,2) DEFAULT NULL,
  `pc` decimal(4,2) DEFAULT NULL,
  `svt` decimal(4,2) DEFAULT NULL,
  `anglais` decimal(4,2) DEFAULT NULL,
  `francais` decimal(4,2) DEFAULT NULL,
  PRIMARY KEY (`numetu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`numetu`, `nom`, `prenom`, `math`, `pc`, `svt`, `anglais`, `francais`) VALUES
('0001', 'Alex', 'Ferdinand', '12.50', '13.00', '16.00', '14.00', '13.50'),
('0002', 'Frank', 'Simmon', '11.00', '8.00', '12.00', '14.00', '12.50');

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `vnote`
--
CREATE TABLE IF NOT EXISTS `commande` (
`numetu` varchar(15)
,`nom` varchar(50)
,`prenom` varchar(50)
,`math` decimal(4,2)
,`pc` decimal(4,2)
,`svt` decimal(4,2)
,`anglais` decimal(4,2)
,`francais` decimal(4,2)
,`moyenne` decimal(10,2)
);
-- --------------------------------------------------------

--
-- Structure de la vue `commande`
--
DROP TABLE IF EXISTS `vcommande`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vnote` AS select `tbnote`.`numetu` AS `numetu`,`tbnote`.`nom` AS `nom`,`tbnote`.`prenom` AS `prenom`,`tbnote`.`math` AS `math`,`tbnote`.`pc` AS `pc`,`tbnote`.`svt` AS `svt`,`tbnote`.`anglais` AS `anglais`,`tbnote`.`francais` AS `francais`,round(((((((`tbnote`.`math` * 4) + (`tbnote`.`pc` * 3)) + (`tbnote`.`svt` * 3)) + (`tbnote`.`anglais` * 2)) + (`tbnote`.`francais` * 3)) / 15),2) AS `moyenne` from `tbnote`;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
