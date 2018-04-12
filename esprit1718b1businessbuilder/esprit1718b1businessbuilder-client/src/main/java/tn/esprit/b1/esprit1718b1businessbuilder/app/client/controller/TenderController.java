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
    /**
     * Initializes the controller class.
     */
    
    String jndiNameTender="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/TenderService!tn.esprit.b1.esprit1718b1businessbuilder.services.ITender";
    @FXML
    private Tab MyTenders;
    @FXML
    private Pane paneVbox;
    
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
        
        VBox v = new VBox();
        v.setPadding(new Insets(10, 50, 50, 50));
        v.setSpacing(10);
        int i =0;
        
        
        do{
        	Label qualif = new Label();
        	Label status = new Label();
        	
        	qualif.setText(qualifications.get(i).getNameQualification());
        	qualif.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        	
        	v.getChildren().add(qualif);
           
           
            status.setText("status");
            status.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            
            v.getChildren().add(status);
            i=i+1;
        }while (i<nbrQualif);
        
        
     
        paneVbox.getChildren().add(v);
        
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
