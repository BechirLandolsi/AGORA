package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ContratPK implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int idCompany ; 
	private int idProduct ;
	
	public int getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
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
		result = prime * result + idCompany;
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
		ContratPK other = (ContratPK) obj;
		if (idCompany != other.idCompany)
			return false;
		if (idProduct != other.idProduct)
			return false;
		return true;
	}
	
	

}
