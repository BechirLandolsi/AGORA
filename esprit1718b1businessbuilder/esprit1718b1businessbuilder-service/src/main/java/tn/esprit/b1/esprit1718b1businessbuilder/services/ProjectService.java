package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;

@Stateless
public class ProjectService implements ProjectRemote{
	
	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ;

	@Override
	public void addProject(Project P) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Project> getAllProject() {
TypedQuery <Project> k = em.createQuery("select c from Project c",Project.class);
		
		List<Project> listproject = k.getResultList();
		
		//return (long) em.createQuery("select count(*) from employe",Long.class);
		//System.out.println("list"+listproject);
		return listproject;
		
	} 
	
}






