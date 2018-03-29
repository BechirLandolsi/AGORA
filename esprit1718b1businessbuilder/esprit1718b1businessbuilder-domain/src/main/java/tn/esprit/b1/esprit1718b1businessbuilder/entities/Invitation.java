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
	@JoinColumn(name="idCompany",referencedColumnName="USR_ID",insertable=false,updatable=false)
	private Company company ;
	@ManyToOne
	@JoinColumn(name="idguest",referencedColumnName="USR_ID",insertable=false,updatable=false)
	private Company guest ;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "invitationDate")
	private Date invitationDate;
	
	@Column(name = "guestResponse")
	private String guestResponse;

}
