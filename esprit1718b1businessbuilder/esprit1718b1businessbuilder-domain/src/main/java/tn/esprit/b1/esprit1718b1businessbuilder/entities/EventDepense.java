package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_Event_Depense")
public class EventDepense implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "EVENTDEPENSE_ID")
	private Long id_depense;
	
	/*Associations*/
	@OneToOne(mappedBy = "Event_Dep")
	private Event event ;
  
	@Column(name = "BUDGET")
	private float budget;
	
	@Column(name = "FOODBEVERAGE")
	private float foodbeverage;
	
	@Column(name = "MARKETING")
	private float marketing;
	
	@Column(name="TECHNIQUEVISUEL")
	private float techniquevisuel;
	
	@Column(name = "COMMUNICATION")
	private float communication;
	
	@Column(name = "ACCOMNDATION")
	private float accomondation;
	
	@Column(name = "PLANB")
	private float planb;
	
	@Column(name = "ENTERTAINMENT")
	private float entertainment;
	
	@Column(name = "TRANSPORT")
	private float transport;
	
	@Column(name = "LOGISTIQUE")
	private float logistique;
	
	@Column(name ="TOTAL")
	private float total;

	
	/* Getters and Setters*/
	public Long getId_depense() {
		return id_depense;
	}

	public void setId_depense(Long id_depense) {
		this.id_depense = id_depense;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}

	public float getFoodbeverage() {
		return foodbeverage;
	}

	public void setFoodbeverage(float foodbeverage) {
		this.foodbeverage = foodbeverage;
	}

	public float getMarketing() {
		return marketing;
	}

	public void setMarketing(float marketing) {
		this.marketing = marketing;
	}

	public float getTechniquevisuel() {
		return techniquevisuel;
	}

	public void setTechniquevisuel(float techniquevisuel) {
		this.techniquevisuel = techniquevisuel;
	}

	public float getCommunication() {
		return communication;
	}

	public void setCommunication(float communication) {
		this.communication = communication;
	}

	public float getAccomondation() {
		return accomondation;
	}

	public void setAccomondation(float accomondation) {
		this.accomondation = accomondation;
	}

	public float getPlanb() {
		return planb;
	}

	public void setPlanb(float planb) {
		this.planb = planb;
	}

	public float getEntertainment() {
		return entertainment;
	}

	public void setEntertainment(float entertainment) {
		this.entertainment = entertainment;
	}

	public float getTransport() {
		return transport;
	}

	public void setTransport(float transport) {
		this.transport = transport;
	}

	public float getLogistique() {
		return logistique;
	}

	public void setLogistique(float logistique) {
		this.logistique = logistique;
	}

	public EventDepense() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EventDepense [event=" + event + ", budget=" + budget + ", foodbeverage=" + foodbeverage + ", marketing="
				+ marketing + ", techniquevisuel=" + techniquevisuel + ", communication=" + communication
				+ ", accomondation=" + accomondation + ", planb=" + planb + ", entertainment=" + entertainment
				+ ", transport=" + transport + ", logistique=" + logistique + "]";
	}
	
	

	
	
	
}
