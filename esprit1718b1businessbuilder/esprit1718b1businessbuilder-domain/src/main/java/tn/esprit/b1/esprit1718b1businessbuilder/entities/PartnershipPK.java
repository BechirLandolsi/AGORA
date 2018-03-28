package tn.esprit.b1.esprit1718b1businessbuilder.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Embeddable
public class PartnershipPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long ProjectId;
	private Long CompanyOwnerId;
	private Long CompanyPartnerId;
	
	
	public PartnershipPK() {
		super();
	}


	public Long getProjectId() {
		return ProjectId;
	}


	public void setProjectId(Long projectId) {
		ProjectId = projectId;
	}


	public Long getCompanyOwnerId() {
		return CompanyOwnerId;
	}


	public void setCompanyOwnerId(Long companyOwnerId) {
		CompanyOwnerId = companyOwnerId;
	}


	public Long getCompanyPartnerId() {
		return CompanyPartnerId;
	}


	public void setCompanyPartnerId(Long companyPartnerId) {
		CompanyPartnerId = companyPartnerId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CompanyOwnerId == null) ? 0 : CompanyOwnerId.hashCode());
		result = prime * result + ((CompanyPartnerId == null) ? 0 : CompanyPartnerId.hashCode());
		result = prime * result + ((ProjectId == null) ? 0 : ProjectId.hashCode());
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
		PartnershipPK other = (PartnershipPK) obj;
		if (CompanyOwnerId == null) {
			if (other.CompanyOwnerId != null)
				return false;
		} else if (!CompanyOwnerId.equals(other.CompanyOwnerId))
			return false;
		if (CompanyPartnerId == null) {
			if (other.CompanyPartnerId != null)
				return false;
		} else if (!CompanyPartnerId.equals(other.CompanyPartnerId))
			return false;
		if (ProjectId == null) {
			if (other.ProjectId != null)
				return false;
		} else if (!ProjectId.equals(other.ProjectId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "PartnershipPK [ProjectId=" + ProjectId + ", CompanyOwnerId=" + CompanyOwnerId + ", CompanyPartnerId="
				+ CompanyPartnerId + "]";
	}

	
	
	
}
