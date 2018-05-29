package tn.esprit.b1.esprit1718b1businessbuilder.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

	@Override
	public Long applicationNumber(Tender tender) {
		
		TypedQuery<Long> k= em.createQuery("select Count(ta) from TenderApplication ta inner join ta.tender t where ta.tender=:tender",Long.class);
		k.setParameter("tender", tender);	
		 return k.getSingleResult() ;
	}

	@Override
	public Float applicationNmbrProgress(Tender tender) {
		
		TypedQuery<Long> k= em.createQuery("select Count(ta) from TenderApplication ta inner join ta.company c where c.progress >=80 AND ta.tender=:tender",Long.class);
		k.setParameter("tender", tender);
		
		if(applicationNumber(tender)==0){
			return (float)0;
		}
		
		return (float) ((k.getSingleResult()*100)/(applicationNumber(tender)));
	}

	@Override
	public Float applicationNmbrRate(Tender tender) {

		TypedQuery<Long> k= em.createQuery("select Count(ta) from TenderApplication ta inner join ta.company c where c.rate >=4 AND ta.tender=:tender",Long.class);
		k.setParameter("tender", tender);
		
		if(applicationNumber(tender)==0){
			return (float)0;
		}
		
		return (float) ((k.getSingleResult()*100)/(applicationNumber(tender)));
	}

	@Override
	public Float applicationNmbrProjects (Tender tender) {
		
		TypedQuery<Long> k= em.createQuery("select Count(ta) from TenderApplication ta inner join ta.company c where c.nbrprojects >=8 AND ta.tender=:tender",Long.class);
		k.setParameter("tender", tender);
		
		if(applicationNumber(tender)==0){
			return (float)0;
		}
		
		return (float) ((k.getSingleResult()*100)/(applicationNumber(tender)));
	}

}
