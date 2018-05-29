package tn.esprit.b1.esprit1718b1businessbuilder.app.client.main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Contrat;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.IProvision;
import tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote;

public class mainTest {

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

		
		/**** La company li tconnectiiw biiihaaa ***********/
		Company c1 = companyProxy.findBy((long)32) ; 
		
		Produit p1 = new Produit("tibo",(long)300,null,(float)39,(float)50,null);
		Produit p2 = new Produit("Ballons de foot",(long)500,null,(float)39,(float)50,null);
		Produit p3 = new Produit("peinture speciale grise",(long)250,null,(float)44,(float)60,null);
		Produit p4 = new Produit("peinture dain champagne ",(long)120,null,(float)49,(float)63,null);
		
		/******************Ajouter des produits *********************************/
		
				//productProxy.addProduct(p1, c1) ; 
				//productProxy.addProduct(p2, c1) ; 
				//productProxy.addProduct(p3, c1) ; 
				//productProxy.addProduct(p4, c1) ; 
		
		/********** Baad ma tajoutiw les produits , choufou les id te3hom fel base *********/
		
				p1 = productProxy.findProduct(48);
				p2 = productProxy.findProduct(49);
				p3 = productProxy.findProduct(50);
				p4 = productProxy.findProduct(51);
				
				
				//Orderproxy.addProductToOrder(p2, c1, 125);
				//Orderproxy.addProductToOrder(p3, c1, 10000);
				//Orderproxy.addProductToOrder(p4, c1, 1285);
				//Orderproxy.addProductToOrder(p1, c1, 1285);
				
				//Orderproxy.payOrder(c1);
		/*****************************************************************************/
		
					//provProxy.addContrat(c1, p4, 100);
					
	   /********** id de la company connectée o id taa l p4 !! *********/
					//Contrat c = provProxy.findContrat(32,p4.getId()); 
					//provProxy.provideProduct(c); 
					//provProxy.provideProduct(c);
				
	  /****************************************************************/
				
				
	}

}
