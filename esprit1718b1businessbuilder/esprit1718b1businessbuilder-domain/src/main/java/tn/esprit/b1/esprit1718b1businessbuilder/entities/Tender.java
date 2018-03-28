package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tab_tender")
public class Tender implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TenderId")
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Temporal(TemporalType.DATE)
	@Column(name="deadline")
	private Date deadline;
	
	@Column(name="content")
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="publishedDate")
	private Date publishedDate;
	
	@ManyToOne
	private Company companyTender;
	
	@OneToMany(mappedBy="tender")
	private List <TenderApplication> tenderApplications;
	
	@ManyToOne
	private TenderCategory category;
	
	@ManyToMany(mappedBy="tenders")
	private List<TenderQualification> qualifications;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	
	

	public Company getCompanyTender() {
		return companyTender;
	}

	public void setCompanyTender(Company companyTender) {
		this.companyTender = companyTender;
	}
	
	
	public List<TenderApplication> getTenderApplications() {
		return tenderApplications;
	}

	public void setTenderApplications(List<TenderApplication> tenderApplications) {
		this.tenderApplications = tenderApplications;
	}

	public TenderCategory getCategory() {
		return category;
	}

	public void setCategory(TenderCategory category) {
		this.category = category;
	}
	
	public List<TenderQualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<TenderQualification> qualifications) {
		this.qualifications = qualifications;
	}

	public Tender() {
		super();
	}

	

	public Tender(String title, Date deadline, String content, Date publishedDate) {
		super();
		this.title = title;
		this.deadline = deadline;
		this.content = content;
		this.publishedDate = publishedDate;
	}

	@Override
	public String toString() {
		return "Tender [title=" + title + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
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
		Tender other = (Tender) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		return true;
	}
	
	
	

}
