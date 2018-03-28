package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote;

public class AdminDashboardController implements Initializable {

    @FXML
    private AnchorPane HolderAnchor;
    @FXML
    private Label lbSubnumber;
    @FXML
    private Label lbvalue;
    @FXML
    private Label lbSubnumberDay;
    @FXML
    private PieChart pieBookings;
    @FXML
    private ImageView imgAvatar;
    @FXML
    private Label lblname;
    @FXML
    private Label lbCountry;
    @FXML
    private Label lblBirthdate;
    @FXML
    private Label lblemail;
    

    @FXML
    private LineChart< String , Number> lineChart;
    
    Context context;
	//jndi OrderSercice
	String jndiName="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/OrderService!tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote";
	
	   
	 
    
	@Override
	public void initialize(URL location, ResourceBundle resources)  {
		// TODO Auto-generated method stub
		
		try {
			context = new InitialContext();
			
		    OrderServiceRemote proxy = (OrderServiceRemote) context.lookup(jndiName); 
		    lbSubnumber.setText(proxy.nbSubscriber().toString());
		    lbSubnumberDay.setText(proxy.nbSubscriberPerday().toString());
		    buildPieChartData(); 
		    MakeLineGraph(); 
		    
		    
	   
		    
		    
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	  private ObservableList<PieChart.Data> data; 
	    
	    private void buildPieChartData() throws NamingException {
	            data = FXCollections.observableArrayList();
	            
	            context = new InitialContext();
				
			    OrderServiceRemote proxy = (OrderServiceRemote) context.lookup(jndiName); 
			    List<Object[]> list = proxy.nbSubscriberPertype();
			    for (Object[] o : list){
			    	String sector = (String)o[1] ; 
			    	long count = (long)o[0] ; 
			    	data.add(new PieChart.Data(sector, count)); 
			    	pieBookings.setTitle("Companies per sector");
			    	pieBookings.setData(data);
			    

			          for (final PieChart.Data data : pieBookings.getData()) {
			              data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			                  @Override
			                  public void handle(MouseEvent e) {
			                     // caption.setTranslateX(e.getSceneX());
			                      //caption.setTranslateY(e.getSceneY());
			                	  //System.out.println(String.valueOf(data.getPieValue()));
			                	  lbvalue.setText(String.valueOf(data.getPieValue()));
			         }});
			         }}
			     }
	    
	    private void MakeLineGraph() throws NamingException {
	        
	    	lineChart.setTitle("Expenses Visualization");
	         

	         ObservableList<XYChart.Series< String , Number>> chartData = FXCollections.observableArrayList();

	         XYChart.Series<String , Number> series = new XYChart.Series<>();
	                
	            context = new InitialContext();
				
			    OrderServiceRemote proxy = (OrderServiceRemote) context.lookup(jndiName); 
			    List<Object[]> list = proxy.salesPermonth();
			    
			    String PATTERN="yyyy-MM-dd";
 			    SimpleDateFormat dateFormat=new SimpleDateFormat();
 			    dateFormat.applyPattern(PATTERN);
 			    String today =dateFormat.format(Calendar.getInstance().getTime());
 			    int moisNow = Integer.parseInt((today.toString().substring(5,7)));
 			    
	             for(Object[] o : list){
	            	 System.out.println("1");
	            	 double ammount = (double)o[0] ;
	            	 System.out.println("2");
	 		    	 Date date = (Date)o[1] ;
	 		    	System.out.println(1);
	 		    	String date1=dateFormat.format(date.getTime());
	 			    System.out.println(2);
	 			    int mois = Integer.parseInt((date1.toString().substring(5,7)));
	 			    
	 			   
	 		    	 if(mois == moisNow){
	 		    	System.out.println("3");
	                 series.getData().add(new XYChart.Data<>(date.toString(),ammount));
	                 System.out.println("1111");
	 		    	}
	             }
	             chartData.add(series);
	             System.out.println("4");
	             lineChart.getData().addAll(chartData);
	             System.out.println("5");
	         }


 }

    