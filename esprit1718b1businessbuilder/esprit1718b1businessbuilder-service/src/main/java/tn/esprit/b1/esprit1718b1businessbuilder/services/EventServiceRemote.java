package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.IGenericDAO;
@Remote
public interface EventServiceRemote extends IGenericDAO<Event> {


	public List<Event> findEventByCompany(long companyId);
	public List<String> DisplaySector();
	//public void inviteCompany(); 
	//public void inviteCompanyBySector(String Sector);
}
