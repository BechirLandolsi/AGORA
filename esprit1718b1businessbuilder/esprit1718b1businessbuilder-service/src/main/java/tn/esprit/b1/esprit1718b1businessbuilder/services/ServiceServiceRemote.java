package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Service;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;

@Remote
public interface ServiceServiceRemote {
	
	public void ajouterService(Service service);
	public void editService (Service service) ;
	public void removeService (int id) ;
	public Service findService (int id) ;
	public List<String> getAllService();
	public List<String> getByName(String name) ;
	public void affecterServiceACompany(long companyId, long serviceId);
	public void ajouterCompany(User user) ;
	public List <String> ResercheListe (long id) ;
}
