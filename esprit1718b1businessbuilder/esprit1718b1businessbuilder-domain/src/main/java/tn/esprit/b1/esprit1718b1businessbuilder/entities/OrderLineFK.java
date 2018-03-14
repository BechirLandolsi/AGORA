package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class OrderLineFK implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int idOrder ; 
	private int idProduct ;
	
	
	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idOrder;
		result = prime * result + idProduct;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLineFK other = (OrderLineFK) obj;
		if (idOrder != other.idOrder)
			return false;
		if (idProduct != other.idProduct)
			return false;
		return true;
	}
	
	
	
	
	
}
