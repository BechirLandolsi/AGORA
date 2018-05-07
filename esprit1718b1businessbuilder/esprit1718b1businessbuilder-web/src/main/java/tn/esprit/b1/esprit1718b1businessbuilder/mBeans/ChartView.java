package tn.esprit.b1.esprit1718b1businessbuilder.mBeans;


 
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.DonutChartModel;
import org.primefaces.model.chart.LineChartSeries;


import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Contrat;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Order;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Provision;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProvisionService;
 
@ManagedBean
public class ChartView implements Serializable {
 
    /**
	 * 
	 */
	
	@EJB
    private ProvisionService provisionService ;
	
	@ManagedProperty(value = "#{identity}")
	private Identity identity ; 
	
	
	private static final long serialVersionUID = 1L;
	private LineChartModel dateModel;
	private DonutChartModel donutModel1;
	private Double mRevenue ;
	private Double aRevenue ;
	private Double netIncome ; 
	
	private Long maxProduct ; 
	
	 private BarChartModel barModel;
	 
 
    @PostConstruct
    public void init() {
        createDateModel();
        createBarModel();
        createDonutModels();
    }
 
    public DonutChartModel getDonutModel1() {
        return donutModel1;
    }
    
    public LineChartModel getDateModel() {
        return dateModel;
    }
    
    public BarChartModel getBarModel() {
        return barModel;
    }
    

    private void createDonutModels() {
        donutModel1 = initDonutModel();
        
        donutModel1.setLegendPosition("w");
        donutModel1.isMouseoverHighlight();
        
         
        
    }
 
    private DonutChartModel initDonutModel() {
        DonutChartModel model = new DonutChartModel();
         
        Map<String, Number> circle1 = new LinkedHashMap<String, Number>();
        
        List<Contrat> list = provisionService.provisionByCompany((Company)identity.getUser()) ; 
        	for(Contrat o : list){
        		
        		List<Provision> l = o.getProvisions() ;
        		int s =l.size();
        		long q = s * o.getQuantity();
        		 circle1.put(o.getProduit().getDescription().toString(), q);
        	}
        
        model.addCircle(circle1);
         
       
         
        return model;
    }
    
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        	long max = 0;
        	ChartSeries serie1 = new ChartSeries();
        	List<Object[]> list = provisionService.productSales((Company)identity.getUser()) ; 
        
	    	for(Object[] o : list){
		    	 long qt = (long)o[0] ;
           	     Produit produit = (Produit)o[1] ;
        	 	
        	 	  String name = produit.getDescription();
        	 	  double ammount = qt *( produit.getPrice());
		    	  if(qt>max){
		    		  max = qt ; 
		    	  }
		    	
			    serie1.set(name,ammount);
             
         }
        
        
 
