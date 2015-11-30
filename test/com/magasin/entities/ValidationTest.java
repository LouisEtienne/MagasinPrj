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
    public void testPregMatchTele() {
        System.out.println("pregMatchTele");
        boolean expResult;
        String patternTele = "[1-9][0-9][0-9][-][1-9][0-9][0-9][-][0-9][0-9][0-9][0-9]";
        String content = "514-746-1234";
        if (content.matches(patternTele))
        {
            expResult = true;
        } else {
            expResult = false;
        } 
        boolean result = Validation.pregMatchTele(content);
        assertEquals(expResult, result);       
    }
    
    /**
     * String patternTele = "[1-9][0-9][0-9][-][1-9][0-9][0-9][-][0-9][0-9][0-9][0-9]";
     *   return content.matches(patternTele);
     */

    /**
     * Test of pregMatchCodePostal method, of class Validation.
     */
    @Test
    public void testPregMatchCodePostal() {
        System.out.println("pregMatchCodePostal");
         boolean expResult;
        String patternCodePostal = "[a-zA-Z][0-9][a-zA-Z][0-9][a-zA-Z][0-9]";
        String content = "H2T 5N4";
        if (content.matches(patternCodePostal))
        {
            expResult = true;
        } else {
            expResult = false;
        } 
        boolean result = Validation.pregMatchCodePostal(content);
        assertEquals(expResult, result);
    }

    /**
     * Test of pregMatchCredit method, of class Validation.
     */
    @Test
    public void testPregMatchCredit() {
        System.out.println("pregMatchCredit");
        boolean expResult;
        String patternCredit = "[0-9][0-9][0-9][1-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]";
        String content = "1234567890123456";
        if (content.matches(patternCredit))
        {
            expResult = true;
        } else {
            expResult = false;
        } 
        boolean result = Validation.pregMatchCredit(content);
        assertEquals(expResult, result);
    }
    
}
