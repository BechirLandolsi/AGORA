package tn.esprit.b1.esprit1718b1businessbuilder.services;

import javax.ejb.Stateless;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderCategory;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.GenericDAO;

@Stateless
public class TenderCategoryService extends GenericDAO<TenderCategory> implements ITenderCategory {

	public TenderCategoryService( ) {
		super(TenderCategory.class);
	}

	@Override
	public TenderCategory find(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
