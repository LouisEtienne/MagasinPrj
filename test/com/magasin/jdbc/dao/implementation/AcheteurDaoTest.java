/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magasin.jdbc.dao.implementation;

import com.magasin.entities.Acheteur;
import com.magasin.jdbc.Connexion;
import java.util.List;
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
public class AcheteurDaoTest {
    
    public AcheteurDaoTest() {
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
    
    /**
     * Test of create method, of class AcheteurDao.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Acheteur x = new Acheteur("louis@gmail.com","1234","1234567890987654","Lemire"
                ,"Louis","6239 FieldStreet","Montreal","Quebec","H1M2K5","455-455-4555","544-544-5444",1);
       // boolean expResult = true;
        Connexion.setUrl("jdbc:mysql://localhost/online_store?user=root&amp;password=root");
        AcheteurDao adao = new AcheteurDao(Connexion.getInstance());
        
        assert(adao.create(x));
    }

    /**
     * Test of delete method, of class AcheteurDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Acheteur x = null;
        AcheteurDao instance = null;
        boolean expResult = false;
        boolean result = instance.delete(x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class AcheteurDao.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        String courriel = "";
        AcheteurDao instance = null;
        Acheteur expResult = null;
        Acheteur result = instance.read(courriel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkLogin method, of class AcheteurDao.
     */
    @Test
    public void testCheckLogin() {
        System.out.println("checkLogin");
        String user = "";
        String password = "";
        AcheteurDao instance = null;
        boolean expResult = false;
        boolean result = instance.checkLogin(user, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class AcheteurDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Acheteur x = null;
        AcheteurDao instance = null;
        boolean expResult = false;
        boolean result = instance.update(x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class AcheteurDao.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        AcheteurDao instance = null;
        List<Acheteur> expResult = null;
        List<Acheteur> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
