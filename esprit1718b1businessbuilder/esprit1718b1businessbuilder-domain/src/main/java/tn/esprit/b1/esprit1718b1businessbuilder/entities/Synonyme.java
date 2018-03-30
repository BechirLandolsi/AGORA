package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tab_synonyme")
public class Synonyme implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	
	private String service;
	private String synonyme1;
	private String synonyme2;
	private String synonyme3;
	private String synonyme4;
	private String synonyme5;
	@OneToOne(mappedBy ="synonyme")
    private Service services ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getSynonyme1() {
		return synonyme1;
	}
	public void setSynonyme1(String synonyme1) {
		this.synonyme1 = synonyme1;
	}
	public String getSynonyme2() {
		return synonyme2;
	}
	public void setSynonyme2(String synonyme2) {
		this.synonyme2 = synonyme2;
	}
	public String getSynonyme3() {
		return synonyme3;
	}
	public void setSynonyme3(String synonyme3) {
		this.synonyme3 = synonyme3;
	}
	public String getSynonyme4() {
		return synonyme4;
	}
	public void setSynonyme4(String synonyme4) {
		this.synonyme4 = synonyme4;
	}
	public String getSynonyme5() {
		return synonyme5;
	}
	public void setSynonyme5(String synonyme5) {
		this.synonyme5 = synonyme5;
	}
	public Service getServices() {
		return services;
	}
	public void setServices(Service services) {
		this.services = services;
	}

	
	
	
	
	
}
