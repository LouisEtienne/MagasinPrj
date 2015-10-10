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
public class Administrateur {
    
    private String codeAdministrateur, motPasseAdministrateur, nomAdministrateur, 
            prenomAdministrateur;

    public Administrateur(String codeAdministrateur, String motPasseAdministrateur) {
        this.codeAdministrateur = codeAdministrateur;
        this.motPasseAdministrateur = motPasseAdministrateur;
    }
    
    public Administrateur() {
        this.codeAdministrateur = "";
        this.motPasseAdministrateur = "";
        this.nomAdministrateur = "";
        this.prenomAdministrateur = "";
    }

    public Administrateur(String codeAdministrateur, String motPasseAdministrateur, String nomAdministrateur, String prenomAdministrateur) {
        this.codeAdministrateur = codeAdministrateur;
        this.motPasseAdministrateur = motPasseAdministrateur;
        this.nomAdministrateur = nomAdministrateur;
        this.prenomAdministrateur = prenomAdministrateur;
    }

    public String getCodeAdministrateur() {
        return codeAdministrateur;
    }

    public void setCodeAdministrateur(String codeAdministrateur) {
        this.codeAdministrateur = codeAdministrateur;
    }

    public String getMotPasseAdministrateur() {
        return motPasseAdministrateur;
    }

    public void setMotPasseAdministrateur(String motPasseAdministrateur) {
        this.motPasseAdministrateur = motPasseAdministrateur;
    }

    public String getNomAdministrateur() {
        return nomAdministrateur;
    }

    public void setNomAdministrateur(String nomAdministrateur) {
        this.nomAdministrateur = nomAdministrateur;
    }

    public String getPrenomAdministrateur() {
        return prenomAdministrateur;
    }

    public void setPrenomAdministrateur(String prenomAdministrateur) {
        this.prenomAdministrateur = prenomAdministrateur;
    }
    
}
