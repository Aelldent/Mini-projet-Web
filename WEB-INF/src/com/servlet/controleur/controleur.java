package com.servlet.controleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.model.modeleBaseDeDonnee;

public class controleur extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		//mise a jour du modeleBD, celui qui servira a la recherche
		//modeleBaseDeDonnee modelBD = new modeleBaseDeDonnee();
		//modelBD.setNomArtiste((String)request.getAttribute("nomArtiste"));
		//modelBD.setTitreSoundtrack((String)request.getAttribute("titreSoundtrack"));
		
		//envoi du modele
		//request.setAttribute("modeleBD", modelBD);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("pageResultRech.jsp");
		dispatch.forward(request, response);
	}
	
	// init
	@SuppressWarnings("unchecked")
	public void init() throws ServletException 
	{
		// on récupère les paramètres d'initialisation de la servlet
		ServletConfig config = getServletConfig();
		
	}
}
