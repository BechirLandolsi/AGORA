package tn.esprit.b1.esprit1718b1businessbuilder.mBeans;

import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import org.ocpsoft.prettytime.PrettyTime;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Tender;
import tn.esprit.b1.esprit1718b1businessbuilder.services.TenderService;

@ManagedBean
@RequestScoped
public class TenderBean {
	
	//private Tender tender= new Tender();
	
	@EJB
	private TenderService tenderService;
	
	private List<Tender> tenders;
	
	private String prettyTime;
	
	
	
	public String getPrettyTime(Tender tender) {
		PrettyTime p =new PrettyTime();
		prettyTime= p.format(tender.getPublishedDate());
		return prettyTime;
	}

	public void setPrettyTime(String prettyTime) {
		this.prettyTime = prettyTime;
	}

	public List<Tender> getTenders(){
		
		tenders=tenderService.findAll();
		tenders.sort(Comparator.comparing(Tender::getPublishedDate).reversed());
		
		return tenders;
	}

	public void setTenders(List<Tender> tenders) {
		this.tenders = tenders;
	}
	
	
	

}
