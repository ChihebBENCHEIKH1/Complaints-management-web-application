package com.examenJEE.service;


import java.util.List;

import javax.ejb.Local;

import com.examenJEE.entities.Etudiant;
import com.examenJEE.entities.Reclamation;
import com.examenJEE.entities.TypeReclamation;
import com.examenJEE.entities.Utilisateur;

@Local
public interface ReclamationServiceDistant {
	void ajouterReclamation(Reclamation reclamation);
	void ajouterTypeReclamation(TypeReclamation typeReclamation);
	List<Reclamation> listerReclamations();
	public TypeReclamation chercherTypeReclamation(int id);
	public void updateTypeReclamation(String type,int id);
	public List<TypeReclamation> chercherTypeReclamation(String type);
	public void supprimerTypeReclamation(int id);
	List<TypeReclamation> listerTypeReclamations();
	boolean existeTypeReclalamtion(String type);
	TypeReclamation chercherTypeReclamationParType(String type);
	List<Reclamation> listerReclamationParEtudiant(Etudiant etudiant);
	public List<Reclamation> chercherReclamation(String rec,Etudiant etudiant);
	public void ajouterIdUtilisateurEtTypeReclamation(String type,int id,Reclamation reclamation);

}

