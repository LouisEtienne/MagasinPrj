/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magasin.entities;

/**
 *
 * @author usager
 */
public class Produit {
    private String codeProduit,codeBarre,nom,
            categorie,imageProduit;
    private int quantite;
    private double prix;

    public Produit() {
    }

    public String getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(String codeProduit) {
        this.codeProduit = codeProduit;
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix >= 0 ? prix : 0;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite >= 0 ? quantite : 0;
    }

    public String getImageProduit() {
        return imageProduit;
    }

    public void setImageProduit(String imageProduit) {
        this.imageProduit = imageProduit;
    }

    @Override
    public String toString() {
        return "Produit{" + "codeProduit=" + codeProduit + ", codeBarre=" + codeBarre + ", nom=" + nom + ", categorie=" + categorie + ", prix=" + prix + ", quantite=" + quantite + '}';
    }
    
}
