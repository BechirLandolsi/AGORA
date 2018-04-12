/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import com.jfoenix.controls.JFXButton;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.controlsfx.control.Rating;
import tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller.TenderRowController;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Tender;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderQualification;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ITender;
/**
 * FXML Controller class
 *
 * @author Beshir
 */
public class TenderController implements Initializable {

    @FXML
    private TextField search;
    @FXML
    private JFXButton btnSearch;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblPhone;
    @FXML
    private Label lblLocation;
    @FXML
    private ListView<Tender> list_Tenders;
     @FXML
    private ListView<Tender> My_tenders;
    
    private ObservableList<Tender> tendersList;
    private ObservableList<Tender> myTendersList;
    
    private static Company entreprise;
    
    private static List<TenderQualification> qualifications;

    public static Company getEntreprise() {
        return entreprise;
    }

    public static void setEntreprise(Company entreprise) {
        TenderController.entreprise = entreprise;
    }
    
    public static List<TenderQualification> getQualifications() {
		return qualifications;
	}



	public static void setQualifications(List<TenderQualification> qualifications) {
		TenderController.qualifications = qualifications;
	}
	
    @FXML
    private ImageView logoCompany;
    @FXML
    private Rating CompanyRate;
    @FXML
    private JFXButton getDetails;
    @FXML
    private JFXButton post;
    
    public static StackPane mainRootPane;
    private StackPane rootPane;
    
    final Tooltip tooltip = new Tooltip();
    /**
     * Initializes the controller class.
     */
    
    String jndiNameTender="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/TenderService!tn.esprit.b1.esprit1718b1businessbuilder.services.ITender";
    @FXML
    private Tab MyTenders;
    @FXML
    private Label status1;
    @FXML
    private Label status2;
    @FXML
    private Label status3;
    @FXML
    private Label sttatus4;
    @FXML
    private Label status5;
    @FXML
    private Label sameCountry;
    @FXML
    private Label has4stars;
    @FXML
    private Label has3stars;
    @FXML
    private Label has3projects;
    @FXML
    private Label has80profile;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	User loggedUser = LoginController.LoggedUser ;
    	
         ITender proxy;
		try {
			 Context context = new InitialContext();
			proxy = (ITender) context.lookup(jndiNameTender);
			
			tendersList = FXCollections.observableArrayList(proxy.findAll()).sorted(Comparator.comparing(Tender::getPublishedDate).reversed());

		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		list_Tenders.setItems(tendersList);
 		list_Tenders.setCellFactory(new Callback<ListView<Tender>, javafx.scene.control.ListCell<Tender>>()
        {
			@Override
			public ListCell<Tender> call(ListView<Tender> param) {
				 return new TenderRowController();
			}
			
        });
                
    }    

    @FXML
    private void Search(KeyEvent event) throws NamingException {
    	
    	
        ITender proxy;
        Context context = new InitialContext();
        proxy = (ITender) context.lookup(jndiNameTender);
        
        if (event.getCode().equals(KeyCode.ENTER))
        {
        	if(search.getText().isEmpty() || search.getText().equals(" ")){
        		tendersList = FXCollections.observableArrayList(proxy.findAll()).sorted(Comparator.comparing(Tender::getPublishedDate).reversed());
        	}
        	else{
        		tendersList = FXCollections.observableArrayList(proxy.findAll()).filtered(t->t.getTitle().toLowerCase().contains(search.getText().toLowerCase()) 
    					|| t.getCompanyTender().getName().toLowerCase().equals(search.getText().toLowerCase()))
    					.sorted(Comparator.comparing(Tender::getPublishedDate).reversed());
        	}
    			 				
    		list_Tenders.setItems(tendersList);
     		list_Tenders.setCellFactory(new Callback<ListView<Tender>, javafx.scene.control.ListCell<Tender>>()
            {
    			@Override
    			public ListCell<Tender> call(ListView<Tender> param) {
    				 return new TenderRowController();
    			}
    			
            });
        }
      }

    @FXML
    private void doSearch(ActionEvent event) throws NamingException {
    	
    	 ITender proxy;
        Context context = new InitialContext();
        proxy = (ITender) context.lookup(jndiNameTender);
        
    	if(search.getText().isEmpty() || search.getText().equals(" ")){
    		tendersList = FXCollections.observableArrayList(proxy.findAll()).sorted(Comparator.comparing(Tender::getPublishedDate).reversed());
    	}
    	else{
    		tendersList = FXCollections.observableArrayList(proxy.findAll()).filtered(t->t.getTitle().toLowerCase().contains(search.getText().toLowerCase())
    				|| t.getCompanyTender().getName().toLowerCase().equals(search.getText().toLowerCase()))
    				.sorted(Comparator.comparing(Tender::getPublishedDate).reversed());
    	}
			 				
		list_Tenders.setItems(tendersList);
 		list_Tenders.setCellFactory(new Callback<ListView<Tender>, javafx.scene.control.ListCell<Tender>>()
        {
			@Override
			public ListCell<Tender> call(ListView<Tender> param) {
				 return new TenderRowController();
			}
			
        });
          
    }

