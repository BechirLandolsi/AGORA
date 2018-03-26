package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;

@Remote
public interface ProjectRemote {

	public void addProject(Project P); 
	
	public List<Project> getAllProject(); 
	
	public List<Project> getProjectsByCompany(int companyId);
	
	
	
}
