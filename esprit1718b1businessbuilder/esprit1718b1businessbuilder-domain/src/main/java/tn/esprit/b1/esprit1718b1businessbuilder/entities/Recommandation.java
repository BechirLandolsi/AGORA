package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_Recommandation")
public class Recommandation  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@EmbeddedId
	private RecommandationPK recommandationPK ; 
	/* Association */ 
	@ManyToOne
	@JoinColumn(name="idcompany1",referencedColumnName="USR_ID",insertable=false,updatable=false)
	private Company company1 ;
	@ManyToOne
	@JoinColumn(name="idcompany2",referencedColumnName="USR_ID",insertable=false,updatable=false)
	private Company company2 ;
	
	/***************/
	
	
	
	public RecommandationPK getRecommandationPK() {
		return recommandationPK;
	}
	public void setRecommandationPK(RecommandationPK recommandationPK) {
		this.recommandationPK = recommandationPK;
	}
	public Company getCompany1() {
		return company1;
	}
	public void setCompany1(Company company1) {
		this.company1 = company1;
	}
	public Company getCompany2() {
		return company2;
	}
	public void setCompany2(Company company2) {
		this.company2 = company2;
	}

	
}
