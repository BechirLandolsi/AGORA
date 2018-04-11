package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderLineFK orderLineFK ; 
	
	private Integer quantity ;
	
	 
	
	/* Association */ 
	@ManyToOne
	@JoinColumn(name="idProduct",referencedColumnName="id",insertable=false,updatable=false)
	private Produit prod ; 
	
	
	@ManyToOne
	@JoinColumn(name="idOrder",referencedColumnName="id",insertable=false,updatable=false)
	private Order ord ;
	
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
	
	

	public Produit getProd() {
		return prod;
	}

	public void setProd(Produit prod) {
		this.prod = prod;
	}

	public Order getOrd() {
		return ord;
	}

	public void setOrd(Order ord) {
		this.ord = ord;
	}

	public OrderLine(OrderLineFK orderLineFK, Integer quantity) {
		super();
		this.orderLineFK = orderLineFK;
		this.quantity = quantity;
	}

	public OrderLine() {
		super();
	}

	@Override
	public String toString() {
		return "OrderLine [orderLineFK=" + orderLineFK + ", quantity=" + quantity + ", prod=" + prod + ", ord=" + ord
				+ "]";
	} 
	
	

}
