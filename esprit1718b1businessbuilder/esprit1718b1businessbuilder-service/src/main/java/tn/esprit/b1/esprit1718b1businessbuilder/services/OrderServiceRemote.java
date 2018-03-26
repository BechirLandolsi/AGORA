package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;


import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Order;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;


@Remote
public interface OrderServiceRemote {

	
	public Order findOrder(int id);
	public void addProductToOrder(Produit P,Company C,int k) ; 
	public String payOrder(Company C);
	public List<Order> findAllOrder(Company C); 
	public Order findActiveOrder(Company C); 
	public  Float calculAmount(Order o) ;
	
	public Long nbSubscriber();
	public Long nbSubscriberPerday(); 
	public List<Object[]> nbSubscriberPertype() ; 
	
	public List<Object[]> salesPermonth() ; 

}
