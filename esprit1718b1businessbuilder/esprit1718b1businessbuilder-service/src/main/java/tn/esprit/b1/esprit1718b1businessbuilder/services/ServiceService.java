package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Service;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;

@Stateless
public class ServiceService implements ServiceServiceRemote  {

	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ;
	
	
	@Override
	public void ajouterService(Service service) {
		em.persist(service);
	}

	@Override
	public void editService(Service service) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeService(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Service findService(int id) {
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

}
