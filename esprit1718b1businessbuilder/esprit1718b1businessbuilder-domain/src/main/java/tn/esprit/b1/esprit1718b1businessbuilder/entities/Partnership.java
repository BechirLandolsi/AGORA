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
	@JoinColumn(name="CompanyPartnerId",referencedColumnName="USR_ID",insertable=false,updatable=false)
	private Company CompanyPartner;
	
	
	
	@ManyToOne
	@JoinColumn(name="ProjectId",referencedColumnName="ProjectId",insertable=false,updatable=false)
	private Project project;
		
	@Column(name = "partnershipDate")
	private String partnershipDate;
	
	@Column(name = "partnershipDuration")
	private String partnershipDuration;
	
	public Partnership() {
		super();
	}

	public Partnership(PartnershipPK partnershipPK, Company companyPartner, Project project, String partnershipDate,
			String partnershipDuration) {
		super();
		this.partnershipPK = partnershipPK;
		CompanyPartner = companyPartner;
		this.project = project;
		this.partnershipDate = partnershipDate;
		this.partnershipDuration = partnershipDuration;
	}

	public PartnershipPK getPartnershipPK() {
		return partnershipPK;
	}

	public void setPartnershipPK(PartnershipPK partnershipPK) {
		this.partnershipPK = partnershipPK;
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