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
@Table(name="tab_order")
public class Order implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private Long id; 
	
	@Column(name = "O_date")
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	
	@Column(name = "D_date")
	@Temporal(TemporalType.DATE)
	private Date delivDate;
	
	@Column(name = "amount")
	private Float amount;
	
	
	
	

}
