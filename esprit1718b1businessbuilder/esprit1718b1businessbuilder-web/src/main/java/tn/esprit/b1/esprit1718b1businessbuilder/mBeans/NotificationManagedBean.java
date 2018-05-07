package tn.esprit.b1.esprit1718b1businessbuilder.mBeans;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;


import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;

import tn.esprit.b1.esprit1718b1businessbuilder.services.ProvisionService;

@ManagedBean

public class NotificationManagedBean {

	   
	  
	    @ManagedProperty(value = "#{identity}")
		private Identity identity ;
	    
	    @EJB
		private ProvisionService provisionService ;
	    
	 

	  public String getMessage() {
		  
	    return provisionService.updateStock((Company)identity.getUser());
	  }
	  
	  

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	  
	  
}
