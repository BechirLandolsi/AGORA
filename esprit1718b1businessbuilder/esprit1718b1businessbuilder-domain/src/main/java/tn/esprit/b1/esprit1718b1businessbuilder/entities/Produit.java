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
@Table(name="produits")
public class Produit implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private int id; 
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "stock")
	private Long stock;
	
	@Column(name = "path")
	private String path;
	
	@Column(name = "cost")
	private Float cout;
	
	@Column(name = "price")
	private Float price;
	
	@Column(name = "deliveryD")   //Delai delivery
	private Long deliveryD;
	
	/*  association  */
	@ManyToOne
	private Company supplier ; 
	
	@OneToMany(mappedBy = "prod" )
	private List<OrderLine> orderLines ; 
	
	/*********************/
	
//Getter and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Float getCout() {
		return cout;
	}

	public void setCout(Float cout) {
		this.cout = cout;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Long getDeliveryD() {
		return deliveryD;
	}

	public void setDeliveryD(Long deliveryD) {
		this.deliveryD = deliveryD;
	}
	
	
	
	

	public Company getSupplier() {
		return supplier;
	}

	public void setSupplier(Company supplier) {
		this.supplier = supplier;
	}
	
	

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public Produit() {
		super();
	}

	public Produit(String description, Long stock, String path, Float cout, Float price, Long deliveryD) {
		super();
		this.description = description;
		this.stock = stock;
		this.path = path;
		this.cout = cout;
		this.price = price;
		this.deliveryD = deliveryD;
	}
	
	
	
	

}
