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
	
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@EmbeddedId
	private PartnershipPK partnershipPK;
	
	@ManyToOne
	@JoinColumn(name="CompanyOwnerId",referencedColumnName="USR_ID",insertable=false,updatable=false)
	private Company CompanyOwner;
	
	@ManyToOne
	@JoinColumn(name="CompanyPartnerId",referencedColumnName="USR_ID",insertable=false,updatable=false)
	private Company CompanyPartner;
	
	
	@ManyToOne
	@JoinColumn(name="ProjectId",referencedColumnName="ProjectId",insertable=false,updatable=false)
	private Project project;
		
	@Column(name = "partnershipDate")
	private Date partnershipDate;
	
	@Column(name = "partnershipDuration")
	private String partnershipDuration;
	
	@Column(name = "state")
	private boolean state;
	
	public Partnership() {
		super();
	}

	
	
	



	public Partnership(PartnershipPK partnershipPK, Company companyOwner, Company companyPartner, Project project,
			Date partnershipDate, String partnershipDuration, boolean state) {
		super();
		this.partnershipPK = partnershipPK;
		CompanyOwner = companyOwner;
		CompanyPartner = companyPartner;
		this.project = project;
		this.partnershipDate = partnershipDate;
		this.partnershipDuration = partnershipDuration;
		this.state = state;
	}







	public PartnershipPK getPartnershipPK() {
		return partnershipPK;
	}

	public void setPartnershipPK(PartnershipPK partnershipPK) {
		this.partnershipPK = partnershipPK;
	}

	public Company getCompanyOwner() {
		return CompanyOwner;
	}

	public void setCompanyOwner(Company companyOwner) {
		CompanyOwner = companyOwner;
	}

	public Company getCompanyPartner() {
		return CompanyPartner;
	}

	public void setCompanyPartner(Company companyPartner) {
		CompanyPartner = companyPartner;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Date getPartnershipDate() {
		return partnershipDate;
	}

	public void setPartnershipDate(Date partnershipDate) {
		this.partnershipDate = partnershipDate;
	}

	public String getPartnershipDuration() {
		return partnershipDuration;
	}

	public void setPartnershipDuration(String partnershipDuration) {
		this.partnershipDuration = partnershipDuration;
	}


	public boolean isState() {
		return state;
	}


	public void setState(boolean state) {
		this.state = state;
	}

	

	@Override
	public String toString() {
		return "Partnership [partnershipPK=" + partnershipPK + ", CompanyOwner=" + CompanyOwner + ", CompanyPartner="
				+ CompanyPartner + ", project=" + project + ", partnershipDate=" + partnershipDate
				+ ", partnershipDuration=" + partnershipDuration + "]";
	}

	
	
}