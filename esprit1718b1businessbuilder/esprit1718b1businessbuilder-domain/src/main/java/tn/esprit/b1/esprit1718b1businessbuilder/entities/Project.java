package tn.esprit.b1.esprit1718b1businessbuilder.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "tab_project")
public class Project implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProjectId")
	private Long id;
	
	@OneToMany (mappedBy="project")
	private List <Partnership> partnerships;
	
	@OneToMany (mappedBy="projectComment")
	private List <CommentProject> commentProjects ;
	
	@ManyToOne
	private Company ProjectOwner;
	
	@OneToOne(mappedBy="project")
	private Bilan bilan;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "service")
	private String service;
	
	@Column(name = "projectNature")
	private String projectNature;
	
	@Column(name = "stock")
	private Integer stock;
	
	@Column(name = "priceUnit")
	private float priceUnit;
	
	@Column(name = "purchase")
	private float purchase;
	
	@Column(name = "energyCost")
	private float energyCost;

	@Column(name = "transportCost")
	private float transportCost;
	
	@Column(name = "employeeSalaire")
	private float employeeSalaire;
	
	@Column(name = "interestOnLoans")
	private float interestOnLoans;
	
	@Column(name = "rentCost")
	private float rentCost;
	
	@Column(name = "capital")
	private float capital;
	
	@Column(name = "state")
	private boolean state;
	
	@Column(name = "quality")
	private double quality;
	
	@Column(name = "count")
	private int count;
	
	@Temporal(TemporalType.DATE)
	private Date creationDate ;
	
	@Temporal(TemporalType.DATE)
	private Date finishDate;
	
	@Column(name = "product")
	private String product;
	
	@Column(name = "nbrTache")
	private Integer nbrTache;
	
	@Column(name = "nbrEmployee")
	private Integer nbrEmployee;
	
	
	public Project() {
		super();
		
		this.count=0;
		this.quality=0.0;
		
	}


	

	



	public Project(Long id, List<Partnership> partnerships, List<CommentProject> commentProjects, Company projectOwner,
			Bilan bilan, String name, String service, String projectNature, Integer stock, float priceUnit,
			float purchase, float energyCost, float transportCost, float employeeSalaire, float interestOnLoans,
			float rentCost, float capital, boolean state, double quality, int count, Date creationDate, Date finishDate,
			String product, Integer nbrTache, Integer nbrEmployee) {
		super();
		this.id = id;
		this.partnerships = partnerships;
		this.commentProjects = commentProjects;
		ProjectOwner = projectOwner;
		this.bilan = bilan;
		this.name = name;
		this.service = service;
		this.projectNature = projectNature;
		this.stock = stock;
		this.priceUnit = priceUnit;
		this.purchase = purchase;
		this.energyCost = energyCost;
		this.transportCost = transportCost;
		this.employeeSalaire = employeeSalaire;
		this.interestOnLoans = interestOnLoans;
		this.rentCost = rentCost;
		this.capital = capital;
		this.state = state;
		this.quality = quality;
		this.count = count;
		this.creationDate = creationDate;
		this.finishDate = finishDate;
		this.product = product;
		this.nbrTache = nbrTache;
		this.nbrEmployee = nbrEmployee;
	}

	public Project(Company projectOwner, String name, String service) {
		super();
		ProjectOwner = projectOwner;
		this.name = name;
		this.service = service;
	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Partnership> getPartnerships() {
		return partnerships;
	}

	public void setPartnerships(List<Partnership> partnerships) {
		this.partnerships = partnerships;
	}

	public Company getProjectOwner() {
		return ProjectOwner;
	}

	public void setProjectOwner(Company projectOwner) {
		ProjectOwner = projectOwner;
	}

	public Bilan getBilan() {
		return bilan;
	}

	public void setBilan(Bilan bilan) {
		this.bilan = bilan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getProjectNature() {
		return projectNature;
	}

	public void setProjectNature(String projectNature) {
		this.projectNature = projectNature;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public float getPriceUnit() {
		return priceUnit;
	}

	public void setPriceUnit(float priceUnit) {
		this.priceUnit = priceUnit;
	}

	public float getPurchase() {
		return purchase;
	}

	public void setPurchase(float purchase) {
		this.purchase = purchase;
	}

	public float getEnergyCost() {
		return energyCost;
	}

	public void setEnergyCost(float energyCost) {
		this.energyCost = energyCost;
	}

	public float getTransportCost() {
		return transportCost;
	}

	public void setTransportCost(float transportCost) {
		this.transportCost = transportCost;
	}

	public float getEmployeeSalaire() {
		return employeeSalaire;
	}

	public void setEmployeeSalaire(float employeeSalaire) {
		this.employeeSalaire = employeeSalaire;
	}

	public float getInterestOnLoans() {
		return interestOnLoans;
	}

	public void setInterestOnLoans(float interestOnLoans) {
		this.interestOnLoans = interestOnLoans;
	}

	public float getRentCost() {
		return rentCost;
	}

	public void setRentCost(float rentCost) {
		this.rentCost = rentCost;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public double getQuality() {
		return quality;
	}

	public void setQuality(double quality) {
		this.quality = quality;
	}
	
		

	public float getCapital() {
		return capital;
	}

	public void setCapital(float capital) {
		this.capital = capital;
	}

	
	
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}

	
	

	public String getProduct() {
		return product;
	}




	public void setProduct(String product) {
		this.product = product;
	}


	

	public List<CommentProject> getCommentProjects() {
		return commentProjects;
	}




	public void setCommentProjects(List<CommentProject> commentProjects) {
		this.commentProjects = commentProjects;
	}


	


	public Date getCreationDate() {
		return creationDate;
	}




	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}




	public Date getFinishDate() {
		return finishDate;
	}




	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}




	public Integer getNbrTache() {
		return nbrTache;
	}




	public void setNbrTache(Integer nbrTache) {
		this.nbrTache = nbrTache;
	}


	

	public Integer getNbrEmployee() {
		return nbrEmployee;
	}


	public void setNbrEmployee(Integer nbrEmployee) {
		this.nbrEmployee = nbrEmployee;
	}



	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", service=" + service + ", projectNature=" + projectNature + ", stock="
				+ stock + ", priceUnit=" + priceUnit + ", purchase=" + purchase + ", energyCost=" + energyCost
				+ ", transportCost=" + transportCost + ", employeeSalaire=" + employeeSalaire + ", interestOnLoans="
				+ interestOnLoans + ", rentCost=" + rentCost + ", capital=" + capital + ", state=" + state
				+ ", quality=" + quality + ", count=" + count + ", product=" + product + "]";
	}




	



	
	
}
