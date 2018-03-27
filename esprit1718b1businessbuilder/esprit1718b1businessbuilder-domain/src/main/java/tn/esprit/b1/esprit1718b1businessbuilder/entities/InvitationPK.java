package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class InvitationPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idCompany;
	private int idGuest;
	private int idEvent;
	
	
	public int getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}
	public int getIdGuest() {
		return idGuest;
	}
	public void setIdGuest(int idGuest) {
		this.idGuest = idGuest;
	}
	public int getIdEvent() {
		return idEvent;
	}
	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCompany;
		result = prime * result + idEvent;
		result = prime * result + idGuest;
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
		InvitationPK other = (InvitationPK) obj;
		if (idCompany != other.idCompany)
			return false;
		if (idEvent != other.idEvent)
			return false;
		if (idGuest != other.idGuest)
			return false;
		return true;
	}

	
	
	
	
	
	

}
