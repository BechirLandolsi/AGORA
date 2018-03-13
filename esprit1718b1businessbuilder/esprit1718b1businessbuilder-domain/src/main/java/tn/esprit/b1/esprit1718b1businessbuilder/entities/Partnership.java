package tn.esprit.b1.esprit1718b1businessbuilder.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tab_partnership")
public class Partnership implements Serializable {
	
	@EmbeddedId
	private PartnershipPK partnershipPk;
	

	//@ManyToOne
	//@JoinColumn(name="idCompany",referencedColumnName="id",insertable=false,updatable=false)
	private Company company;
	
	//@ManyToOne
	//@JoinColumn(name="idPartner",referencedColumnName="id",insertable=false,updatable=false)
	private Company partner;
		
	@Column(name = "partnershipDate")
	private String partnershipDate;
	
	@Column(name = "partnershipDuration")
	private String partnershipDuration;
	
	public Partnership() {
		super();
	}

	public Partnership(PartnershipPK partnershipPk, Company company, Company partner, String partnershipDate,
			String partnershipDuration) {
		super();
		this.partnershipPk = partnershipPk;
		this.company = company;
		this.partner = partner;
		this.partnershipDate = partnershipDate;
		this.partnershipDuration = partnershipDuration;
	}

	public PartnershipPK getPartnershipPk() {
		return partnershipPk;
	}

	public void setPartnershipPk(PartnershipPK partnershipPk) {
		this.partnershipPk = partnershipPk;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Company getPartner() {
		return partner;
	}

	public void setPartner(Company partner) {
		this.partner = partner;
	}

	public String getPartnershipDate() {
		return partnershipDate;
	}

	public void setPartnershipDate(String partnershipDate) {
		this.partnershipDate = partnershipDate;
	}

	public String getPartnershipDuration() {
		return partnershipDuration;
	}

	public void setPartnershipDuration(String partnershipDuration) {
		this.partnershipDuration = partnershipDuration;
	}
	
	



	
	


}