package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;

@Stateless
public class EventService implements EventServiceRemote{
	
	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ; 

	@Override
	public void addEvent(Event E) {
		em.persist(E);
	}

	@Override
	public void removeEvent(long id) {
	em.remove(em.find(Event.class,id));
	}

	@Override
	public void editEvent(Event E) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Event findEvent(long id) {
		Event e= em.find(Event.class, id);
		return e ;
	}

	@Override
	public List<Event> findAllEvent() {
		TypedQuery<Event> e =  em.createQuery("select e from Event e ",Event.class) ;
		 List<Event> events = e.getResultList() ;
		 return events;
	}

	@Override
	public List<Event> findEventByCompany(long companyId) {
		 TypedQuery <Event> ev = em.createQuery("select e from Event e where e.company_organizer.id="+companyId,Event.class);
			List<Event> eventlist = ev.getResultList();
			return eventlist;
		

	}

	@Override
	public List<String> DisplaySector() {
	
		return null;
	}

}
