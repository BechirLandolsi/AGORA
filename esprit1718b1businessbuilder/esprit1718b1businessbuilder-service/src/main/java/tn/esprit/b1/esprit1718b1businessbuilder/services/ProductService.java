package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;

@Stateless
public class ProductService implements ProductServiceRemote{
	
	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ; 

	@Override
	public void addProduct(Produit P) {
		em.persist(P);
		
	}

	@Override
	public void removeProduct(Produit P) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editProduct(Produit P) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produit findProduct(int id) {
		Produit P= em.find(Produit.class, id);
		return P ;
	}

	@Override
	public List<Produit> findAllProduct() {
		TypedQuery<Produit> q =  em.createQuery("select * from Produit ",Produit.class) ;
		 List<Produit> produits = q.getResultList() ;
		return produits;
	}



}
