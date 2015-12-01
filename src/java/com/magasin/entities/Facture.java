/**
 * Cette classe contient les informations sur une facture pour un client en
 * particulier. Elle comprend des lignes de facture pour chaque produit acheté
 * ainsi que les différents montants.
 * Fichier : Taxes.java
 * Date de création : 2015-02-24
 * Date de modification : 2015-11-30
 * @author Michel Plamondon
 * @version 1.0
 */
package com.magasin.entities;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Facture {
    
    private int noFacture;
    private Date dateFacture;
    private double montantHorsTaxes;
    private double montantTVQ;
    private double montantTPS;
    private double montantTotal;
    private List<LigneFacture> listeLignesFacture = new LinkedList<LigneFacture>();
    private Acheteur unAcheteur;

    /** 
     * Ce constructeur permet de construire une facture par défaut.
     */    
    public Facture() {
        this(0,null,0,0,0,0,null);
    }
    
    /** 
     * Ce constructeur permet de construire une facture avec les valeurs calculées
     * pour un achat d'un achteur en particulier.
     * @param noFacture Valeur entière représentant le numéro de la facture.
     * @param dateFacture Valeur de type Date représentant la date de la facture.
     * @param montantHorsTaxes Valeur de type double pour le montant hors taxes.
     * @param montantTVQ Valeur de type double pour le montant de la TVQ.
     * @param montantTPS Valeur de type double pour le montant de la TPS.
     * @param montantTotal Valeur de type double pour le montant de le montant total.
     */
    public Facture(int noFacture, Date dateFacture, double montantHorsTaxes, double montantTVQ, double montantTPS, double montantTotal, Acheteur unAcheteur) {
        this.noFacture = noFacture;
        this.dateFacture = dateFacture;
        this.setMontantHorsTaxes(montantHorsTaxes);
        this.setMontantTVQ(montantTVQ);
        this.setMontantTPS(montantTPS);
        this.setMontantTotal(montantTotal);
        this.unAcheteur = unAcheteur;
    }

    /** 
     * Cette méthode retourne le numéro de la facture.
     * @return Valeur entière représentant le numéro de la facture.
     */    
    public int getNoFacture() {
        return noFacture;
    }

    /** 
     * Cette méthode initialise le numéro de la facture.
     * @param noFacture Représente le numéro de la facture.
     */    
    public void setNoFacture(int noFacture) {
        this.noFacture = noFacture;
    }

    /** 
     * Cette méthode retourne la date de facturation.
     * @return Valeur de type Date pour la date de facturation.
     */      
    public Date getDateFacture() {
        return dateFacture;
    }

    /** 
     * Cette méthode initialise la date de la facturation.
     * @param dateFacture Représente la date de la facturation.
     */     
    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    /** 
     * Cette méthode retourne le montant hors taxes de la facturation.
     * @return Valeur réelle représentant le montant hors taxes.
     */     
    public double getMontantHorsTaxes() {
        return montantHorsTaxes;
    }

    /** 
     * Cette méthode initialise le montant hors taxes de la facture.
     * @param montantHorsTaxes Représente le montant hors taxes de la facture.
     */     
    public void setMontantHorsTaxes(double montantHorsTaxes) {
        this.montantHorsTaxes = montantHorsTaxes >= 0 ? montantHorsTaxes : 0;
    }

    /** 
     * Cette méthode retourne le montant de la TVQ de la facturation.
     * @return Valeur réelle représentant le montant de la TVQ.
     */    
    public double getMontantTVQ() {
        return montantTVQ;
    }

    /** 
     * Cette méthode initialise le montant de la TVQ.
     * @param montantTotal Représente le montant de la TVQ figurant sur la facture.
     */     
    public void setMontantTVQ(double montantTVQ) {
        this.montantTVQ = montantTVQ >= 0 ? montantTVQ : 0;
    }

    /** 
     * Cette méthode retourne le montant de la TPS de la facturation.
     * @return Valeur réelle représentant le montant de la TPS.
     */    
    public double getMontantTPS() {
        return montantTPS;
    }

    /** 
     * Cette méthode initialise le montant de la TPS.
     * @param montantTPS Représente le montant de la TPS figurant sur la facture.
     */     
    public void setMontantTPS(double montantTPS) {
        this.montantTPS = montantTPS >= 0 ? montantTPS : 0;
    }

    /** 
     * Cette méthode retourne le montant total de la facturation.
     * @return Valeur réelle représentant le montant total de la facturation.
     */    
    public double getMontantTotal() {
        return montantTotal;
    }

    /** 
     * Cette méthode initialise le montant total de la facture.
     * @param montantTotal Représente le montant total de la facture.
     */     
    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal >= 0 ? montantTotal : 0;
    }

    /** 
     * Cette méthode retourne la liste des lignes de la facture.
     * @return Liste contenant les lignes de la facturation pour un acheteur.
     */    
    public List<LigneFacture> getListeLignesFacture() {
        return listeLignesFacture;
    }

    /** 
     * Cette méthode initialise la liste des lignes pour la facturation.
     * @param listeLignesFacture Contient la liste des lignes de la facture.
     */     
    public void setListeLignesFacture(List<LigneFacture> listeLignesFacture) {
        this.listeLignesFacture = listeLignesFacture;
    }

    /** 
     * Cette méthode retourne les informations sur l'acheteur.
     * @return Valeur de type Acheteur contenant les informations sur l'acheteur.
     */    
    public Acheteur getUnAcheteur() {
        return unAcheteur;
    }

    /** 
     * Cette méthode initialise les informations sur un acheteur en lien avec la facture.
     * @param unAcheteur Contient les informations sur un acheteur.
     */     
    public void setUnAcheteur(Acheteur unAcheteur) {
        this.unAcheteur = unAcheteur;
    }

    /** 
     * Cette méthode détermine si deux factures sont identiques.
     * @return Valeur booléenne pour confirmer si deux factures sont identiques.
     */    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Facture other = (Facture) obj;
        if (this.noFacture != other.noFacture) {
            return false;
        }
        return true;
    }

    /** 
     * Cette méthode ajoute une ligne sur une facture pour un acheteur.
     * @param uneLigneFacture Une ligne contenant les informations sur un produit acheté.
     * @return Valeur booléenne pour confirmer l'ajout de la ligne dans la facture.
     */    
    public boolean ajouterLigneFacture(LigneFacture uneLigneFacture) {
       return listeLignesFacture.add(uneLigneFacture);
    }
}
