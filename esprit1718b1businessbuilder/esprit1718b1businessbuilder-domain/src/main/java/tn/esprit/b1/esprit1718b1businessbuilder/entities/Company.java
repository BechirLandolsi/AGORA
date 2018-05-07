package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.ws.rs.DefaultValue;

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
	private int nbrprojects = 0;
	private int nbrorders =0 ;
	
	private float activity=(float) 0.0;
	
	public float getActivity() {
		return activity;
	}


	public void setActivity(float activity) {
		this.activity = activity;
	}


	public int getNbrprojects() {
		return nbrprojects;
	}


	public void setNbrprojects(int nbrprojects) {
		this.nbrprojects = nbrprojects;
	}


	public int getNbrorders() {
		return nbrorders;
	}


	public void setNbrorders(int nbrorders) {
		this.nbrorders = nbrorders;
	}


	@Column(nullable=true)
	private int nbrfolowers = 0;
	@Column(nullable=true)

	private int nbrfolowings = 0 ;
	@Column(nullable=true)
	private int visite = 0 ;
	public int getVisite() {
		return visite;
	}


	public void setVisite(int visite) {
		this.visite = visite;
	}


	@Temporal(TemporalType.DATE)
	private Date dateVisite ;
	
	
	
	public Date getDateVisite() {
		return dateVisite;
	}


	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}


	
	


	public int getNbrfolowers() {
		return nbrfolowers;
	}


	public void setNbrfolowers(int nbrfolowers) {
		this.nbrfolowers = nbrfolowers;
	}


	public int getNbrfolowings() {
		return nbrfolowings;
	}


	public void setNbrfolowings(int nbrfolowings) {
		this.nbrfolowings = nbrfolowings;
	}


	//date d'inscription
	@Temporal(TemporalType.DATE)
	private Date subDate ; 
	
	
	@OneToMany (mappedBy="CompanyOwner")
	private List <Partnership> CompanyOwner;
	
	@OneToMany (mappedBy="CompanyPartner")
	private List <Partnership> CompanyPartner;
	
	@OneToMany (mappedBy="Company")
	private List<Contact> Company ;
	
	@OneToMany (mappedBy="CompanyContact")
	private List <Contact> CompanyContact ;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((CEO == null) ? 0 : CEO.hashCode());
		result = prime * result + ((Company == null) ? 0 : Company.hashCode());
		result = prime * result + ((CompanyContact == null) ? 0 : CompanyContact.hashCode());
		result = prime * result + ((CompanyOwner == null) ? 0 : CompanyOwner.hashCode());
		result = prime * result + ((CompanyPartner == null) ? 0 : CompanyPartner.hashCode());
		result = prime * result + ((Recevedclaims == null) ? 0 : Recevedclaims.hashCode());
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((events == null) ? 0 : events.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((invitation == null) ? 0 : invitation.hashCode());
		result = prime * result + ((myClaims == null) ? 0 : myClaims.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		result = prime * result + ((partner == null) ? 0 : partner.hashCode());
		result = prime * result + ((produits == null) ? 0 : produits.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + rate;
		result = prime * result + ((recommandations1 == null) ? 0 : recommandations1.hashCode());
		result = prime * result + ((recommandations2 == null) ? 0 : recommandations2.hashCode());
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		result = prime * result + ((reserche == null) ? 0 : reserche.hashCode());
		result = prime * result + ((resultTest == null) ? 0 : resultTest.hashCode());
		result = prime * result + ((sector == null) ? 0 : sector.hashCode());
		result = prime * result + ((services == null) ? 0 : services.hashCode());
		result = prime * result + ((subDate == null) ? 0 : subDate.hashCode());
		result = prime * result + ((tenderApplications == null) ? 0 : tenderApplications.hashCode());
		result = prime * result + ((tenders == null) ? 0 : tenders.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (CEO == null) {
			if (other.CEO != null)
				return false;
		} else if (!CEO.equals(other.CEO))
			return false;
		if (Company == null) {
			if (other.Company != null)
				return false;
		} else if (!Company.equals(other.Company))
			return false;
		if (CompanyContact == null) {
			if (other.CompanyContact != null)
				return false;
		} else if (!CompanyContact.equals(other.CompanyContact))
			return false;
		if (CompanyOwner == null) {
			if (other.CompanyOwner != null)
				return false;
		} else if (!CompanyOwner.equals(other.CompanyOwner))
			return false;
		if (CompanyPartner == null) {
			if (other.CompanyPartner != null)
				return false;
		} else if (!CompanyPartner.equals(other.CompanyPartner))
			return false;
		if (Recevedclaims == null) {
			if (other.Recevedclaims != null)
				return false;
		} else if (!Recevedclaims.equals(other.Recevedclaims))
			return false;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (events == null) {
			if (other.events != null)
				return false;
		} else if (!events.equals(other.events))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (invitation == null) {
			if (other.invitation != null)
				return false;
		} else if (!invitation.equals(other.invitation))
			return false;
		if (myClaims == null) {
			if (other.myClaims != null)
				return false;
		} else if (!myClaims.equals(other.myClaims))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		if (partner == null) {
			if (other.partner != null)
				return false;
		} else if (!partner.equals(other.partner))
			return false;
		if (produits == null) {
			if (other.produits != null)
				return false;
		} else if (!produits.equals(other.produits))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (rate != other.rate)
			return false;
		if (recommandations1 == null) {
			if (other.recommandations1 != null)
				return false;
		} else if (!recommandations1.equals(other.recommandations1))
			return false;
		if (recommandations2 == null) {
			if (other.recommandations2 != null)
				return false;
		} else if (!recommandations2.equals(other.recommandations2))
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		if (reserche == null) {
			if (other.reserche != null)
				return false;
		} else if (!reserche.equals(other.reserche))
			return false;
		if (resultTest == null) {
			if (other.resultTest != null)
				return false;
		} else if (!resultTest.equals(other.resultTest))
			return false;
		if (sector == null) {
			if (other.sector != null)
				return false;
		} else if (!sector.equals(other.sector))
			return false;
		if (services == null) {
			if (other.services != null)
				return false;
		} else if (!services.equals(other.services))
			return false;
		if (subDate == null) {
			if (other.subDate != null)
				return false;
		} else if (!subDate.equals(other.subDate))
			return false;
		if (tenderApplications == null) {
			if (other.tenderApplications != null)
				return false;
		} else if (!tenderApplications.equals(other.tenderApplications))
			return false;
		if (tenders == null) {
			if (other.tenders != null)
				return false;
		} else if (!tenders.equals(other.tenders))
			return false;
		return true;
	}


	public List<Contact> getCompany() {
		return Company;
	}


	public void setCompany(List<Contact> company) {
		Company = company;
	}


	public List<Contact> getCompanyContact() {
		return CompanyContact;
	}


	public void setCompanyContact(List<Contact> companyContact) {
		CompanyContact = companyContact;
	}


	
	
	
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
	  
	  @OneToMany(mappedBy = "company" )
		private List<Contrat> contrats ; 

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

	

	public List<Contrat> getContrats() {
		return contrats;
	}


	public void setContrats(List<Contrat> contrats) {
		this.contrats = contrats;
	}


	@Override
	public String toString() {

		return "Company [CEO=" + CEO + ", adress=" + adress + ", sector=" + sector + ", toString()=" + super.toString()
				+ "]";
	}    public void stream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
}
