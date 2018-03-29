package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;
@Remote
public interface EventServiceRemote {

	public void addEvent(Event E); 
	public void removeEvent(Event E); 
	public void editEvent(Event E); 
	public Event findEvent(int id);
	public List<Event> findAllEvent(); 
}
