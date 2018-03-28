package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class TenderApplicationPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long tenderId;
	private Long companyId;
	
	public Long getTenderId() {
		return tenderId;
	}
	public void setTenderId(Long tenderId) {
		this.tenderId = tenderId;
	}
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
		result = prime * result + ((tenderId == null) ? 0 : tenderId.hashCode());
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
		TenderApplicationPK other = (TenderApplicationPK) obj;
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.companyId))
			return false;
		if (tenderId == null) {
			if (other.tenderId != null)
				return false;
		} else if (!tenderId.equals(other.tenderId))
			return false;
		return true;
	}
	public TenderApplicationPK() {
		super();
	}
	public TenderApplicationPK(Long tenderId, Long companyId) {
		super();
		this.tenderId = tenderId;
		this.companyId = companyId;
	}
	
	
	

}
