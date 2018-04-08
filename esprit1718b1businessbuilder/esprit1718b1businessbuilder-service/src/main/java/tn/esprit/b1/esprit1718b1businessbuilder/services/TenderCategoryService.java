package tn.esprit.b1.esprit1718b1businessbuilder.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderCategory;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.GenericDAO;

@Stateless
public class TenderCategoryService extends GenericDAO<TenderCategory> implements ITenderCategory {

	@PersistenceContext
	private EntityManager em;
	
	public TenderCategoryService( ) {
		super(TenderCategory.class);
	}

	@Override
	public TenderCategory find(TenderCategory tc) {
		
		String tcName=tc.getNameCategory();
		TypedQuery<TenderCategory> query = em.createQuery("select tc from TenderCategory tc WHERE tc.nameCategory = :tcName",TenderCategory.class);
		
		tc= query.setParameter("tcName", tcName).getSingleResult();
		
		return tc;
	}

}
