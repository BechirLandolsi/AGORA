package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tab_tenderCategory")
public class TenderCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoryId")
	private Long id;
	
	@Column(name="nameCategory")
	private String nameCategory;
	
	@OneToMany(mappedBy="category")
	private List<Tender> tenders;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Tender> getTenders() {
		return tenders;
	}

	public void setTenders(List<Tender> tenders) {
		this.tenders = tenders;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nameCategory == null) ? 0 : nameCategory.hashCode());
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
		TenderCategory other = (TenderCategory) obj;
		if (nameCategory == null) {
			if (other.nameCategory != null)
				return false;
		} else if (!nameCategory.equals(other.nameCategory))
			return false;
		return true;
	}

	public TenderCategory() {
		super();
	}

	public TenderCategory(String nameCategory) {
		super();
		this.nameCategory = nameCategory;
	}

	@Override
	public String toString() {
		return "Category [nameCategory=" + nameCategory + "]";
	}
	

}
