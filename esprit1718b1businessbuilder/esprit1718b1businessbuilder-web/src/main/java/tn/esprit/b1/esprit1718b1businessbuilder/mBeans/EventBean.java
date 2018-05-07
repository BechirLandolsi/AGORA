package tn.esprit.b1.esprit1718b1businessbuilder.mBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Invitation;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.EventService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.InvitationService;


@ManagedBean
@SessionScoped
public class EventBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id_event;
	private Long idcompany;
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
	private Date today_date;
	private List<Event> events;
	private List<String> sectors;
	private List<Invitation> invitations;
	private long nombre;
	private long guests;
	private long refused;
	
	@ManagedProperty(value="#{identity}")
	private Identity loginBean;
	
	@EJB
	EventService eventService;
	@EJB
	CompanyService companyService;

@EJB
	InvitationService invitationService;

	
	public Long getIdcompany() {
		return idcompany;
	}

	public Date getToday_date() {
		today_date=new Date();
		return today_date;
	}

	public void setToday_date(Date today_date) {
		this.today_date = today_date;
	}

	public void setIdcompany(Long idcompany) {
		this.idcompany = idcompany;
	}


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
	

	public long getGuests() {
		return guests;
	}

	public void setGuests(long guests) {
		this.guests = guests;
	}

	public long getRefused() {
		return refused;
	}

	public void setRefused(long refused) {
		this.refused = refused;
	}

	public Identity getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(Identity loginBean) {
		this.loginBean = loginBean;
	}

	public List<Event> getEvents() {
		Company c =new Company();
		c=(Company)loginBean.getUser();
		events= eventService.findEventByCompany(c.getId());
		System.out.println(events);
		return events;
	}
	
	public void deleteanevent(Long eventid){
		eventService.deleteev(eventid);
		System.out.println("removed");
	}
	
	
	public void ajouterevent()
	{
		Company c = (Company)loginBean.getUser();
		
		Event e =new Event(event_name, event_adress, event_sector, event_type, event_profitable, event_privacy, event_date);
		e.setCompany_organizer(c);
		eventService.save(e);
		System.out.println("added");
	}
	
	public List<String> Sectors(){
	 sectors=eventService.DisplaySector();
	 System.out.println(sectors);
	 return sectors;
	}
	
	
	
	public String navigation(long id){
		String navigateTo="null";
		navigateTo = "/Details?faces-redirect=true";
		this.id_event=id;
		System.out.println(this.id_event);

		return navigateTo;
	}
	
	public Long NumberInvitation(Event e){
		Event e1 = new Event();
		e1=eventService.find(this.id_event);
		nombre=invitationService.countnumberinvitation(e1);
		return nombre  ;
	}
	
	public Long NumberGuest(){
		Event e = new Event();
		e=eventService.find(this.id_event);
		guests=invitationService.countnumberguest(e);
		return guests;
	}
	
	public void inviteCompany(long id){
		idcompany=id;
		System.out.println(id_event);
		System.out.println(idcompany);
		invitationService.InviteCompanyToAnEvent(idcompany,id_event);	
	}
	
	public List<String> getSectors() {
		return sectors;
	}

	public void setSectors(List<String> sectors) {
		this.sectors = sectors;
	}

	public List<Invitation> getInvitations() {
		return invitations;
	}

	public void setInvitations(List<Invitation> invitations) {
		this.invitations = invitations;
	}

	public long getNombre() {
		return nombre;
	}

	public void setNombre(long nombre) {
		this.nombre = nombre;
	}

	public List<Invitation> DisplayMyInvitation(){
		invitations=invitationService.DisplayInvitationByCompany((Company)loginBean.getUser());
		return invitations;
	}
	
	
	public  List<Event> AfficherEvents(long id){
		Company c =new Company();
		c=(Company)loginBean.getUser();
		events= eventService.findEventByCompany(c.getId());
		System.out.println(events);
		return events;
		
		
	
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	
}
