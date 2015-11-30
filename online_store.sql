-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 30 Novembre 2015 à 03:13
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `online_store`
--

-- --------------------------------------------------------

--
-- Structure de la table `acheteur`
--

CREATE TABLE IF NOT EXISTS `acheteur` (
  `courriel` varchar(100) NOT NULL,
  `motPasseAcheteur` varchar(100) NOT NULL,
  `noCarteCredit` varchar(20) NOT NULL,
  `nomAcheteur` varchar(100) NOT NULL,
  `prenomAcheteur` varchar(100) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `ville` varchar(100) NOT NULL,
  `province` varchar(100) NOT NULL,
  `codePostal` varchar(100) NOT NULL,
  `telephonePrincipal` varchar(20) NOT NULL,
  `telephoneSecondaire` varchar(20) NOT NULL,
  `compteActif` tinyint(1) NOT NULL,
  PRIMARY KEY (`courriel`),
  UNIQUE KEY `noCarteCredit` (`noCarteCredit`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `acheteur`
--

INSERT INTO `acheteur` (`courriel`, `motPasseAcheteur`, `noCarteCredit`, `nomAcheteur`, `prenomAcheteur`, `adresse`, `ville`, `province`, `codePostal`, `telephonePrincipal`, `telephoneSecondaire`, `compteActif`) VALUES
('louis.etienne.lemire@gmail.com', 'diffusio13', '4540162030406790', 'Lemire', 'Louis', '6140 Duquesne', 'Montréal', 'Québec', 'H1M2K5', '514-706-2061', '438-763-2413', 1),
('test', 'test', '12345678', 'test', 'test', 'test', 'test', 'test', 'test', '12345667', '', 0),
('abc', 'null', 'abc', 'abc', 'abc', 'abc', 'abc', 'abc', 'abc', 'abc', 'null', 1),
('qwerty', 'null', 'qwerty', 'qwerty', 'qwerty', 'qwerty', 'qwerty', 'qwerty', 'qwerty', 'qwerty', 'null', 1),
('sup', 'null', '', '', '', '', '', '', '', '', 'null', 1);

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

CREATE TABLE IF NOT EXISTS `administrateur` (
  `codeAdministrateur` varchar(20) NOT NULL,
  `motPasseAdministrateur` varchar(30) NOT NULL,
  `nomAdministrateur` varchar(30) NOT NULL,
  `prenomAdministrateur` varchar(30) NOT NULL,
  PRIMARY KEY (`codeAdministrateur`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `administrateur`
--

INSERT INTO `administrateur` (`codeAdministrateur`, `motPasseAdministrateur`, `nomAdministrateur`, `prenomAdministrateur`) VALUES
('admin', 'admin', 'Plamondon', 'Michel');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE IF NOT EXISTS `produit` (
  `codeProduit` varchar(10) NOT NULL,
  `codeBarre` varchar(13) NOT NULL,
  `nomProduit` varchar(50) NOT NULL,
  `categorieProduit` varchar(30) NOT NULL,
  `prixProduit` double NOT NULL,
  `quantite` int(20) NOT NULL,
  PRIMARY KEY (`codeProduit`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
