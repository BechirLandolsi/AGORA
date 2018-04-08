package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.util.List;

import javax.ejb.Remote;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Tender;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderCategory;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderQualification;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.IGenericDAO;

@Remote
public interface ITender extends IGenericDAO<Tender> {
	public void saveTender (Tender tender);
	public long add(Tender tender);
	public List <Tender> findByCategory(TenderCategory tc);
	public void affectTenderToCompanyCategory(Tender tender, User loggedUsery, TenderCategory tc);
	public void affectTenderToQualification(Tender tender, TenderQualification qualification);
}
