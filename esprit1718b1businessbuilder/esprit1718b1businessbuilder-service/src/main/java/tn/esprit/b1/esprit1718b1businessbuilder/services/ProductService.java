package tn.esprit.b1.esprit1718b1businessbuilder.services;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Order;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;


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
	
	@Override
	public List<Produit> findProductByName(String p) {
		TypedQuery<Produit> q =  em.createQuery("select p from Produit p WHERE p.description LIKE :name",Produit.class) ;
		List<Produit> produit = q.setParameter("name", "%" + p + "%").getResultList() ;
		return produit ;	
	}

	@Override
	public List<Object []> findBestProduct () {
		Query  q =  em.createQuery("select SUM (p.quantity) , p from OrderLine p GROUP BY p.prod") ;
		 List<Object []> produits = q.getResultList() ;
		return produits;
		
	}
	


	@Override
	public Long nbProbuit() {
		TypedQuery<Long> q =  em.createQuery("select Count(c) from Produit c ",Long.class) ;
		return q.getSingleResult() ;
	}


	@Override
	public Long nbProjet() {
		TypedQuery<Long> q =  em.createQuery("select Count(c) from Project c ",Long.class) ;
		return q.getSingleResult() ;
	}


	@Override
	public Long nbPartnershp() {
		TypedQuery<Long> q =  em.createQuery("select Count(c) from Partnership c ",Long.class) ;
		return q.getSingleResult() ;
	}


	@Override
	public Long nbTender() {
		TypedQuery<Long> q =  em.createQuery("select Count(c) from Tender c ",Long.class) ;
		return q.getSingleResult() ;
	}
	
	
	@Override
	public List<Object[]> salesPerCompany() {
		 
		Query q =  em.createQuery("select SUM(o.quantity) , o.prod from OrderLine o inner join o.prod p where o.prod = p.id group by o.prod ") ;
		 List<Object[]> listO = q.getResultList();
		return listO;
	}


	@Override
	public List<Object[]> salesPerProduit() {
		Query q =  em.createQuery("select o.quantity , o.prod , o.ord from OrderLine o ") ;
		 List<Object[]> listO = q.getResultList();
		return listO;
	}


	@Override
	public List<Object[]> salesPerSector() {
		 Query q =  em.createQuery("select o , COUNT(o) from OrderLine o inner join o.prod p inner join p.supplier s where p.supplier = s.id  group by s.sector ") ;
		 List<Object[]> listO = q.getResultList();
		return listO;
	}
	
	@Override
	public List<Object[]> bestSales() {
		Query q =  em.createQuery("select SUM(o.quantity) , o.prod , o.ord from OrderLine o GROUP BY o.prod ") ;
		 List<Object[]> listO = q.getResultList();
		 List<Object[]> list = new ArrayList<>() ;
		 long max = 0 ; 
		 Object[] m = null ; 
		 for (Object[] o : listO){
		    long qt = (long)o[0] ; 
 	    	  
 	    	 if (qt>max){
 	    		 max= qt ; 
 	    		 m=o ; 
 	    	 }
 	    list.add(m);	 
	    	
	    }
		return list;
	}
	








	

}
