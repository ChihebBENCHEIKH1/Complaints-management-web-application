package com.examenJEE.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Utilisateur
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_utilisateur",discriminatorType = DiscriminatorType.STRING)
public abstract class Utilisateur implements Serializable {

	   
	@Id @GeneratedValue(strategy = GenerationType.AUTO)@Column(name = "Id_uti")
	private Integer id;
	private String email;
	private String password;
	private boolean actif;
	private static final long serialVersionUID = 1L;

	public Utilisateur() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public boolean getActif() {
		return this.actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}
   
}
