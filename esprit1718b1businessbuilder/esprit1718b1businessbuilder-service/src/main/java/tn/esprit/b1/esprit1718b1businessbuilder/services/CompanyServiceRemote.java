package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Remote;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Reserche;
@Remote
public interface CompanyServiceRemote {
	

	    public List<Company> findAllCompany() ; 
	    public List<String> findAllCompanyNames() ;
		public Company findAllCompanyByName(String name); 	
		public Company findBy(long id) ;
		public void AddCompanyReserche(Reserche r,  Company c );
		public List<Company> findAllCompanyByService(String service) ;
}

	
	



