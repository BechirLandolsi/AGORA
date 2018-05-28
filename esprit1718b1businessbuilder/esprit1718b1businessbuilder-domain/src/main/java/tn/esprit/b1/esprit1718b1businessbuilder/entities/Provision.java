package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * <b><Provision> est la classe representant une provision d'un produit se basant sur un contrat 
 * <p> une provision est caractérisé par :
 * <ul>
 * <li> un identifiant unique  </li>
 * <li> date provision </li>
 * <li> etat de livraison </li>
 * <li> etat de packaging</li>
 * <li> etat de paiment</li>
 * <li> le contrat associé</li>
 * </ul>
 * </p>
 * @see ProvisionService
 * 
 * @author Nour
 * 
 */

@Entity
@Table(name="provisions")
public class Provision implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * l'ID unique de la provision 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
	private Integer id ; 
	
	/**
	 * la date de la provision
	 */
	
	@Temporal(TemporalType.DATE)
	private Date date_provision ;
	
	/**
	 * l'etat de la provision
	 */
	@Column(name="delivery")
	private StateType delivState ; 
	
	/**
	 * l'etat de paiement
	 */
	@Column(name="invoicement")
	private StateType invoState ; 
	
	/**
	 * l'etat de packaging
	 */
	@Column(name="packaging")
	private StateType packState ; 
	
	/**
	 * l'etat sous form d'enum
	 * @author Nour
	 *
	 */
	public enum StateType {
		delivered , inProgress , toBeDone , paied , done
	} 
	
	/**
	 * association entre provision et contrat
	 */
	@ManyToOne
	private Contrat contrat ;

	/**
	 * 
	 * @return l'id de provision
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * mettre à jour l'id
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 
	 * @return date de la provision
	 */
	public Date getDate_provision() {
		return date_provision;
	}

	/**
	 * mettre à jour la date de provision
	 * @param date_provision
	 */
	public void setDate_provision(Date date_provision) {
		this.date_provision = date_provision;
	}
	
	/**
	 * 
	 * @return l'etat de livraison
	 */

	public StateType getDelivState() {
		return delivState;
	}

	/**
	 * mettre à jour l'etat de la livraison une fois livrée
	 * @param delivState
	 */
	public void setDelivState(StateType delivState) {
		this.delivState = delivState;
	}
	
	/**
	 * 
	 * @return l'etat de paiment 
	 */

	public StateType getInvoState() {
		return invoState;
	}

	/**
	 * mettre à jour l'etat de paiment
	 * @param invoState
	 */
	
	public void setInvoState(StateType invoState) {
		this.invoState = invoState;
	}

	/**
	 * 
	 * @return l'etat de packaging
	 */
	public StateType getPackState() {
		return packState;
	}

	/**
	 * mettre à jour l'etat de packaging
	 * @param packState
	 */
	public void setPackState(StateType packState) {
		this.packState = packState;
	}


    /**
     *  
     * @return contrat
     */
	public Contrat getContrat() {
		return contrat;
	}

	/**
	 * mettre à jour le contrat
	 * @param contrat
	 */
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	/**
	 * constructeur d'une provision caractérisée par :
	 * @param id
	 * @param date_provision
	 * @param delivState
	 * @param invoState
	 * @param packState
	 */
	public Provision(Integer id, Date date_provision, StateType delivState, StateType invoState, StateType packState) {
		super();
		this.id = id;
		this.date_provision = date_provision;
		this.delivState = delivState;
		this.invoState = invoState;
		this.packState = packState;
	}

	public Provision() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Provision [id=" + id + ", date_provision=" + date_provision + ", delivState=" + delivState
				+ ", invoState=" + invoState + ", packState=" + packState + "]";
	}
	
	
	

}
