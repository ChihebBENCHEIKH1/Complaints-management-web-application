package com.examenJEE.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.examenJEE.entities.Etudiant;
import com.examenJEE.entities.Reclamation;
import com.examenJEE.entities.TypeReclamation;

@Stateless
public class ReclamationServiceImp implements ReclamationServiceDistant, ReclamationServiceLocal {

	@PersistenceContext(unitName = "examenJEE")
	private EntityManager em;
	@Override
	public void ajouterReclamation(Reclamation reclamation) {
		em.persist(reclamation);

	}

	@Override
	public void ajouterTypeReclamation(TypeReclamation typeReclamation) {
		em.persist(typeReclamation);

	}

	@Override
	public List<Reclamation> listerReclamations() {
		Query q=em.createQuery("from Reclamation r");
		return q.getResultList();
	}

	@Override
	public List<TypeReclamation> listerTypeReclamations() {
		Query q=em.createQuery("from TypeReclamation tr");
		return q.getResultList();
	}

	@Override
	public boolean existeTypeReclalamtion(String type) {
		Query q=em.createQuery("select tr from TypeReclamation tr where tr.type like :typeReclamation");
		q.setParameter("typeReclamation", type);
		return q==null?false:true;
	}

	@Override
	public TypeReclamation chercherTypeReclamationParType(String type) {
		Query q=em.createQuery("select tr from TypeReclamation tr where tr.type like :typeReclamation");
		q.setParameter("typeReclamation", type);
		return (TypeReclamation) q.getSingleResult();
	}
	@Override
	public List<Reclamation> chercherReclamation(String rec,Etudiant etudiant) {
		Query q=em.createQuery("select tr from Reclamation tr where tr.titre like :ReclamationTitre and etud_Id_uti= :idEtudiant");
		q.setParameter("ReclamationTitre", rec+"%");
		q.setParameter("idEtudiant", etudiant.getId());
		return q.getResultList();
	}

	@Override
	public List<Reclamation> listerReclamationParEtudiant(Etudiant etudiant) {
		Query q=em.createQuery("select r from Reclamation r where etud_Id_uti= :idEtudiant");
		q.setParameter("idEtudiant", etudiant.getId());
		return q.getResultList();
	}

	@Override
	public void ajouterIdUtilisateurEtTypeReclamation(String type,int id,Reclamation reclamation){
		Query q1=em.createQuery("select ty from TypeReclamation ty where ty.type=:type");
		q1.setParameter("type", type);
		TypeReclamation typeRec=(TypeReclamation) q1.getSingleResult();
		Query q=em.createQuery("update Reclamation set etud_Id_uti=:id,type_idTypeRec=:idType where IdReclamation=:recId");
		q.setParameter("id", id);
		q.setParameter("idType", typeRec.getId());
		q.setParameter("recId", reclamation.getId());
		int i=q.executeUpdate();
		
	}

	@Override
	public void supprimerTypeReclamation(int id) {
		Query q=em.createQuery("DELETE FROM Reclamation WHERE type_idTypeRec=:id");
		q.setParameter("id", id);
		q.executeUpdate();
		TypeReclamation type=em.find(TypeReclamation.class, id);
		em.remove(type);
	}

	@Override
	public TypeReclamation chercherTypeReclamation(int id) {
		TypeReclamation typeReclamation=em.find(TypeReclamation.class,id);
		return typeReclamation;
	}

	@Override
	public void updateTypeReclamation(String type,int id) {
		Query q=em.createQuery("update TypeReclamation set type=:type where idTypeRec=:id");
		q.setParameter("id", id);
		q.setParameter("type", type);
		q.executeUpdate();
		
	}

	@Override
	public List<TypeReclamation> chercherTypeReclamation(String type) {
		Query q =em.createQuery("select tr from TypeReclamation tr where tr.type like :type");
		q.setParameter("type", "%"+type+"%");
		return q.getResultList();
	}

	
}