        model.addSeries(serie1);
        return model;
    }
    
    private void createBarModel() {
        barModel = initBarModel();
         
        //barModel.setTitle("Bar Chart");
        barModel.setLegendPosition("ne");
        barModel.setAnimate(true);
        barModel.setExtender("chartExtender");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("products");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("sales");
        
    }
     
    private void createDateModel() {
        dateModel = new LineChartModel();
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");
        
        List<Object[]> list = provisionService.productSales((Company)identity.getUser()) ; 
        
	    String PATTERN="yyyy-MM-dd";
		    SimpleDateFormat dateFormat=new SimpleDateFormat();
		    dateFormat.applyPattern(PATTERN);
		    String today =dateFormat.format(Calendar.getInstance().getTime());
		    int moisNow = Integer.parseInt((today.toString().substring(5,7)));
		  
         for(Object[] o : list){
        	 long qt = (long)o[0] ;
           	 
        	 	Produit produit = (Produit)o[1] ;
        	 	Order order = (Order)o[2] ;
        	 	Date date = order.getOrderDate() ;
 	    	double ammount = qt *( produit.getPrice());
		    	
		    	String date1=dateFormat.format(date.getTime());
			   
			    int mois = Integer.parseInt((date1.toString().substring(5,7)));
			    if(mois == moisNow){
		    	
			    	series1.set(date.toString(),ammount);
             
		    	}
         }
        
 
        dateModel.addSeries(series1);
       //dateModel.setSeriesColors("#23c6c8");
        dateModel.setTitle(Month.of(moisNow) +"'s  "+ "Sales ");
        dateModel.setZoom(true);
        dateModel.setAnimate(true);
        dateModel.getAxis(AxisType.Y).setLabel("sales");
        dateModel.setExtender("chartExtender");
        DateAxis axis = new DateAxis("Dates");
       
       axis.setTickAngle(-50);
        
       axis.setTickFormat("%b %#d, %y");
         
        dateModel.getAxes().put(AxisType.X, axis);
    }

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public Double getmRevenue() {
		Double revenu = (double) 0 ;
			List<Object[]> list = provisionService.productSales((Company)identity.getUser()) ; 
        
	    String PATTERN="yyyy-MM-dd";
		    SimpleDateFormat dateFormat=new SimpleDateFormat();
		    dateFormat.applyPattern(PATTERN);
		    String today =dateFormat.format(Calendar.getInstance().getTime());
		    int moisNow = Integer.parseInt((today.toString().substring(5,7)));
		  
         for(Object[] o : list){
        	 long qt = (long)o[0] ;
           	 
        	 	Produit produit = (Produit)o[1] ;
        	 	Order order = (Order)o[2] ;
        	 	Date date = order.getOrderDate() ;
 	    	double ammount = qt *( produit.getPrice());
		    	
		    	String date1=dateFormat.format(date.getTime());
			   
			    int mois = Integer.parseInt((date1.toString().substring(5,7)));
			    if(mois == moisNow){
		    	
			    	revenu = revenu + ammount ; 
             
		    	}
         }
		return revenu;
	}

	public void setmRevenue(Double mRevenue) {
		this.mRevenue = mRevenue;
	}

	public Double getaRevenue() {
		Double revenu = (double) 0 ;
		List<Object[]> list = provisionService.productSales((Company)identity.getUser()) ; 
    
    String PATTERN="yyyy-MM-dd";
	    SimpleDateFormat dateFormat=new SimpleDateFormat();
	    dateFormat.applyPattern(PATTERN);
	    String today =dateFormat.format(Calendar.getInstance().getTime());
	    int moisNow = Integer.parseInt((today.toString().substring(0,4)));
	  
     for(Object[] o : list){
    	 long qt = (long)o[0] ;
       	 
    	 	Produit produit = (Produit)o[1] ;
    	 	Order order = (Order)o[2] ;
    	 	Date date = order.getOrderDate() ;
	    	double ammount = qt *( produit.getPrice());
	    	
	    	String date1=dateFormat.format(date.getTime());
		   
		    int mois = Integer.parseInt((date1.toString().substring(0,4)));
		    if(mois == moisNow){
	    	
		    	revenu = revenu + ammount ; 
         
	    	}
     }
	return revenu;
		
	}

	public void setaRevenue(Double aRevenue) {
		this.aRevenue = aRevenue;
	}

	public Double getNetIncome() {
		Double revenu = (double) 0 ;
		List<Object[]> list = provisionService.productSales((Company)identity.getUser()) ; 
    
    String PATTERN="yyyy-MM-dd";
	    SimpleDateFormat dateFormat=new SimpleDateFormat();
	    dateFormat.applyPattern(PATTERN);
	    String today =dateFormat.format(Calendar.getInstance().getTime());
	    int moisNow = Integer.parseInt((today.toString().substring(0,4)));
	  
     for(Object[] o : list){
    	 long qt = (long)o[0] ;
       	 
    	 	Produit produit = (Produit)o[1] ;
    	 	Order order = (Order)o[2] ;
    	 	Date date = order.getOrderDate() ;
	    	double ammount = qt *( produit.getPrice()-produit.getCout());
	    	
	    	String date1=dateFormat.format(date.getTime());
		   
		    int mois = Integer.parseInt((date1.toString().substring(0,4)));
		    if(mois == moisNow){
	    	
		    	revenu = revenu + ammount ; 
         
	    	}
     }
	return revenu;
	}

	public void setNetIncome(Double netIncome) {
		this.netIncome = netIncome;
	}

	public Long getMaxProduct() {
		long max = 0;
    	
    	List<Object[]> list = provisionService.productSales((Company)identity.getUser()) ; 
    
    	for(Object[] o : list){
	    	 long qt = (long)o[0] ;
       	     Produit produit = (Produit)o[1] ;
    	 	
	    	  if(qt>max){
	    		  max = qt ; 
	    	  }
    	}
		return max;
	}

	public String getMaxName() {
		String nom="" ;
		long max = 0 ;
    	
    	List<Object[]> list = provisionService.productSales((Company)identity.getUser()) ; 
    
    	for(Object[] o : list){
	    	 long qt = (long)o[0] ;
       	     Produit produit = (Produit)o[1] ;
    	 	
	    	  if(qt>max){
	    		  max = qt ; 
	    		  nom = produit.getDescription() ;
	    	  }
    	}
		return nom ;
	}
	
	public double getMaxRev() {
		double rev = 0 ;
		long max = 0 ;
    	
    	List<Object[]> list = provisionService.productSales((Company)identity.getUser()) ; 
    
    	for(Object[] o : list){
	    	 long qt = (long)o[0] ;
       	     Produit produit = (Produit)o[1] ;
    	 	
	    	  if(qt>max){
	    		  max = qt ; 
	    		 rev = qt * (produit.getPrice());
	    	  }
    	}
		return rev ;
	}
	
	public void setMaxProduct(Long maxProduct) {
		this.maxProduct = maxProduct;
	}
    
	public String redirectContract(){
		return "/signContract?faces-redirect=true";
	}
    
}