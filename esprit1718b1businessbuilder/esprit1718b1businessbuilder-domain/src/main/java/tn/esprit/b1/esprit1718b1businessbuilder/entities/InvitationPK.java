package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class InvitationPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/// company guest id
	private int idCompanyGuest;
	
	/// event in invitation id
	private int idEvent;

	/*  Getters and Setters*/
	

	
	public int getIdEvent() {
		return idEvent;
	}
	
	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}
	public int getIdCompanyGuest() {
		return idCompanyGuest;
	}
	public void setIdCompanyGuest(int idCompanyGuest) {
		this.idCompanyGuest = idCompanyGuest;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCompanyGuest;
		result = prime * result + idEvent;
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
		if (idCompanyGuest != other.idCompanyGuest)
			return false;
		if (idEvent != other.idEvent)
			return false;
		return true;
	}
	
	
	
	


}
