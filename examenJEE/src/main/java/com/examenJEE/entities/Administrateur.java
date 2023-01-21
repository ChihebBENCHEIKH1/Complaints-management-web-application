package com.examenJEE.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Administrateur
 *
 */
@Entity
@DiscriminatorValue("Administrateur")
public class Administrateur extends Utilisateur implements Serializable {

	
	private static final long serialVersionUID = 1L;
	public Administrateur() {
		super();
	}
   
}

