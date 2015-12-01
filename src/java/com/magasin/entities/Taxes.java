/**
 * Cette classe sert pour le calcul d'une facture. Elle inclut le calcul pour le
 * montant de TPS, de TVQ et le montant total.
 * Fichier : Taxes.java
 * Date de création : 2015-02-24
 * Date de modification : 2015-11-30
 * @author Michel Plamondon
 * @version 1.0
 */
package com.magasin.entities;

public class Taxes {
    
    private static final double TPS = 0.05;
    private static final double TVQ = 0.09975;

    public Taxes() {
    }

    /**
     * Cette méthode retourne le montant de la TPS.
     * @param montantHorsTaxes Somme des items sans les taxes.
     * @return Valeur de type double représentant le montant de la TPS.
     */    
    public static double getMontantTPS(double montantHorsTaxes) {
    	return montantHorsTaxes >= 0 ? montantHorsTaxes * TPS : 0;
    }

    /**
     * Cette méthode retourne le montant de la TVQ.
     * @param montantHorsTaxes Somme des items sans les taxes.
     * @return Valeur de type double représentant le montant de la TVQ.
     */     
    public static double getMontantTVQ(double montantHorsTaxes) {
    	return montantHorsTaxes >= 0 ? (montantHorsTaxes + getMontantTPS(montantHorsTaxes)) * TVQ : 0;
    }

    /**
     * Cette méthode retourne le montant total d'une facture.
     * @param montantHorsTaxes Somme des items sans les taxes.
     * @return Valeur de type double représentant le montant total.
     */     
    public static double getMontantTotal(double montantHorsTaxes) {
    	return montantHorsTaxes >= 0 ? montantHorsTaxes + getMontantTPS(montantHorsTaxes) + getMontantTVQ(montantHorsTaxes) : 0;
    }    
}
