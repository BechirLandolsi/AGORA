package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.IGenericDAO;
@Remote
public interface EventServiceRemote extends IGenericDAO<Event> {

    public void deleteev(long idevent);
	public List<Event> findEventByCompany(long companyId);
	public List<Event> findEventByName(String name);
	public List<Event> findEventByDate(Date date);
	public List<Event> EventReminder(List<Event> eventlist);
	public List<String>DisplaySector();
	public void AffectAnEventToCompany(Event e , Company c);
	public List<Event> DisplayArchivedEvents(Event e);
	public List<Event> UpComingEvents();
	public void ArchiveAnEvent(List<Event> e);
	public List<Company> FindCompanyToInvite(long idCompany);
	public Event FindEventType(String type);
	public List<Event> EventReminderSelonChoix(List<Event> eventlist ,int choix);
	
	
}
