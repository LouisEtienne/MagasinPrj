/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magasin.entities;

/**
 *
 * @author Louis-E
 */
public class Acheteur {
    
    private String courriel, motPasseAcheteur, noCarteCredit, nomAcheteur, prenomAcheteur,
                    adresse, ville, province, codePostal, telephonePrincipal, telephoneSecondaire;
    private int compteActif;

    public Acheteur(String courriel, String motPasseAcheteur) {
        this.courriel = courriel;
        this.motPasseAcheteur = motPasseAcheteur;
    }
    
    public Acheteur() {
        this.courriel = "";
        this.motPasseAcheteur = "";
        this.noCarteCredit = "";
        this.nomAcheteur = "";
        this.prenomAcheteur = "";
        this.adresse = "";
        this.ville = "";
        this.province = "";
        this.codePostal = "";
        this.telephonePrincipal = "";
        this.telephoneSecondaire = "";
        this.compteActif = 1;
        
    }

    public Acheteur(String courriel, String motPasseAcheteur, String noCarteCredit, String nomAcheteur, String prenomAcheteur,
                    String adresse, String ville, String province, String codePostal, String telephonePrincipal, String telephoneSecondaire,
                    int compteActif) {
        this.courriel = courriel;
        this.motPasseAcheteur = motPasseAcheteur;
        this.noCarteCredit = noCarteCredit;
        this.nomAcheteur = nomAcheteur;
        this.prenomAcheteur = prenomAcheteur;
        this.adresse = adresse;
        this.ville = ville;
        this.province = province;
        this.codePostal = codePostal;
        this.telephonePrincipal = telephonePrincipal;
        this.telephoneSecondaire = telephoneSecondaire;
        this.compteActif = compteActif;
    }    

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getMotPasseAcheteur() {
        return motPasseAcheteur;
    }

    public void setMotPasseAcheteur(String motPasseAcheteur) {
        this.motPasseAcheteur = motPasseAcheteur;
    }

    public String getNoCarteCredit() {
        return noCarteCredit;
    }

    public void setNoCarteCredit(String noCarteCredit) {
        this.noCarteCredit = noCarteCredit;
    }

    public String getNomAcheteur() {
        return nomAcheteur;
    }

    public void setNomAcheteur(String nomAcheteur) {
        this.nomAcheteur = nomAcheteur;
    }

    public String getPrenomAcheteur() {
        return prenomAcheteur;
    }

    public void setPrenomAcheteur(String prenomAcheteur) {
        this.prenomAcheteur = prenomAcheteur;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getTelephonePrincipal() {
        return telephonePrincipal;
    }

    public void setTelephonePrincipal(String telephonePrincipal) {
        this.telephonePrincipal = telephonePrincipal;
    }

    public String getTelephoneSecondaire() {
        return telephoneSecondaire;
    }

    public void setTelephoneSecondaire(String telephoneSecondaire) {
        this.telephoneSecondaire = telephoneSecondaire;
    }

    public int isCompteActif() {
        return compteActif;
    }

    public void setCompteActif(int compteActif) {
        this.compteActif = compteActif;
    }

    
}

