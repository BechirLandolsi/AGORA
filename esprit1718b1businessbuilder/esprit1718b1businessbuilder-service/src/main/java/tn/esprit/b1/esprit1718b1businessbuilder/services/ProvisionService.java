package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Contrat;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.ContratPK;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;

@Stateless
@LocalBean

public class ProvisionService implements IProvision {

	@PersistenceContext(unitName="sample-project-ejb")
	EntityManager em ;

	@Override
	public void addContrat(Company cmp, Produit p , int q) {
		Contrat c = new Contrat(); 
		ContratPK cpk = new ContratPK() ; 
		cpk.setIdCompany((int)cmp.getId());
		cpk.setIdProduct(p.getId());
		c.setContratPK(cpk); 
		c.setCompany(cmp);
		c.setProduit(p);
		c.setQuantity(q);
		Date current = new Date() ; 
		c.setDate_contrat(current);
		
		em.persist(c);	
	}

	@Override
	public void provideProduct() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
