/**
 * Cette classe contient les informations sur une facture pour un client en
 * particulier. Elle comprend des lignes de facture pour chaque produit acheté
 * ainsi que les différents montants.
 * Fichier : LigneFacture.java
 * Date de création : 2015-02-24
 * Date de modification : 2015-12-01
 * @author Michel Plamondon
 * @version 1.0
 */
package com.magasin.entities;

public class LigneFacture {
    
    private String codeProduitAchat;
    private double prixProduitAchat;
    private int quantiteProduits;

    /** 
     * Ce constructeur permet de construire une ligne de facture par défaut.
     */     
    public LigneFacture() {
        this("",0,0);
    }

    /** 
     * Ce constructeur permet de construire une ligne de facture contenant le
     * produit acheté, la quantité ainsi que le prix au moment de l'achat de
     * l'article.
     * @param codeProduitAchat Le code du produit existant dans la base de données au moment de l'achat.
     * @param prixProduitAchat Le prix du produit au moment de l'achat.
     * @param quantiteProduits La quantité de produits vendus à l'acheteur.
     */    
    public LigneFacture(String codeProduitAchat, double prixProduitAchat, int quantiteProduits) {
        this.setCodeProduitAchat(codeProduitAchat);
        this.setPrixProduitAchat(prixProduitAchat);
        this.setQuantiteProduits(quantiteProduits);
    }

    /** 
     * Cette méthode retourne le code du produit au moment de l'achat.
     * @return Chaîne de caractères représentant le code du produit au moment de l'achat.
     */ 
    public String getCodeProduitAchat() {
        return codeProduitAchat;
    }

    /** 
     * Cette méthode initialise le code du produit au moment de l'achat.
     * @param codeProduitAchat Chaîne de caractères représentant le code du produit.
     */  
    public void setCodeProduitAchat(String codeProduitAchat) {
        this.codeProduitAchat = codeProduitAchat;
    }

    /** 
     * Cette méthode retourne le prix d'un produit au moment de l'achat.
     * @return Valeur de type double représentant le prix du produit au moment de l'achat.
     */ 
    public double getPrixProduitAchat() {
        return prixProduitAchat;
    }

    /** 
     * Cette méthode initialise le prix du produit au moment de l'achat.
     * @param prixProduitAchat Valeur réelle représentant le prix du produit au moment de l'achat.
     */    
    public void setPrixProduitAchat(double prixProduitAchat) {
        this.prixProduitAchat = prixProduitAchat >= 0 ? prixProduitAchat : 0;
    }

    /** 
     * Cette méthode retourne la quantité des produits vendus à l'acheteur.
     * @return Valeur entière représentant la quantité de produits vendus.
     */ 
    public int getQuantiteProduits() {
        return quantiteProduits;
    }

    /** 
     * Cette méthode initialise la quantité de produits vendus.
     * @param quantiteProduits Valeur entière représentant la quantité de produits vendus.
     */
    public void setQuantiteProduits(int quantiteProduits) {
        this.quantiteProduits = quantiteProduits >= 0 ? quantiteProduits : 0;
    }  
}
