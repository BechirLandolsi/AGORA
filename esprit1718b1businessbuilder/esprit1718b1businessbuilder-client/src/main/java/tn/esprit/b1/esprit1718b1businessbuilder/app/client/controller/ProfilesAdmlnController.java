package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.ejb.Remove;
import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.controlsfx.control.ToggleSwitch;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXTextField;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Order;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.OrderLine;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote;


public class ProfilesAdmlnController  implements Initializable {
	 @FXML
	    private AnchorPane HolderAnchor;

	    @FXML
	    private JFXListView<Company> listview;
	    
	    @FXML
	    private JFXTextField search;
	    
	    @FXML
	    private Label companyName;

	    @FXML
	    private Label companyCEO;

	    @FXML
	    private Label ps;

	    @FXML
	    private Label quantity;

	    @FXML
	    private Label sales;


	    private ObservableList<Company> cplist ;
	    
	    @FXML
	    private Label test; 
	    
	    @FXML
	    private JFXButton show;
	    
	    @FXML
	    private AnchorPane dashbord;
	    

	    @FXML
	    private AnchorPane initialPane ; 
	    @FXML
	    private Label net;
	    

	    @FXML
	    private JFXProgressBar progressSales;

	    @FXML
	    private Label valueSales;
	    
	    @FXML
	    private Label valueNet ; 

	    @FXML
	    private JFXProgressBar progressNet;

	    @FXML
	    private TableView<Produit> tableview;

	    @FXML
	    private ToggleSwitch  outstock;

	    @FXML
	    private JFXButton send;

	    @FXML
	    private TableColumn<Produit, String> p_description;
	    @FXML
	    private TableColumn<Produit, Float> p_price;
	    @FXML
	    private TableColumn<Produit, Float> p_cost;
	    @FXML
	    private TableColumn<Produit, Long> p_stock;
	    
	    @FXML
	    private LineChart<String , Number> linechart;
	  
	    @FXML
	    private ToggleSwitch showAll;
	    @FXML
	    private Button mailtest ; 
	    
	    @FXML
	    private ImageView faza;
	    @FXML
	    private Pane alert;

	    @FXML
	    private JFXButton alertClose;
	 
	    
	    private static Company entreprise;
	    
		public static Company getEntreprise() {
			return entreprise;
		}

		public static void setEntreprise(Company entreprise) {
			ProfilesAdmlnController.entreprise = entreprise;
		}
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			initialPane.setVisible(true);
			dashbord.setVisible(false);
			mailtest.setVisible(false);
			String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 	
			CompanyServiceRemote proxy;
			
			 
			try {
				 Context	context = new InitialContext();
				proxy = (CompanyServiceRemote) context.lookup(jndiName1);
				
				
				cplist = FXCollections.observableArrayList(proxy.findAllCompany());
				setBest();
			} catch (NamingException e) {
				e.printStackTrace();
			}
			//System.out.println(cplist);
			
	 		
			
			listview.setItems(cplist);
	             
