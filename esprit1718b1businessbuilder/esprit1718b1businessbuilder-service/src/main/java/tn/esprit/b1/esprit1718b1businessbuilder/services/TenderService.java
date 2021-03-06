package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Tender;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderCategory;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderQualification;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.GenericDAO;

@Stateless
@LocalBean
public class TenderService extends GenericDAO<Tender> implements ITender {

	
	@PersistenceContext
	private EntityManager em;

	public TenderService() {
		super(Tender.class);
	}

	@Override
	public List<Tender> findByCategory(TenderCategory tc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void affectTenderToCompanyCategory(Tender tender, User loggedUser, TenderCategory tc) {
		
		tender.setCompanyTender(loggedUser);
		tender.setCategory(tc);
	}

	@Override
	public void saveTender(Tender tender) {
		
		tender.setId(add(tender));
		
	}

	@Override
	public long add(Tender tender) {
		
		em.persist(tender);
		
		return tender.getId();
	}

	@Override
	public void affectTenderToQualification(Tender tender, TenderQualification qualification) {
		tender = em.find(Tender.class, tender.getId());
		qualification = em.find(TenderQualification.class,qualification.getId());
		tender.getQualifications().add(qualification);
	}

	@Override
	public Tender find(Long i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tender> findByCompany(User user) {
		
		TypedQuery<Tender> query = em.createQuery("select t from Tender t WHERE t.companyTender = :user",Tender.class);
		List<Tender> tenders = query.setParameter("user", user).getResultList() ;
		
		return tenders;
	}
	
	
	

}
