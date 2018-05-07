package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Bilan;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;

@Stateless
@LocalBean

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
	public List<Project> getProjectsByCompany(Long companyId) {
		
	TypedQuery <Project> k = em.createQuery("select pr from Project pr where pr.ProjectOwner.id="+companyId,Project.class);
	
	List<Project> listproject = k.getResultList();
	
	return listproject;
		
	}

	
	@Override
	public List <Long> countProjectsByCompanyName(Company c) {
		
		TypedQuery <Long> k= em.createQuery("select count (p) from Project p where p.ProjectOwner="+c.getId(),Long.class);
		
		List<Long> nbr = k.getResultList();
		
				
		return nbr;
	} 
	
	
	@Override
	public void Edit(Project p,double quality,int count)
	{
		Project project = em.find(Project.class,p.getId());
		project.setCount(count);
		project.setQuality(quality);
		
		
	}

	@Override
	public long CountStableProjects(Company c) {
	TypedQuery <Long> k= em.createQuery("select count (p) from Project p where state=1 and p.ProjectOwner= :c",Long.class);
	k.setParameter("c", c);	
	long nbr = k.getSingleResult();
		
				
		return nbr;
	}

	@Override
	public long CountUnstableProjects(Company c) {
		
	TypedQuery <Long> k= em.createQuery("select count (p) from Project p where state=0 and p.ProjectOwner= :c",Long.class);
	k.setParameter("c", c);	
	long nbr = k.getSingleResult();
		
				
		return nbr;
	}

	@Override
	public List<String> getProjectsNameByCompany(Company c) {
		
		TypedQuery <String> k= em.createQuery("select p.name from Project p where p.ProjectOwner= :company group by quality",String.class);
		
		List<String> projects = k.setParameter("company",c).getResultList() ;
		
				
		return projects;
	
	}
	
	@Override
	public List<Number> getProjectsQualityByCompany(Company c) {
		
		TypedQuery <Number> k= em.createQuery("select p.quality from Project p where p.ProjectOwner= :company group by quality",Number.class);
		
		List<Number> projects = k.setParameter("company",c).getResultList() ;
		
				
		return projects;
	
	}

	@Override
	public void delete(Project p) 
	{
		TypedQuery <Bilan> k= em.createQuery("select b from Bilan b where b.project= :p",Bilan.class);
		Bilan b1=k.setParameter("p", p).getSingleResult();
		em.remove(em.contains(b1) ? b1 : em.merge(b1));
		em.remove(em.contains(p) ? p : em.merge(p));
		
		
	}

	@Override
	public Project Edit(Project p) {
		em.merge(p);
		return p;
	}

	@Override
	public List<Project> findProjectById(Long id) {
		
     TypedQuery <Project> k= em.createQuery("select p from Project p where p.id="+id,Project.class);
		
		List<Project> p = k.getResultList() ;
		
		return p;
	}

	@Override
	public List<Project> searchForProject(String mot, Company c) {
		
TypedQuery <Project> k= em.createQuery("select p from Project p where p.ProjectOwner=:c and (p.name like :mot or p.service like :mot or p.projectNature like :mot "
+ "or p.product like :mot or p.capital like :mot)",Project.class);
		//TypedQuery <Project> k= em.createQuery("select p from Project p where p.productmot",Project.class);
		k.setParameter("c", c);
		 List<Project> p  =	k.setParameter("mot",  "%" + mot + "%" ).getResultList();

			
			return p;
		
	}

	@Override
	public double AvancementProject(Project p) {
		
		Calendar creation = new GregorianCalendar();
		 Calendar fin = new GregorianCalendar();
		 Calendar now = new GregorianCalendar();


		 fin.setTime(p.getFinishDate());
		  creation.setTime(p.getCreationDate());
		  double projectdays = (fin.getTime().getTime()-creation.getTime().getTime())/ (1000 * 60 * 60 * 24);
		
		  LocalDate localDate = LocalDate.now();
		  Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		  now.setTime(date);
		  double startdays= (now.getTime().getTime()-creation.getTime().getTime())/ (1000 * 60 * 60 * 24);
		  
		  double tauxAvancement = ((startdays/projectdays))*100;
		  
		return tauxAvancement;
	}

	@Override
	public List<Number> AvancementDesProjetsByCompanyjsf(Long companyId) {
		
		TypedQuery <Project> k = em.createQuery("select pr from Project pr where pr.ProjectOwner.id="+companyId,Project.class);
		
		List<Project> listproject = k.getResultList();
		List<Number> list = new ArrayList<>();
		for(Project p : listproject)
		{
			
			list.add(this.AvancementProject(p));
		}
		
		return list;
	}
	
	
	@Override
	public List<String> getProjectsNameByCompanyjsf(Long companyId) {
		
		TypedQuery <String> k= em.createQuery("select p.name from Project p where p.ProjectOwner.id="+companyId,String.class);
		
		List<String> projects = k.getResultList() ;
		
				
		return projects;
	
	}
	
	
	
	
	
}






