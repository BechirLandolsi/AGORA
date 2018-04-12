package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="tab_tenderQualification")
public class TenderQualification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Qualif_ID")
	private Long id;
	
	@Column(name="nameQualification")
	private String nameQualification;
	
	@ManyToMany(mappedBy="qualifications")
	private List<Tender>tenders;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameQualification() {
		return nameQualification;
	}

	public void setNameQualification(String nameQualification) {
		this.nameQualification = nameQualification;
	}

	public TenderQualification() {
		super();
	}

	public TenderQualification(String nameQualification) {
		super();
		this.nameQualification = nameQualification;
	}
	
	public List<Tender> getTenders() {
		return tenders;
	}

	public void setTenders(List<Tender> tenders) {
		this.tenders = tenders;
	}

	@Override
	public String toString() {
		return nameQualification;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nameQualification == null) ? 0 : nameQualification.hashCode());
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
		TenderQualification other = (TenderQualification) obj;
		if (nameQualification == null) {
			if (other.nameQualification != null)
				return false;
		} else if (!nameQualification.equals(other.nameQualification))
			return false;
		return true;
	}
	
	
	
	
	

}
