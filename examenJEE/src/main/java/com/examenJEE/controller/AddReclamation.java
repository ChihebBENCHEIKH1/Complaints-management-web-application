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

import com.examenJEE.entities.Etudiant;
import com.examenJEE.entities.Reclamation;
import com.examenJEE.entities.Utilisateur;
import com.examenJEE.service.ReclamationServiceLocal;

/**
 * Servlet implementation class AddReclamation
 */
@WebServlet("/AddReclamation")
public class AddReclamation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private ReclamationServiceLocal rec;
	ServletContext context ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReclamation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context= request.getSession().getServletContext();
		// TODO Auto-generated method stub
		
		String titre=request.getParameter("titre");
		String description=request.getParameter("desc");
		String type=request.getParameter("type");
		Reclamation reclamation=new Reclamation();
		reclamation.setDescription(description);
		reclamation.setId(null);
		reclamation.setTitre(titre);
		HttpSession hs=request.getSession();
		Utilisateur u=(Etudiant) hs.getAttribute("etud");
		rec.ajouterReclamation(reclamation);
		rec.ajouterIdUtilisateurEtTypeReclamation(type,u.getId(),reclamation);
		List<Reclamation> listeReclamationDunEtudiant=	rec.listerReclamationParEtudiant((Etudiant) u);
		context.setAttribute("listeReclamationDunEtudiant", listeReclamationDunEtudiant);
		context.getRequestDispatcher("/espaceEtudiant.jsp").forward(request, response);
	}
	}


