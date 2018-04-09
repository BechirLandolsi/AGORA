package tn.esprit.b1.esprit1718b1businessbuilder.entities;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tab_bilan")
public class Bilan implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BilanId")
	private Long id;
	
	@OneToOne
	private Project project;
	
	@Column(name = "CA")
	private float CA;
	
	@Column(name = "CF")
	private float CF;
		
	@Column(name = "CV")
	private float CV;
	
	@Column(name = "margeSurCoutV")
	private float margeSurCoutV;
	
	@Column(name = "result")
	private float result;
	
	@Column(name = "SR")
	private float SR;

	@Column(name = "PM")
	private float PM;

	@Column(name = "FR")
	private float FR;

	public Bilan() {
		super();
	}

	public Bilan(Long id, Project project, float cA, float cF, float cV, float margeSurCoutV, float result, float sR,
			float pM, float fR) {
		super();
		this.id = id;
		this.project = project;
		CA = cA;
		CF = cF;
		CV = cV;
		this.margeSurCoutV = margeSurCoutV;
		this.result = result;
		SR = sR;
		PM = pM;
		FR = fR;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public float getCA() {
		return CA;
	}

	public void setCA(float cA) {
		CA = cA;
	}

	public float getCF() {
		return CF;
	}

	public void setCF(float cF) {
		CF = cF;
	}

	public float getCV() {
		return CV;
	}

	public void setCV(float cV) {
		CV = cV;
	}

	public float getMargeSurCoutV() {
		return margeSurCoutV;
	}

	public void setMargeSurCoutV(float margeSurCoutV) {
		this.margeSurCoutV = margeSurCoutV;
	}

	public float getResult() {
		return result;
	}

	public void setResult(float result) {
		this.result = result;
	}

	public float getSR() {
		return SR;
	}

	public void setSR(float sR) {
		SR = sR;
	}

	public float getPM() {
		return PM;
	}

	public void setPM(float pM) {
		PM = pM;
	}

	public float getFR() {
		return FR;
	}

	public void setFR(float fR) {
		FR = fR;
	}

	@Override
	public String toString() {
		return "Bilan [id=" + id + ", project=" + project + ", CA=" + CA + ", CF=" + CF + ", CV=" + CV
				+ ", margeSurCoutV=" + margeSurCoutV + ", result=" + result + ", SR=" + SR + ", PM=" + PM + ", FR=" + FR
				+ "]";
	}

	


}




