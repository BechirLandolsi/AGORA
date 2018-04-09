package tn.esprit.b1.esprit1718b1businessbuilder.services;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.jms.Session;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Order;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.OrderLine;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.OrderLineFK;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;


@Stateless
public class OrderService implements OrderServiceRemote {
	
	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ;

	@Override
	public Order findOrder(int id) {
		Order O = em.find(Order.class, id) ; 
	    return O ; 
	}

    /*
     * to find order's company
     */
	@Override
	public List<Order> findAllOrder(Company C) {
		TypedQuery<Order> q =  em.createQuery("select o from Order o where o.buyer= :buyer ",Order.class) ;
		 List<Order> orders = q.setParameter("buyer", C).getResultList() ;
		return orders;
	}


	@Override
	public void addProductToOrder(Produit P, Company C, int k) {
		Order o ; 
		
		if (findActiveOrder(C) == null){
			System.out.println("aaaaaaaa");
			o = new Order();
			o.setBuyer(C);
			em.persist(o);
		}else {
			o = findActiveOrder(C);
		}
		OrderLine ol = new OrderLine();
		OrderLineFK opk = new OrderLineFK() ; 
		opk.setIdOrder(o.getId());
		opk.setIdProduct(P.getId());
		ol.setOrderLineFK(opk);
		ol.setQuantity(k);
		
        em.persist(ol);
	}


	@Override
	public String payOrder(Company C) {
		String s ;
		Order o = findActiveOrder(C) ; 
		if(o != null){
		o.setState(1);
		Date current = new Date() ; 
		o.setOrderDate(current);
		o.setAmount(calculAmount(o));
		s = "order paied" ; 
		}else {
			s= "no order to pay" ; 
		}
		return s ;
	}

	@Override
	public Order findActiveOrder(Company C) {
		TypedQuery<Order> q =  em.createQuery("select o from Order o where o.buyer = :buyer and o.state=0 ",Order.class) ;
		Order order ; 
		order = null ; 
		 try{
			 order = q.setParameter("buyer", C).getSingleResult() ;
			 
		 }catch(NoResultException e){
			System.out.println(e); 
			}
		
		
		return order;
	}

	@Override
	public  Float calculAmount(Order o) {
        Float ammount = (float)0  ; 
		TypedQuery<OrderLine> q =  em.createQuery("select o from OrderLine o where o.ord= :order  ",OrderLine.class) ;
		 List<OrderLine> listO = q.setParameter("order", o).getResultList();	
		 for(OrderLine ol : listO){
			 ammount = ammount + ol.getProd().getPrice()*ol.getQuantity() ;
			 
		 }
		return ammount;
	}

	@Override
	public Long nbSubscriber() {
		TypedQuery<Long> q =  em.createQuery("select Count(c) from Company c ",Long.class) ;
		return q.getSingleResult() ;
	}

	@Override
	public Long nbSubscriberPerday() {
		TypedQuery<Long> q =  em.createQuery("select Count(c) from Company c where c.subDate = :date",Long.class) ;
		Date current = new Date() ; 
		Long n = q.setParameter("date", current, TemporalType.DATE).getSingleResult();
		return n ;
	}

	@Override
	public List<Object[]> nbSubscriberPertype() {
		Query q =  em.createQuery("select Count(c), c.sector from Company c group by c.sector ") ;
		return q.getResultList() ;
	}
	

	@Override
	public List<Object[]> salesPermonth() {
		
		 
		Query q =  em.createQuery("select  SUM(c.amount) , c.orderDate from Order c group by c.orderDate " ) ;
		    
		
		
		List<Object[]> l = q.getResultList(); 
		return l ;
	}
	
	@Override
	public List<Company> findAllCompanyByName(String name) {

		TypedQuery<Company> q =  em.createQuery("select c from Company c WHERE c.name LIKE :name ",Company.class) ;
		List<Company > c = new ArrayList<>() ;
		try{
		c =	q.setParameter("name", "%" + name+ "%").getResultList() ;
		}catch(NoResultException e){
			
		}
		
		return c ;
	}

}
