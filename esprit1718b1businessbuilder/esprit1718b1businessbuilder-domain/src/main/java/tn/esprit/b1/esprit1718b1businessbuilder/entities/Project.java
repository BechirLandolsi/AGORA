package tn.esprit.b1.esprit1718b1businessbuilder.entities;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	
	
	public Project() {
		super();
	}



	public Project(Long id, List<Partnership> partnerships, Company projectOwner, String name, String service,
			String projectNature, Integer stock, float priceUnit, float purchase, float energyCost, float transportCost,
			float employeeSalaire, float interestOnLoans, float rentCost) {
		super();
		this.id = id;
		this.partnerships = partnerships;
		ProjectOwner = projectOwner;
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



	@Override
	public String toString() {
		return "Project [id=" + id + ", partnerships=" + partnerships + ", ProjectOwner=" + ProjectOwner + ", name="
				+ name + ", service=" + service + ", projectNature=" + projectNature + ", stock=" + stock
				+ ", priceUnit=" + priceUnit + ", purchase=" + purchase + ", energyCost=" + energyCost
				+ ", transportCost=" + transportCost + ", employeeSalaire=" + employeeSalaire + ", interestOnLoans="
				+ interestOnLoans + ", rentCost=" + rentCost + "]";
	}


	

}
