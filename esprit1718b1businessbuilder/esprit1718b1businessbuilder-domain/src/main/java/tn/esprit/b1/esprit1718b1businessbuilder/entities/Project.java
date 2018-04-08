package tn.esprit.b1.esprit1718b1businessbuilder.entities;
import java.io.Serializable;
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
	
	@Column(name = "product")
	private String product;
	
	public Project() {
		super();
		
		this.count=0;
		this.quality=0.0;
		
	}


	

	public Project(Long id, List<Partnership> partnerships, Company projectOwner, Bilan bilan, String name,
			String service, String projectNature, Integer stock, float priceUnit, float purchase, float energyCost,
			float transportCost, float employeeSalaire, float interestOnLoans, float rentCost, float capital,
			boolean state, double quality, int count, String product) {
		super();
		this.id = id;
		this.partnerships = partnerships;
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
		this.product = product;
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




	@Override
	public String toString() {
		return "Project [id=" + id + ", partnerships=" + partnerships + ", ProjectOwner=" + ProjectOwner + ", bilan="
				+ bilan + ", name=" + name + ", service=" + service + ", projectNature=" + projectNature + ", stock="
				+ stock + ", priceUnit=" + priceUnit + ", purchase=" + purchase + ", energyCost=" + energyCost
				+ ", transportCost=" + transportCost + ", employeeSalaire=" + employeeSalaire + ", interestOnLoans="
				+ interestOnLoans + ", rentCost=" + rentCost + ", capital=" + capital + ", state=" + state
				+ ", quality=" + quality + ", count=" + count + ", product=" + product + "]";
	}




	



	
	
}
