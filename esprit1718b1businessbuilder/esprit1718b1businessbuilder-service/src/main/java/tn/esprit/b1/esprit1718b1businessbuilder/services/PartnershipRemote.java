package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Partnership;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;

@Remote
public interface PartnershipRemote {

	
    public List <String> getPartnerByProject(Long ProjectId);
 
	public void addPartner(Partnership part,Company owner, Company partner, Project project);
	
	public List<Partnership> PartnershipByProject(Project p);
	
	public List<Partnership> PartnershipNonConfirm(Long companyId);
	
	public long countPartnershipNonConfirm (Long companyId);
	
	public Partnership findPartnershipById(Long id);
	

	
	
	
	
}
