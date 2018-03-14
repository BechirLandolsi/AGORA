package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tab_order")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private int id; 
	
	@Column(name = "O_date")
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	
	@Column(name = "state")
	private Boolean state;
	
	@Column(name = "amount")
	private Float amount;

	/* Association */
	@ManyToOne 
	private Company buyer ; 
	
	@OneToMany(mappedBy = "ord" )
	private List<OrderLine> orderLines ; 
	
	/****************/

	//getter and setters 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}
	

	
	

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public Order(Date orderDate, Boolean state, Float amount) {
		super();
		this.orderDate = orderDate;
		this.state = state;
		this.amount = amount;
	}

	public Order() {
		
	}

	public Company getBuyer() {
		return buyer;
	}

	public void setBuyer(Company buyer) {
		this.buyer = buyer;
	}
	
	
	
	
	
	

}
