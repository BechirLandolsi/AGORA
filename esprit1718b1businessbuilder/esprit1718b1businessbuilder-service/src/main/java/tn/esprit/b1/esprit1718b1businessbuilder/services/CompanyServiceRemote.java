package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Remote;
import javax.persistence.EntityManager;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
@Remote
public interface CompanyServiceRemote {
	
	public List<Company> findAllCompany() ; 
	 public List<String> findAllCompanyNames() ;
		public Company findAllCompanyByName(String name); 
}
