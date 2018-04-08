package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;
@Remote
public interface EventServiceRemote {

	public void addEvent(Event E); 
	public void removeEvent(long id); 
	public void editEvent(Event E); 
	public Event findEvent(long id);
	public List<Event> findEventByCompany(long companyId);
	public List<Event> findAllEvent(); 
	public List<String> DisplaySector();
	//public void inviteCompany(); 
	//public void inviteCompanyBySector(String Sector);
}
