package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tab_order")
public class Order implements Serializable {
	
	@Id
	@Column(name = "id")
	private Long id; 
	
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
	
	@OneToMany(mappedBy="order")
	private List<OrderLine> orderLines ; 
	
	/****************/

	//getter and setters 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	

	public Company getBuyer() {
		return buyer;
	}

	public void setBuyer(Company buyer) {
		this.buyer = buyer;
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
	
	
	
	
	
	

}
