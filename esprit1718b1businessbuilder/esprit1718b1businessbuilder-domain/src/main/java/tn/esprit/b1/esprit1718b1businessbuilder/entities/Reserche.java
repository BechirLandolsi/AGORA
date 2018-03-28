package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_Reserche")
public class Reserche  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	@ManyToOne
	Company companyR ;
	
	String reserche ;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Company getCompanyR() {
		return companyR;
	}
	public void setCompanyR(Company companyR) {
		this.companyR = companyR;
	}
	public String getReserche() {
		return reserche;
	}
	public void setReserche(String reserche) {
		this.reserche = reserche;
	}
	public Reserche(Company companyR, String reserche) {
		this.companyR = companyR;
		this.reserche = reserche;
	}
	public Reserche() {
	}
	
	
}
