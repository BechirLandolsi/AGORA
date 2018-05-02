package tn.esprit.b1.esprit1718b1businessbuilder.app.client.main;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Bilan;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.BilanRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote;

public class TesnimMain {

	public static void main(String[] args) throws NamingException {
		
        String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ProjectService!tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote" ; 
		
        String jndiName2 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 
       
        String jndiName3 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/BilanService!tn.esprit.b1.esprit1718b1businessbuilder.services.BilanRemote" ; 

       
        
		Context context = new InitialContext();
		
		CompanyServiceRemote proxy = (CompanyServiceRemote) context.lookup(jndiName2);
		
		//System.out.println("projets sont: "+proxy.getProjectsByCompany(16));
		
		//System.out.println(proxy.getProjectsByCompany(10));
		
		//System.out.println(proxy.FindBySector("Sport"));
		
		
		//Context context2 = new InitialContext();
		
	//	ProjectRemote proxy2 = (ProjectRemote) context2.lookup(jndiName1);
		
		//Company c =proxy.findBy((long)2);
		
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

/*******************************************************************************************************************************/		
		
		/*List<Project> p = new ArrayList<>();
		
		ProjectRemote proxy1 = (ProjectRemote) context.lookup(jndiName1);
		p = proxy1.findProjectById((long)13);
		if (p.isEmpty())
		{
			System.out.println("Project not found");
		}
		else {
			p.get(0).setName("test Edit");
			proxy1.Edit(p.get(0));
			System.out.println("Edit validé");
			}
		*/
		
/**************************************************************************************************************/		
		ProjectRemote proxy1 = (ProjectRemote) context.lookup(jndiName1);
		//BilanRemote proxy2 = (BilanRemote) context.lookup(jndiName2);
		
		//List<Bilan> b = new ArrayList<>();
		
		//b=proxy2.findBilan((long) 21);

		List<Project> p = new ArrayList<>();
		
		p = proxy1.findProjectById((long)15);
		proxy1.delete(p.get(0));
		
		
		
		
		
	}

	
}
