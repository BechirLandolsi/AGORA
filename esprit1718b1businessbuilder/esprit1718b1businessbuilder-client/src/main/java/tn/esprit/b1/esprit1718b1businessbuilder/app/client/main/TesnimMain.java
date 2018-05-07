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
		Context context2 = new InitialContext();
		CompanyServiceRemote proxy = (CompanyServiceRemote) context2.lookup(jndiName2);
		ProjectRemote proxy2 = (ProjectRemote) context.lookup(jndiName1);
		//System.out.println("projets sont: "+proxy.getProjectsByCompany(16));
		
		//System.out.println(proxy.getProjectsByCompany(10));
		
		//System.out.println(proxy.FindBySector("Sport"));
	
		
		
		Company c =proxy.findBy((long)3);
		
		//System.out.println(c);
		//System.out.println(c.getId());
		
	//	List<Long> nbr = new ArrayList<>();
		
		//nbr=proxy2.countProjectsByCompanyName(c);
		
	  // System.out.println(nbr.get(0));
		
		//long i=proxy2.CountUnstableProjects();
		//System.out.println(i);
		
		
	//	List<Project> p = new ArrayList<>();
		//p=proxy2.getRateByCompany(c);
		//p=proxy2.getProjectsPerCompanyBySector(c);
		
	//	System.out.println(p);
		
		//System.out.println(proxy.FindBySectorButCompany((long)2, "Sport"));
		
		/*List<Object[]> list = new  ;
		list=proxy2.getProjectsPerCompanyBySector();
		System.out.println(list);*/
		 for (Object[] o : proxy2.getProjectsPerCompanyBySector(c)){
			 System.out.println(o[0]);
			 System.out.println(o[1]);
		 }
	}

	
}
