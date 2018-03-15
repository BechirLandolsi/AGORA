package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Service;

@Remote
public interface ServiceServiceRemote {
	
	public void ajouterService(Service service);
	public void editService (Service service) ;
	public void removeService (int id) ;
	public Service findService (int id) ;
	public List<Service> getAllService();
	public void affecterServiceACompany(int companyId, int serviceId);
}
