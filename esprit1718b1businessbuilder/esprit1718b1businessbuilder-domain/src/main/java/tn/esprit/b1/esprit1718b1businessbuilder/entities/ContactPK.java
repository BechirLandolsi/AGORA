package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ContactPK implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long CompanyID ;
	private Long CompanyContactID ;
	
	public ContactPK(Long companyID, Long companyContactID) {
		super();
		CompanyID = companyID;
		CompanyContactID = companyContactID;
	}
	public Long getCompanyID() {
		return CompanyID;
	}
	public void setCompanyID(Long companyID) {
		CompanyID = companyID;
	}
	public Long getCompanyContactID() {
		return CompanyContactID;
	}
	public void setCompanyContactID(Long companyContactID) {
		CompanyContactID = companyContactID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CompanyContactID == null) ? 0 : CompanyContactID.hashCode());
		result = prime * result + ((CompanyID == null) ? 0 : CompanyID.hashCode());
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
		ContactPK other = (ContactPK) obj;
		if (CompanyContactID == null) {
			if (other.CompanyContactID != null)
				return false;
		} else if (!CompanyContactID.equals(other.CompanyContactID))
			return false;
		if (CompanyID == null) {
			if (other.CompanyID != null)
				return false;
		} else if (!CompanyID.equals(other.CompanyID))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ContactPK [CompanyID=" + CompanyID + ", CompanyContactID=" + CompanyContactID + "]";
	}
	public ContactPK() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
