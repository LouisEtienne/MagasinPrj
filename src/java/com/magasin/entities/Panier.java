/**
 * Cette classe contient les produits selectionnés par l'acheteur en vue d'effectuer
 * une transaction financière.
 * Fichier : Panier.java
 * Date de création : 2015-02-24
 * Date de modification : 2015-12-01
 * @author Michel Plamondon
 * @version 1.0
 */
package com.magasin.entities;

import java.util.LinkedList;
import java.util.List;

public class Panier {
    
    private Acheteur unAcheteur;
    private List<Produit> listeProduits = new LinkedList<Produit>();

    /** 
     * Ce constructeur permet de construire un panier par défaut.
     */    
    public Panier() {
        this(null);
    }
    
    /** 
     * Ce constructeur permet de construire un panier pour un acheteur.
     * @param unAcheteur Les informations sur l'acheteur en lien avec le panier.
     */
    public Panier(Acheteur unAcheteur) {
        this.unAcheteur = unAcheteur;
    }

    public Acheteur getUnAcheteur() {
        return unAcheteur;
    }

    public void setUnAcheteur(Acheteur unAcheteur) {
        this.unAcheteur = unAcheteur;
    }
    
    /** 
     * Cette méthode ajoute un produit dans le panier de l'acheteur.
     * @param unProduit Une ligne contenant les informations sur un produit à ajouter.
     * @return Valeur booléenne pour confirmer l'ajout du produit dans le panier.
     */    
    public boolean ajouterProduit(Produit unProduit) {
       return listeProduits.add(unProduit);
    }
    
    /** 
     * Cette méthode supprimer un produit dans le panier de l'acheteur.
     * @param unProduit Une ligne contenant les informations sur un produit à supprimer.
     * @return Valeur booléenne pour confirmer la suppression du produit dans le panier.
     */    
    public boolean supprimerProduit(Produit unProduit) {
        return listeProduits.remove(unProduit);
    }   
}
