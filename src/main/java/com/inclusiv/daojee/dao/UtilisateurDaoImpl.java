package com.inclusiv.daojee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inclusiv.daojee.bean.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao{
	private DaoFactory daofactory;
	
	public UtilisateurDaoImpl(DaoFactory daofactory) {
		this.daofactory = daofactory;
	}

	@Override
	public void ajouter(Utilisateur utilisateur) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = daofactory.getConnexion();
			preparedStatement = this.daofactory.getConnexion().prepareStatement("INSERT INTO user(nom, prenom, mail, mdp) VALUES(?,?,?,?);");
			preparedStatement.setString(1, utilisateur.getNom());
			preparedStatement.setString(2, utilisateur.getPrenom());
			preparedStatement.setString(3, utilisateur.getEmail());
			preparedStatement.setString(4, utilisateur.getMdp());
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());;
		}
	}

	@Override
	public List<Utilisateur> lister() {
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = daofactory.getConnexion();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT `nom`,`prenom`,`mail` FROM `user`");
			
			while(resultSet.next()) {
				
				Utilisateur utilisateur = new Utilisateur();
				
				utilisateur.setNom(resultSet.getString(0));
				utilisateur.setPrenom(resultSet.getString(1));
				utilisateur.setEmail(resultSet.getString(2));
				
				utilisateurs.add(utilisateur);
			}
			
			resultSet.close();
			return utilisateurs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
