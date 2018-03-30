package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Bilan;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;

@Stateless
public class ProjectService implements ProjectRemote{
	
	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ;

	@Override
	public void addProject(Project p ,Bilan b) {
	
		em.persist(p);
		b.setProject(p);
		em.persist(b);
		
	}

	@Override
	public List<Project> getAllProject() {
    
		TypedQuery <Project> k = em.createQuery("select c from Project c",Project.class);
		
		List<Project> listproject = k.getResultList();
		
		return listproject;
		
	}
	

	@Override
	public List<Project> getProjectsByCompany(int companyId) {
		
	//TypedQuery <Project> k = em.createQuery("select pr.service, par.CompanyPartner.name,par.partnershipDuration from Partnership par inner join par.Project pr on (pr.id=par.project.id) where pr.ProjectOwner.id="+companyId,Project.class);
	
	//TypedQuery <Project> k = em.createQuery("select pr from Partnership par inner join par.project pr where pr.ProjectOwner.id="+companyId,Project.class);

   TypedQuery <Project> k = em.createQuery("select pr from Project pr where pr.ProjectOwner.id="+companyId,Project.class);

		
	List<Project> listproject = k.getResultList();
	
	return listproject;
		
	} 
	
	
	
	
	
	
	
}






