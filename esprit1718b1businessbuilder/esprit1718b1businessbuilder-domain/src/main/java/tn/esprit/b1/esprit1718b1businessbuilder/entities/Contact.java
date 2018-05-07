package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tab_contacts")
public class Contact implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EmbeddedId 
	private ContactPK contactPK ;
	
	
	@ManyToOne
	@JoinColumn(name="CompanyID",referencedColumnName="USR_ID",insertable=false,updatable=false)
	private Company Company;
	
	@ManyToOne
	@JoinColumn(name="CompanyContactID",referencedColumnName="USR_ID",insertable=false,updatable=false)
	private Company CompanyContact;

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(ContactPK contactPK, tn.esprit.b1.esprit1718b1businessbuilder.entities.Company company,
			tn.esprit.b1.esprit1718b1businessbuilder.entities.Company companyContact) {
		super();
		this.contactPK = contactPK;
		Company = company;
		CompanyContact = companyContact;
	}

	public ContactPK getContactPK() {
		return contactPK;
	}

	public void setContactPK(ContactPK contactPK) {
		this.contactPK = contactPK;
	}

	public Company getCompany() {
		return Company;
	}

	public void setCompany(Company company) {
		Company = company;
	}

	public Company getCompanyContact() {
		return CompanyContact;
	}

	public void setCompanyContact(Company companyContact) {
		CompanyContact = companyContact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Company == null) ? 0 : Company.hashCode());
		result = prime * result + ((CompanyContact == null) ? 0 : CompanyContact.hashCode());
		result = prime * result + ((contactPK == null) ? 0 : contactPK.hashCode());
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
		Contact other = (Contact) obj;
		if (Company == null) {
			if (other.Company != null)
				return false;
		} else if (!Company.equals(other.Company))
			return false;
		if (CompanyContact == null) {
			if (other.CompanyContact != null)
				return false;
		} else if (!CompanyContact.equals(other.CompanyContact))
			return false;
		if (contactPK == null) {
			if (other.contactPK != null)
				return false;
		} else if (!contactPK.equals(other.contactPK))
			return false;
		return true;
	}

	
}
