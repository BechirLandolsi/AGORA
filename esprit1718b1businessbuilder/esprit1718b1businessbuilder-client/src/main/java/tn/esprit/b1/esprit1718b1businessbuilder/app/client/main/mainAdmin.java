package tn.esprit.b1.esprit1718b1businessbuilder.app.client.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Order;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote;

public class mainAdmin {

	public static void main(String[] args) throws NamingException {
			
		Context context = new InitialContext();
		
		//*******************************Company******************************\\
		//CompanyService
		String jndiName2 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ;
		//ServiceService
		String jndiName3 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ServiceService!tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote" ; 
		 
		    CompanyServiceRemote proxy2 = (CompanyServiceRemote) context.lookup(jndiName2) ; 
			ServiceServiceRemote proxy3 = (ServiceServiceRemote) context.lookup(jndiName3);
			
			/*Company c1 = new Company("Michelin","michelinlogin","michpass","michelin@gmail.com","CEO_Michelin","Allemagne",(long)4585269,"0D5","Production-Roue",4,"good","michelin.jpg");
			Company c2 = new Company("Zara","Zaralogin","Zarapass","Zara@gmail.com","CEO_Zara","Espagne",(long)339585789,"0E17","Vetement",5,"excellent","Zara.jpg");
			Company c3 = new Company("Astral","Astrallogin","Astralgpass","Astral@gmail.com","CEO_Astral","Tunisie",(long)71852963,"0T13","peinture",5,"excellent","Astral.jpg");
		    
			proxy3.ajouterCompany(c1);
		    proxy3.ajouterCompany(c2);
		    proxy3.ajouterCompany(c3);*/
		//***************************************************************************\\
		//*******************************PRODUCT******************************************\\
			//ProductService
		    String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ProductService!tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote" ;
			
		ProductServiceRemote proxy1 = (ProductServiceRemote) context.lookup(jndiName1);
		
	  		//System.out.println(proxy3.findBy(32));
				//Company c1 = proxy2.findBy(31) ; 
				 
			/*	//Produit p1 = new Produit("Baskets Adidas",(long)300,null,(float)39,(float)50,null);
				Produit p2 = new Produit("Ballons de foot",(long)500,null,(float)39,(float)50,null);
				Produit p3 = new Produit("peinture speciale grise",(long)250,null,(float)44,(float)60,null);
				Produit p4 = new Produit("peinture dain champagne ",(long)120,null,(float)49,(float)63,null);
				Produit p5 = new Produit("pinceau",(long)120,null,(float)8,(float)12,null);
				//proxy1.addProduct(p1,c1);
				//proxy1.addProduct(p2,c1);*/
				
				//System.out.println(c1.getProduits());
				//proxy1.addProduct(p3,c1);
				//proxy1.addProduct(p4,c1);
				//proxy1.addProduct(p5,c1); 
		 //********************************************************************************\\

		//*******************************Order****************************************\\
		    //OrderService
		    String jndiName="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/OrderService!tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote";
			
		    OrderServiceRemote proxy = (OrderServiceRemote) context.lookup(jndiName); 
		 Company c1 = proxy2.findBy(34) ; 
		 Produit p1 = proxy1.findProduct(3);
		 proxy.addProductToOrder(p1, c1, 50);
		  //proxy.payOrder(c1); 
		    //Produit p1 = proxy1.findProduct(15);
		   // proxy.addProductToOrder(p1, c1, 55);
		//proxy.payOrder(c1); 
		   //System.out.println(proxy.salesPermonth().toString());
		   /* Date current = new Date() ; 
		    String PATTERN="yyyy-MM-dd";
		    SimpleDateFormat dateFormat=new SimpleDateFormat();
		    dateFormat.applyPattern(PATTERN);
		    String date1=dateFormat.format(Calendar.getInstance().getTime());
		    int mois = Integer.parseInt((date1.toString().substring(5,7)));
		    System.out.println(mois);*/
		   
		   /* for (Object[] o : proxy.salesPermonth()){
		    	System.out.println((double)o[0]) ; 
		    	System.out.println((Date)o[1]) ;
		    }*/
		    
		    //Order o = proxy.findOrder(1);
		    //System.out.println(proxy.calculAmount(o));
		 //********************************************************************************\\
		 
		
		
		 // System.out.println( proxy1.findAllProduct()); 
		
		 

	}

}
