package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Service;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;


@Stateless
public class ServiceService implements ServiceServiceRemote  {

	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ;
	
	
	@Override
	public long ajouterService(Service service) {
		em.persist(service);
		return service.getId();
	}

	@Override
	public void editService(Service service) {
	
		em.merge(service);
		
	}

	@Override
	public void removeService(long id) {
		Service s1 = em.find(Service.class, id) ;
		em.remove(s1);
		
	}

	@Override
	public Service findService(long id) {
		Service s1 = em.find(Service.class, id) ;
		return s1 ;
	}

	@Override
	public List<String> getAllService() {
	
		TypedQuery<String> q = em.createQuery("select c.name from Service c " , String.class ) ;
		List <String> services = q.getResultList() ;
		return services;
	}

	@Override
	public void affecterServiceACompany(long companyId, long serviceId) {
		Service s1 = em.find(Service.class, serviceId) ;
		Company c1 = em.find(Company.class, companyId) ;
		c1.getServices().add(s1);
	}

	@Override
	public List<String> getByName(String name) {
		TypedQuery<String> q = em.createQuery("select c.name from Service c WHERE c.name =:name" , String.class ) ;
		List<String> servicename = q.setParameter("service", "%" + name+ "%").getResultList() ;
	    
		return servicename; 
	}
	public void ajouterCompany(User user){
		em.persist(user);
	}
	
	@Override
	public List <String> getName()
	{
		TypedQuery<String> q = em.createQuery("select s.name from Service s" , String.class ) ;
		List <String> services = q.getResultList() ;
		return services;
	}

	@Override
	public List<String> ResercheListe(long id) {
		Company c1 = em.find(Company.class, id) ;
		TypedQuery<String> q = em.createQuery("select r.reserche from Reserche r where r.companyR=:id  " , String.class ) ;
		List <String> recherches = q.setParameter("id", c1).getResultList() ;
		return recherches;
	}
	@Override
	public List<Produit> findProductByCompany(Company c) {
		 TypedQuery<Produit> q =  em.createQuery("select p from Produit p WHERE p.supplier =:company ",Produit.class) ;
		 List<Produit> produits  =	q.setParameter("company", c).getResultList();
		return produits;
	}

	@Override
	public List<Company> findCompanyBysynonyme(String r) {
		 TypedQuery<Company> q =  em.createQuery("select c from Company c INNER JOIN c.services s where s.name IN (select s.service from Synonyme s where   s.synonyme1 LIKE :service OR s.synonyme2 LIKE :service OR s.synonyme3 LIKE :service OR s.synonyme4 LIKE :service OR s.synonyme5 LIKE :service)",Company.class) ;
		 
		 List<Company> companies  =	q.setParameter("service",  "%" + r + "%" ).getResultList();
		return companies;
	}


}
