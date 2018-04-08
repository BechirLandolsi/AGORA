package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Remote;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Reserche;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Tender;
@Remote
public interface CompanyServiceRemote extends UserServiceRemote {
	
		public void add(Company c);
	    public List<Company> findAllCompany() ; 
	    public List<String> findAllCompanyNames() ;
		public Company findAllCompanyByName(String name); 	
		public Company findBy(long id) ;
		public void AddCompanyReserche(Reserche r,  Company c );
		public List<Company> findAllCompanyByService(String service) ;
		public List <String> FindBySector(String sector);
		public List<Company> findCompanyBySector2(String sector) ;
		public List <String> FindBySectorButCompany(Long companyId, String sector);
		public List <String> getAllSectors();
		
		
}

	
	
	



