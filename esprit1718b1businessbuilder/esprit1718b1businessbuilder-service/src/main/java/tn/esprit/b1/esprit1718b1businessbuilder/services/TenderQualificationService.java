package tn.esprit.b1.esprit1718b1businessbuilder.services;

import javax.ejb.Stateless;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderQualification;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.GenericDAO;

@Stateless
public class TenderQualificationService extends GenericDAO<TenderQualification> implements ITenderQualification {

	public TenderQualificationService() {
		super(TenderQualification.class);
	}

	@Override
	public TenderQualification find(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}
