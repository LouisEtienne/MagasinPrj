/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magasin.jdbc.dao.implementation;
import com.magasin.entities.Acheteur;
import com.magasin.entities.Produit;
import com.magasin.jdbc.dao.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author usager
 */
public class ProduitDAO extends Dao<Produit>{

    public ProduitDAO(Connection cnx) {
        super(cnx);
    }

    @Override
    public boolean create(Produit p) {
        String img = "rajouter image?";
        String req = "INSERT INTO `produit`(`codeProduit`, `codeBarre`, `nomProduit`, `categorieProduit`, `prixProduit`, `quantiteProduit`,`imageProduit`) VALUES "
            + "('" +p.getCodeProduit()+"','"+p.getCodeBarre()+"','"+p.getNom()+"','"+p.getCategorie()+"','"+p.getPrix()+"','"+p.getQuantite()+"','"+img +" ')";
            System.out.println("REQUETE "+req);

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
                exp.printStackTrace();
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
    public Produit read(String code) {
                PreparedStatement stm = null;
        try {
            stm = cnx.prepareStatement("SELECT * FROM produit WHERE LOWER(codeProduit) = LOWER('" + code +"')");
            ResultSet r = stm.executeQuery();
            if (r.next()) {
                Produit p = new Produit();
                p.setCategorie(r.getString("categorieProduit"));
                p.setCodeBarre(r.getString("codeBarre"));
                p.setCodeProduit(r.getString("codeProduit"));
                p.setNom(r.getString("nomProduit"));
                p.setPrix(r.getDouble("prixProduit"));
                p.setQuantite(r.getInt("quantiteProduit"));                
                r.close();
                stm.close();
                return p;
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
    public boolean update(Produit p) {
        Statement stm = null;
        try {
            //a faire
            String req="UPDATE `produit` SET codeProduit=\""+p.getCodeProduit()+"\", codeBarre =\""+p.getCodeBarre()+"\", nomProduit=\"" + p.getNom() + "\", categorieProduit=\"" + p.getCategorie() + "\", prixProduit=\"" + p.getPrix()+"\", quantiteProduit=\"" + p.getQuantite()  
            +"\""+" WHERE codeProduit = '" + p.getCodeProduit() + "'";
            
            
            
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
    public boolean delete(Produit x) {
        Statement stm = null;
        try {
            stm = cnx.createStatement();
            int n = stm.executeUpdate("DELETE FROM produit WHERE LOWER(codeProduit) = LOWER('" + x.getCodeProduit() + "')");
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
    public List<Produit> findAll() {
                List<Produit> liste = new LinkedList<Produit>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r = stm.executeQuery("SELECT * FROM produit");
            while (r.next()) {
                Produit p = new Produit();//a faire
                p.setCategorie(r.getString("categorieProduit"));
                p.setCodeBarre(r.getString("codeBarre"));
                p.setCodeProduit(r.getString("codeProduit"));
                p.setNom(r.getString("nomProduit"));
                p.setPrix(r.getDouble("prixProduit"));
                p.setQuantite(r.getInt("quantiteProduit"));
                liste.add(p);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return liste;
    }
    public List<Produit> findAllParametre(char type, String recherche) {
                List<Produit> list = new LinkedList<Produit>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r;
            
            // D'autres types de recherche vont s'ajouter dans le futur.
            switch(type){
                case 'n'://nom  
                    r = stm.executeQuery("SELECT * FROM produit WHERE LOWER(nomProduit) LIKE LOWER('%"+ recherche+"%')");
                    break;
                default:
                    r = stm.executeQuery("SELECT * FROM produit WHERE LOWER(categorieProduit) LIKE LOWER('%"+ recherche+"%')");
                    break;
            }      
            
            while (r.next()) {
                Produit p = new Produit();
                p.setCategorie(r.getString("categorieProduit"));
                p.setCodeBarre(r.getString("codeBarre"));
                p.setCodeProduit(r.getString("codeProduit"));
                p.setNom(r.getString("nomProduit"));
                p.setPrix(r.getDouble("prixProduit"));
                p.setQuantite(r.getInt("quantiteProduit"));
                list.add(p);
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return list;
    }
    
    public List<String> findCategorie() {
                List<String> list = new LinkedList<String>();
        try {
            Statement stm = cnx.createStatement();
            ResultSet r;
            
            r = stm.executeQuery("SELECT DISTINCT categorieProduit FROM produit");
      
            while (r.next()) {
                list.add(r.getString("categorieProduit"));
            }
            r.close();
            stm.close();
        } catch (SQLException exp) {
        }
        return list;
    }      
}
