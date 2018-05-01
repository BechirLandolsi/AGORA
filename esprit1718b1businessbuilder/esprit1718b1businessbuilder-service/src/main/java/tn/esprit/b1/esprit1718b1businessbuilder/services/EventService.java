package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Invitation;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.InvitationPK;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.GenericDAO;

@Stateless
public class EventService extends GenericDAO<Event> implements EventServiceRemote{
	
	public EventService() {
		super(Event.class);
	}

	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ; 

	
////***************************** Get Events of a Company ************************
	@Override
	public List<Event> findEventByCompany(long companyId) {
		 TypedQuery <Event> ev = em.createQuery("select e from Event e where e.company_organizer.id="+companyId+"AND e.event_state="+false,Event.class);
			List<Event> eventlist = ev.getResultList();
			return eventlist;
	}
////****************************** Get all the companies sectors **************************
	@Override
	public List<String> DisplaySector() {
		TypedQuery<String> q =  em.createQuery("select DISTINCT c.sector from Company c",String.class) ;
		List<String> allsectors = q.getResultList() ;
		return allsectors;
	}
//new JFS
////******************************* remind the user of the upcoming event before two days of its date *****************
	@Override
	public List<Event> EventReminder(List<Event> eventlist) {
		List<Event> eventsoon = new ArrayList<Event>();
		long DayInMillisecond=60*60*1000*24;
		Date d1 = new Date(); //Date d'aujourd'hui
		long nbDaysSecondDate=d1.getTime()/DayInMillisecond;
		long difference;
		
		for(Event ev : eventlist)
		{
		Date a = ev.getEvent_date();
		long nbDaysFirstDate=a.getTime()/DayInMillisecond;
		difference= nbDaysSecondDate-nbDaysFirstDate;
		if(difference<2 && difference>0){eventsoon.add(ev);}
		}
		return eventsoon;	
	}

///New JSF
////******************************* remind the user of the upcoming event before days of its date  selon le choix de l'utilisateur*****************
	@Override
	public List<Event> EventReminderSelonChoix(List<Event> eventlist ,int choix) {
		List<Event> eventsoon = new ArrayList<Event>();
		long DayInMillisecond=60*60*1000*24;
		Date d1 = new Date(); //Date d'aujourd'hui
		long nbDaysSecondDate=d1.getTime()/DayInMillisecond;
		long difference;
		
		for(Event ev : eventlist)
		{
		Date a = ev.getEvent_date();
		long nbDaysFirstDate=a.getTime()/DayInMillisecond;
		difference= nbDaysSecondDate-nbDaysFirstDate;
		if(difference<choix && difference>0){eventsoon.add(ev);}
		}
		return eventsoon;	
	}
////************************** Find Events By its Name  ************************************
	@Override
	public List<Event> findEventByName(String name) {
		List<Event> event = new ArrayList<Event>();
		TypedQuery<Event> query = em.createQuery("SELECT e FROM Event e WHERE e.event_name = :event_name", Event.class);
		event=query.setParameter("event_name" , name).getResultList();
		return event;
			
	}
	
////*************************** Find Events By its Date ************************************

	@Override
	public List<Event> findEventByDate(Date date) {
		List<Event> event = new ArrayList<Event>();
		TypedQuery<Event> query = em.createQuery("SELECT e FROM Event e WHERE e.event_date = :event_date", Event.class);
		event=query.setParameter("event_date" , date).getResultList();
		return event;
		}
	@Override
	public void AffectAnEventToCompany(Event e, Company c) {
		List<Event> event = new ArrayList<Event>();
		event=c.getEvents();
		if(e!=null){
		event.add(e);
		c.setEvents(event);
		}
	}
	
////*************************** Display all the archived events ************************************
	//the time the event'date passed the event will be archived and not deleted so the 
	//user can display the past events he organized 
	@Override
	public List<Event> DisplayArchivedEvents(Event e) {
		List<Event> event = new ArrayList<Event>();
		TypedQuery<Event> query = em.createQuery("SELECT e FROM Event e WHERE e.event_state="+true, Event.class);
		event=query.getResultList();
		return event;	
	}
	
	
////******************************************Upcoming events ************************************	
	@Override
	public List<Event> UpComingEvents() {
		List<Event> upcomingonly = new ArrayList<Event>();
		TypedQuery<Event> query = em.createQuery("SELECT e FROM Event e WHERE e.event_state="+false, Event.class);
		upcomingonly=query.getResultList();
		return upcomingonly;	
		
	}
	
////******************************************Archive an old event by changing state ************************************	
	@Override
	public void ArchiveAnEvent(List<Event> e) {

    	///get the system date
		java.util.Date da = new java.util.Date(); 
		
		for(Event event : e ){
			Date a = event.getEvent_date();
			if(a.after(da)){
			 event.setEvent_state(true);	
			}
		}
	}
	//**************************************************************************************************
	@Override
	public List<Company> FindCompanyToInvite(long idCompany) {
		TypedQuery<Company> q =  em.createQuery("select c from Company c  where c.id !="+idCompany,Company.class) ;
		List<Company> companies = q.getResultList() ;
	
		
	return companies;
	}
	//*******************************************************************************************************
	
	//********************************************************************************************************
	@Override
	public Event FindEventType(String type) {
		Event e = new Event();
		e=null;
		TypedQuery<Event> query = em.createQuery("SELECT e FROM Event e WHERE e.event_type=:type", Event.class);
		query.setParameter("type",type);
		try{
		e=query.getSingleResult();
		}
		catch (NoResultException nre ){
			e=null;	
	}	
		
		return e;
	}
	
}
