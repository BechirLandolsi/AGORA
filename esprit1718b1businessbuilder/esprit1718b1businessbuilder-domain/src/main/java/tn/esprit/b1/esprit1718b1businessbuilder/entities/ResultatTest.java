package tn.esprit.b1.esprit1718b1businessbuilder.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_test")
public class ResultatTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RSLT_ID")
	private Long Id;
	
	@Column(name = "RSLT_APTITUDE")
	private Float AptitudeTestResult;
	
	@Column(name = "RSLT_DETERMINATION")
	private Float DeterminationTestResult;
	
	@Column(name="RSLT_FInal")
	private Float FinalResult;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Float getAptitudeTestResult() {
		return AptitudeTestResult;
	}

	public void setAptitudeTestResult(Float aptitudeTestResult) {
		AptitudeTestResult = aptitudeTestResult;
	}

	public Float getDeterminationTestResult() {
		return DeterminationTestResult;
	}

	public void setDeterminationTestResult(Float determinationTestResult) {
		DeterminationTestResult = determinationTestResult;
	}

	public Float getFinalResult() {
		return FinalResult;
	}

	public void setFinalResult(Float finalResult) {
		FinalResult = finalResult;
	}

	public ResultatTest() {
		super();
	}

	public ResultatTest(Float aptitudeTestResult, Float determinationTestResult, Float finalResult) {
		super();
		AptitudeTestResult = aptitudeTestResult;
		DeterminationTestResult = determinationTestResult;
		FinalResult = finalResult;
	}
	
	
	
	
}
