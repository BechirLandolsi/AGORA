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
	private long idCompanyGuest;
	
	/// event in invitation id
	private long  idEvent;

	public long getIdCompanyGuest() {
		return idCompanyGuest;
	}

	public void setIdCompanyGuest(long idCompanyGuest) {
		this.idCompanyGuest = idCompanyGuest;
	}

	public long getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(long idEvent) {
		this.idEvent = idEvent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idCompanyGuest ^ (idCompanyGuest >>> 32));
		result = prime * result + (int) (idEvent ^ (idEvent >>> 32));
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

	/*  Getters and Setters*/

	
}
	
