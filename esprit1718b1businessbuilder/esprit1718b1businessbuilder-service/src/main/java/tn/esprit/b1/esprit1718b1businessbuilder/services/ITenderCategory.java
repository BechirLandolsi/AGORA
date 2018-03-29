package tn.esprit.b1.esprit1718b1businessbuilder.services;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderCategory;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.IGenericDAO;

@Remote
public interface ITenderCategory extends IGenericDAO<TenderCategory> {

}
