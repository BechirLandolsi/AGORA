package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;
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
		 TypedQuery <Event> ev = em.createQuery("select e from Event e where e.company_organizer.id="+companyId+"AND e.event_state="+true,Event.class);
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

////******************************* remind the user of the upcoming event before two days of its date *****************
	@Override
	public List<Event> EventReminder(List<Event> eventlist) {
		List<Event> eventsoon = new ArrayList<Event>();
		String format = "dd/MM/yy H:mm:ss"; 
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
		java.util.Date da = new java.util.Date(); 
		Calendar c1 = Calendar.getInstance();
	    c1.setTime(da);
	    int today=c1.get(Calendar.DAY_OF_YEAR);
	    int thisyear = c1.get(Calendar.YEAR);
	    
		for (Event event : eventlist) {
	    Date a = event.getEvent_date();
	    Calendar c = Calendar.getInstance();
	    c.setTime(a);
	    int dayOfyear = c.get(Calendar.DAY_OF_YEAR);
	    int year =c.get(Calendar.YEAR);
	    if((year==thisyear)&&(today-dayOfyear==2)){
	    eventsoon.add(event);System.out.println(event);
	    
	    }
		}
		/*for (Event event : eventlist){
			System.out.println(event);
		}*/
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
	

////******************************************Archive an event ************************************	
	@Override
	public void ArchiveAnEvent(Event e) {
		e.setEvent_state(true);
	}

	

}
