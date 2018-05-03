package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="provisions")
public class Provision implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private Integer id ; 
	
	@Temporal(TemporalType.DATE)
	private Date date_provision ;
	
	@Column(name="delivery")
	private StateType delivState ; 
	
	@Column(name="invoicement")
	private StateType invoState ; 
	
	@Column(name="packaging")
	private StateType packState ; 
	
	public enum StateType {
		delivered , inProgress , toBeDone , paied , done
	} 
	
	@ManyToOne
	private Contrat contrat ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate_provision() {
		return date_provision;
	}

	public void setDate_provision(Date date_provision) {
		this.date_provision = date_provision;
	}

	public StateType getDelivState() {
		return delivState;
	}

	public void setDelivState(StateType delivState) {
		this.delivState = delivState;
	}

	public StateType getInvoState() {
		return invoState;
	}

	public void setInvoState(StateType invoState) {
		this.invoState = invoState;
	}

	public StateType getPackState() {
		return packState;
	}

	public void setPackState(StateType packState) {
		this.packState = packState;
	}



	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public Provision(Integer id, Date date_provision, StateType delivState, StateType invoState, StateType packState) {
		super();
		this.id = id;
		this.date_provision = date_provision;
		this.delivState = delivState;
		this.invoState = invoState;
		this.packState = packState;
	}

	public Provision() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
