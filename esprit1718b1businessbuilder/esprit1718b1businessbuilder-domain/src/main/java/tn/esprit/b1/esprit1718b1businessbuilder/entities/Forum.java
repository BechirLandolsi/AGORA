package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="forum")
public class Forum implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private int id; 
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	@Column(name = "rate")
	private Float rate;
	@ManyToOne
	private Produit productF ;
	
	@ManyToOne
	private Project projectF ;
	
	@ManyToOne
	private Company companyForum ;
	
	@OneToMany (mappedBy="forumC")
	private List <Comment> comment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Produit getProductF() {
		return productF;
	}

	public void setProductF(Produit product) {
		this.productF = product;
	}

	

	public Company getCompanyForum() {
		return companyForum;
	}

	public void setCompanyForum(Company companyForum) {
		this.companyForum = companyForum;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public Forum() {
	}

	public Forum(String name, String description, Produit productF, Company companyForum) {
		this.name = name;
		this.description = description;
		this.productF = productF;
		this.companyForum = companyForum;
	}

	@Override
	public String toString() {
		return "Forum [name=" + name + ", description=" + description + "]";
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public Project getProjectF() {
		return projectF;
	}

	public void setProjectF(Project projectF) {
		this.projectF = projectF;
	}


	
	
	
}
