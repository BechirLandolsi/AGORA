package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contrat implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ContratPK contratPK ; 
	
	private Integer quantity ;
	
	@Temporal(TemporalType.DATE)
	private Date date_contrat ;
	
	/* Association */ 
	@OneToMany(mappedBy="contrat") 
	private List<Provision> provisions ;
	
	@ManyToOne
	@JoinColumn(name="idProduct",referencedColumnName="id",insertable=false,updatable=false)
	private Produit produit ; 
	
	
	@ManyToOne
	@JoinColumn(name="idCompany",referencedColumnName="USR_ID",insertable=false,updatable=false)
	private Company company ;
	
	/***************/
	
	public ContratPK getContratPK() {
		return contratPK;
	}
	public void setContratPK(ContratPK contratPK) {
		this.contratPK = contratPK;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Date getDate_contrat() {
		return date_contrat;
	}
	public void setDate_contrat(Date date_contrat) {
		this.date_contrat = date_contrat;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contrat(ContratPK contratPK, Integer quantity, Date date_contrat) {
		super();
		this.contratPK = contratPK;
		this.quantity = quantity;
		this.date_contrat = date_contrat;
	}
	@Override
	public String toString() {
		return "Contrat [contratPK=" + contratPK + ", quantity=" + quantity + ", date_contrat=" + date_contrat + "]";
	} 
	
	

}
