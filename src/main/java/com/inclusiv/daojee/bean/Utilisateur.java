package com.inclusiv.daojee.bean;

public class Utilisateur {
	private String nom;
	private String prenom;
	private String email;
	private String mdp;
	private String cmdp;
	
	
	
	public Utilisateur() {
	}

	public Utilisateur(String nom, String prenom, String email, String mdp, String cmdp) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.cmdp = cmdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getCmdp() {
		return cmdp;
	}

	public void setCmdp(String cmdp) {
		this.cmdp = cmdp;
	}
	
	
}
