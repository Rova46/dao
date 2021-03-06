package com.inclusiv.daojee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
	private String url;
	private String username;
	private String password;

	public DaoFactory(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public static DaoFactory getInstance() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {

		}

		DaoFactory daoFactory = new DaoFactory("jdbc:mysql://localhost:3306/inclusiv_projet", "root", "");
		return daoFactory;
	}
	
	public Connection getConnexion() throws SQLException {
		return DriverManager.getConnection(url,username,password);
	}
	
	public UtilisateurDaoImpl getUtilisateurDaoImpl() {
		return new UtilisateurDaoImpl(this);
		
	}
}
