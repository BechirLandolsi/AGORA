package tn.esprit.b1.esprit1718b1businessbuilder.services;

import javax.ejb.Stateless;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderApplication;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.GenericDAO;

@Stateless
public class TenderApplicationService extends GenericDAO<TenderApplication> implements ITenderApplication {

	public TenderApplicationService() {
		super(TenderApplication.class);
		
	}

}
