package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tab_Company")
public class Company extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String CEO ;
	
	@Temporal(TemporalType.DATE)
	private Date creationDate ;
	
	private String adress ;
	
	private Long number ;
	
	private String reference ;
	
	private String partner ; 
	
	private String sector ;
	
	private int rate ; 
	
	private String resultTest ;
	
	private String Services ;
	
	/* Association */
	
	@OneToMany(mappedBy="supplier") 
	private List<Produit> produits ;

	@OneToMany(mappedBy="buyer") 
	private List<Order> orders ;  
    
	/***********************/
	
	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	

	
	
	public String getCEO() {
		return CEO;
	}

	public void setCEO(String cEO) {
		CEO = cEO;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getResultTest() {
		return resultTest;
	}

	public void setResultTest(String resultTest) {
		this.resultTest = resultTest;
	}

	public String getServices() {
		return Services;
	}

	public void setServices(String services) {
		Services = services;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	

}
