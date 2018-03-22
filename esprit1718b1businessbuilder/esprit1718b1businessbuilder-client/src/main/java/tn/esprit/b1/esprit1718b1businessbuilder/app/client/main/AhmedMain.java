package tn.esprit.b1.esprit1718b1businessbuilder.app.client.main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote;

public class AhmedMain {

	public static void main(String[] args) throws NamingException {
        String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ServiceService!tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote" ; 
		
		Context context = new InitialContext();
		
		ServiceServiceRemote proxy = (ServiceServiceRemote) context.lookup(jndiName1);
		
	User c1 = new Company("Ooredoo","orange","orange","orange","CEO","Tunis",(long)71322,"0F1","IT",5,"good");
		
	proxy.ajouterCompany(c1);
	}

}
