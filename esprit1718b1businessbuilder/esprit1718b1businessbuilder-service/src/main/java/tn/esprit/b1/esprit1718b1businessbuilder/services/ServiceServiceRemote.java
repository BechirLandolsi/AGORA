package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Service;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;

@Remote
public interface ServiceServiceRemote {
	
	public long ajouterService(Service service);
	public void editService (Service service) ;
	public void removeService (long id) ;
	public Service findService (long id) ;
	public List<String> getAllService();
	public List<String> getByName(String name) ;
	public void affecterServiceACompany(long companyId, long serviceId);


	public List <String> ResercheListe (long id) ;

	public List <String> getName();
	public List<Produit> findProductByCompany(Company c);
	public List<Company> findCompanyBysynonyme(String r) ;
}
