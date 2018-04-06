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
	private int idComanyGuest;
	
	/// event in invitation id
	private int idEvent;
	

	
	/*  Getters and Setters*/
	
	public int getIdComanyGuest() {
		return idComanyGuest;
	}
	public void setIdComanyGuest(int idComanyGuest) {
		this.idComanyGuest = idComanyGuest;
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
		result = prime * result + idComanyGuest;
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
		if (idComanyGuest != other.idComanyGuest)
			return false;
		if (idEvent != other.idEvent)
			return false;
		return true;
	}
	

}
