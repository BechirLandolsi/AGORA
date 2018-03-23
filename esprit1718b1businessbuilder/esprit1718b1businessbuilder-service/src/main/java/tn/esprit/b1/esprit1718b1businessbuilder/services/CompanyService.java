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

}
