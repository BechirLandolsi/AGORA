package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;

@Stateless
public class CompanyService implements CompanyServiceRemote{
	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ; 
	
	@Override
	public List<Company> findAllCompany() {
		
		TypedQuery<Company> q =  em.createQuery("select c from Company c",Company.class) ;
		List<Company> companies = q.getResultList() ;
		return companies;
	
	}

	@Override
	public Company findBy(long id) {
		TypedQuery<Company> q =  em.createQuery("select c from Company c where c.id=:id",Company.class) ;
		
		return q.setParameter("id", id).getSingleResult();
	}

}