    @FXML
    private void getDetails(ActionEvent event){
    	
    	
    	Company loggedUser = (Company)LoginController.LoggedUser ;
    	entreprise=TenderRowController.getEntreprise();
    	qualifications=TenderRowController.getQualifications();
    	int nbrQualif = TenderRowController.getNbrQualif();

    	lblLocation.setText(entreprise.getAdress());
    	lblEmail.setText(entreprise.getEmail());
    	lblPhone.setText(entreprise.getNumber().toString());
    	CompanyRate.setRating(entreprise.getRate());
    	
 	
    	File file = new File("D:/Users/Beshir/Documents/MEGA/Esprit/4Info_B/Semestre 2/JEE Project/Agora/esprit1718b1businessbuilder/esprit1718b1businessbuilder/esprit1718b1businessbuilder-client/target/classes/tn/esprit/b1/esprit1718b1businessbuilder/app/client/images/" + entreprise.getImage());
        Image logo = new Image(file.toURI().toString());
        logoCompany.setImage(logo);
        
        for(int i=0;i<=nbrQualif;i++){
        	switch (qualifications.get(i).getNameQualification()){
        		case "Same Country" :
        			if(entreprise.getAdress().equals(loggedUser.getAdress())){
        				status1.setText("Yes");
        				status1.setStyle("-fx-background-color: #37a000;");
        				tooltip.setText("You meet this qualification");
        				status1.setTooltip(tooltip);
        			}
        			else{
        				status1.setText("No");
        				status1.setStyle("-fx-background-color: #FF0000;");
        				tooltip.setText("You don't meet this qualification");
        				status1.setTooltip(tooltip);
        			}
        			break;
        		case "Has at least 4 stars" :
        			if(loggedUser.getRate()==4){
        				status2.setText("Yes");
        				status2.setStyle("-fx-background-color: #37a000;");
        				tooltip.setText("You meet this qualification");
        				status2.setTooltip(tooltip);
        			}
        			else{
        				status2.setText("No");
        				status2.setStyle("-fx-background-color: #FF0000;");
        				tooltip.setText("You don't meet this qualification");
        				status2.setTooltip(tooltip);
        			}
        			break;
        		case "Has at least 3 stars" :
        			if(loggedUser.getRate()==3){
        				status3.setText("Yes");
        				status3.setStyle("-fx-background-color: #37a000;");
        				tooltip.setText("You meet this qualification");
        				status3.setTooltip(tooltip);
        			}
        			else{
        				status3.setText("No");
        				status3.setStyle("-fx-background-color: #FF0000;");
        				tooltip.setText("You don't meet this qualification");
        				status3.setTooltip(tooltip);
        			}
        			break;
        		case "Has worked on 3 projects" :
        			if(loggedUser.getRate()==3){
        				sttatus4.setText("Yes");
        				sttatus4.setStyle("-fx-background-color: #37a000;");
        				tooltip.setText("You meet this qualification");
        				sttatus4.setTooltip(tooltip);
        			}
        			else{
        				sttatus4.setText("No");
        				sttatus4.setStyle("-fx-background-color: #FF0000;");
        				tooltip.setText("You don't meet this qualification");
        				sttatus4.setTooltip(tooltip);
        			}
        			break;
        		case "At least 80% reached on profile" :
        			if(loggedUser.getProgress()>=80){
        				status5.setText("Yes");
        				status5.setStyle("-fx-background-color: #37a000;");
        				tooltip.setText("You meet this qualification");
        				status5.setTooltip(tooltip);
        			}
        			else{
        				status5.setText("No");
        				status5.setStyle("-fx-background-color: #FF0000;");
        				tooltip.setText("You don't meet this qualification");
        				status1.setTooltip(tooltip);
        			}
        			break;
        		
        	}
        }
        
    }

    @FXML
    private void onPostCliked(ActionEvent event) {
    	
    	setStage("../gui/AddMyTender.fxml");
    }

    @FXML
    private void getMyTenders(Event event) {
    	User loggedUser = LoginController.LoggedUser ;
    	
        ITender proxy;
		try {
			 Context context = new InitialContext();
			proxy = (ITender) context.lookup(jndiNameTender);
			
			
			myTendersList=FXCollections.observableArrayList(proxy.findAll()).filtered(t->t.getCompanyTender().equals(loggedUser))
                               .sorted(Comparator.comparing(Tender::getPublishedDate).reversed());
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
               
               My_tenders.setItems(myTendersList);
               My_tenders.setCellFactory(new Callback<ListView<Tender>, javafx.scene.control.ListCell<Tender>>()
       {
			@Override
			public ListCell<Tender> call(ListView<Tender> param) {
				 return new MyTendersRowController();
			}
			
       });
    }
    
    private void setStage(String fxml) {
        try {
            //dim overlay on new stage opening
            Region veil = new Region();
            veil.setPrefSize(1100, 650);
            veil.setStyle("-fx-background-color:rgba(0,0,0,0.3)");
            Stage newStage = new Stage();
            Parent parent = FXMLLoader.load(getClass().getResource(fxml));
            
            Scene scene = new Scene(parent);
            scene.setFill(Color.TRANSPARENT);
            newStage.setScene(scene);
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.initStyle(StageStyle.TRANSPARENT);
            newStage.getScene().getRoot().setEffect(new DropShadow());
            newStage.showingProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue) {
                    rootPane.getChildren().add(veil);
                } else if (rootPane.getChildren().contains(veil)) {
                    rootPane.getChildren().removeAll(veil);
                }
                
            });
            newStage.centerOnScreen();
            newStage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
   
}
