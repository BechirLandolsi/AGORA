package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "tab_invitation")
public class Invitation implements Serializable {
	
	
	@EmbeddedId
	private InvitationPK invitationPK;
	
	
	@ManyToOne
	@JoinColumn(name="idEvent",referencedColumnName="EVENT_ID",insertable=false,updatable=false)
	private Event Event ;
	@ManyToOne
	@JoinColumn(name="idguest",referencedColumnName="USR_ID",insertable=false,updatable=false)
	private Company guest ;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "INVITATION_DATE")
	private Date invitationDate;
	
	@Column(name = "GUEST_RESPONSE")
	private boolean guest_Response;
	
	@Column(name = "PARTICIPATION_PRICE")
	private float participation_price;

	public InvitationPK getInvitationPK() {
		return invitationPK;
	}

	public void setInvitationPK(InvitationPK invitationPK) {
		this.invitationPK = invitationPK;
	}

	

	public Event getEvent() {
		return Event;
	}

	public void setEvent(Event event) {
		Event = event;
	}

	public Company getGuest() {
		return guest;
	}

	public void setGuest(Company guest) {
		this.guest = guest;
	}

	public Date getInvitationDate() {
		return invitationDate;
	}

	public void setInvitationDate(Date invitationDate) {
		this.invitationDate = invitationDate;
	}

	public boolean isGuest_Response() {
		return guest_Response;
	}

	public void setGuest_Response(boolean guest_Response) {
		this.guest_Response = guest_Response;
	}

	public float getParticipation_price() {
		return participation_price;
	}

	public void setParticipation_price(float participation_price) {
		this.participation_price = participation_price;
	}
	
	
	

}
