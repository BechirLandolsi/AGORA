package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class Claim implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private int id; 
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	/* Association */ 
	
	@ManyToOne
	@JoinColumn(name="idClaimant",referencedColumnName="USR_ID",insertable=false,updatable=false)
	private Company claimant ;
	
	@ManyToOne
	@JoinColumn(name="idCompany",referencedColumnName="USR_ID",insertable=false,updatable=false)
	private Company company ;
	
	/*****************/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Company getClaimant() {
		return claimant;
	}

	public void setClaimant(Company claimant) {
		this.claimant = claimant;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	
	
	
	

}
