package tn.esprit.b1.esprit1718b1businessbuilder.services;


import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Order;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.OrderLine;
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
		TypedQuery<Order> q =  em.createQuery("select * from Order o where o.buyer:= buyer ",Order.class) ;
		 List<Order> orders = q.setParameter("buyer", C).getResultList() ;
		return orders;
	}


	@Override
	public void addProductToOrder(Produit P, Company C, int k) {
		Order o ; 
		if (findActiveOrder(C) == null){
			o = new Order();
			o.setBuyer(C);
			em.persist(o);
		}else {
			o = findActiveOrder(C);
		}
		OrderLine ol = new OrderLine();
		ol.setProd(P);
		ol.setQuantity(k);
		ol.setOrd(o);
        em.persist(ol);
	}


	@Override
	public void payOrder(Company C) {
		Order o = findActiveOrder(C) ; 
		o.setState(1);
		Date current = new Date() ; 
		o.setOrderDate(current);
		
	}

	@Override
	public Order findActiveOrder(Company C) {
		TypedQuery<Order> q =  em.createQuery("select * from Order o where o.buyer:= buyer and o.state=0 ",Order.class) ;
		 Order order = q.setParameter("buyer", C).getSingleResult() ;
		return order;
	}

	@Override
	public Float calculAmount(Order o,Company C) {
		
		/*TypedQuery<Order> q =  em.createQuery("select * from OrderLine o where o.buyer:= buyer and o.state=0 ",Order.class) ;
		 Order order = q.setParameter("buyer", C).getSingleResult() ;*/
		
		return null;
	}

}
