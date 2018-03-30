package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Bilan;
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


}
