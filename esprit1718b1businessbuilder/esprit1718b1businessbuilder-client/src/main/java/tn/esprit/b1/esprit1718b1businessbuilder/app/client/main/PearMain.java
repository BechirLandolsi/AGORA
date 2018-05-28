package tn.esprit.b1.esprit1718b1businessbuilder.app.client.main;

import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Contrat;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Service;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.IProvision;
import tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote;

public class PearMain {
	public static void main(String[] args) throws NamingException {
        Context context = new InitialContext();
		
		
		String companyJNDI ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ;
		String ServiceJNDI ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ServiceService!tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote" ; 
		String ProductJNDI ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ProductService!tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote" ;
		String OrderJNDI="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/OrderService!tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote";
		String provJNDI="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ProvisionService!tn.esprit.b1.esprit1718b1businessbuilder.services.IProvision";

		OrderServiceRemote Orderproxy = (OrderServiceRemote) context.lookup(OrderJNDI);
		ProductServiceRemote productProxy = (ProductServiceRemote) context.lookup(ProductJNDI);
		CompanyServiceRemote companyProxy = (CompanyServiceRemote) context.lookup(companyJNDI) ; 
		ServiceServiceRemote ServiceProxy = (ServiceServiceRemote) context.lookup(ServiceJNDI);
		IProvision provProxy = (IProvision) context.lookup(provJNDI);
	/************************ORDERS************************************/	
		Company c3 = new Company("Astral","Astrallogin","Astralgpass","Astral@gmail.com","CEO_Astral","Tunisie",(long)71852963,"0T13","peinture",5,"excellent","Astral.jpg");
		//companyProxy.add(c3);
		
	    Company c1 = companyProxy.findBy((long)31) ; 
	   
	    
	    Produit p2 = productProxy.findProduct(3); 
	    Produit p3 = productProxy.findProduct(4); 
	    Produit p4 = productProxy.findProduct(5); 
	    Produit p5 = productProxy.findProduct(6); 
	    
	    Contrat cc = provProxy.findContrat(31,5);
	    //provProxy.addContrat(c1, p3, 100);
		//provProxy.addContrat(c1, p4, 550);
		provProxy.provideProduct(cc);
		
		//Orderproxy.payOrder(c1);
	    
	    //Orderproxy.addProductToOrder(p2, c1, 125);
		//Orderproxy.addProductToOrder(p3, c1, 10000);
		//Orderproxy.addProductToOrder(p4, c1, 1285);
		//Orderproxy.addProductToOrder(p5, c1, 1285);
	    
	    
		//
	//Company c2 = companyProxy.findBy((long)36) ; 
	
/*	Produit p1 = new Produit("tibo",(long)300,null,(float)39,(float)50,null);
	Produit p2 = new Produit("Ballons de foot",(long)500,null,(float)39,(float)50,null);
	Produit p3 = new Produit("peinture speciale grise",(long)250,null,(float)44,(float)60,null);
	Produit p4 = new Produit("peinture dain champagne ",(long)120,null,(float)49,(float)63,null);
	Produit p5 = new Produit("pinceau",(long)120,null,(float)8,(float)12,null);*/
	//productProxy.addProduct(p1, c1);
	//productProxy.addProduct(p2, c1);
	//productProxy.addProduct(p3, c2);
	//productProxy.addProduct(p4, c2);
	//productProxy.addProduct(p5, c2);
/*	Produit p6 = productProxy.findProduct(16);
	Produit p7 = productProxy.findProduct(5);
	Produit p8 = productProxy.findProduct(25);*/
	/*Orderproxy.addProductToOrder(p6, c1, 125);
	Orderproxy.addProductToOrder(p7, c1, 10000);
	Orderproxy.addProductToOrder(p8, c1, 1285);
	
	Orderproxy.payOrder(c1);
	*/
	//p6.setDescription("Baskets");
	
	//productProxy.editProduct(p6);
	//productProxy.removeProduct(p6);
	 //System.out.println(productProxy.findAllProduct()); 
	//System.out.println(c1.toString());
	//provProxy.addContrat(c1, p6, 100);
	//provProxy.addContrat(c2, p7, 550);
	//Contrat c = provProxy.findContrat(36,5);
	//provProxy.provideProduct(c);
	
	//Contrat cc = provProxy.findContrat(36,6);
	//provProxy.provideProduct(cc);
	//int l = provProxy.provisionTBD(c1);
	//System.out.println(l);
	//provProxy.updateDelivery(2);
	//Date d = new Date(); 
	//System.out.println(d);
	
	//List<Contrat> l = provProxy.provisionByCompany(c1) ;
	//System.out.println(l.toString());
	//System.out.println(provProxy.updateStock(c1));
	 
		 
		
}
}
