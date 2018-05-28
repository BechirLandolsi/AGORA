package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Partnership;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.PartnershipPK;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;

@Stateless
@LocalBean

public class PartnershipService implements PartnershipRemote{
	
	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ;

	@Override
	public List <String> getPartnerByProject(Long ProjectId) {
		
		TypedQuery <String> k = em.createQuery("select p.CompanyPartner.name from Partnership p where p.project.id="+ProjectId,String.class);

		List <String> listproject = k.getResultList();
		
		return listproject;
		
	}

	@Override
	public void addPartner(Partnership part, Company owner, Company partner, Project project) {
		PartnershipPK PartnershipPK = new PartnershipPK(project.getId(),owner.getId(),partner.getId());
		part.setPartnershipPK(PartnershipPK);
		
		em.persist(part);
		
	}

	@Override
	public List<Partnership> PartnershipByProject(Project p) {
		TypedQuery <Partnership> k = em.createQuery("select p from Partnership p where p.project=:p",Partnership.class);
		k.setParameter("p", p);
		List <Partnership> listproject = k.getResultList();
		
		return listproject;
		
	}

	@Override
	public List<Partnership> PartnershipNonConfirm(Long companyId) {
		
		Company c = new Company();
		c=em.find(Company.class,companyId);
		TypedQuery <Partnership> k = em.createQuery("select p from Partnership p where p.state=0 and p.CompanyPartner=:c",Partnership.class);
		k.setParameter("c", c);
		List <Partnership> listpartnerships = null;
		try
		{
			 listpartnerships = k.getResultList();
		}
		catch(NoResultException e)
		{
			System.out.println("y a rien");
		}
		
		
		return listpartnerships;
		
	}

	@Override
	public long countPartnershipNonConfirm(Long companyId) {
		
		Company c = new Company();
		c=em.find(Company.class,companyId);
		TypedQuery <Long> k = em.createQuery("select count(p) from Partnership p where p.state=0 and p.CompanyPartner=:c",Long.class);
		k.setParameter("c", c);
	
		long nbr = 0 ;
		try
		{
			 nbr = k.getSingleResult();
		}
		catch(NoResultException e)
		{
			System.out.println("y a rien");
		}
		
		
		return nbr;
		
	}

	@Override
	public Partnership findPartnershipById(Long idproject) {

			Partnership p = new Partnership();
			Project project = new Project();
			project= em.find(Project.class, idproject);
			TypedQuery <Partnership> k = em.createQuery("select p from Partnership p where p.project=:project",Partnership.class);
			k.setParameter("project", project);
			p=k.getSingleResult();
			
		return p;
	}

	@Override
	public void ChangeStateToTrue(Project p) {
		Partnership par = new Partnership();
		TypedQuery <Partnership> k = em.createQuery("select p from Partnership p where p.project=:project",Partnership.class);
		k.setParameter("project", p);
		par=k.getSingleResult();
		par.setState(true);
		em.merge(p);
		
	}

	
	
	

	
	
	
	
}






