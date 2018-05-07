package tn.esprit.b1.esprit1718b1businessbuilder.mBeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote;

import org.primefaces.model.chart.ChartSeries;
 
@ManagedBean
public class ChartView implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModel;
    
    @EJB
    ProjectRemote projectService ;
 
    @PostConstruct
    public void init() {
        createBarModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }
 
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
 
      
 
        model.addSeries(boys);
      
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
        createHorizontalBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Bar Chart");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Gender");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
     
    private void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Projects");
        
    /*    for (Object[] o : projectService.getProjectsPerCompanyBySector(c)){
			 System.out.println(o[0]);
			 System.out.println(o[1]);
		 }*/
        boys.set("2004", 50);
        boys.set("2005", 96);
        boys.set("2006", 44);
        boys.set("2007", 55);
        boys.set("2008", 25);
 
       
 
        horizontalBarModel.addSeries(boys);
      
         
        horizontalBarModel.setTitle("Horizontal and Stacked");
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setStacked(true);
         
        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setLabel("Number of Projects");
        xAxis.setMin(0);
        xAxis.setMax(200);
         
        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel("Service");        
    }
 
}
