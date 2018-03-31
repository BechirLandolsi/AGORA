package tn.esprit.b1.esprit1718b1businessbuilder.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tab_Event")
public class Event implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "EVENT_ID")
	private Long id_event;
	
	@Column(name = "EVENT_NAME")
	private String event_name;
	
	@Column(name = "EVENT_ADDRESS")
	private String event_adress;
	
	@Column(name = "EVENT_SECTOR")
	private String event_sector;
	
	@Column(name = "EVENT_PROFITABLE")
	private Boolean event_profitable;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "EVENT_DATE")
	private Date event_date;
	
	
	/*Associations*/
	@ManyToOne
	@JoinColumn(name="idCompany",referencedColumnName="USR_ID",insertable=false,updatable=false)
	private Company company_organizer ;
	
	
	/* Getters And Setters*/

	public Long getId_event() {
		return id_event;
	}

	public void setId_event(Long id_event) {
		this.id_event = id_event;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getEvent_adress() {
		return event_adress;
	}

	public void setEvent_adress(String event_adress) {
		this.event_adress = event_adress;
	}

	public Date getEvent_date() {
		return event_date;
	}

	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}

	public String getEvent_sector() {
		return event_sector;
	}

	public void setEvent_sector(String event_sector) {
		this.event_sector = event_sector;
	}

	public Boolean getEvent_profitable() {
		return event_profitable;
	}

	public void setEvent_profitable(Boolean event_profitable) {
		this.event_profitable = event_profitable;
	}
 
	public Company getCompany_organizer() {
		return company_organizer;
	}

	public void setCompany_organizer(Company company_organizer) {
		this.company_organizer = company_organizer;
	}
	

	/* constructors */
	
	

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Event(String event_name, String event_adress, String event_sector, Boolean event_profitable,
			Date event_date) {
		super();
		this.event_name = event_name;
		this.event_adress = event_adress;
		this.event_sector = event_sector;
		this.event_profitable = event_profitable;
		this.event_date = event_date;
	}

	
	@Override
	public String toString() {
		return "Event [event_name=" + event_name + ", event_adress=" + event_adress + ", event_sector=" + event_sector
				+ ", event_profitable=" + event_profitable + ", event_date=" + event_date + "]";
	}

}
