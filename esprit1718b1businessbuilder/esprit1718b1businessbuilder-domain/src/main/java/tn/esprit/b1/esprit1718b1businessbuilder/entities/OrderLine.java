package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine implements Serializable{
	
	@EmbeddedId
	private OrderLineFK orderLineFK ; 
	
	private Integer quantity ;
	
	 
	
	/* Association */ 
	@ManyToOne
	@JoinColumn(name="idProduct",referencedColumnName="id",insertable=false,updatable=false)
	private Produit product ; 
	
	@ManyToOne
	@JoinColumn(name="idOrder",referencedColumnName="id",insertable=false,updatable=false)
	private Order order ;
	
	/***************/
	

	public OrderLineFK getOrderLineFK() {
		return orderLineFK;
	}

	public void setOrderLineFK(OrderLineFK orderLineFK) {
		this.orderLineFK = orderLineFK;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	

	public Produit getProduct() {
		return product;
	}

	public void setProduct(Produit product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderLine(OrderLineFK orderLineFK, Integer quantity) {
		super();
		this.orderLineFK = orderLineFK;
		this.quantity = quantity;
	}

	public OrderLine() {
		super();
	} 
	
	

}
