package com.examenJEE.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.examenJEE.entities.Administrateur;
import com.examenJEE.entities.Etudiant;
import com.examenJEE.entities.Reclamation;
import com.examenJEE.entities.TypeReclamation;
import com.examenJEE.entities.Utilisateur;
import com.examenJEE.service.AuthentificationServiceLocal;
import com.examenJEE.service.ReclamationServiceLocal;

/**
 * Servlet implementation class Recherche
 */
@WebServlet("/Recherche")
public class Recherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB private ReclamationServiceLocal rec;
    @EJB private AuthentificationServiceLocal auth;
    ServletContext context;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recherche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context= request.getSession().getServletContext();
		HttpSession hs=request.getSession();
		Etudiant u=(Etudiant) hs.getAttribute("etud");
		String reclamationARechercher =request.getParameter("recherche");
		List<Reclamation> listeReclamationRechercher=rec.chercherReclamation(reclamationARechercher,u);
		context.setAttribute("listeReclamationDunEtudiant", listeReclamationRechercher);
		context.getRequestDispatcher("/espaceEtudiant.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		context= request.getSession().getServletContext();
		
		if(request.getParameter("action").equals("Recherche Etudiant"))
		{
			String NomEtudiantRechercher=request.getParameter("rechercheEtud");
			List<Etudiant> listeEtudiants=auth.listerEtudiantsRechercher(NomEtudiantRechercher);
			context.setAttribute("listeEtudiant", listeEtudiants);
			context.getRequestDispatcher("/espaceAdminEtud.jsp").forward(request, response);}
		else if(request.getParameter("action").equals("Recherche"))
		{
			String typeReclamationRechercher=request.getParameter("rechercheType");
			List<TypeReclamation> listeTypeReclamationRechercher=rec.chercherTypeReclamation(typeReclamationRechercher);
			List<TypeReclamation> listeTypeReclamation =rec.listerTypeReclamations();
			context.setAttribute("listeTypeReclamation", listeTypeReclamationRechercher);
			context.getRequestDispatcher("/espaceAdminType.jsp").forward(request, response);
		}
		else if(request.getParameter("action").equals("Recherche Admin"))
		{
			String adminRechercher=request.getParameter("rechercheAdmin");
			List<Administrateur> listeAdmin=auth.listeAdminRechercher(adminRechercher);
			context.setAttribute("listeAdmin", listeAdmin);
			context.getRequestDispatcher("/espaceAdmin.jsp").forward(request, response);
		}
		else if(request.getParameter("action").equals("rechercherec"))
		{
			HttpSession hs=request.getSession();
			String rechercherRec=request.getParameter("rechercheReclamation");
			 Etudiant u=(Etudiant) hs.getAttribute("etud");
			List<Reclamation> listeRec=rec.chercherReclamation(rechercherRec, u);
			context.setAttribute("listeReclamationDunEtudiant", listeRec);
			context.getRequestDispatcher("/espaceEtudiant.jsp").forward(request, response);
		}
	}

}
