package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Partnership;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.PartnershipPK;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;

@Stateless
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
	
	

	
	
	
	
}






