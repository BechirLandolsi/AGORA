package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Bilan;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;

@Remote
public interface ProjectRemote {

	public void addProject(Project P,Bilan b); 
	
	public List<Project> getAllProject(); 
	
	public List<Project> getProjectsByCompany(Long companyId);
	
	public List <Long> countProjectsByCompanyName(Company c);

	public void Edit(Project p, double quality, int count);
	
	public long CountStableProjects();
	
	public long CountUnstableProjects();
	
	public List<Project> getRateByCompany(Company c);
	


	
	
	
}
