package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;

@Stateless
public class ProductService implements ProductServiceRemote{
	
	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ; 


	@Override
	public void addProduct(Produit P, Company C) {
		P.setSupplier(C);
		em.persist(P);
		
	}

	
	@Override
	public List<Produit> findAllProduct() {
		TypedQuery<Produit> q =  em.createQuery("select p from Produit p ",Produit.class) ;
		 List<Produit> produits = q.getResultList() ;
		return produits;
	}


	@Override
	public Produit findProduct(int id) {
		Produit p = em.find(Produit.class, id);
		return p;
	}













	

}
