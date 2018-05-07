package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Contrat;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Provision;

@Remote
public interface IProvision {

	public void addContrat(Company cmp, Produit p , int q)  ; 
	public void provideProduct(Contrat c);
	public Contrat findContrat(Integer idC, Integer idP);
	public Provision findProvision(Integer id);
	public Integer provisionTBD(Company c);
	public Integer provisionTBP(Company c);
	public Float provisionTBI(Company c);
	public Integer quantityInhand(Company c);
	public Integer quantityToRecieve(Company c);
	
	public void verifyStock(); 
	public List<Provision> getProvisionTBD(Company c);
	public List<Provision> getProvisionTBP(Company c);
	void updateDelivery(Integer id);
	void updatePackaging(Integer id);
	List<Object[]> salesPerCompany(Company c);
	List<Object[]> productSales(Company c);
	List<Contrat> provisionByCompany(Company c);
	
	String updateStock(Company c1);
	
	
	
}
