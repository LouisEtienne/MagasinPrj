-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Ven 13 Novembre 2015 à 13:39
-- Version du serveur :  5.6.20-log
-- Version de PHP :  5.4.31

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
  `compteActif` tinyint(1) NOT NULL
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
  `prenomAdministrateur` varchar(30) NOT NULL
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
  `codeProduit` varchar(200) NOT NULL,
  `codeBarre` varchar(200) NOT NULL,
  `nomProduit` varchar(200) NOT NULL,
  `categorieProduit` varchar(200) NOT NULL,
  `prixProduit` varchar(3) NOT NULL,
  `quantite` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `acheteur`
--
ALTER TABLE `acheteur`
 ADD PRIMARY KEY (`courriel`), ADD UNIQUE KEY `noCarteCredit` (`noCarteCredit`);

--
-- Index pour la table `administrateur`
--
ALTER TABLE `administrateur`
 ADD PRIMARY KEY (`codeAdministrateur`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
 ADD PRIMARY KEY (`codeProduit`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
