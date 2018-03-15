package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;

@Remote
public interface ProductServiceRemote {

	public void addProduct(Produit P); 
	public void removeProduct(Produit P); 
	public void editProduct(Produit P); 
	public Produit findProduct(int id);
	public List<Produit> findAllProduct(); 
	//public void orderProduct(Produit P) ; 
	
	
}
