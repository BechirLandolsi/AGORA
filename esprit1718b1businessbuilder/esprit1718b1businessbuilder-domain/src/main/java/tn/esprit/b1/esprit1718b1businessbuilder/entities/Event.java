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
@Table(name = "tab_Event")
public class Event implements Serializable {

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "Event [event_name=" + event_name + ", event_adress=" + event_adress + ", event_date=" + event_date
				+ "]";
	}


	public Event(String event_name, String event_adress, Date event_date) {
		super();
		this.event_name = event_name;
		this.event_adress = event_adress;
		this.event_date = event_date;
	}


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
	
	@Temporal(TemporalType.DATE)
	@Column(name = "EVENT_DATE")
	private Date event_date;

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


	
	

}
