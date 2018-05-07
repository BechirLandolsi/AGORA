package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.Duration;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Bilan;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Partnership;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.BilanRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.Mail;
import tn.esprit.b1.esprit1718b1businessbuilder.services.PartnershipRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Spinner;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;
import javafx.scene.Parent;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.NoResultException;

import org.controlsfx.control.HyperlinkLabel;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.Rating;

import javafx.scene.control.TextField;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * FXML Controller class
 *
 * @author bn
 */
public class PartnershipController implements Initializable {

	@FXML
    private AnchorPane anchor2;

    @FXML
    private AnchorPane anchor1;
    
    @FXML
    private Label testRate;
	
	 @FXML
	    private JFXComboBox<String> sectorcombo;

	    @FXML
	    private JFXComboBox<String> companiescombo;
	    
	    @FXML
	    private Label companynameLabel;

	    @FXML
	    private Label nbrprojLabel;

	    @FXML
	    private TableView<Project> tab_project;

	    @FXML
	    private TableColumn<Project, String> col_name;

	    @FXML
	    private TableColumn<Project, String> col_service;
	    
	    @FXML
	    private TableColumn<Project, String> col_nature;

	    @FXML
	    private TableColumn<Project, String> col_product;

	    @FXML
	    private TableColumn<Project, Float> col_capital;

	   

	    @FXML
	    private Label has;

	    @FXML
	    private Label ProjectsLabel;
	    
	    @FXML
	    private Rating rateOne;
	    
	    @FXML
	    private JFXButton btnrate;
	    
	    @FXML
	    private PieChart pieChart1;
	    
	    @FXML
	    private Label chartLabel;
	    
	    @FXML
	    private BarChart<String,Number> BarChart;

/**************************************************** Anchor2 ***************************************************/

	    @FXML
	    private Label salesLabel;

	    @FXML
	    private Label rollingcapLabel;

	    @FXML
	    private Label resultLabel;

	    @FXML
	    private ImageView happyimg;

	    @FXML
	    private ImageView sadimg;

	    @FXML
	    private Label stateLabel;

	    @FXML
	    private Label qualityLabel;

	    @FXML
	    private Label countLabel;
	   
	
	   ProjectController projectController;
	
	  // ProjectRowController projectrowcontroller;
	   
/******************************************************* Anchor3 ****************************************************/
	    
	
	 @FXML
	    private AnchorPane anchor3;

	    @FXML
	    private JFXButton btnbackanchor3To2;
	    
	    @FXML
	    private JFXButton btnpartner;
	    

	    @FXML
	    private Label salesLabel1;

	    @FXML
	    private Label CVLabel;

	    @FXML
	    private Label percentCVLabel;

	    @FXML
	    private Label MgLabel;

	    @FXML
	    private Label percentMgLabel;

	    @FXML
	    private Label CFLabel;

	    @FXML
	    private Label resultLabel1;

	    @FXML
	    private Label SRLabel;

	    @FXML
	    private Label PointMortLabel;

	    @FXML
	    private Label fondDeRoulmntLabel;

	    @FXML
	    private HyperlinkLabel afficherBilanLink;
	    
    
	    @FXML
	    private AnchorPane holderPane;
	    
	    @FXML
	    private Label btnLabel;
	    
	    @FXML
	    private Label requestLabel;
	    

	    
/*********************************************************************************************************************/
	    
	    
	    
		 String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 
		 Context context1;
		 
		 String jndiName2 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ProjectService!tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote" ; 
		 Context context2;
		 
		 String jndiName3 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/BilanService!tn.esprit.b1.esprit1718b1businessbuilder.services.BilanRemote" ; 
		 Context context3;
		 
		 String jndiName4 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/PartnershipService!tn.esprit.b1.esprit1718b1businessbuilder.services.PartnershipRemote" ; 
		 Context context4;
		 
		 private ObservableList<Project> sectors = FXCollections.observableArrayList();
		 CompanyService oe = new CompanyService();
		 
		 private ObservableList<Project> listproject = FXCollections.observableArrayList();
		 
		 User loggedcompany = LoginController.LoggedUser;

