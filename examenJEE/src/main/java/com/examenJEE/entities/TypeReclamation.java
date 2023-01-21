package com.examenJEE.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: TypeReclamation
 *
 */
@Entity

public class TypeReclamation implements Serializable {

	   
	@Id @GeneratedValue(strategy = GenerationType.AUTO)@Column(name = "idTypeRec")
	private Integer id;
	private String type;
	@OneToMany(mappedBy = "type")
	private List<Reclamation> listRec = new ArrayList<Reclamation>();;
	private static final long serialVersionUID = 1L;

	public TypeReclamation() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
   
}
