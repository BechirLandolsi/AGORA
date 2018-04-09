package tn.esprit.b1.esprit1718b1businessbuilder.app.client.main;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote;

public class TesnimMain {

	public static void main(String[] args) throws NamingException {
		
        String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ProjectService!tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote" ; 
		
        String jndiName2 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 

       
        
		Context context = new InitialContext();
		
		CompanyServiceRemote proxy = (CompanyServiceRemote) context.lookup(jndiName2);
		
		//System.out.println("projets sont: "+proxy.getProjectsByCompany(16));
		
		//System.out.println(proxy.getProjectsByCompany(10));
		
		//System.out.println(proxy.FindBySector("Sport"));
		
		
		//Context context2 = new InitialContext();
		
	//	ProjectRemote proxy2 = (ProjectRemote) context2.lookup(jndiName1);
		
		Company c =proxy.findBy((long)2);
		
		//System.out.println(c);
		//System.out.println(c.getId());
		
		//List <Integer> nbr = new ArrayList<>();
		
		//nbr=proxy2.countProjectsByCompanyName("Vermeg");
		
	//	System.out.println(nbr.get(0));
		
		//long i=proxy2.CountUnstableProjects();
		//System.out.println(i);
		
		
		///List <Project> p = new ArrayList<>();
		//p=proxy2.getRateByCompany(c);
		
		//System.out.println(p);
		
		//System.out.println(proxy.FindBySectorButCompany(c.getId(), "Sport"));
		
		
	}

	
}
