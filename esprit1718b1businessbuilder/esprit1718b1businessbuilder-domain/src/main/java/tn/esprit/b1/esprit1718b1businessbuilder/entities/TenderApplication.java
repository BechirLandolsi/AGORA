package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;
import java.time.ZonedDateTime;
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
@Table(name="tab_tenderApplication")
public class TenderApplication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private TenderApplicationPK tenderApplicationPK;
		
	@ManyToOne
	@JoinColumn(name="tenderId",referencedColumnName="TenderId",insertable=false,updatable=false)
	private Tender tender;
	
	@ManyToOne
	@JoinColumn(name="companyId",referencedColumnName="USR_ID",insertable=false,updatable=false)
	private Company company;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="APPLICATION_DATE")
	private Date applicationDate;

	public TenderApplicationPK getTenderApplicationPK() {
		return tenderApplicationPK;
	}

	public void setTenderApplicationPK(TenderApplicationPK tenderApplicationPK) {
		this.tenderApplicationPK = tenderApplicationPK;
	}

	public Tender getTender() {
		return tender;
	}

	public void setTender(Tender tender) {
		this.tender = tender;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(ZonedDateTime applicationDate) {
		applicationDate = ZonedDateTime.now();
		this.applicationDate = java.util.Date.from( applicationDate.toInstant() );
	}

	public TenderApplication() {
		super();
	}

	public TenderApplication(TenderApplicationPK tenderApplicationPK, Tender tender, Company company,Date applicationDate) {
		super();
		this.tenderApplicationPK = tenderApplicationPK;
		this.tender = tender;
		this.company = company;
		this.applicationDate = applicationDate;
	}
	
	
	

}
