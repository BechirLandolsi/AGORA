package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;

@Stateless
public class EventService implements EventServiceRemote{
	
	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ; 

	@Override
	public void addEvent(Event E) {
		em.persist(E);
		
	}

	@Override
	public void removeEvent(Event E) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editEvent(Event E) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Event findEvent(int id) {
		Event e= em.find(Event.class, id);
		return e ;
	}

	@Override
	public List<Event> findAllEvent() {
		TypedQuery<Event> e =  em.createQuery("select * from Event ",Event.class) ;
		 List<Event> events = e.getResultList() ;
		 return events;
	}

}
