-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 17 Décembre 2015 à 21:10
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
('luc@gmail.com', '4321', '12300001234', 'Brunet', 'Simon', '4352 De larochelle', 'Montreal', 'Qc', 'xyz 432', '514-900-9866', '514-800-8777', 1),
('test', 'test', '1234567890987654', 'Tracy', 'Nathasha', 'Julie', 'Maryse', 'Samantha', 'l9p6r4', '514-234-3456', '535-345-3455', 1),
('jean@hotmail.com', 'admin', '123456789012345', 'Lemire', 'Jean', '111 Gold', 'Mtl', 'Qc', 'H1M2K5', '514-878-1280', 'null', 1),
('Yves@gmail.com', '1234', '0000999933338888', 'eldorado', 'Yves', '222 Silver', 'Mtl', 'Qc', 'H1M2k5', '514-333-3333', 'null', 1),
('Chantal@gmail.com', '4564', '7777666655554444', 'Remy', 'Chantal', '234 Duroseiers', 'Montreal', 'Qc', 'H1M2K5', '348-999-7777', '514-659-2304', 1);

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
('admin', 'admin', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE IF NOT EXISTS `facture` (
  `noFacture` int(255) NOT NULL AUTO_INCREMENT,
  `courriel` varchar(255) NOT NULL,
  `dateFacture` date NOT NULL,
  `montantHorsTaxes` double NOT NULL,
  `montantTPS` double NOT NULL,
  `montantTVQ` double NOT NULL,
  `montantTotal` double NOT NULL,
  PRIMARY KEY (`noFacture`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `lignefacture`
--

CREATE TABLE IF NOT EXISTS `lignefacture` (
  `noLigneFacture` int(11) NOT NULL AUTO_INCREMENT,
  `noFacture` int(255) NOT NULL,
  `codeProduitAchat` varchar(255) NOT NULL,
  `quantiteProduit` int(255) NOT NULL,
  `prixProduitAchat` double NOT NULL,
  PRIMARY KEY (`noLigneFacture`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE IF NOT EXISTS `produit` (
  `codeProduit` varchar(10) NOT NULL,
  `codeBarre` varchar(255) NOT NULL,
  `nomProduit` varchar(255) NOT NULL,
  `categorieProduit` varchar(255) NOT NULL,
  `prixProduit` double NOT NULL,
  `quantiteProduit` int(11) NOT NULL,
  `imageProduit` varchar(255) NOT NULL,
  PRIMARY KEY (`codeProduit`),
  UNIQUE KEY `codeBarre` (`codeBarre`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`codeProduit`, `codeBarre`, `nomProduit`, `categorieProduit`, `prixProduit`, `quantiteProduit`, `imageProduit`) VALUES
('bure890345', '159753123654', 'Bureau', 'Mobilier', 48.99, 42, 'rajouter image? '),
('chai734343', '4653248978965', 'Chaise', 'Mobilier', 75.96, 56, 'rajouter image? '),
('java123456', '789456123456', 'Café colombien', 'Nourriture', 8.99, 7, 'rajouter image? '),
('poiu452369', '789456123552', 'Souris', 'Informatique', 59.99, 42, 'rajouter image? '),
('foul345698', '753159963498', 'Foulard', 'Vêtement', 41.85, 18, 'rajouter image? ');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
