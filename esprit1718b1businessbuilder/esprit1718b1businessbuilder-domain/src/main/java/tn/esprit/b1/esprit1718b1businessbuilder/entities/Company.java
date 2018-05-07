package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.util.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

public class Company extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public List<Partnership> getCompanyOwner() {
		return CompanyOwner;
	}


	public void setCompanyOwner(List<Partnership> companyOwner) {
		CompanyOwner = companyOwner;
	}


	public List<Reserche> getReserche() {
		return reserche;
	}


	public void setReserche(List<Reserche> reserche) {
		this.reserche = reserche;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	private String CEO ;
	
	@Temporal(TemporalType.DATE)
	private Date creationDate ;
	
	private String adress ;
	
	private Long number ;
	
	private String reference ;
	
	private String partner ; 
	
	private String sector ;
	
	private int rate ; 
	
	private String resultTest ;
	private String image ;
	
	//date d'inscription
	@Temporal(TemporalType.DATE)
	private Date subDate ; 
	
	
	@OneToMany (mappedBy="CompanyOwner")
	private List <Partnership> CompanyOwner;
	
	@OneToMany (mappedBy="CompanyPartner")
	private List <Partnership> CompanyPartner;
	
	@OneToMany (mappedBy="CompanyComment")
	private List <CommentProject> CompanyComment;
	
	
	@OneToMany(mappedBy="companyTender")
	private List <Tender> tenders;
	
	@OneToMany(mappedBy="company")
	private List <TenderApplication> tenderApplications;
	
	@OneToMany (mappedBy="ProjectOwner")
	private List <Project> project;
	
	/************************************************************/
	
	/* Association */
	@ManyToMany
	private List<Service> services ;
	
	@OneToMany(mappedBy="supplier") 
	private List<Produit> produits ;

	@OneToMany(mappedBy="buyer") 
	private List<Order> orders ;  
	
	@OneToMany(mappedBy="claimant") 
	private List<Claim> myClaims ;  
	
	@OneToMany(mappedBy="company") 
	private List<Claim> Recevedclaims ; 
    
 
	@OneToMany(mappedBy = "company1" )
	private List<Recommandation> recommandations1 ; 
	
	@OneToMany(mappedBy = "company2" )
	private List<Recommandation> recommandations2 ; 
	
	
	@OneToMany(mappedBy = "companyR" )
    private List<Reserche> reserche ; 
	

	
	  @OneToMany(mappedBy = "company_organizer" )
      private List<Event> events;
	  
	  @OneToMany(mappedBy = "guest" )
	  private List<Invitation> invitation;

	/***********************/
	
	

	public List<Produit> getProduits() {
		return produits;
	}

	
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Company(String name, String login, String password, String email,String cEO, String adress, long number, String reference,
			
		String sector, int rate, String resultTest, String image) {
		super(name, login, password, email);
		CEO = cEO;
	
		this.adress = adress;
		this.number = number;
		this.reference = reference;
		
		this.sector = sector;
		this.rate = rate;
		this.resultTest = resultTest;
		this.image = image;
	
		
	}


	public List<Recommandation> getRecommandations1() {
		return recommandations1;
	}


	public void setRecommandations1(List<Recommandation> recommandations1) {
		this.recommandations1 = recommandations1;
	}


	public List<Recommandation> getRecommandations2() {
		return recommandations2;
	}


	public void setRecommandations2(List<Recommandation> recommandations2) {
		this.recommandations2 = recommandations2;
	}


	public List<Claim> getMyClaims() {
		return myClaims;
	}

	public void setMyClaims(List<Claim> myClaims) {
		this.myClaims = myClaims;
	}

	public List<Claim> getRecevedclaims() {
		return Recevedclaims;
	}

	public void setRecevedclaims(List<Claim> recevedclaims) {
		Recevedclaims = recevedclaims;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	
	
	public List<Tender> getTenders() {
		return tenders;
	}


	public void setTenders(List<Tender> tenders) {
		this.tenders = tenders;
	}
	

	public List<TenderApplication> getTenderApplications() {
		return tenderApplications;
	}


	public void setTenderApplications(List<TenderApplication> tenderApplications) {
		this.tenderApplications = tenderApplications;
	}


	public String getCEO() {
		return CEO;
	}

	public void setCEO(String cEO) {
		CEO = cEO;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getResultTest() {
		return resultTest;
	}

	public void setResultTest(String resultTest) {
		this.resultTest = resultTest;
	}

	
	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<Partnership> getCompanyPartner() {
		return CompanyPartner;
	}

	public void setCompanyPartner(List<Partnership> companyPartner) {
		CompanyPartner = companyPartner;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}


	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

    
	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Date getSubDate() {
		return subDate;
	}


	public void setSubDate(Date subDate) {
		this.subDate = subDate;
	}

 
	public List<Invitation> getInvitation() {
		return invitation;

	}


	public void setInvitation(List<Invitation> invitation) {
		this.invitation = invitation;
	}
	
	


	public List<CommentProject> getCompanyComment() {
		return CompanyComment;
	}


	public void setCompanyComment(List<CommentProject> companyComment) {
		CompanyComment = companyComment;
	}


	@Override
	public String toString() {

		return "Company [CEO=" + CEO + ", adress=" + adress + ", sector=" + sector + ", toString()=" + super.toString()
				+ "]";
	}    public void stream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
}
