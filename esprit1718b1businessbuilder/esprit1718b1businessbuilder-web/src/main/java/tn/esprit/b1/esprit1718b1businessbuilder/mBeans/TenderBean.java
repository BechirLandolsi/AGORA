package tn.esprit.b1.esprit1718b1businessbuilder.mBeans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.bean.ViewScoped;

import org.ocpsoft.prettytime.PrettyTime;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Tender;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderApplication;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderCategory;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.TenderApplicationService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.TenderCategoryService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.TenderService;

/**
 * Java class represented a managed bean for the entity tender
 * 
 * @author Beshir
 *
 */

@ManagedBean
@ViewScoped
public class TenderBean {
	
	
	@EJB
	private TenderService tenderService;
	
	@EJB
	private TenderCategoryService tenderCategoryService;
	
	private List<Tender> tenders;
	
	private String prettyTime;
	
	private List<TenderCategory> categories;
	
	private Tender tender; 
	
	private User loggedCompany;
	
	private TenderCategory category;
	
	private String categoryName;
	
	@ManagedProperty(value="#{identity}")
	private Identity loginBean;
	
	@EJB
	private CompanyService cs;
	
	@EJB
	private TenderApplicationService tenderApplicationService;
	
	private TenderApplication application;
	
	private List <Tender> myTenders;
	
	
	
	/**
	 * It defines the new instance of the entities.
	 */
	@PostConstruct
	private void init() {
		tender=new Tender();
		category = new TenderCategory();
		loggedCompany = new User();
		application= new TenderApplication();
	}
	
	public Tender getTender() {
		return tender;
	}

	public void setTender(Tender tender) {
		this.tender = tender;
	}

	
	/**
	 * It returns all the list of categories in the DB
	 * @return
	 */
	public List<TenderCategory> getCategories() {
		
		categories= tenderCategoryService.findAll();
		return categories;
	}

	public void setCategories(List<TenderCategory> categories) {
		this.categories = categories;
	}

	/**
	 * It defines the time passed from the date of the post
	 * @param tender
	 * @return
	 */
	public String getPrettyTime(Tender tender) {
		PrettyTime p =new PrettyTime();
		prettyTime= p.format(tender.getPublishedDate());
		return prettyTime;
	}

	public void setPrettyTime(String prettyTime) {
		this.prettyTime = prettyTime;
	}

	
	/**
	 * it returns the list of the tenders and sorted with java 8
	 * @return
	 */
	public List<Tender> getTenders(){
		
		tenders=tenderService.findAll();
		tenders.sort(Comparator.comparing(Tender::getPublishedDate).reversed());
		
		return tenders;
	}

	public void setTenders(List<Tender> tenders) {
		this.tenders = tenders;
	}
	
	
	public Identity getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(Identity loginBean) {
		this.loginBean = loginBean;
	}

	public User getLoggedCompany() {
		return loggedCompany;
	}

	public void setLoggedCompany(User loggedCompany) {
		this.loggedCompany = loggedCompany;
	}

	public TenderCategory getCategory() {
		return category;
	}

	public void setCategory(TenderCategory category) {
		this.category = category;
	}

	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * It define the method for adding a new tender
	 * @throws ParseException
	 */
	public void ajouter() throws ParseException{
		
				loggedCompany= loginBean.getUser(); 
				Date publishedDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
				tender.setPublishedDate(publishedDate);
				
				category= tenderCategoryService.findByName(categoryName);
				
				tenderService.affectTenderToCompanyCategory(tender, loggedCompany,category);
				tenderService.add(tender);
		
	}
	
	/**
	 * it defines the method to apply in a tender
	 * @param t
	 * @throws ParseException
	 */
	public void apply(Tender t) throws ParseException{
		
		loggedCompany=loginBean.getUser();
		tenderApplicationService.apply(loggedCompany, t);
	}

	/**
	 * it returns all the tenders of the logged User
	 * @return
	 */
	public List<Tender> getMyTenders() {

		loggedCompany=loginBean.getUser();
		myTenders=tenderService.findByCompany(loggedCompany);
		myTenders.sort(Comparator.comparing(Tender::getPublishedDate).reversed());
		return myTenders;
	}

	public void setMyTenders(List<Tender> myTenders) {
		this.myTenders = myTenders;
	}

	public TenderApplication getApplication() {
		return application;
	}

	public void setApplication(TenderApplication application) {
		this.application = application;
	}
	
	public void delete(Tender t){
		tenderService.delete(t);
	}
	
	/**
	 * it returns the numbers of applications in a tender
	 * @param t
	 * @return
	 */
	public Long nbrApplication(Tender t){
		Long nbr;
		nbr=tenderApplicationService.applicationNumber(t);
		System.out.println(nbr);
		return nbr;
	}
	
	
	/**
	 * it returns the number of the companies that has a developed profile in our application
	 * @param t
	 * @return
	 */
	public Float applicationNmbrProgress(Tender t){
		Float nbr;
		nbr=tenderApplicationService.applicationNmbrProgress(t);
		System.out.println(nbr);
		return nbr;
	}
	
	/**
	 * it returns the number of companies that have a good rate
	 * @param t
	 * @return
	 */
	public Float applicationNmbrRate(Tender t){
		Float nbr;
		nbr=tenderApplicationService.applicationNmbrRate(t);
		System.out.println(nbr);
		return nbr;
		
	}
	
	/**
	 * it returns the number of companies that worked on more than 8 projects
	 * @param tender
	 * @return
	 */
	public Float applicationNmbrProjects(Tender tender){
		Float nbr;
		nbr=tenderApplicationService.applicationNmbrProjects(tender);
		System.out.println(nbr);
		return nbr;
	}

}
