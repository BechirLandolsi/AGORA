package tn.esprit.b1.esprit1718b1businessbuilder.entities;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tab_project")
public class Project implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProjectId")
	private Long id;
	
	@Column(name = "service")
	private String service;
	
	@OneToMany (mappedBy="project")
	private List <Partnership> partnerships;
	
	@ManyToOne
	private Company ProjectOwner;
	
	
	public Project() {
		super();
	}


	public Project(Long id, String service, List<Partnership> partnerships, Company projectOwner) {
		super();
		this.id = id;
		this.service = service;
		this.partnerships = partnerships;
		ProjectOwner = projectOwner;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getService() {
		return service;
	}


	public void setService(String service) {
		this.service = service;
	}


	public List<Partnership> getPartnerships() {
		return partnerships;
	}


	public void setPartnerships(List<Partnership> partnerships) {
		this.partnerships = partnerships;
	}


	public Company getProjectOwner() {
		return ProjectOwner;
	}


	public void setProjectOwner(Company projectOwner) {
		ProjectOwner = projectOwner;
	}

	

	

	

}
