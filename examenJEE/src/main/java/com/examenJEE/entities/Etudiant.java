package com.examenJEE.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Etudiant
 *
 */
@Entity
@DiscriminatorValue("Etudiant")
public class Etudiant extends Utilisateur implements Serializable {
	private String nom;
	private String prenom;
	@OneToMany(mappedBy = "etud")
	private List<Reclamation> listRec = new ArrayList<Reclamation>();;
	private static final long serialVersionUID = 1L;

	public Etudiant() {
		super();
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
   
}
