package tn.esprit.b1.esprit1718b1businessbuilder.services;

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
