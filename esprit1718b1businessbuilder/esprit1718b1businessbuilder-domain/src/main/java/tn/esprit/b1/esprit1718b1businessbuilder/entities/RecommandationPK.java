package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class RecommandationPK implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long idcompany1 ; 
	private Long idcompany2 ;
	private int idservice;
	public Long getIdcompany1() {
		return idcompany1;
	}
	public void setIdcompany1(Long idcompany1) {
		this.idcompany1 = idcompany1;
	}
	public Long getIdcompany2() {
		return idcompany2;
	}
	public void setIdcompany2(Long idcompany2) {
		this.idcompany2 = idcompany2;
	}
	public int getIdservice() {
		return idservice;
	}
	public void setIdservice(int idservice) {
		this.idservice = idservice;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcompany1 == null) ? 0 : idcompany1.hashCode());
		result = prime * result + ((idcompany2 == null) ? 0 : idcompany2.hashCode());
		result = prime * result + idservice;
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
		RecommandationPK other = (RecommandationPK) obj;
		if (idcompany1 == null) {
			if (other.idcompany1 != null)
				return false;
		} else if (!idcompany1.equals(other.idcompany1))
			return false;
		if (idcompany2 == null) {
			if (other.idcompany2 != null)
				return false;
		} else if (!idcompany2.equals(other.idcompany2))
			return false;
		if (idservice != other.idservice)
			return false;
		return true;
	}
	
	
}
