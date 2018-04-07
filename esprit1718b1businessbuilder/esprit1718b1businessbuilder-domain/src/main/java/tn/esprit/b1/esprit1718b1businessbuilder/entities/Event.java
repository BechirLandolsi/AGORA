package tn.esprit.b1.esprit1718b1businessbuilder.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@Column(name = "EVENT_TYPE")
	private String event_type;
	
	@Column(name = "EVENT_PROFITABLE")
	private boolean event_profitable;
	
	@Column(name = "INVITATION_NUMBER")
	private int invitation_number;
	
	@Column(name = "PARTICIPANT_NUMBER")
	private String participant_number;
	
	@Column(name = "EVENT_STATE")
	private boolean event_state;
	
	@Column(name = "EVENT_PRIVACY")
	private boolean event_privacy;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "EVENT_DATE")
	private Date event_date;
	
	
	/*Associations*/
	@ManyToOne
	private Company company_organizer ;
	
	@OneToOne
	private EventDepense Event_Dep;
	
	@OneToMany(mappedBy = "Event" )
    private List<Invitation> invitation;
	
	
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
	
	public String getEvent_type() {
		return event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}

	public int getInvitation_number() {
		return invitation_number;
	}

	public void setInvitation_number(int invitation_number) {
		this.invitation_number = invitation_number;
	}

	public String getParticipant_number() {
		return participant_number;
	}

	public void setParticipant_number(String participant_number) {
		this.participant_number = participant_number;
	}

	public boolean isEvent_state() {
		return event_state;
	}

	public void setEvent_state(boolean event_state) {
		this.event_state = event_state;
	}

	public EventDepense getEvent_Dep() {
		return Event_Dep;
	}

	public void setEvent_Dep(EventDepense event_Dep) {
		Event_Dep = event_Dep;
	}

	public void setEvent_profitable(boolean event_profitable) {
		this.event_profitable = event_profitable;
	}
	

	public List<Invitation> getInvitation() {
		return invitation;
	}

	public void setInvitation(List<Invitation> invitation) {
		this.invitation = invitation;
	}
	
	public boolean isEvent_privacy() {
		return event_privacy;
	}

	public void setEvent_privacy(boolean event_privacy) {
		this.event_privacy = event_privacy;
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