		 //static Project o;
		 
/*******************************************************************************************************************/
		 
   
		    public void PieChart(Company c) throws NamingException {
		    	context2 = new InitialContext();
		 	   ProjectRemote proxy2 = (ProjectRemote) context2.lookup(jndiName2);
		 	   long i1=proxy2.CountStableProjects(c);
		 	    long i2=proxy2.CountUnstableProjects(c);
		
		 	   pieChart1.setTitle("Projects' State");
		 	    
		    ObservableList<PieChart.Data> pieChartData =
	               FXCollections.observableArrayList(
	               new PieChart.Data("In Stable State",i1),
	               new PieChart.Data("In danger", i2));
		   pieChart1.setLegendSide(Side.RIGHT);
		    pieChart1.setData(pieChartData);
		 
		    	     
		    }
		    
		    
		       public void BarChart(Company c) throws NamingException {
		    	   BarChart.getData().clear();
		    	
		       context2 = new InitialContext();
		 	   ProjectRemote proxy2 = (ProjectRemote) context2.lookup(jndiName2);
		 	   List l1=new ArrayList<>();
		 	   List l2=new ArrayList<>();
		 	   
		 	   l1=proxy2.getProjectsNameByCompany(c);
		 	   l2=proxy2.getProjectsQualityByCompany(c);
		 	   
		 	   
		 	   BarChart.setTitle("Projects by score");
		 	  ObservableList<XYChart.Series<String, Number>> data = FXCollections.observableArrayList();
		 	  XYChart.Series series1 = null;
		 	    series1 = new XYChart.Series();
		 	   
		        for(int i=0;i<l1.size();i++)
		        {
		        	series1.getData().add(new XYChart.Data(l1.get(i), l2.get(i)));
		        	

		        }
		       
		        data.add(series1);
		        
		        BarChart.getData().addAll(data);
		     
		    	

		    
		    }
		       
		      	
/***************************************************************************************************************/
		    
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
		   	context1 = new InitialContext();
		   	CompanyServiceRemote proxy = (CompanyServiceRemote) context1.lookup(jndiName1);
		   	
		   	Company company =proxy.findBy(loggedcompany.getId());
		   	
		   	Set <String> hashset = new HashSet<>();
		   	
		   	hashset.addAll(proxy.getAllSectors());
		   	