			listview.setCellFactory(new Callback<ListView<Company>, ListCell<Company>>() {
			          

				@Override
				public ListCell<Company> call(ListView<Company> param) {
					// TODO Auto-generated method stub
					return new GridRowController() ;
				}
			});
			
			
			 search.textProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> observable,String oldValue, String newValue) {
					String jndiName="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/OrderService!tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote";
					
				    OrderServiceRemote proxy1 ; 
					
					Context context1;
					try {
						context1 = new InitialContext();
						proxy1 =(OrderServiceRemote) context1.lookup(jndiName);
					
					String str = search.getText() ;
			    	if (!str.equals("") ){
			    		cplist = FXCollections.observableArrayList(proxy1.findAllCompanyByName(search.getText()));
			    		
			    	  //  System.out.println(cplist.toString());
			    		listview.setItems(cplist);
			             
						listview.setCellFactory(new Callback<ListView<Company>, ListCell<Company>>() {
						          

							@Override
							public ListCell<Company> call(ListView<Company> param) {
								// TODO Auto-generated method stub
								return new GridRowController() ;
							}
						});
			    	}
			    	else {

			    		String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 	
						CompanyServiceRemote proxy;
						try {
							 Context	context = new InitialContext();
							proxy = (CompanyServiceRemote) context.lookup(jndiName1);
							cplist = FXCollections.observableArrayList(proxy.findAllCompany());
						} catch (NamingException e) {
							e.printStackTrace();
						}
						listview.setItems(cplist);
			             
						listview.setCellFactory(new Callback<ListView<Company>, ListCell<Company>>() {
						          

							@Override
							public ListCell<Company> call(ListView<Company> param) {
								// TODO Auto-generated method stub
								return new GridRowController() ;
							}
						});
				 		
			    	}

					} catch (NamingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					
				}
				
			});
				
			 
			
		}
		
		public void setBest() throws NamingException {
			String jndiNameProduit ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ProductService!tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote" ;
			 ProductServiceRemote proxy1 ;
			 Context	context = new InitialContext();
			 proxy1 = (ProductServiceRemote) context.lookup(jndiNameProduit);
			 for (Object[] o : proxy1.bestSales()){
			    	
		    	 Produit p = new Produit();
		    	 p= (Produit)o[1] ;
		    	 long qt = (long)o[0];
		    	 Order order = new Order();
		    	 order = (Order)o[2];
		    	 companyName.setText(p.getSupplier().getName());
		    	 companyCEO.setText(p.getSupplier().getCEO());
		    	 quantity.setText(String.valueOf(qt)); 
		    	 sales.setText(String.valueOf(order.getAmount()));
		    	 ps.setText(p.getDescription());
		    	 
		    	 
	 	    	  
		    	
		    }
		}
		
		  @FXML
		    void showDashboard(ActionEvent event) throws NamingException {
			  dashbord.setVisible(false);
			  mailtest.setVisible(true);
			  entreprise=GridRowController.getEntreprise();
			  System.out.println(entreprise);
			  //mailtest.setOnAction(e->faza.setVisible(true));
			  	if(entreprise!= null){
			  		initialPane.setVisible(false);
			  		dashbord.setVisible(true);
			  		MakeLineGraph(entreprise);
			  		progressSales.setProgress(calculateSales());
			  		valueSales.setText(String.valueOf(calculateSales()));
			  		progressNet.setProgress(calculateNet());
			  		valueNet.setText(String.valueOf(calculateNet())); 
			  		
			  		if(!outstock.isSelected()){
			  			setTableProduit(entreprise);
			  		}else {
			  			setTableProduitOutStock(entreprise);
			  		}
			  		
			  		outstock.selectedProperty().addListener(a -> {
			  			if(outstock.isSelected()){
			  				
			  			
			  			try {
							setTableProduitOutStock(entreprise);
						} catch (NamingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			  			}else {
			  				try {
								setTableProduit(entreprise);
							} catch (NamingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			  			}
			  		});
			  		showAll.selectedProperty().addListener(a -> {
			  			if(showAll.isSelected()){
			  				
			  			
			  			try {
							MakeLineGraph(entreprise);
						} catch (NamingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			  			}
			  		});
			  		
			  	}
		    }
		  
		  public double calculateSales() throws NamingException{
			  String OrderJNDI="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/OrderService!tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote";
			  Context	context = new InitialContext();
			  OrderServiceRemote Orderproxy = (OrderServiceRemote) context.lookup(OrderJNDI);
			  
			  List<Object[]> list = Orderproxy.salesPerCompany(entreprise);
			  
			  double sale =0  ;
			    for (Object[] o : list){
			    	long qt = (long)o[0] ; 
			    	
			    	Produit p = new Produit();
			    	p = (Produit)o[1] ; 
			    	sale = sale + qt*p.getPrice() ; 

			    } return sale ; 
		  }
		  
		  public double calculateNet()throws NamingException{
			  String OrderJNDI="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/OrderService!tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote";
			  Context	context = new InitialContext();
			  OrderServiceRemote Orderproxy = (OrderServiceRemote) context.lookup(OrderJNDI);
		  
			  List<Object[]> list = Orderproxy.salesPerCompany(entreprise);
			  double netincome =0  ;
			    for (Object[] o : list){
			    	long qt = (long)o[0] ; 
			    	
			    	Produit p = new Produit();
			    	p = (Produit)o[1] ; 
			    	netincome = netincome + qt*(p.getPrice()-p.getCout()) ; 

			    } return netincome ; 
		  }
		  
		  public void setTableProduit(Company c) throws NamingException{
			  String OrderJNDI="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/OrderService!tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote";
				Context	context = new InitialContext();
				OrderServiceRemote Orderproxy = (OrderServiceRemote) context.lookup(OrderJNDI);
			  
				ObservableList<Produit> lp =FXCollections.observableArrayList( Orderproxy.findAllProduct(entreprise));
				p_description.setCellValueFactory(new PropertyValueFactory<>("description"));
		    	p_description.cellFactoryProperty();
		         
		    	p_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		    	p_price.cellFactoryProperty();
		    	
		    	p_cost.setCellValueFactory(new PropertyValueFactory<>("cout"));
		    	p_cost.cellFactoryProperty();
		    	
		    	p_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
		    	p_stock.cellFactoryProperty();
		    	     	  
		    	tableview.setItems(lp); 
		  }
		  
		  public void setTableProduitOutStock(Company c) throws NamingException{
			 
			  String OrderJNDI="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/OrderService!tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote";
				Context	context = new InitialContext();
				OrderServiceRemote Orderproxy = (OrderServiceRemote) context.lookup(OrderJNDI);
			  
				ObservableList<Produit> lp =FXCollections.observableArrayList( Orderproxy.findAllProductOutStock(entreprise));
				p_description.setCellValueFactory(new PropertyValueFactory<>("description"));
		    	p_description.cellFactoryProperty();
		         
		    	p_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		    	p_price.cellFactoryProperty();
		    	
		    	p_cost.setCellValueFactory(new PropertyValueFactory<>("cout"));
		    	p_cost.cellFactoryProperty();
		    	
		    	p_stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
		    	p_stock.cellFactoryProperty();
		    	     	  
		    	tableview.setItems(lp); 
		  }
		  
		  private void MakeLineGraph(Company c) throws NamingException {
			    
		       
		    	ObservableList<XYChart.Series< String , Number>> chartData = FXCollections.observableArrayList();
		    	 XYChart.Series<String , Number> seriesSales = new XYChart.Series<>();
		   	     XYChart.Series<String , Number> seriesNet = new XYChart.Series<>();
		    	linechart.getData().clear();
		    	//seriesNet.getData().removeAll();
		    	//seriesSales.getData().removeAll();

		         //XYChart.Series<String , Number> series = new XYChart.Series<>();
		                
		         String OrderJNDI="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/OrderService!tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote";
					Context	context = new InitialContext();
					OrderServiceRemote Orderproxy = (OrderServiceRemote) context.lookup(OrderJNDI);
				    
				    List<Object[]> list = Orderproxy.productSales(c);
				    seriesNet.setName("Net income");
				    seriesSales.setName("Sales");
				    String PATTERN="yyyy-MM-dd";
	 			    SimpleDateFormat dateFormat=new SimpleDateFormat();
	 			    dateFormat.applyPattern(PATTERN);
	 			    
	 			   linechart.setTitle("Sales");
	 			  
		             for(Object[] o : list){
		            	 
		            	 
		            	 long qt = (long)o[0] ;
		            	 
		            	 Produit produit = (Produit)o[1] ;
		            	 Order order = (Order)o[2] ;
		            	 Date date = order.getOrderDate();
		 		    	// String date1=dateFormat.format(date.getTime());
		 		    	 double ammount = qt *( produit.getPrice() - produit.getCout() );
		 		    	double ammountSales = qt *( produit.getPrice() );
		 		    	// series.setName(produit.getDescription());
		 		    	System.out.println(date);
		 		    	 System.out.println(ammount);
		 			     seriesNet.getData().add(new XYChart.Data<>(date.toString(),ammount));
		                 seriesSales.getData().add(new XYChart.Data<>(date.toString(),ammountSales));
		 		    	
		             }
		             
		             chartData.addAll(seriesNet,seriesSales);
		             
		             linechart.getData().addAll(chartData);
		             
		         }
		  
		  @FXML
		    void selectProduct(MouseEvent event) throws NamingException {
			  if (tableview.getSelectionModel().getSelectedItem() != null) {
		    		 Produit p = new Produit();
		    		 p = tableview.getSelectionModel().getSelectedItem();
		    		 MakeLineProduct(entreprise, p);
		    		 
		    }
		  }
		  
		  private void MakeLineProduct(Company c,Produit p) throws NamingException {
			    
		       
		    	ObservableList<XYChart.Series< String , Number>> chartData = FXCollections.observableArrayList();
		    	 XYChart.Series<String , Number> seriesSales = new XYChart.Series<>();
		   	     XYChart.Series<String , Number> seriesNet = new XYChart.Series<>();
		    	linechart.getData().clear();
		    	
		         String OrderJNDI="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/OrderService!tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote";
					Context	context = new InitialContext();
					OrderServiceRemote Orderproxy = (OrderServiceRemote) context.lookup(OrderJNDI);
				    
				    List<Object[]> list = Orderproxy.salesPerProduit(p, c);
				    seriesNet.setName("Net income");
				    seriesSales.setName("Sales");
				    String PATTERN="yyyy-MM-dd";
	 			    SimpleDateFormat dateFormat=new SimpleDateFormat();
	 			    dateFormat.applyPattern(PATTERN);
	 			    
	 			   linechart.setTitle("Sales");
	 			  
		             for(Object[] o : list){
		            	 
		            	 
		            	 int qt = (int)o[0] ;
		            	 
		            	 Produit produit = (Produit)o[1] ;
		            	 Order order = (Order)o[2] ;
		            	 Date date = order.getOrderDate();
		 		    	 double ammount = qt *( produit.getPrice() - produit.getCout() );
		 		    	 double ammountSales = qt *( produit.getPrice() );
		 		    	 System.out.println(p.toString());
		 		    	 System.out.println(ammount);
		 			     seriesNet.getData().add(new XYChart.Data<>(date.toString(),ammount));
		                 seriesSales.getData().add(new XYChart.Data<>(date.toString(),ammountSales));
		 		    	 
		             }
		             
		             chartData.addAll(seriesNet,seriesSales);
		             
		             linechart.getData().addAll(chartData);
		             
		         }
		  
		  @FXML
		    void send(ActionEvent event) throws IOException, NamingException, InterruptedException {
			  
			  
			  entreprise=GridRowController.getEntreprise();
			  String OrderJNDI="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/OrderService!tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote";
				Context	context = new InitialContext();
				OrderServiceRemote Orderproxy = (OrderServiceRemote) context.lookup(OrderJNDI);
			    List<Produit> lp = Orderproxy.findAllProductOutStock(entreprise);
				List<String> SB = new ArrayList<>();
				for(Produit p : lp){
					SB.add(p.getDescription());
				}
			  WritableImage image = dashbord.snapshot(new SnapshotParameters(), null);
			  File file = new File("C:\\Users\\Asus\\Desktop\\Dashboard.png");
			  try {
			  ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
			  }catch (IOException e) {
			      // TODO: handle exception here
			  }
			    String UsernameSender = "hamdouch.a@gmail.com"; //ur email
		        String password = "2120201455954214";
		        String username = entreprise.getEmail();           //"nourelhouda.gasmi@esprit.tn";

		        Properties props = new Properties();
		        props.put("mail.smtp.auth", true);
		        props.put("mail.smtp.starttls.enable", true);
		        props.put("mail.smtp.host", "smtp.gmail.com");
		        props.put("mail.smtp.port", "587");

		        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(UsernameSender, password);
		            }
		        });

		        try {

		            Message message = new MimeMessage(session);
		            message.setFrom(new InternetAddress(UsernameSender));//ur email
		            message.setRecipients(Message.RecipientType.TO,
		                    InternetAddress.parse(username));//u will send to
		            
		            message.setSubject(entreprise.getName()+"'s Dashboard");
		            
		            MimeBodyPart messageBodyPart = new MimeBodyPart();
		            Multipart multipart = new MimeMultipart();
		            messageBodyPart.setText("<html><head> <h3>BALANCE SHEET</h3></head>"
		            		+ "<body><div><strong>this is your daily </strong><em> balance sheet<em> ,"
		            		+ " you will find below a <strong>screenshot</strong> of your dashbord"
		            		+"<h4>But<h4> before that we want you to know more about your Sales States ."
		            		+ "these products are out of stock :  <strong>"+ SB.toString() +"</strong>"
		            				+ "Your Best sold product <strong> <h3>"+productBestSold(entreprise).getDescription() +"</h3></strong></body></html>","US-ASCII", "html");
		            
		            multipart.addBodyPart(messageBodyPart);
		            
		            MimeBodyPart imagePart = new MimeBodyPart();
		            imagePart.attachFile(file);

		            multipart.addBodyPart(imagePart);
		            message.setContent(multipart);
		            
		            faza.setVisible(true);
		            System.out.println("sending");
		            
		            Transport.send(message);
		           // Thread.sleep(2500);
		           
		            alert.setVisible(true);
		            alertClose.setOnAction(e->{
		            	alert.setVisible(false) ;
		            	faza.setVisible(false);
		            });
		            System.out.println("Done");
	   
		         } catch (MessagingException e) {
		            e.printStackTrace();
		        }
			  
			 
		}
		  
		  public Produit productBestSold(Company c) throws NamingException{
			  String OrderJNDI="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/OrderService!tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote";
				Context	context = new InitialContext();
				OrderServiceRemote Orderproxy = (OrderServiceRemote) context.lookup(OrderJNDI);
			    
			    List<Object[]> list = Orderproxy.productSales(c);
			    
			    String PATTERN="yyyy-MM-dd";
			    SimpleDateFormat dateFormat=new SimpleDateFormat();
			    dateFormat.applyPattern(PATTERN);
			    double max = 0 ;
			    Produit p = new Produit();
			   
			  
	             for(Object[] o : list){
	            	 long qt = (long)o[0] ;
	            	 Produit produit = (Produit)o[1] ;
	            	
	            	 
	 		    	 double ammountSales = qt *( produit.getPrice() );
	 		    	 if(ammountSales > max){
	 		    		 max = ammountSales ; 
	 		    	 }
	 		    	 p = produit ; 
	             }
	 		    
			return p;
			  
		  }

		    
}
