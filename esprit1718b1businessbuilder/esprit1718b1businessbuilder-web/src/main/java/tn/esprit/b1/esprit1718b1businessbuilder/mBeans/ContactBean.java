package tn.esprit.b1.esprit1718b1businessbuilder.mBeans;

import java.util.List;
import java.util.Objects;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Contact;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote;

@ManagedBean
@SessionScoped
public class ContactBean {
	
	private List <Company> contacts ;
	private Company company ;
	
	private Contact cont ;
	public static int nbrProjectsPerCompany ;
	public static int nbrOrdersPerCompany ;
	
	public long numberofprojects ;
	public long profileVisitis;
	
	public long ord ;
	public long getOrd() {
		return ord;
	}

	public void setOrd(long ord) {
		this.ord = ord;
	}

	public long getProfileVisitis() {
		return profileVisitis;
	}

	public void setProfileVisitis(long profileVisitis) {
		this.profileVisitis = profileVisitis;
	}

	private String sector;
	private User loggedCompany;
	
	@ManagedProperty(value="#{identity}")
	private Identity loginBean;
	
	
	public User getLoggedCompany() {
		return loggedCompany;
	}

	public void setLoggedCompany(User loggedCompany) {
		this.loggedCompany = loggedCompany;
	}

	public Contact getCont() {
		return cont;
	}

	public void setCont(Contact cont) {
		this.cont = cont;
	}

	public static int getNbrProjectsPerCompany() {
		return nbrProjectsPerCompany;
	}

	public static void setNbrProjectsPerCompany(int nbrProjectsPerCompany) {
		ContactBean.nbrProjectsPerCompany = nbrProjectsPerCompany;
	}

	public static int getNbrOrdersPerCompany() {
		return nbrOrdersPerCompany;
	}

	public static void setNbrOrdersPerCompany(int nbrOrdersPerCompany) {
		ContactBean.nbrOrdersPerCompany = nbrOrdersPerCompany;
	}

	public long getNumberofprojects() {
		return numberofprojects;
	}

	public void setNumberofprojects(long numberofprojects) {
		this.numberofprojects = numberofprojects;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public ProjectRemote getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectRemote projectService) {
		this.projectService = projectService;
	}

	public OrderServiceRemote getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderServiceRemote orderService) {
		this.orderService = orderService;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@EJB
	CompanyServiceRemote CompanyService ;
	
	@EJB
	ProjectRemote projectService ;
	
	@EJB 
	OrderServiceRemote orderService ;
	

	public List<Company> Listcontact()
	{
		loggedCompany= loginBean.getUser(); 
		return contacts = CompanyService.getContactsByCompany(  loggedCompany.getId());
	}
	
	public Identity getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(Identity loginBean) {
		this.loginBean = loginBean;
	}

	public List<Object[]> listProjectsBySector(){
		loggedCompany= loginBean.getUser(); 
		return projectService.getProjectsPerCompanyBySector((Company) loggedCompany );
		
	}
	
	
	
	public void addtoContacts(Company c){
		loggedCompany= loginBean.getUser(); 
		Contact c1 = new Contact ();
		CompanyService.addContact(c1,(Company) loggedCompany , c);
		
	}
	
	
	
	public String ViewProfile(Company c){
		
		String navigateTo="";
		navigateTo="/Profile?faces-redirect=true";
		CompanyService.incrementVisiteProfile(c);
		CompanyService.countnbrs(c);
		CompanyService.ActivityRate(c);
		System.out.println("nbr projects per Company"+CompanyService.nbProjectByCompany(c) );
		
		numberofprojects=CompanyService.nbProjectByCompany(c);
		ord=orderService.findAllOrder(c).size();
		//profileVisitis=profileVisitis+1;
		//System.out.println("nbr company : "+CompanyService.nbrcompanyperService("Sport"));
		System.out.println("nbr orders per company " +orderService.findAllOrder(c).size());
		
		 for (Object[] o : projectService.getProjectsPerCompanyBySector(c)){
			// numberofprojects= (long) o[0];
			 //sector=(String) o[1];
			 System.out.println(o[0]);
			 System.out.println(o[1]);
		 }

		this.setCompany(c);
		System.out.println(c);
		return navigateTo ;
	}
	
	
	public void incrementFollewers(Company c){
		//System.out.println();
		Company c2 = CompanyService.findBy((long)2) ;
		//System.out.println(identity.getUser().getId());
		CompanyService.incrementnbrFlowwersFollowings(c,c2);
	}
	

	public List<Company> getContacts() {
		return contacts;
	}

	public void setContacts(List<Company> contacts) {
		this.contacts = contacts;
	}

	public CompanyServiceRemote getCompanyService() {
		return CompanyService;
	}

	public void setCompanyService(CompanyServiceRemote companyService) {
		CompanyService = companyService;
	}

}
