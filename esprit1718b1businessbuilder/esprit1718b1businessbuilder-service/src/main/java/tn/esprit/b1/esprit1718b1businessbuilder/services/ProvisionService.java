package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;
import java.security.GeneralSecurityException;
import java.util.Date;

import javax.ejb.Local;
import javax.ejb.LocalBean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import javafx.concurrent.Task;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Contrat;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.ContratPK;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Provision;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Provision.StateType;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.TimeBasedOneTimePasswordUtil;

@Stateless
@LocalBean

public class ProvisionService implements IProvision {

	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ;

	@Override
	public void addContrat(Company cmp, Produit p , int q) {
		Contrat c = new Contrat(); 
		ContratPK cpk = new ContratPK() ; 
		cpk.setIdCompany((int)cmp.getId());
		cpk.setIdProduct(p.getId());
		c.setContratPK(cpk); 
		c.setCompany(cmp);
		c.setProduit(p);
		c.setQuantity(q);
		c.setStock(q);
		Date current = new Date() ; 
		c.setDate_contrat(current);
		
		em.persist(c);	
	}

	@Override
	public void provideProduct(Contrat c) {
		Provision p = new Provision() ; 
		p.setContrat(c);
		Date current = new Date() ; 
		p.setDate_provision(current);
		p.setDelivState(StateType.toBeDone);
		p.setInvoState(StateType.toBeDone);
		p.setPackState(StateType.toBeDone);
		
		em.persist(p);
		c.setStock(c.getQuantity());
		em.merge(c);
		
	}

	@Override
	public Contrat findContrat(Integer idC, Integer idP) {
		ContratPK pk = new ContratPK() ; 
		pk.setIdCompany(idC);
		pk.setIdProduct(idP);
		Contrat c = em.find(Contrat.class, pk);
		return c;
	}

	@Override
	public Provision findProvision(Integer id) {
		Provision p = em.find(Provision.class, id);
		return p;
	}

	@Override
	public Integer provisionTBD(Company cmp) {
		int count = 0 ; 
		TypedQuery<Provision> q =  em.createQuery("select p from Provision p inner join p.contrat c inner join c.produit pr "
				+ "where pr.supplier = :cmp and p.delivState =:state",Provision.class) ;
		
		q.setParameter("cmp"	, cmp) ; 
		q.setParameter("state", StateType.toBeDone);
		List<Provision> l = q.getResultList() ;
		System.out.println(l.toString());
		for(Provision p : l){
			count = count + p.getContrat().getQuantity();
		}
		return count ; 
	}

	@Override
	public Integer provisionTBP(Company c) {
		int count = 0 ; 
		TypedQuery<Provision> q =  em.createQuery("select p from Provision p inner join p.contrat c inner join c.produit pr "
				+ "where pr.supplier = :cmp and p.packState =:state",Provision.class) ;
		
		q.setParameter("cmp", c) ; 
		q.setParameter("state", StateType.toBeDone);
		List<Provision> l = q.getResultList() ;
		System.out.println(l.toString());
		for(Provision p : l){
			count = count + p.getContrat().getQuantity();
		}
		return count ;
		
	}

	@Override
	public Float provisionTBI(Company c) {
		float count = 0 ; 
		TypedQuery<Provision> q =  em.createQuery("select p from Provision p inner join p.contrat c inner join c.produit pr "
				+ "where pr.supplier = :cmp and p.packState =:state",Provision.class) ;
		
		q.setParameter("cmp", c) ; 
		q.setParameter("state", StateType.toBeDone);
		List<Provision> l = q.getResultList() ;
		System.out.println(l.toString());
		for(Provision p : l){
			count = count + p.getContrat().getProduit().getPrice();
		}
		return count ;
		
	}

	@Override
	public Integer quantityInhand(Company c) {
		long count = 0 ; 
		TypedQuery<Produit> q =  em.createQuery("select p from Produit p where p.supplier =:cmp",Produit.class) ;
		
		q.setParameter("cmp", c) ; 
		
		List<Produit> l = q.getResultList() ;
		for(Produit p : l){
			count = count + p.getStock();
		}
		return (int)count;
	}

	@Override
	public Integer quantityToRecieve(Company c) {
		int count = 0 ; 
		TypedQuery<Provision> q =  em.createQuery("select p from Provision p inner join p.contrat c where c.company =:cmp  "
				+ "and p.delivState =:state or p.delivState =:state1",Provision.class) ;
		
		q.setParameter("cmp", c) ; 
		q.setParameter("state", StateType.toBeDone);
		q.setParameter("state1", StateType.inProgress);
		List<Provision> l = q.getResultList() ;
		System.out.println(l.toString());
		for(Provision p : l){
			count = count + p.getContrat().getQuantity();
		}
		return count;
	}

