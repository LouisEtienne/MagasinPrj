/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor...
 */
package com.magasin.jdbc.dao.implementation;

import com.magasin.entities.Acheteur;
import com.magasin.entities.Administrateur;
import com.magasin.jdbc.dao.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Louis
 */
public class AdministrateurDao extends Dao<Administrateur> {
    //private Object cnx;

    public AdministrateurDao(Connection c) {
        super(c);
    }
    
    @Override
    public boolean create(Administrateur x) {
        // TODO Auto-generated method stub

        String req = "INSERT INTO user (`numId` , `mdp`) "
                + "VALUES ('" + x.getCodeAdministrateur() + "','" + x.getMotPasseAdministrateur() + "','" + x.getNomAdministrateur() + "','" + x.getPrenomAdministrateur() + "')";

        //System.out.println("REQUETE "+req);

        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } 
        catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return false;
    }

    @Override
    public boolean delete(Administrateur x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM user WHERE codeAdministrateur='" + x.getCodeAdministrateur() + "'");
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
    
    public boolean checkLogin(String c,String p) 
	{
            try 
            {
                Statement stm = null;
                stm = cnx.createStatement(); 
                ResultSet r = stm.executeQuery("SELECT codeAdministrateur, motPasseAdministrateur FROM administrateur WHERE codeAdministrateur = '"+ c +"' AND motPasseAdministrateur ='"+p+"'" );
                if (r.next())
                {
                       Administrateur a = new Administrateur(
                               r.getString("codeAdministrateur"),
                               r.getString("motPasseAdministrateur"));
                        r.close();
                        stm.close();
                        return true;
                }
            }
            catch (SQLException exp)
            {
            }
            return false;
	}


    @Override
    public Administrateur read(String id) {
        // TODO Auto-generated method stub
        PreparedStatement stm = null;
        try {
//            Statement stm = cnx.createStatement();
//            ResultSet r = stm.executeQuery("SELECT * FROM user WHERE numId = '" + id + "'");
            //Avec requête paramétrée :
            stm = cnx.prepareStatement("SELECT * FROM administrateur WHERE codeAdministrateur = ?");
            stm.setString(1,id);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                //User c = new User(r.getString("numId"),r.getString("mdp"));
                Administrateur c = new Administrateur();
                c.setCodeAdministrateur(r.getString("codeAdministrateur"));
                c.setMotPasseAdministrateur(r.getString("motPasseAdministrateur"));
                r.close();
                stm.close();
                return c;
            }
        } catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    @Override
    public boolean update(Administrateur x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            String req;
            req = "UPDATE user SET motPasseAdministrateur = '" + x.getMotPasseAdministrateur() + "'"
                    + " WHERE codeAdministrateur = '" + x.getCodeAdministrateur() + "'";
            //System.out.println("REQUETE "+req);
            stm = cnx.createStatement();
            int n = stm.executeUpdate(req);
            if (n > 0) {
                stm.close();
                return true;
            }
        } catch (SQLException exp) {
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public List<Administrateur> findAll() {
        // TODO Auto-generated method stub
        List<Administrateur> liste = new LinkedList<Administrateur>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM administrateur");
            while (r.next()) {
                Administrateur c = new Administrateur(r.getString("codeAdministrateur"),
                        r.getString("motPasseAdministrateur"));
                liste.add(c);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }
}
