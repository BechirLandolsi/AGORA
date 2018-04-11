package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;


import java.net.URL;

import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Order;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.OrderLine;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote;

public class GlobalViewAdminController implements Initializable {


    @FXML
    private AnchorPane HolderAnchor;

    @FXML
    private Label lbProduct;

    @FXML
    private Label lbTender;

    @FXML
    private Label lbProjet;

    @FXML
    private Label lbPartnership;

    @FXML
    private BarChart<String, Number> mybarchart ;

    @FXML
    private ProgressBar Erate;

    @FXML
    private ProgressBar Prate;

    @FXML
    private ProgressBar Pvalue;

    @FXML
    private PieChart pieBookings;

   
    
    final NumberAxis xAxis = new NumberAxis();
    final NumberAxis yAxis = new NumberAxis();
    
  //  @FXML
   // private BubbleChart<Number, Number> myBubble ;

    /*********JNDI PRODUCT ****************/
    String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ProductService!tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote" ;
	  Context context;
	  ProductServiceRemote proxy1 ;
	  
	/***************************************/
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		  
		try {
			context = new InitialContext();
			 proxy1 = (ProductServiceRemote) context.lookup(jndiName1);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lbPartnership.setText(proxy1.nbPartnershp().toString());
		lbProduct.setText(proxy1.nbProbuit().toString());
		lbProjet.setText(proxy1.nbProjet().toString());
		lbTender.setText(proxy1.nbTender().toString());
		
		try {
			MakeBarGraphCategory() ;
			buildPieChartData();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
	/*	try {
			MakeBubble();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}
	   
	 private void MakeBarGraphCategory() throws NamingException {
		 
		 context = new InitialContext();
		 proxy1 = (ProductServiceRemote) context.lookup(jndiName1);
		 
	        mybarchart.setTitle("Sales per Company");
	        ObservableList<XYChart.Series< String , Number>> chartData = FXCollections.observableArrayList();

	        XYChart.Series<String , Number> series = new XYChart.Series<>();
	               
	           List<Object[]> list = proxy1.salesPerCompany();
	           
	           for(Object[] o : list){
	        	   
	        	   long qt = (long)o[0] ; 
	   	    	   Produit p = new Produit();
	   	    	   p= (Produit)o[1] ;
	   	    	   
	   	    	   String company = p.getSupplier().getName() ; 
	   	    	   float sales = qt*p.getPrice() ; 
	   	    	   		
	              series.getData().add(new XYChart.Data<>(company,sales));
	                }
	            chartData.add(series);
	            mybarchart.getData().addAll(chartData);
	   }
 
	  
	 /* private void MakeBubble() throws NamingException {
		 
		 context = new InitialContext();
		 proxy1 = (ProductServiceRemote) context.lookup(jndiName1);
		 
		    
	       // myBubble = new BubbleChart<>(xAxis,yAxis);
	        xAxis.setLabel("Week");
	        yAxis.setLabel("Product Budget");
	        myBubble.setTitle("Sales per Product");
	        
	        ObservableList<XYChart.Series< Number , Number>> chartData = FXCollections.observableArrayList();
	        xAxis.setLabel("Week");
	        yAxis.setLabel("Product quantity");
	        XYChart.Series<Number , Number> series = new XYChart.Series<>();
	               
	          List<Object[]> list = proxy1.salesPerProduit();
	          
	           
			    for(Object[] o : list){
			       Produit p = new Produit();
		   	       p= (Produit)o[1] ;
	        	  
	        	   int qt = (int)o[0] ;  
	   	    	   float sales = qt*p.getPrice() ; 
	   	    	   Order o1 = new Order() ;
	   	    	   o1 = (Order)o[2] ;
	   	    	 Calendar cal = Calendar.getInstance();
	   	    	   cal.setTime(o1.getOrderDate()); 
	   	    	   int week = cal.get(Calendar.WEEK_OF_YEAR);
	   	    	   System.out.println(week);
	   	    	System.out.println(sales);
	   	    	   
	   	    	   
	   	    	   series.getData().add(new XYChart.Data<>(week,sales));
	   	    	System.out.println(series.getData().toString());
	                }
			    chartData.add(series);
			    
			    System.out.println(chartData.toString());
	            myBubble.getData().addAll(chartData);
	   }*/
	  
	    private ObservableList<PieChart.Data> data; 
	    
	    private void buildPieChartData() throws NamingException {
	           data = FXCollections.observableArrayList();
	            
	         context = new InitialContext();
	   		 proxy1 = (ProductServiceRemote) context.lookup(jndiName1);
			    List<Object[]> list = proxy1.salesPerSector();
			    for (Object[] o : list){
			    	 
			    	 OrderLine o1 = new OrderLine() ; 
			    	 
		 	    	o1= (OrderLine)o[0] ;
		 	    	long count = (long)o[1] ; 
			    	String sector = count + " : " + o1.getProd().getSupplier().getSector()    ; 
			    	
			    	data.add(new PieChart.Data(sector, count)); 
			    	pieBookings.setTitle("Products sold per sector");
			    	pieBookings.setData(data);
			    	
			         }
			     }
	  

}