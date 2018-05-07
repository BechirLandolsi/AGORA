package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Bilan;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;

@Remote
public interface BilanRemote {

	public void addBilan(Bilan b ,long idP ) ;
		
	public void deleteBilan(Bilan b);
	
	public List<Bilan> findBilan(long id);
	
	
}