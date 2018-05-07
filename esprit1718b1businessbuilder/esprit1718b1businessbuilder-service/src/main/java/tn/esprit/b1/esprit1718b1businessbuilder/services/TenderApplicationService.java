package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Tender;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderApplication;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderApplicationPK;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.GenericDAO;

@Stateless
@LocalBean
public class TenderApplicationService extends GenericDAO<TenderApplication> implements ITenderApplication {

	@PersistenceContext
	private EntityManager em;
	
	public TenderApplicationService() {
		super(TenderApplication.class);
		
	}

	@Override
	public TenderApplication find(Long i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void apply(User user, Tender tender) throws ParseException {
		TenderApplication application = new TenderApplication();
		TenderApplicationPK applicationPK = new TenderApplicationPK();
		applicationPK.setCompanyId(user.getId());
		applicationPK.setTenderId(tender.getId());
		application.setTenderApplicationPK(applicationPK);
		Date applicationDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date()));
		application.setApplicationDate(applicationDate);
		
		em.persist(application);
		
	}

}
