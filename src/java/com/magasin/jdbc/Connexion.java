/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magasin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Louis-E
 */
public class Connexion {
    
	private static Connection cnx;
	private static String 	url,
				user = "", password="";
	public static Connection getInstance()
	{
            if (cnx == null)
                try {
                    if (user.equals(""))
                            cnx = DriverManager.getConnection(url);
                    else
                            cnx = DriverManager.getConnection(url,user,password);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            return cnx;
	}
        
	public static void reinit()
	{
		cnx = null;
	}
	public static void close()
	{
		try {
			if (cnx!=null)
				cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
                
	}
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		Connexion.url = url;
	}
	public static String getUser() {
		return user;
	}
	public static void setUser(String user) {
		Connexion.user = user;
	}
	public static void setPassword(String password) {
		Connexion.password = password;
	}
}
