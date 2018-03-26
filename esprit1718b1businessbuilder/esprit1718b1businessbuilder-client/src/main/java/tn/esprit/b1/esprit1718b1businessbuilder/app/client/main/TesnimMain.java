package tn.esprit.b1.esprit1718b1businessbuilder.app.client.main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote;

public class TesnimMain {

	public static void main(String[] args) throws NamingException {
		
        String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ProjectService!tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote" ; 
		
		Context context = new InitialContext();
		
		ProjectRemote proxy = (ProjectRemote) context.lookup(jndiName1);
		
		System.out.println("projets sont: "+proxy.getProjectsByCompany(16));
		
		//System.out.println(proxy.getProjectsByCompany(10));
		
	}

	
}
