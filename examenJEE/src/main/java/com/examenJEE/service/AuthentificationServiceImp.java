package com.examenJEE.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.examenJEE.controller.Admin;
import com.examenJEE.entities.Administrateur;
import com.examenJEE.entities.Etudiant;
import com.examenJEE.entities.Utilisateur;
@Stateless(name = "authentifier")
public class AuthentificationServiceImp implements AuthentificationServiceDistant, AuthentificationServiceLocal {

	@PersistenceContext(unitName = "examenJEE")
	private EntityManager em;
	@Override
	public Utilisateur authentifier(String login, String pwd) {
		Query q=em.createQuery("SELECT u FROM Utilisateur u WHERE u.email like :login and u.password like :pwd");
		q.setParameter("login", login);
		q.setParameter("pwd", pwd);
		List<Utilisateur> l=q.getResultList();
		if(l.isEmpty())
		{
			return null;
		}
		else 
		{
			return l.get(0);
		}
	}

	@Override
	public boolean existeEmail(String login) {
		Query q=em.createQuery("select u from Utilisateur u where u.email = :login ");
		q.setParameter("login", login);
		List<Utilisateur> liste=q.getResultList();
		return liste.isEmpty()?false:true;
	}

	@Override
	public void sauvegarderUtilisateur(Utilisateur utilisateur) {
		em.merge(utilisateur);
	}

	@Override
	public List<Etudiant> listerEtudiants() {
		Query q=em.createQuery("select u from Utilisateur u where type_utilisateur =Etudiant");
		return q.getResultList();}

	@Override
	public void descativerUtilisateur(int id) {
		Utilisateur u =em.find(Utilisateur.class, id);
		u.setActif(false);
		em.merge(u);
		
	}

	@Override
	public void acativerUtilisateur(int id) {
		Utilisateur u =em.find(Utilisateur.class, id);
		u.setActif(true);
		em.merge(u);
		
	}

	@Override
	public void ajouterEtudiant(Integer id,String nom,String prenom,String mail,String password,boolean actif) {
		Etudiant u =new Etudiant();
		u.setActif(actif);
		u.setEmail(mail);
		u.setId(id);
		u.setPassword(password);
		u.setNom(prenom);
		u.setPrenom(prenom);
		em.merge(u);
		
	}
	public void ajouterAdmin(Integer id,String mail,String password,boolean actif){
		Administrateur u =new Administrateur();
		u.setActif(actif);
		u.setEmail(mail);
		u.setPassword(password);
		u.setId(id);
		em.merge(u);
	}

	@Override
	public void supprimerUtilisateur(int id) {
		Query q=em.createQuery("DELETE FROM Reclamation WHERE etud_Id_uti=:id");
		q.setParameter("id", id);
		q.executeUpdate();
		Utilisateur u=em.find(Utilisateur.class, id);
		em.remove(u);
	}

	@Override
	public
	void updateUtilisateur(String type,Integer id,String nom,String prenom,String mail,String password,boolean actif) {
		
		if(type.equals("Update Etudiant"))
		{Query q=em.createQuery("UPDATE Utilisateur SET nom =:nom,prenom=:prenom,email=:mail,password=:pass,actif=:act WHERE Id_uti=: id");
		q.setParameter("id", id);
		q.setParameter("mail", mail);
		q.setParameter("pass", password);
		q.setParameter("act", actif);
		q.setParameter("nom", nom);
		q.setParameter("prenom", prenom);
		q.executeUpdate();
			
					}
		else
		{
			Query q=em.createQuery("UPDATE Utilisateur SET email=:mail,password=:pass,actif=:act WHERE Id_uti=: id");
			q.setParameter("id", id);
			q.setParameter("mail", mail);
			q.setParameter("pass", password);
			q.setParameter("act", actif);
			q.executeUpdate();
				
		}
		
	}

	@Override
	public Utilisateur chercherUtilisateurAvecId(int id) {
		Utilisateur u=em.find(Utilisateur.class, id);
		return u;
	}

	@Override
	public List<Etudiant> listerEtudiantsRechercher(String nom) {
		Query q=em.createQuery("select u from Utilisateur u where u.nom  like :nom and type_utilisateur =Etudiant");
		q.setParameter("nom", "%"+nom+"%");
		return q.getResultList();
	}

	@Override
	public List<Administrateur> listeAdmin() {
		Query q =em.createQuery("select u from Utilisateur u where type_utilisateur =Administrateur");
		return q.getResultList();
	}
	public List<Administrateur> listeAdminRechercher(String adminRechercher) {
		Query q =em.createQuery("select u from Utilisateur u where email like :adminRechercher and type_utilisateur =Administrateur");
		q.setParameter("adminRechercher", "%"+adminRechercher+"%");
		return q.getResultList();
	}
}
