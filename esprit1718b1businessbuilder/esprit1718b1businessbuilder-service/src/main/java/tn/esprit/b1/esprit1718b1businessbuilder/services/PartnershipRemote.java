package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface PartnershipRemote {

	
 public String getPartnerByProject(Long ProjectId);
	
	
	
}
