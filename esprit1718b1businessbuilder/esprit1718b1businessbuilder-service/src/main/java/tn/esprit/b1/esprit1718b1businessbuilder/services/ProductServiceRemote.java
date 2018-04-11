package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.registry.infomodel.User;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;

@Remote
public interface ProductServiceRemote {

	public void addProduct(Produit P,Company C); 
	public Produit findProduct(int id);
	
	public List<Produit> findAllProduct(); 
	public List<Produit> findProductByName(String p);
	public List<Object []> findBestProduct () ;
	public  float currencyConvertion(String from,String to , float price) ;
}
