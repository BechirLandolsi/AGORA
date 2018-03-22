package tn.esprit.b1.esprit1718b1businessbuilder.app.client.main;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote;

public class mainAdmin {

	public static void main(String[] args) throws NamingException {
		String jndiName="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/OrderService!tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote";
		String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ProductService!tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote" ; 
		
		Context context = new InitialContext();
		
		OrderServiceRemote proxy = (OrderServiceRemote) context.lookup(jndiName); 
		ProductServiceRemote proxy1 = (ProductServiceRemote) context.lookup(jndiName1);
		
		Company c1 = new Company(); 
		c1.setName("Agile");
		proxy1.addCompany(c1);
		
	/*	Produit p1 = new Produit("Roue",(long)1200,null,(float)66,(float)90,null);  
		p1.setSupplier(c1);*/
		//proxy1.editProduct(p1); 
		//proxy1.addProduct(p1,);
		
		 
		
		 

	}

}