		   	ObservableList<String> sectors = FXCollections.observableArrayList(hashset);
		   	sectorcombo.setItems(sectors);
		   	
		   	
		   	   	}
		    	catch (NamingException e)
		    	{
		    		e.printStackTrace();
		    		
		    	}
	
		
	}
	

	
	    
	   static Company companypartner;  
	    
	 @FXML
	    void help(MouseEvent event) throws NamingException {
		 context1 = new InitialContext();
		   CompanyServiceRemote proxy = (CompanyServiceRemote) context1.lookup(jndiName1);
		   
		   context2 = new InitialContext();
		   ProjectRemote proxy2 = (ProjectRemote) context2.lookup(jndiName2);
		   
		   context3 = new InitialContext();
		   PartnershipRemote proxy3 = (PartnershipRemote) context3.lookup(jndiName4);
		 
		 String sector;
		 
		    if(sectorcombo.getValue()!="")
		    {
		   	 	
		   	//System.out.println(sector);
		   
		    	sector=sectorcombo.getValue();
		    	
		    	Company company =proxy.findBy(loggedcompany.getId());
		    	System.out.println(company);
	
		    ObservableList<String> Allcompanies = FXCollections.observableArrayList(proxy.FindBySector(sector));

		   if (Allcompanies.isEmpty())
		   {System.out.println("--------");}
		   
		   else 
		   {
			   for(String c : Allcompanies) 
		    {
		    	
		    	  if(company.getName().equals(c)) 
		    	  {
		    			        	
		    	  System.out.println("name==name");
		    	  Allcompanies.remove(company.getName());
		    			        	
		    			          
		    	  }
		    			        
		    }
		    			      
		       companiescombo.setItems(Allcompanies);
			   companynameLabel.setText(companiescombo.getValue());
			    
				companypartner = new Company();
				companypartner = proxy.findAllCompanyByName(companynameLabel.getText());
				
								
				List <Long> nbrL = new ArrayList<>();
				if (companypartner!=null)
				{
				nbrL = proxy2.countProjectsByCompanyName(companypartner);
				
				if(nbrL.isEmpty())
				
				{
					System.err.println("empty");
				}
				
				else
				{	
					
				nbrprojLabel.setText(String.valueOf(nbrL.get(0)));
				
				companynameLabel.setVisible(true);
				ProjectsLabel.setVisible(true);
				has.setVisible(true);
				nbrprojLabel.setVisible(true);
				
/***************************************************************************************************************/				

				
				//List <Project> projects = new ArrayList<>();
			   //projects=proxy3.getAllProjectsAffectedByCompany(companypartner);
				
				//List <Project> Allprojects = new ArrayList<>();
				//Allprojects = proxy2.getProjectsByCompany(companypartner.getId());
					
				//List <Project> projectsNotaffected = new ArrayList<>();
				
				/*for (Project p1 : Allprojects)
				{
					for(Project p2 :projects )
					 
					{if (p1!=p2)
					 	{
						projectsNotaffected.add(p2);
						System.out.println(projectsNotaffected);
					 	}
						 
					}
				}	*/
		
/***************************************************************************************************************/				
				
				listproject = FXCollections.observableArrayList(proxy2.getProjectsByCompany(companypartner.getId()));
		    	
				  col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		    	  col_name.cellFactoryProperty();
		         
		    	  col_service.setCellValueFactory(new PropertyValueFactory<>("service"));
		    	  col_service.cellFactoryProperty();
		    	  
		    	  col_nature.setCellValueFactory(new PropertyValueFactory<>("projectNature"));
		    	  col_nature.cellFactoryProperty();
		    	  
		    	  col_product.setCellValueFactory(new PropertyValueFactory<>("product"));
		    	  col_product.cellFactoryProperty();
		    	  
		    	  col_capital.setCellValueFactory(new PropertyValueFactory<>("capital"));
		    	  col_capital.cellFactoryProperty();
		    	  
		    	  tab_project.setItems(listproject); 
		    	  
		    	  PieChart(companypartner);
		    	  BarChart(companypartner);
		    	  
		    	
		    	
		    	 
				} 
				
		   	}
		    }
		    }

		    
		    /****************************************************************/
		
	     
		    
		    /****************************************************************/
		    
		    

	    }
	 

	 Project o = new Project();
	 @FXML
	    void tableclick(MouseEvent event) throws NamingException {
		 		 
    		 o = new Project();
    		 o = tab_project.getSelectionModel().getSelectedItem();
      	   
    		 if(o!=null)
    		 
    		 {
    			 anchor1.setVisible(false);
    		
      	    anchor2.setVisible(true);
      	
      	   context3 = new InitialContext();
     
    
      	 
      	 salesLabel.setText(String.valueOf(o.getBilan().getCA()));
      	 rollingcapLabel.setText(String.valueOf(o.getBilan().getFR()));
      	 resultLabel.setText(String.valueOf(o.getBilan().getResult()));
      	 qualityLabel.setText(String.valueOf(o.getQuality()));
      	 countLabel.setText(String.valueOf(o.getCount()));
      	    
      	if (o.isState())
    	{
    		happyimg.setVisible(true);
    		stateLabel.setTextFill(Color.GREEN);
    		
    		stateLabel.setText("Stable financial state ");
    	}
    	
    	if (!o.isState())
    	{
    		sadimg.setVisible(true);
    		
    		stateLabel.setTextFill(Color.RED);
    		stateLabel.setText("Unstable financial state ");

    		
    	}	
    		 }
      	     
      	  }
	 
	 
	 @FXML
	    void btnback(ActionEvent event) {
		 
		 
		 
		 anchor2.setVisible(false);
		 anchor1.setVisible(true);
		 sadimg.setVisible(false);
		 happyimg.setVisible(false);
		 
	    }

	
	 
	  @FXML
	    void onrate(MouseEvent event) {
		 
		  btnrate.setVisible(true);
		 testRate.setText(String.valueOf(rateOne.getRating()));
	
		
	    }
	
	int count=0;
	  @FXML
	    void btnrate(ActionEvent event) throws NamingException {

		  context2 = new InitialContext();
		  ProjectRemote proxy2 = (ProjectRemote) context2.lookup(jndiName2);
	
		  count =o.getCount()+1;
		
			
		double quality; 
		quality =(o.getQuality()+(Double.parseDouble(testRate.getText())))/count;
			
		
			  proxy2.Edit(o,quality, count);
			 
				  
	    }
	  
	  
	  
	    @FXML
	    void btnpartner(ActionEvent event) throws NamingException, IOException {
	    	
	    	context1 = new InitialContext();
	    	ProjectRemote proxy3 = (ProjectRemote) context1.lookup(jndiName2);
			   CompanyServiceRemote proxy = (CompanyServiceRemote) context1.lookup(jndiName1); 	
	       	Company c =proxy.findBy(loggedcompany.getId());
	    	context4 = new InitialContext();
			   PartnershipRemote proxy2 = (PartnershipRemote) context4.lookup(jndiName4);
			   Partnership part = new Partnership();
			  
			if (part!=null && companypartner!=null) {
			
			
			  
			Calendar cal = Calendar.getInstance();
	      
		        
			    //System.out.println(ProjectRowController.project1);
				   part.setPartnershipDate(cal.getTime());
				   
							       
					   
				          proxy2.addPartner(part,c, companypartner, ProjectRowController.project1);
				          
				          String Sender = c.getEmail();
			    	        String password = c.getPassword();
			    	        String receiver = companypartner.getEmail();

			    	        Properties props = new Properties();
			    	        props.put("mail.smtp.auth", true);
			    	        props.put("mail.smtp.starttls.enable", true);
			    	        props.put("mail.smtp.host", "smtp.gmail.com");
			    	        props.put("mail.smtp.port", "587");

			    	        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			    	            protected PasswordAuthentication getPasswordAuthentication() {
			    	                return new PasswordAuthentication(Sender, password);
			    	            }
			    	        });

			    	        try {

			    	            Message message = new MimeMessage(session);
			    	            message.setFrom(new InternetAddress(Sender));
			    	            message.setRecipients(Message.RecipientType.TO,
			    	                    InternetAddress.parse(receiver));
			    	            message.setSubject("Partnership Request/"+c.getName()+"'Company");
			    	            message.setText("Dear Sir/Madam\n Each year we work with more than 100 companies from all over the "
			    	            		+ "world and it will be an honor to work with you on our new project\n "
			    	            		+"The attached piece bellow presents the Balance Sheet of the Project:\n"
			    	            		+ " _____________________________________________________________________________________________________ \n"
					    	            + "|                                                                                                      \n"
					    	            + "|Project name:    "+ProjectRowController.project1.getName()+"                                          \n"
					    	            + "|_____________________________________________________________________________________________________ \n"
					    	            + "|                                                                                                      \n"
					    	            + "|Project nature:  "+ProjectRowController.project1.getProjectNature()+"                                 \n"
			    	            		+ "|_____________________________________________________________________________________________________ \n"
					    	            + "|                                                                                                      \n"
			    	            		+ "|Service:         "+ProjectRowController.project1.getService()+"                                       \n"
			    	            		+ "|_____________________________________________________________________________________________________ \n"
					    	            + "|                                                                                                      \n"
			    	            		+ "|Capital(DT):     "+ProjectRowController.project1.getCapital()+"                                       \n"
			    	            		+ "|_____________________________________________________________________________________________________ \n"
			    	            		+ "\nAt your request I can send you our company's "
			    	            		+ "introductory profile in PDFformat for your perusal and more informations about the project."
			    	            		+ "\nThank you very much, and we hope to receive your favorably response soon. Best regards");
			    	            MimeBodyPart messageBodyPart = new MimeBodyPart();
			    	            Multipart multipart = new MimeMultipart();
			    	            Transport.send(message);
			    	           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
						        alert.setTitle("Confirmation");
						         alert.setHeaderText(null);
						         alert.setContentText("Partnership request sent");
						         alert.showAndWait().ifPresent(response -> {
						             if (response == ButtonType.OK) {
						            	
						            	btnpartner.getScene().getWindow().hide();
								      
						             
						             }
						         });
						     
						 
			       
			    	         } catch (MessagingException e) {
			    	            e.printStackTrace();
			    

			    	         }
				          
				       }
				   
				   
			   
				  
			         
			   
	    	/**********************************************************************************************/
	       
			          
   
	
	    }
	    
	    @FXML
	    void afficherBilanLink(MouseEvent event) {
	    	 anchor2.setVisible(false);
			 anchor3.setVisible(true);
			  
		    	float percentCV = (o.getBilan().getCV()/o.getBilan().getCA())*100 ;
		    	float percentMg= (o.getBilan().getMargeSurCoutV()/o.getBilan().getCA())*100;
		    
		    	salesLabel1.setText(String.valueOf(o.getBilan().getCA()));
		      	CVLabel.setText(String.valueOf(o.getBilan().getCV()));
		    	percentCVLabel.setText(String.valueOf(percentCV)+"%");
		    	MgLabel.setText(String.valueOf(o.getBilan().getMargeSurCoutV()));
		    	percentMgLabel.setText(String.valueOf(percentMg)+"%");
		    	CFLabel.setText(String.valueOf(o.getBilan().getCF()));
		    	resultLabel1.setText(String.valueOf(o.getBilan().getResult()));
		    	SRLabel.setText(String.valueOf(o.getBilan().getSR()));
		    	fondDeRoulmntLabel.setText(String.valueOf(o.getBilan().getFR()));
			 
	    }
	    
	
	    @FXML
	    void btnbackanchor3To2(ActionEvent event) {

	   	 anchor3.setVisible(false);
		 anchor2.setVisible(true);
		 
		 
	    	
	    }
	    
	    
	  

	
}	
