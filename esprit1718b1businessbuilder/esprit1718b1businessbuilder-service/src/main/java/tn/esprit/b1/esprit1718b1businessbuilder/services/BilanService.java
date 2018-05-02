package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Bilan;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Service;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;

@Stateless
public class BilanService implements BilanRemote{
	
	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ;

	
	@Override
	public void addBilan(Bilan b ,long idP ) 
	{ Project s1 = em.find(Project.class, idP) ;
	    b.setProject(s1);
		em.persist(b);
		
	}


	@Override
	public void deleteBilan(Bilan b) {
		em.remove(b);
		
	}


	@Override
	public List<Bilan> findBilan(long id) {
		 TypedQuery <Bilan> k= em.createQuery("select p from Project p where p.id="+id,Bilan.class);
			
			List<Bilan> b = k.getResultList() ;
			
			return b;
			
	}


	

}
