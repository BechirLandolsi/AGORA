package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Tender;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderCategory;
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

	@Override
	public void affectTenderToCompanyCategory(Tender tender, Company loggedUser) {
		
		/*this.find(tender.getId());
		
		System.out.println(tender);
		System.out.println(loggedUser);
		//tender.setCompanyTender(loggedUser);
		
		category= entityManager.find(TenderCategory.class, categoryId );
		tender.setCategory(category);*/
	}

}
