package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Remote;
import javax.xml.registry.infomodel.User;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.OrderLine;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;

@Remote
public interface ProductServiceRemote {

	public void addProduct(Produit P,Company C); 
	public void editProduct(Produit P);
	public void removeProduct(Produit P);
	
	public Produit findProduct(int id);
	
	public List<Produit> findAllProduct(); 

	public Long nbProbuit();
	public Long nbProjet(); 
	public Long nbPartnershp(); 
	public Long nbTender(); 
	public List<Object[]> salesPerCompany();
	public List<Object[]> salesPerProduit();
	public List<Object[]> salesPerSector();
	public List<Object[]> bestSales();
	


	public List<Produit> findProductByName(String p);

	public List<Object []> findBestProduct () ;
	public  float currencyConvertion(String from,String to , float price) ;



	

}
