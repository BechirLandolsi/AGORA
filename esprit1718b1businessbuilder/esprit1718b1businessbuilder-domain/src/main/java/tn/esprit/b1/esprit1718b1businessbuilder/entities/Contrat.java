package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <b><Contrat> est la classe representant un contrat entre deux companies 
 * <p> un contrat est caractérisé par :
 * <ul>
 * <li> un identifiant unique composé d'une company qui cherche une provision et un produit à 
 * fournir par une autre company </li>
 * <li> une quantité à fournir</li>
 * <li> un stock </li>
 * <li>une liste de provision fournit par ce contrat </li>
 * </ul>
 * </p>
 * @see ProvisionService
 * 
 * @author Nour
 * 
 */
@Entity
public class Contrat implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * L'id du contrat. composé de deux clées étrangeres 
	 * celui de la company et celui du produit
	 */
	
	@EmbeddedId
	private ContratPK contratPK ; 
	
	/**
	 * quantité du produit que la company souhaite avoir suite à ce contrat de provision
	 */
	private Integer quantity ;
	/**
	 * date du contrat
	 */
	@Temporal(TemporalType.DATE)
	private Date date_contrat ;
	
	/**
	 * stock à surveiller dés qu'il s'annule , une provision e lance automatiquement
	 */
	@Column(unique=false, nullable=true)
	private Integer stock ;
	
	/**
	 *  Association many to many entre : 
	 *  Provision et Contrat
	 */ 
	@OneToMany(mappedBy="contrat") 
	private List<Provision> provisions ;
	
	/**
	 *  Association many to many entre : 
	 *  <ul>
	 *  <li> company souhaitant être fournit</li>
	 *  <li> produit à fournir</li>
	 *  </ul>
	 */ 
	
	@ManyToOne
	@JoinColumn(name="idProduct",referencedColumnName="id",insertable=false,updatable=false)
	private Produit produit ; 
	
	
	@ManyToOne
	@JoinColumn(name="idCompany",referencedColumnName="USR_ID",insertable=false,updatable=false)
	private Company company ;
	
	/***************/
	
	/**
	 * 
	 * @return l'identifiant du contrat
	 */
	public ContratPK getContratPK() {
		return contratPK;
	}
	/**
	 * 
	 * @return stock du produit
	 */
	public Integer getStock() {
		return stock;
	}
	/**
	 * mettre à jour le stock
	 * @param stock : le nouveau stock
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	/**
	 * 
	 * @return la liste de provisions assurées par ce contrat 
	 */
	public List<Provision> getProvisions() {
		return provisions;
	}
	/**
	 * mettre à jour la liste des provisions
	 * @param provisions
	 */
	
	public void setProvisions(List<Provision> provisions) {
		this.provisions = provisions;
	}
	/**
	 * mettre à jour l'ID du contrat
	 * @param contratPK
	 */
	
	public void setContratPK(ContratPK contratPK) {
		this.contratPK = contratPK;
	}
	
	/**
	 * 
	 * @return la quantité du contrat
	 */
	public Integer getQuantity() {
		return quantity;
	}
	
	/** 
	 * mettre à jour l quantité
	 * @param quantity
	 */
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * 
	 * @return la date du contrat
	 */
	public Date getDate_contrat() {
		return date_contrat;
	}
	
	/**
	 * mettre à jour le contrat
	 * @param date_contrat
	 */
	public void setDate_contrat(Date date_contrat) {
		this.date_contrat = date_contrat;
	}
	
	/**
	 * 
	 * @return le produit à fournir du contrat 
	 */
	public Produit getProduit() {
		return produit;
	}
	
	/**
	 * mettre à jour le produit
	 * @param produit
	 */
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	/**
	 * 
	 * @return la company du contrat
	 */
	
	public Company getCompany() {
		return company;
	}
	
	/**
	 * mettre à jour la company
	 * @param company
	 */
	public void setCompany(Company company) {
		this.company = company;
	}
	
	/**
	 * constructeur de contrat 
	 * 
	 */
	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * constructeur d'un contrat caractérisé par : 
	 * <ul>
	 * <li> l'ID composé du contrat</li>
	 * <li> la quantité </li>
	 * <li> la date du contrat</li>
	 * </ul>
	 * @param contratPK
	 * @param quantity
	 * @param date_contrat
	 */
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
