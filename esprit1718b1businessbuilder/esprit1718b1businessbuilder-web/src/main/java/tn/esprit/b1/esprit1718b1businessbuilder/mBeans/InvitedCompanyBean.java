package tn.esprit.b1.esprit1718b1businessbuilder.mBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.services.EventService;

@ManagedBean
@SessionScoped
public class InvitedCompanyBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Company> companies;
	private String name ;
	private String sector ;
	private String adress ;
	private String CEO ;

	@ManagedProperty(value="#{identity}")
	private Identity loginBean;
	
	
	public Identity getLoginBean() {
		return loginBean;
	}
	public void setLoginBean(Identity loginBean) {
		this.loginBean = loginBean;
	}
	public List<Company> getCompanies() {
		return companies;
	}
	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCEO() {
		return CEO;
	}
	public void setCEO(String cEO) {
		CEO = cEO;
	}
	@EJB
	EventService eventService;
	public List<Company> companiesToInvite(long id){
		companies=eventService.FindCompanyToInvite(loginBean.getUser().getId()); 
		System.out.println(companies);
		return companies;
	}
}
