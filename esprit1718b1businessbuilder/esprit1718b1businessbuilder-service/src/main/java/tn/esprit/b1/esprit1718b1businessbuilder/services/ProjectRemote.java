package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.Date;
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
	
	public long CountStableProjects(Company c);
	
	public long CountUnstableProjects(Company c);
	
	public List<String> getProjectsNameByCompany(Company c);
	
	public List<Number> getProjectsQualityByCompany(Company c);
	
	public void delete(Project p);
	
	public Project Edit (Project p);
	
	public List<Project> findProjectById(Long id);
	
	public List<Project> searchForProject(String mot,Company c);

	public List <Long> countProjectsPerCompanyBySector(Long CompanyId,String Sector);
	
	public List<Object[]> getProjectsPerCompanyBySector(Company c);
	
	public double AvancementProject(Project p); 
	
	public List<Number> AvancementDesProjetsByCompanyjsf(Long companyid);
	
	public List<String> getProjectsNameByCompanyjsf(Long companyid);
	
	
	
}
