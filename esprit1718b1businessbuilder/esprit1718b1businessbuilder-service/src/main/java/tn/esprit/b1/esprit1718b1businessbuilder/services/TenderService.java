package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Tender;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderCategory;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderQualification;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.GenericDAO;

@Stateless
public class TenderService extends GenericDAO<Tender> implements ITender {

	@PersistenceContext
	private EntityManager entityManager;
	
	public TenderService() {
		super(Tender.class);
	}

	@Override
	public List<Tender> findByCategory(TenderCategory tc) {
		// TODO Auto-generated method stub
		return null;
	}

}
