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
public class Validation {
    
    public static boolean pregMatchTele(String content) {
        String patternTele = "[1-9][0-9][0-9][-][1-9][0-9][0-9][-][0-9][0-9][0-9][0-9]";
        return content.matches(patternTele);
    }
    
    public static boolean pregMatchCodePostal(String content) {
        String patternCodePostal = "[a-zA-Z][0-9][a-zA-Z][0-9][a-zA-Z][0-9]";
        return content.matches(patternCodePostal);
    }
    
    public static boolean pregMatchCredit(String content) {
        String patternCredit = "[0-9][0-9][0-9][1-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
        return content.matches(patternCredit);
    }
    
}
