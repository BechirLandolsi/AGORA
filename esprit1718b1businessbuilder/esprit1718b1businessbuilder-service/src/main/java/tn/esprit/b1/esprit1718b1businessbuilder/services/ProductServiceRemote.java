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
	

	
}
