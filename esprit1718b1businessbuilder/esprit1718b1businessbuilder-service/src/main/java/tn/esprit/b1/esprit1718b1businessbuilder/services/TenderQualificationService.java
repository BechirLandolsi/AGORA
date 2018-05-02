package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderQualification;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.GenericDAO;

@Stateless
public class TenderQualificationService extends GenericDAO<TenderQualification> implements ITenderQualification {

	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ;
	
	public TenderQualificationService() {
		super(TenderQualification.class);
	}

	@Override
	public List<TenderQualification> findAllQualifByTender(long id) {
		TypedQuery<TenderQualification> q =  em.createQuery("select tq from TenderQualification tq INNER JOIN tq.tenders t where t.id=:id",TenderQualification.class) ;
		List<TenderQualification> qualifications = q.setParameter("id", id).getResultList() ;
		return qualifications;
	}

	@Override
	public TenderQualification findByName(String nameQualification) {
		TypedQuery<TenderQualification> q =  em.createQuery("select tq from TenderQualification tq WHERE tq.nameQualification = :nameQualification",TenderQualification.class) ;
		TenderQualification tq = q.setParameter("nameQualification", nameQualification).getSingleResult() ;
		return tq ;
	}

}
