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

import com.examenJEE.entities.Etudiant;
import com.examenJEE.entities.Reclamation;
import com.examenJEE.entities.TypeReclamation;
import com.examenJEE.entities.Utilisateur;
import com.examenJEE.service.ReclamationServiceLocal;

/**
 * Servlet implementation class EspaceEtud
 */
@WebServlet("/EspaceEtud")
public class EspaceEtud extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private ReclamationServiceLocal rec;
	ServletContext context ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EspaceEtud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context= request.getSession().getServletContext();
		
		   Utilisateur u=(Utilisateur) request.getAttribute("etud");
		  
		   List<Reclamation> listeReclamationDunEtudiant=	rec.listerReclamationParEtudiant((Etudiant) u);
		   List<TypeReclamation> listeTypeReclamation =rec.listerTypeReclamations();
				context.setAttribute("listeReclamationDunEtudiant", listeReclamationDunEtudiant);
				context.setAttribute("listeTypeReclamation", listeTypeReclamation);
	           request.setAttribute("etud", u);
				//getServletContext().getRequestDispatcher("/AddReclamation").forward(request,response);
				request.getRequestDispatcher("espaceEtudiant.jsp").forward(request, response);
		           context.getRequestDispatcher("/espaceEtudiant.jsp").forward(request, response);
		          
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
