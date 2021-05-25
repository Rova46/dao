package com.inclusiv.daojee.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inclusiv.daojee.bean.Utilisateur;
import com.inclusiv.daojee.dao.DaoFactory;
import com.inclusiv.daojee.dao.UtilisateurDao;

/**
 * Servlet implementation class UtilisateurServlet
 */
public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UtilisateurDao dao;
    
    public UtilisateurServlet() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException {
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.dao = daoFactory.getUtilisateurDaoImpl();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/ajouterUtilisateur.jsp").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom(request.getParameter("nom"));
		utilisateur.setPrenom(request.getParameter("prenom"));
		utilisateur.setEmail(request.getParameter("email"));
		utilisateur.setMdp(request.getParameter("mdp"));
		
		dao.ajouter(utilisateur);
		
		doGet(request, response);
	}

}
