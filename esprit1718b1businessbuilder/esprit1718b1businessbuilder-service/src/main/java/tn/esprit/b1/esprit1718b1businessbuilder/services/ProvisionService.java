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

/**
 * <ProvisionService> est un EJB stateless implementant l'interface 
 * @see <IProvision> 
 * 
 * @author Nour 
 *
 */

@Stateless
@LocalBean
public class ProvisionService implements IProvision {

	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ;

	/**
	 * permet d'ajouter un contrat :
	 * @param company 
	 * @param produit
	 * @param quantité
	 * 
	 */
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
	/**
	 * cette methode permet d'ajouter 
	 * une provision ayant une clé étrangére
	 * <Contrat> et modifier le stock de celui 
	 * ci 
	 * 
	 */

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
	/**
	 * 
	 * cette methode permet de trouver 
	 * le contrat d'une company dont l'id est
	 * @param idC et le produit ayant un id
	 * @param idP
	 * 
	 * @return Contrat
	 *
	 */

	@Override
	public Contrat findContrat(Integer idC, Integer idP) {
		ContratPK pk = new ContratPK() ; 
		pk.setIdCompany(idC);
		pk.setIdProduct(idP);
		Contrat c = em.find(Contrat.class, pk);
		return c;
	}
	
	/**
	 * cette methode permet de trouver 
	 * la provision dont l'ID est 
	 * @param id
	 * 
	 * @return Provision
	 * 
	 */

	@Override
	public Provision findProvision(Integer id) {
		Provision p = em.find(Provision.class, id);
		return p;
	}
	
	/**
	 * cette methode permet de compter les
	 * provisions qui ne sont pas encore 
	 * delivrés
	 * 
	 * @return Integer
	 */

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
	/**
	 * cette methode permet de compter les
	 * provisions qui ne sont pas encore 
	 * packetées
	 * 
	 * @return Integer
	 */

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
	/**
	 * cette methode permet de compter les
	 * provisions qui ne sont pas encore 
	 * payés
	 * 
	 * @return Float
	 */

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
	/**
	 * cette methode permet de compter
	 * le stock d'une company 
	 * 
	 * @param Company
	 * 
	 * @return Integer
	 */

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
	
	/**
	 * 
	 * cette methode permet de calculer la quantité
	 * des produits commandés et non pas encore reçue
	 * 
	 */

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
	
	/**
	 * cette methode permet de 
	 * trouver les companies dont 
	 * le stock est null 
	 * et leur repasser des provisions 
	 * automatiquement
	 * 
	 */

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
	
	/**
	 * cette methode permet de 
	 * verifier le stock d'un company 
	 * s'il est null
	 *  des provisions sont ajoutées
	 * automatiquement
	 * 
	 */
	
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
	
	/**
	 * cette methode permet de trouver les
	 * provisions qui ne sont pas encore 
	 * delivrés
	 * 
	 * @return List<Provision>
	 */
	
	@Override
	public List<Provision> getProvisionTBD(Company c) {
		TypedQuery<Provision> q =  em.createQuery("select p from Provision p inner join p.contrat c inner join c.produit pr "
				+ "where pr.supplier = :cmp and p.delivState =:state",Provision.class) ;
		
		q.setParameter("cmp", c) ; 
		q.setParameter("state", StateType.toBeDone);
		List<Provision> l = q.getResultList() ;
		return l;
	}
     /**
	 * cette methode permet de trouver les
	 * provisions qui ne sont pas encore 
	 * payés
	 * 
	 * @return List<Provision>
	 */
	 
	@Override
	public List<Provision> getProvisionTBP(Company c) {
		TypedQuery<Provision> q =  em.createQuery("select p from Provision p inner join p.contrat c inner join c.produit pr "
				+ "where pr.supplier = :cmp and p.packState =:state",Provision.class) ;
		
		q.setParameter("cmp"	, c) ; 
		q.setParameter("state", StateType.toBeDone);
		List<Provision> l = q.getResultList() ;   
		return l;
	}
	/**
	 *
	 *cette methode permet de changer
	 *l'etat de la livraison 
	 *
	 */
	
	@Override
	public void updateDelivery(Integer id){
		Provision p = em.find(Provision.class, id);
		p.setDelivState(StateType.delivered);
		em.merge(p);
				
	}
	
	/**
	 * cette methode permet de changer
	 *l'etat de la livraison 
	 *
	 */
	@Override
	public void updatePackaging(Integer id){
		Provision p = em.find(Provision.class, id);
		p.setPackState(StateType.done);
		em.merge(p);
				
	}
	
	/**
	 * cette methode permet de retourner
	 * la quantité des produits et les produits vendues par 
	 * la companies 
	 * 
	 */
	
	@Override
	public List<Object[]> salesPerCompany(Company c) {
		 
		Query q =  em.createQuery("select SUM(o.quantity) , o.prod from OrderLine o inner join o.prod p where o.prod = p.id AND p.supplier = :c group by o.prod ") ;
		 List<Object[]> listO = q.setParameter("c", c).getResultList();
		return listO;
	}
	
	/**
	 * cette methode permet de joigner 
	 * les deux tables Orderline et 
	 * produits et 
	 *  retourner 
	 * la quantité des produits 
	 *  vendues par 
	 * la companies 
	 * 
	 */
	@Override
	public List<Object[]> productSales(Company c) {
		 
		Query q =  em.createQuery("select SUM(o.quantity) , o.prod ,o.ord from OrderLine o inner join o.prod p where o.prod = p.id AND p.supplier = :c group by o.prod ") ;
		 List<Object[]> listO = q.setParameter("c", c).getResultList();
		return listO;
	}
	/**
	 * cette methode permet de joigner 
	 * les deux tables  Contrat et Produit
	 * et 
	 * @return List<Object[]>
	 *  
	 */
	@Override
	public List<Contrat> provisionByCompany(Company c) {
		TypedQuery<Contrat> q =  em.createQuery("select ct from Contrat ct inner join ct.produit pr where pr.supplier= :c ",Contrat.class ) ;
		q.setParameter("c", c);
		
		List<Contrat> l = q.getResultList(); 
		return l ;
	}
}
