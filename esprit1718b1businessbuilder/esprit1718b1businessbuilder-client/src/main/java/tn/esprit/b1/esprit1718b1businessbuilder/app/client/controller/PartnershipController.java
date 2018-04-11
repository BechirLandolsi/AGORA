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

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.NoResultException;

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
/***********************************************************************************************************************/
	    
	    
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
		   // pieChart1.setLegendSide(Side.LEFT);
		    pieChart1.setData(pieChartData);
		 
		    
	     
		    }
		    
	
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
		 
		 String sector;
		 
		    if(sectorcombo.getValue()!="")
		    {
		   	 	
		   	//System.out.println(sector);
		   
		    	sector=sectorcombo.getValue();
		    	
		    	Company company =proxy.findBy(loggedcompany.getId());
		    	System.out.println(company);
	
	
	
	//ObservableList<String> Allcompaniesname = FXCollections.observableArrayList(proxy.findAllCompanyNames());

		    	ObservableList<String> Allcompanies = FXCollections.observableArrayList(proxy.FindBySector(sector));

		    			
		    for(String c : Allcompanies) 
		    {
		    	
		    			       if(company.getName().equals(c)) {
		    			        	
		    			    	    System.out.println("name==name");
		    			        	Allcompanies.remove(company.getName());
		    			        	
		    			          
		    			        }
		    			        
		    }
		    			       companiescombo.setItems(Allcompanies);
		    			 	
		    	

				//companiescombo.setItems(Allcompanies);
				
				/*companynameLabel.setVisible(true);
				ProjectsLabel.setVisible(true);
				has.setVisible(true);
				nbrprojLabel.setVisible(true);*/
				
				companynameLabel.setText(companiescombo.getValue());
			    
				companypartner = new Company();
				companypartner = proxy.findAllCompanyByName(companynameLabel.getText());
				
								
				List <Long> nbrL = new ArrayList<>();
				nbrL = proxy2.countProjectsByCompanyName(companypartner);
				
				
				
				if(nbrL.isEmpty())
				
				{
					System.err.println("empty");
				}
				
				else{	
				nbrprojLabel.setText(String.valueOf(nbrL.get(0)));
				
				companynameLabel.setVisible(true);
				ProjectsLabel.setVisible(true);
				has.setVisible(true);
				nbrprojLabel.setVisible(true);
				
			
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
		    	  
		    	  //System.out.println("aaaaaaaaaaaaaaaaaaaaa");
		    	  PieChart(companypartner);
				
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
	  
	  
	  public void envoyer(String pwd, String mail)
      {
          Properties props = new Properties();
          props.put("mail.smtp.auth", "true");
          props.put("mail.smtp.starttls.enable", "true");
          props.put("mail.smtp.host", "smtp.gmail.com");
          props.put("mail.smtp.port", "587");
          
          Session session = Session.getInstance(props,new javax.mail.Authenticator(){
              protected PasswordAuthentication getPasswordAuthentication(){
                  return new PasswordAuthentication("tesnim.dahmeni@esprit.tn", "22121995missou");
              }
          }); 
          try
          {
              Message message = new MimeMessage(session);
              message.setFrom(new InternetAddress("tesnim.dahmeni@esprit.tn"));
              message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
              message.setSubject("Salut");
              message.setText("coucou");
              Transport.send(message);
              Notifications nb = Notifications.create().darkStyle().hideAfter(Duration.seconds(5)).title("Logout")
                      .text("Mail sent successfully !");
                    
              nb.showConfirm();
   
          }
          catch(MessagingException e){
              
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                      alert.setTitle("Failure to send");
                      alert.setHeaderText("Please check your informations !!");

                      alert.showAndWait();
                  
               }      
          
      }
	  
	  
	    @FXML
	    void btnpartner(ActionEvent event) throws NamingException {
	    	
	    	context1 = new InitialContext();
			   CompanyServiceRemote proxy = (CompanyServiceRemote) context1.lookup(jndiName1); 	
	       	Company c =proxy.findBy(loggedcompany.getId());
	    	context4 = new InitialContext();
			   PartnershipRemote proxy2 = (PartnershipRemote) context4.lookup(jndiName4);
			   Partnership part = new Partnership();
			  
			if (part!=null && companypartner!=null  ) {
			}
			
			  
			Calendar cal = Calendar.getInstance();
	       //sdf.format(cal.getTime());
		        
			   {   part.setPartnershipDate(cal.getTime());
				   proxy2.addPartner(part,c, companypartner, projectController.o); 
			   
				   Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			         //alert.initOwner(adresse.getScene().getWindow());
			         alert.setTitle("Confirmation");
			         alert.setHeaderText(null);
			         alert.setContentText("Partner request sent");
			         alert.showAndWait();
			         
			   
	    	/**********************************************************************************************/
	                       
	                String mail="tesnim.dahmeni@esprit.tn";
	                String pwd ="22121995missou";    
	                
	         
	           
	              //  envoyer(pwd,mail);
			   
			   
	    	/* Mail emailS = new Mail();
	         String[] to = {companypartner.getEmail()};
	        String adresse = c.getEmail();
	         System.out.println(adresse);
	         String subject = "partnership request";
	         String messageText = "Dear Sir/Madam\n Each year we work with more than 100 companies from all over the "
	+ "world, and it will an honor to work with you on our new project\n At your request I can send you our company's "
	+ "introductory profile in PDFformat for your perusal."
	+ "\n Thank you very much, and we hope to receive your favorably response soon.Best regards";

	         if (emailS.sendMail(adresse,c.getPassword(), messageText, subject, to)) {
	         }
	         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	         //alert.initOwner(adresse.getScene().getWindow());
	         alert.setTitle("Confirmation");
	         alert.setHeaderText(null);
	         alert.setContentText("Email Envoyer Avec Succées ");
	         alert.showAndWait().ifPresent(response -> {
	             if (response == ButtonType.OK) {

	             }
	         }); */

			         }
	 
	    }
	  

	
}	
