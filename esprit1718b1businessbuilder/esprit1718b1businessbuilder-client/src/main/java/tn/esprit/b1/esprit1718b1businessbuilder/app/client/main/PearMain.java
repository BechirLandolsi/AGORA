package tn.esprit.b1.esprit1718b1businessbuilder.app.client.main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
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
			

		OrderServiceRemote Orderproxy = (OrderServiceRemote) context.lookup(OrderJNDI);
		ProductServiceRemote productProxy = (ProductServiceRemote) context.lookup(ProductJNDI);
		CompanyServiceRemote companyProxy = (CompanyServiceRemote) context.lookup(companyJNDI) ; 
		ServiceServiceRemote ServiceProxy = (ServiceServiceRemote) context.lookup(ServiceJNDI);
		
		
	Company c1 = companyProxy.findBy((long)32) ; 
	Company c2 = companyProxy.findBy((long)36) ; 
	
	Produit p1 = new Produit("Baskets Adidas",(long)300,null,(float)39,(float)50,null);
	Produit p2 = new Produit("Ballons de foot",(long)500,null,(float)39,(float)50,null);
	Produit p3 = new Produit("peinture speciale grise",(long)250,null,(float)44,(float)60,null);
	Produit p4 = new Produit("peinture dain champagne ",(long)120,null,(float)49,(float)63,null);
	Produit p5 = new Produit("pinceau",(long)120,null,(float)8,(float)12,null);
	//productProxy.addProduct(p1, c1);
	//productProxy.addProduct(p2, c1);
	//productProxy.addProduct(p3, c2);
	//productProxy.addProduct(p4, c2);
	//productProxy.addProduct(p5, c2);0
	Produit p6 = productProxy.findProduct(36);
	Produit p7 = productProxy.findProduct(32);
	Produit p8 = productProxy.findProduct(35);
	Orderproxy.addProductToOrder(p6, c1, 60);
	Orderproxy.addProductToOrder(p7, c1, 50);
	Orderproxy.addProductToOrder(p8, c1, 100);
	
	Orderproxy.payOrder(c1);
	
}
}
