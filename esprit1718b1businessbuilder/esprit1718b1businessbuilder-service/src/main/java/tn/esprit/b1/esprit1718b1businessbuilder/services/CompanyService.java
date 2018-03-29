package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Reserche;
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
    public List<String> findAllCompanyNames() {
		
		TypedQuery<String> q =  em.createQuery("select c.name from Company c",String.class) ;
		List<String> companiesname = q.getResultList() ;
		return companiesname;
	
	}
		
	@Override
	public Company findAllCompanyByName(String name) {

		TypedQuery<Company> q =  em.createQuery("select c from Company c WHERE c.name = :name",Company.class) ;
		Company c = null  ;
		try{
		c =	q.setParameter("name", name).getSingleResult() ;
		}catch(NoResultException e){
			
		}
		
		return c ;
	}
	@Override
	public void AddCompanyReserche(Reserche r, Company c  ) {
		r.setCompanyR(c);
		em.persist(r);
	}
	@Override
	public Company findBy(long id) {
		TypedQuery<Company> q =  em.createQuery("select c from Company c where c.id=:id",Company.class) ;
		
		return q.setParameter("id", id).getSingleResult();
	}
	@Override
	public List<Company> findAllCompanyByService(String service){
		TypedQuery<Company> q =  em.createQuery("select c from Company c INNER JOIN c.services s where s.name LIKE :service",Company.class) ;
		List<Company> companies = q.setParameter("service", "%" + service+ "%").getResultList() ;
		return companies;
	}
	
	@Override
	public List <String> FindBySector(String sector)
	{
		TypedQuery<String> q = em.createQuery("select c.name from Company c WHERE c.sector=:sector", String.class ) ;
		//List <String> names = q.getResultList() ;
		//return names;
		return q.setParameter("sector", sector).getResultList();
	}
	
	@Override
	public List <String> getAllSectors()
	{
		TypedQuery<String> q = em.createQuery("select c.sector from Company c", String.class ) ;
		List <String> sectors = q.getResultList() ;
		return sectors;
		
	}
	@Override
	public void add(Company c) {
		em.persist(c);
		
	}
	
	

}
