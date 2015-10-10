/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor...
 */
package com.magasin.jdbc.dao.implementation;

import com.magasin.entities.Acheteur;
import com.magasin.jdbc.dao.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import org.apache.catalina.User;

/**
 *
 * @author Louis
 */
public class AcheteurDao extends Dao<Acheteur> {

    public AcheteurDao(Connection c) {
        super(c);
    }
    
    @Override
    public boolean create(Acheteur x) {
        // TODO Auto-generated method stub

        String req = "INSERT INTO user (`numId` , `mdp`) "
                + "VALUES ('" + x.getCourriel() + "','" + x.getMotPasseAcheteur() + "','" + x.getNoCarteCredit() + "','" + x.getNomAcheteur() + "','" + x.getPrenomAcheteur() + 
                "','" + x.getAdresse() + "','" + x.getVille() + "','" + x.getProvince() + "','" + x.getCodePostal() + "','" + x.getTelephonePrincipal() + "'"
                + ",'" + x.getTelephoneSecondaire() + "','" + x.isCompteActif() + "')";

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
    public boolean delete(Acheteur x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM user WHERE courriel='" + x.getCourriel() + "'");
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
    public Acheteur read(String id) {
        // TODO Auto-generated method stub
        PreparedStatement stm = null;
        try {
//            Statement stm = cnx.createStatement();
//            ResultSet r = stm.executeQuery("SELECT * FROM user WHERE numId = '" + id + "'");
            //Avec requête paramétrée :
            stm = cnx.prepareStatement("SELECT * FROM user WHERE courriel = ?");
            stm.setString(1,id);
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                //User c = new User(r.getString("numId"),r.getString("mdp"));
                Acheteur c = new Acheteur();
                c.setCourriel(r.getString("courriel"));
                c.setMotPasseAcheteur(r.getString("motPasseAcheteur"));
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
    public boolean update(Acheteur x) {
        // TODO Auto-generated method stub
        Statement stm = null;
        try {
            String req = "UPDATE user SET motPasseAcheteur = '" + x.getMotPasseAcheteur() + "'"
                    + " WHERE courriel = '" + x.getCourriel() + "'";
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
    public List<Acheteur> findAll() {
        // TODO Auto-generated method stub
        List<Acheteur> liste = new LinkedList<Acheteur>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM acheteur");
            while (r.next()) {
                Acheteur c = new Acheteur(r.getString("courriel"),
                        r.getString("motPasseAcheteur"));
                liste.add(c);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }
}
