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
    private String codeProduit,codeBarre,nom,categorie,prix,qantite;

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

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getQantite() {
        return qantite;
    }

    public void setQantite(String qantite) {
        this.qantite = qantite;
    }



    @Override
    public String toString() {
        return "Produit{" + "codeProduit=" + codeProduit + ", codeBarre=" + codeBarre + ", nom=" + nom + ", categorie=" + categorie + ", prix=" + prix + ", qantite=" + qantite + '}';
    }
    
}