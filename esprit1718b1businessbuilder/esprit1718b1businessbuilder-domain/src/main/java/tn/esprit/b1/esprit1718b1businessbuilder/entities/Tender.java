package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Column(name = "TDR_ID")
	private Long id;
	
	@Column(name="TDR_TITLE")
	private String title;
	
	@Temporal(TemporalType.DATE)
	@Column(name="TDR_EXPIRATION")
	private Date expirationDate;
	
	@Column(name="TDR_CONTENT")
	private String content;

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

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Tender() {
		super();
	}

	public Tender(String title, Date expirationDate, String content) {
		super();
		this.title = title;
		this.expirationDate = expirationDate;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Tender [title=" + title + "]";
	}
	
	
	
	

}
