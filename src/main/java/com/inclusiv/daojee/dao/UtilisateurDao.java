package com.inclusiv.daojee.dao;

import java.util.List;

import com.inclusiv.daojee.bean.Utilisateur;

public interface UtilisateurDao {
	void ajouter(Utilisateur utilisateur);
	List<Utilisateur> lister();
	
}
