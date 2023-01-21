package com.examenJEE.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examenJEE.entities.Administrateur;
import com.examenJEE.entities.Etudiant;
import com.examenJEE.entities.TypeReclamation;
import com.examenJEE.entities.Utilisateur;
import com.examenJEE.service.AuthentificationServiceLocal;
import com.examenJEE.service.ReclamationServiceLocal;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB private AuthentificationServiceLocal eth;
	@EJB private ReclamationServiceLocal rec;
	ServletContext context ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		context= request.getSession().getServletContext();
		List<Etudiant> listeEtudiant=	eth.listerEtudiants();
		List<TypeReclamation> listeTypeReclamation =rec.listerTypeReclamations();
		List<Administrateur> listeAdmin=eth.listeAdmin();
		context.setAttribute("listeAdmin", listeAdmin);
		context.setAttribute("listeTypeReclamation", listeTypeReclamation);
		context.setAttribute("listeEtudiant", listeEtudiant);	
		context.getRequestDispatcher("/espaceAdmin.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		context= request.getSession().getServletContext();
		if(request.getParameter("action").equals("Desactiver"))
		{
			int id=Integer.parseInt(request.getParameter("idValue"));
			eth.descativerUtilisateur(id);
			List<Etudiant> listeEtudiant=eth.listerEtudiants();
			context.setAttribute("listeEtudiant", listeEtudiant);	
			context.getRequestDispatcher("/espaceAdminEtud.jsp").forward(request, response);}
		else if(request.getParameter("action").equals("Activer"))
		{
			int id=Integer.parseInt(request.getParameter("idValue"));
			eth.acativerUtilisateur(id);
			List<Etudiant> listeEtudiant=eth.listerEtudiants();
			context.setAttribute("listeEtudiant", listeEtudiant);
			context.getRequestDispatcher("/espaceAdminEtud.jsp").forward(request, response);
		}
		else if(request.getParameter("action").equals("Ajouter Admin"))
		{
			String mail=request.getParameter("mail");
			if(!eth.existeEmail(mail))
			{String mdp=request.getParameter("mdp");
			boolean actif=true;
			if(request.getParameter("actif").equals("non"))
					{
						actif=false;
					}
			eth.ajouterAdmin(null, mail, mdp, actif);
			List<Administrateur> listeAdmin=eth.listeAdmin();
			context.setAttribute("listeAdmin", listeAdmin);
			context.getRequestDispatcher("/espaceAdmin.jsp").forward(request, response);}
			else
			{
				context.getRequestDispatcher("/espaceAdmin.jsp").forward(request, response);
			}
			
			
		}
		else if(request.getParameter("action").equals("Supprimer"))
		{
			int id=Integer.parseInt(request.getParameter("idValue"));
			eth.supprimerUtilisateur(id);
			List<Etudiant> listeEtudiant=eth.listerEtudiants();
			context.setAttribute("listeEtudiant", listeEtudiant);
			context.getRequestDispatcher("/espaceAdminEtud.jsp").forward(request, response);
		}
		else if(request.getParameter("action").equals("Modifier Etudiant"))
		{
			int id=Integer.parseInt(request.getParameter("idValue"));
			Utilisateur u=eth.chercherUtilisateurAvecId(id);
			List<Utilisateur> listUti=new ArrayList<>();
			listUti.add(u);
			context.setAttribute("EtudiantUpdate", listUti);
			context.getRequestDispatcher("/mettreAjourEtud.jsp").forward(request, response);
		}
		else if(request.getParameter("action").equals("Ajouter Etudiant"))
		{
			String mail=request.getParameter("mail");
			if(!eth.existeEmail(mail))
			{
			String mdp=request.getParameter("mdp");
			String nom=request.getParameter("nom");
			String prenom=request.getParameter("prenom");
			boolean actif=true;
			if(request.getParameter("actif").equals("non"))
					{
						actif=false;
					}
			eth.ajouterEtudiant(null, nom, prenom, mail, mdp, actif);
			List<Etudiant> listeEtudiant=eth.listerEtudiants();
			context.setAttribute("listeEtudiant", listeEtudiant);
			context.getRequestDispatcher("/espaceAdminEtud.jsp").forward(request, response);}
			else
			{
				context.getRequestDispatcher("/mailExiste.jsp").forward(request, response);
			}
		}
		else if(request.getParameter("action").equals("Update Etudiant"))
		{
			String mail=request.getParameter("mail");
			String mdp=request.getParameter("mdp");
			int id=Integer.parseInt(request.getParameter("id"));
			String nom=request.getParameter("nom");
			String prenom=request.getParameter("prenom");
			boolean actif=true;
			if(request.getParameter("actif").equals("non"))
					{
						actif=false;
					}
			eth.updateUtilisateur("Update Etudiant",id,nom,prenom, mail, mdp, actif);
			List<Etudiant> listeEtudiant=eth.listerEtudiants();
			context.setAttribute("listeEtudiant", listeEtudiant);
			context.getRequestDispatcher("/espaceAdminEtud.jsp").forward(request, response);
		}
		else if(request.getParameter("action").equals("Ajouter Type"))
		{
			String typeRec=request.getParameter("typeRec");
			TypeReclamation type=new TypeReclamation();
			type.setId(null);
			type.setType(typeRec);
			rec.ajouterTypeReclamation(type);
			List<TypeReclamation> listeTypeReclamation =rec.listerTypeReclamations();
			context.setAttribute("listeTypeReclamation", listeTypeReclamation);
			context.getRequestDispatcher("/espaceAdminType.jsp").forward(request, response);
		}
		else if(request.getParameter("action").equals("Supprimer Type"))
		{
			int typeRec=Integer.parseInt(request.getParameter("id"));
			rec.supprimerTypeReclamation(typeRec);
			
			List<TypeReclamation> listeTypeReclamation =rec.listerTypeReclamations();
			context.setAttribute("listeTypeReclamation", listeTypeReclamation);
			context.getRequestDispatcher("/espaceAdminType.jsp").forward(request, response);
		}
		else if(request.getParameter("action").equals("Modifier Type"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			TypeReclamation t=rec.chercherTypeReclamation(id);
			List<TypeReclamation> listeTypeRec=new ArrayList<>();
			listeTypeRec.add(t);
			context.setAttribute("typeReclamtionPourFaireUpdate", listeTypeRec);
			context.getRequestDispatcher("/mettreAjourTypejsp.jsp").forward(request, response);
		}
		else if(request.getParameter("action").equals("Update Type Reclamation"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			String type =request.getParameter("type");
			rec.updateTypeReclamation(type, id);
			List<TypeReclamation> listeTypeReclamation =rec.listerTypeReclamations();
			context.setAttribute("listeTypeReclamation", listeTypeReclamation);
			context.getRequestDispatcher("/espaceAdminType.jsp").forward(request, response);
		}
		else if(request.getParameter("action").equals("Supprimer Admin"))
		{
			int id=Integer.parseInt(request.getParameter("idValue"));
			eth.supprimerUtilisateur(id);
			List<Administrateur> listeAdmin=eth.listeAdmin();
			context.setAttribute("listeAdmin", listeAdmin);
			context.getRequestDispatcher("/espaceAdmin.jsp").forward(request, response);
		}
		
		
		
		
	}
	

}
