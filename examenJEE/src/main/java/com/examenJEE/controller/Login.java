package com.examenJEE.controller;

import java.io.IOException;

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
import com.examenJEE.entities.Utilisateur;
import com.examenJEE.service.AuthentificationServiceLocal;

/**
 * Servlet implementation class Lo
 */
@WebServlet("/Lo")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private AuthentificationServiceLocal auth;
	ServletContext context ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("mail");
		String mdp=request.getParameter("mdp");
		String type=request.getParameter("type");
		HttpSession hs=request.getSession();
		Utilisateur u=auth.authentifier(email, mdp);
		hs.setAttribute("etud",u);
		if(u==null)
		{
			response.sendRedirect("erreurDeLogin.jsp");
		}
		else if((u instanceof Administrateur &&  type.equals("Etudiant")) || (u instanceof Etudiant && type.equals("Admin")))
		{
			response.sendRedirect("accedeAuBonEndroit.jsp");
		}
		else if(u!=null && type.equals("Etudiant") &&u.getActif())
		{
			request.setAttribute("etud",u);
			getServletContext().getRequestDispatcher("/EspaceEtud").forward(request,response);
			response.sendRedirect("espaceEtudiant.jsp");
		}
		else if(u!=null && type.equals("Admin")&&u.getActif())
		{
			getServletContext().getRequestDispatcher("/Admin").forward(request,response);
			
		}
		
		else
		{
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
