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
	public List<Service> getAllService() {
	
		TypedQuery<Service> q = em.createQuery("select * from Service " , Service.class ) ;
		List <Service> services = q.getResultList() ;
		return services;
	}

	@Override
	public void affecterServiceACompany(long companyId, long serviceId) {
		Service s1 = em.find(Service.class, serviceId) ;
		Company c1 = em.find(Company.class, companyId) ;
		c1.getServices().add(s1);
	}

	@Override
	public List<Service> getByName(String name) {
		TypedQuery<Service> q = em.createQuery("select * from Service s where s.name  " , Service.class ) ;
		List <Service> services = q.getResultList() ;
	    
		return null; 
	}
	public void ajouterCompany(User user){
		em.persist(user);
	}

}
