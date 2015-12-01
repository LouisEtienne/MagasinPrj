/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magasin.entities;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Louis
 */
public class ValidationTest {
    
    public ValidationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // Exemple de test de Michel
    @Test
    public void testTelephoneTiretMalPlace() {
        assertEquals(false, Validation.pregMatchTele("514—123-456"));       
    }
    
    /**
     * Test of pregMatchTele method, of class Validation.
     */
    @Test
    public void testPregMatchTeleVide() {
        assertEquals(false, Validation.pregMatchTele(""));       
    }
    
    @Test
    public void testPregMatchTeleOk() {
        assertEquals(true, Validation.pregMatchTele("418-659-2304"));       
    }
    
    @Test
    public void testPregMatchTeleTropCourt() {
        assertEquals(false, Validation.pregMatchTele("418-659-230"));       
    }
    
    @Test
    public void testPregMatchTeleTropLong() {
        assertEquals(false, Validation.pregMatchTele("418-659-230044"));       
    }
    
    @Test
    public void testPregMatchTeleLettre() {
        assertEquals(false, Validation.pregMatchTele("418-659-230A"));       
    }
    
        
   
    /**
     * Test of pregMatchCodePostal method, of class Validation.
     */
    @Test
    public void testPregMatchCodePostalChaineVide() {
        assertEquals(false, Validation.pregMatchCodePostal(""));
    }
    
    @Test
    public void testPregMatchCodePostal() {
        assertEquals(true, Validation.pregMatchCodePostal("H1M2K5"));
    }
    
    @Test
    public void testPregMatchCodePostalMinuscule() {
        assertEquals(true, Validation.pregMatchCodePostal("h1m2k5"));
    }
    
    @Test
    public void testPregMatchCodePostalMauvaisOrdre() {
        assertEquals(false, Validation.pregMatchCodePostal("1hm2k5"));
    }
    
    @Test
    public void testPregMatchCodePostalMauvaisOrdre2() {
        assertEquals(false, Validation.pregMatchCodePostal("h1mk25"));
    }
    
    @Test
    public void testPregMatchCodePostalTropCours() {
        assertEquals(false, Validation.pregMatchCodePostal("H2T"));
    }

    /**
     * Test of pregMatchCredit method, of class Validation.
     */
    @Test
    public void testPregMatchCreditChaineVide() {
        assertEquals(false, Validation.pregMatchCredit(""));
    }
    
    @Test
    public void testPregMatchCreditChaineOK() {
        assertEquals(true, Validation.pregMatchCredit("4184123412341234"));
    }
    
    @Test
    public void testPregMatchCreditTropCourt() {
        assertEquals(false, Validation.pregMatchCredit("418659230"));
    }
    
    @Test
    public void testPregMatchCreditTropLong() {
        assertEquals(false, Validation.pregMatchCredit("41822304333344444445678"));
    }
    
    @Test
    public void testPregMatchCreditLettre() {
        assertEquals(false, Validation.pregMatchCredit("418965A823043254"));
    }
    
    @Test
    public void testPregMatchCodeProduit() {
        assertEquals(true, Validation.pregMatchCodeProduit("PATL123456"));
    }
    
    @Test
    public void testPregMatchCodeProduitMinuscule() {
        assertEquals(true, Validation.pregMatchCodeProduit("patl123456"));
    }
    
    @Test
    public void testPregMatchCodeProduitLettre() {
        assertEquals(false, Validation.pregMatchCodeProduit("PATLAME456"));
    }
    
    @Test
    public void testPregMatchCodeProduitChaineVide() {
        assertEquals(false, Validation.pregMatchCodeProduit(""));
    }
    
    @Test
    public void testPregMatchCodeProduitTropLong() {
        assertEquals(false, Validation.pregMatchCodeProduit("PATL1234567"));
    }
    
    @Test
    public void testPregMatchCodeProduitTropCourt() {
        assertEquals(false, Validation.pregMatchCodeProduit("PATL12345"));
    }
    
    @Test
    public void testPregMatchCodeBarre11() {
        assertEquals(true, Validation.pregMatchCodeBarre("12345678911"));
    }
    
    @Test
    public void testPregMatchCodeBarre12() {
        assertEquals(true, Validation.pregMatchCodeBarre("123456789012"));
    }
    
    @Test
    public void testPregMatchCodeBarreTropLong() {
        assertEquals(false, Validation.pregMatchCodeBarre("12345678900111"));
    }
    
    @Test
    public void testPregMatchCodeBarreTropCourt() {
        assertEquals(false, Validation.pregMatchCodeBarre("123456789"));
    }
    
    @Test
    public void testPregMatchCodeBarreLettre() {
        assertEquals(false, Validation.pregMatchCodeBarre("1234567890A"));
    }
    
    @Test
    public void testPregMatchCodeBarreChaineVide() {
        assertEquals(false, Validation.pregMatchCodeBarre(""));
    }
    
    @Test
    public void testPregMatchCourriel() {
        assertEquals(true, Validation.pregMatchCourriel("louis@gmail.com"));
    }
    
    @Test
    public void testPregMatchCourrielSansPseudo() {
        assertEquals(false, Validation.pregMatchCourriel("@gmail.com"));
    }
    
    @Test
    public void testPregMatchCourrielSansArobas() {
        assertEquals(false, Validation.pregMatchCourriel("louisgmail.com"));
    }
    
    @Test
    public void testPregMatchCourrielSansPointCom() {
        assertEquals(false, Validation.pregMatchCourriel("louis@gmail"));
    }
    
    @Test
    public void testPregMatchCourrielNomSeul() {
        assertEquals(false, Validation.pregMatchCourriel("louis"));
    }
    
    @Test
    public void testPregMatchCourrielChaineVide() {
        assertEquals(false, Validation.pregMatchCourriel(""));
    }
    
}
