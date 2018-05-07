package tn.esprit.b1.esprit1718b1businessbuilder.mBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.EventService;


@ManagedBean
@SessionScoped
public class EventBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id_event;
	private String event_name;
	private String event_adress;
	private String event_sector;
	private String event_type;
	private boolean event_profitable;
	private int invitation_number;
	private String participant_number;
	private boolean event_state;
	private boolean event_privacy;
	private Date event_date;
	private List<Event> events;
	private List<String> sectors;
	
	@EJB
	EventService eventService;
	CompanyService companyService;

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

	public String getEvent_sector() {
		return event_sector;
	}

	public void setEvent_sector(String event_sector) {
		this.event_sector = event_sector;
	}

	public String getEvent_type() {
		return event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}

	public boolean isEvent_profitable() {
		return event_profitable;
	}

	public void setEvent_profitable(boolean event_profitable) {
		this.event_profitable = event_profitable;
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

	public boolean isEvent_privacy() {
		return event_privacy;
	}

	public void setEvent_privacy(boolean event_privacy) {
		this.event_privacy = event_privacy;
	}

	public Date getEvent_date() {
		return event_date;
	}

	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}
	

	public List<Event> getEvents() {
		events= eventService.findEventByCompany((long)8);
		System.out.println(events);
		return events;
	}
	
	public void deleteanevent(Long eventid){
		eventService.deleteev(eventid);
		System.out.println("removed");
	}
	
	
	public void ajouterevent()
	{
		Event e =new Event(event_name, event_adress, event_sector, event_type, event_profitable, event_privacy, event_date);
		eventService.save(e);
		System.out.println("added");
	}
	
	public List<String> Sectors(){
	 sectors=eventService.DisplaySector();
	 System.out.println(sectors);
	 return sectors;
	}
	
	
	public String navigation(){
		String navigateTo="null";
		navigateTo = "/Details?faces-redirect=true";
		System.out.println("nav");
		return navigateTo;
	}
	
	public  List<Event> AfficherEvents(long id){
		events= eventService.findEventByCompany(8);
		System.out.println(events);
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	
}
