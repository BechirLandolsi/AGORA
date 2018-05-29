package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.text.ParseException;

import javax.ejb.Remote;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Tender;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderApplication;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.IGenericDAO;

@Remote
public interface ITenderApplication extends IGenericDAO<TenderApplication> {
	
	public void apply(User user, Tender tender) throws ParseException;
	public Long applicationNumber(Tender tender);
	public Float applicationNmbrProgress (Tender tender);
	public Float applicationNmbrRate(Tender tender);
	public Float applicationNmbrProjects(Tender tender);
}
