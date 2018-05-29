package tn.esprit.b1.esprit1718b1businessbuilder.mBeans;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;

import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
 
@ManagedBean
public class stat2 implements Serializable {
 
    private PieChartModel pieModel1;
    private PieChartModel pieModel2;
 
    @EJB
	CompanyServiceRemote CompanyService ;
	
    
    
    public CompanyServiceRemote getCompanyService() {
		return CompanyService;
	}

	public void setCompanyService(CompanyServiceRemote companyService) {
		CompanyService = companyService;
	}

	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}

	public void setPieModel2(PieChartModel pieModel2) {
		this.pieModel2 = pieModel2;
	}

	@PostConstruct
    public void init() {
        createPieModels();
    }
 
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
     
    public PieChartModel getPieModel2() {
        return pieModel2;
    }
     
    private void createPieModels() {
        createPieModel1();
        createPieModel2();
    }
 
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
         
        pieModel1.set("Brand 1", 540);
        pieModel1.set("Brand 2", 325);
        pieModel1.set("Brand 3", 702);
        pieModel1.set("Brand 4", 421);
         
        pieModel1.setTitle("Simple Pie");
        pieModel1.setLegendPosition("w");
    }
     
    private void createPieModel2() {
        pieModel2 = new PieChartModel();

 
        pieModel2.set("Social Activity",    CompanyService.findBy((long)6).getActivity()*0.6 );
        pieModel2.set("Proffesional Activity", CompanyService.findBy((long)6).getActivity()*0.4);
      
         
        pieModel2.setTitle("Custom Pie");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(150);
    }
     
}