	@Override
	public void verifyStock() {
		
    	        	 
    	        	 TypedQuery<Contrat> q =  em.createQuery("select c from Contrat c where "
				  				+ "c.stock = 0",Contrat.class) ;
				  		
				  	 List<Contrat> l = q.getResultList() ;
				  		System.out.println(l.toString());
				  		for(Contrat c : l){
				  			Provision p = new Provision() ; 
				  			p.setContrat(c);
				  			Date current = new Date() ; 
				  			p.setDate_provision(current);
				  			p.setDelivState(StateType.toBeDone);
				  			p.setInvoState(StateType.toBeDone);
				  			p.setPackState(StateType.toBeDone);
				  			System.out.println("provision");
				  			em.persist(p);
				  			System.out.println("p persist");
				  			c.setStock(c.getQuantity());
				  			em.merge(c);
				  			System.out.println("c merged");
					}
    	}
	
	@Override
	public String updateStock(Company c1) {
		    String s = "nothing to be updated" ;
    	        	 
    	        	 TypedQuery<Contrat> q =  em.createQuery("select c from Contrat c where "
				  				+ "c.stock = 0",Contrat.class) ;
				  		
				  	 List<Contrat> l = q.getResultList() ;
				  	 System.out.println(l.toString());
				  		for(Contrat c : l){
				  			System.out.println("ccccccccccccccccccccc");
				  			System.out.println(c.getCompany().getId());
				  			System.out.println(c1.getId());
				  			if(c.getCompany().getId()==c1.getId()){
				  				System.out.println("aaaaaaaaaaaaaaaaa");
					  			Provision p = new Provision() ; 
					  			p.setContrat(c);
					  			Date current = new Date() ; 
					  			p.setDate_provision(current);
					  			p.setDelivState(StateType.toBeDone);
					  			p.setInvoState(StateType.toBeDone);
					  			p.setPackState(StateType.toBeDone);
					  			
					  			em.persist(p);
					  			
					  			c.setStock(c.getQuantity());
					  			em.merge(c);
					  			System.out.println("bbbbbbbbbbbbb");
					  			s = "stock updated" ;
				  			
				  			}
					} 
				  		return s ;
				  		
    	}

	@Override
	public List<Provision> getProvisionTBD(Company c) {
		TypedQuery<Provision> q =  em.createQuery("select p from Provision p inner join p.contrat c inner join c.produit pr "
				+ "where pr.supplier = :cmp and p.delivState =:state",Provision.class) ;
		
		q.setParameter("cmp", c) ; 
		q.setParameter("state", StateType.toBeDone);
		List<Provision> l = q.getResultList() ;
		return l;
	}

	@Override
	public List<Provision> getProvisionTBP(Company c) {
		TypedQuery<Provision> q =  em.createQuery("select p from Provision p inner join p.contrat c inner join c.produit pr "
				+ "where pr.supplier = :cmp and p.packState =:state",Provision.class) ;
		
		q.setParameter("cmp"	, c) ; 
		q.setParameter("state", StateType.toBeDone);
		List<Provision> l = q.getResultList() ;
		return l;
	}
	
	@Override
	public void updateDelivery(Integer id){
		Provision p = em.find(Provision.class, id);
		p.setDelivState(StateType.delivered);
		em.merge(p);
				
	}
	@Override
	public void updatePackaging(Integer id){
		Provision p = em.find(Provision.class, id);
		p.setPackState(StateType.done);
		em.merge(p);
				
	}
	
	@Override
	public List<Object[]> salesPerCompany(Company c) {
		 
		Query q =  em.createQuery("select SUM(o.quantity) , o.prod from OrderLine o inner join o.prod p where o.prod = p.id AND p.supplier = :c group by o.prod ") ;
		 List<Object[]> listO = q.setParameter("c", c).getResultList();
		return listO;
	}
	@Override
	public List<Object[]> productSales(Company c) {
		 
		Query q =  em.createQuery("select SUM(o.quantity) , o.prod ,o.ord from OrderLine o inner join o.prod p where o.prod = p.id AND p.supplier = :c group by o.prod ") ;
		 List<Object[]> listO = q.setParameter("c", c).getResultList();
		return listO;
	}
	
	@Override
	public List<Contrat> provisionByCompany(Company c) {
		TypedQuery<Contrat> q =  em.createQuery("select ct from Contrat ct inner join ct.produit pr where pr.supplier= :c ",Contrat.class ) ;
		q.setParameter("c", c);
		
		List<Contrat> l = q.getResultList(); 
		return l ;
	}
}
