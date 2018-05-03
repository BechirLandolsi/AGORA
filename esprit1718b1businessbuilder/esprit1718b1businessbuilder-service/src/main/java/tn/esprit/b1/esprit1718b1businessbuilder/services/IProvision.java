package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.Date;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Contrat;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;

@Remote
public interface IProvision {

	public void addContrat(Company cmp, Produit p , int q)  ; 
	public void provideProduct(); 
	
}
