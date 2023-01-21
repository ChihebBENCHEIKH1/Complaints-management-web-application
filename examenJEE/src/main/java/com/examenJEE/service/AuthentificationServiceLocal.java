package com.examenJEE.service;

import java.util.List;

import javax.ejb.Local;

import com.examenJEE.controller.Admin;
import com.examenJEE.entities.Administrateur;
import com.examenJEE.entities.Etudiant;
import com.examenJEE.entities.Utilisateur;

@Local
public interface AuthentificationServiceLocal {
	public Utilisateur authentifier(String login, String pwd);
	boolean existeEmail(String login);
	void sauvegarderUtilisateur(Utilisateur c);
	List<Etudiant> listerEtudiants();
	public List<Administrateur> listeAdmin();
	public List<Administrateur> listeAdminRechercher(String adminRechercher);
	void descativerUtilisateur(int id);
	void acativerUtilisateur(int id);
	void ajouterEtudiant(Integer id,String nom,String prenom,String mail,String password,boolean actif);
	public void ajouterAdmin(Integer id,String mail,String password,boolean actif);
	void supprimerUtilisateur(int id);
	public void updateUtilisateur(String type,Integer id,String nom,String prenom,String mail,String password,boolean actif);
	public Utilisateur chercherUtilisateurAvecId(int id);
	public List<Etudiant> listerEtudiantsRechercher(String nom);
}
