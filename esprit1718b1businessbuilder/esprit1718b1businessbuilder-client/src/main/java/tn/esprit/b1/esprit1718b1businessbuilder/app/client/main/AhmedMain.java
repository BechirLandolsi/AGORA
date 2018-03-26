package tn.esprit.b1.esprit1718b1businessbuilder.app.client.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.scene.image.Image;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Reserche;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Service;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote;

public class AhmedMain {

	public static void main(String[] args) throws NamingException {
        String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ServiceService!tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote" ; 
		Context context = new InitialContext();
		ServiceServiceRemote proxy = (ServiceServiceRemote) context.lookup(jndiName1);
		
		Company c1 = new Company("Orange","orangelogin","orangepass","orange@gmail.com","CEO_Orange","Tunis",(long)71322111,"0T1","Telecommunication",4,"good","orange.jpg");
		Company c2 = new Company("Adidas","adidaslogin","adidaspass","adidas@gmail.com","CEO_adidas","France",(long)339585789,"0F1","Sport",5,"excellent","adidas.jpg");
		Company c3 = new Company("Vermeg","vermeglogin","vermegpass","vermeg@gmail.com","CEO_vermeg","France",(long)339585789,"0F12","IT",5,"excellent","vermeg.jpg");
	   
		//proxy.ajouterCompany(c1);
	    //proxy.ajouterCompany(c2);
	    //proxy.ajouterCompany(c3);
	    
	/*********************************************TESTCOMPANY*******************************************************************************************************************************************/
	    String jndiName ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 	
		 

	    Context context1 = new InitialContext();
		CompanyServiceRemote proxy1 = (CompanyServiceRemote) context.lookup(jndiName);
 		List <String> list = new ArrayList<>() ;
 	 	list = proxy1.findAllCompanyNames();
	    //System.out.println(list);    
	/**************************************************Reserche************************************************************************************************************************************/
 	 	
 	 	Reserche reserche = new Reserche() ;
 	 	reserche.setReserche("aaa");
 	 	Company c =proxy1.findBy(30) ;
 	 	//proxy1.AddCompanyReserche(reserche,c);
 	/**********************************************Service*************************************************************************************/
 	 	Service service = new Service () ;
 	 	//service.setName("car manufacturing");
 	 	//service.setName("wheel manufacturing");
 	 	//service.setName("furniture manufacturing");
 	 	//service.setName("steel manufacturing");
 	    //service.setName("smartphone manufacturing");
 	    //service.setName("simcard sale ");
 	 	//service.setName("merchandise  sale ");
 	    //service.setName("computer   sale ");
 	 	//                       proxy.ajouterService(service);
 	 	//proxy.affecterServiceACompany(30, 10);
 	    //System.out.println( proxy1.findAllCompanyByService("sim")); 
 	 	System.out.println(proxy.ResercheListe(31));
 	 	
    }
}
