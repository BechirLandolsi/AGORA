package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import java.io.IOException;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TitledPane;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.UserServiceRemote;


public class ProfileController implements Initializable  {

	private static double progress1 = 0;
    private static double progress2 = 0;
    private static double progress3 = 0;
    private static double progress4 = 0;
    private static double progress5 = 0;
    private static double progress6 = 0;
    private static double progress7 = 0;
    private static double progress8 = 0;
    private static double progress9 = 0;
    private static double progress10 = 0;
	@FXML
    private TitledPane missing;
	
	@FXML
    private TitledPane update;
	
	@FXML
    private JFXButton submit;

    @FXML
    private JFXTextField adress;

    @FXML
    private JFXTextField ceo;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField nbr;

    @FXML
    private JFXDatePicker date;

    @FXML
    private JFXTextField ref;
    
    @FXML
    private ProgressBar progressPersonal;

    @FXML
    private Label lblComplete;

    @FXML
    private JFXComboBox<String> sector;
    private ObservableList <String> list = FXCollections.observableArrayList(
			"Secteur agricole",
			"Secteur agroalimentaire",
			"Secteur bancaire et financier",
			"Secteur de l'énergie",
			" Secteur de l'information",
			"Secteur de la communication et des médias",
			"Secteur de la distribution",
			"Secteur de la recherche",
			"Secteur de la santé",
			"Secteur des constructions mécaniques",
			"Secteur des industries chimiques",
			"Secteur des loisirs et du tourisme",
			"Secteur des matières premières",
			"Secteur des services",
			"Secteur des transports",
			"Secteur du bâtiment",
			"Secteur électronique",
			"Secteur informatique",
			"Secteur métallurgique",
			"Secteur textile") ;
    
    User logged = LoginController.LoggedUser ;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	   String jndiNameCategory ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/UserService!tn.esprit.b1.esprit1718b1businessbuilder.services.UserServiceRemote";
	   Context context = null;
	   User logged = LoginController.LoggedUser ;
	   DecimalFormat decimalFormat = new DecimalFormat("###.#");
	   decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
	   progress10= logged.getProgress()/100;
	   progressPersonal.setProgress(progress10);
	   lblComplete.setText(decimalFormat.format(progress10 * 100) + "% complete");
	    if ( logged.getProgress() < 100.0) {
	    	missing.setVisible(true);
	    
	    	updateProgress2();
	    } 
	    else {
	    	update.setVisible(true);
	    }
	    /***********************************************************************************************/
		sector.setItems(list);
		/***********************************************************************************************/
		
		
	}
	
	 public Double updateProgress2() {
		    DecimalFormat decimalFormat = new DecimalFormat("###.#");
		    decimalFormat.setRoundingMode(RoundingMode.HALF_UP);

		    //progressPersonal.setProgress(0.00);       
		    double sum_progress = progress10 + progress1 + progress2 + progress3 + progress4 + progress5 + progress6 + progress7 + progress8 + progress9;
		    
		    name.textProperty().addListener(new ChangeListener<String>() {	
		        @Override
		        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		            if (!newValue.isEmpty()) {
		                progress1 = 0.1;

		            } else {
		                progress1 = 0.0;

		            }
		            double sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5 + progress6 + progress7 + progress8 + progress9);
		            progressPersonal.setProgress(sum);
		            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
		        }
		    });
		    
		    ref.textProperty().addListener(new ChangeListener<String>() {	
		        @Override
		        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		            if (!newValue.isEmpty()) {
		                progress2 = 0.1;

		            } else {
		                progress2 = 0.0;

		            }
		            double sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5 + progress6 + progress7 + progress8 + progress9);
		            progressPersonal.setProgress(sum);
		            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
		        }
		    });
		    
		    ceo.textProperty().addListener(new ChangeListener<String>() {	
		        @Override
		        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		            if (!newValue.isEmpty()) {
		                progress3 = 0.1;

		            } else {
		                progress3 = 0.0;

		            }
		            double sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5 + progress6 + progress7 + progress8 + progress9);
		            progressPersonal.setProgress(sum);
		            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
		        }
		    });
		    adress.textProperty().addListener(new ChangeListener<String>() {	
		        @Override
		        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		            if (!newValue.isEmpty()) {
		                progress4 = 0.1;

		            } else {
		                progress4 = 0.0;

		            }
		            double sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5 + progress6 + progress7 + progress8 + progress9);
		            progressPersonal.setProgress(sum);
		            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
		        }
		    });
		    nbr.textProperty().addListener(new ChangeListener<String>() {	
		        @Override
		        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		            if (!newValue.isEmpty()) {
		                progress5 = 0.1;

		            } else {
		                progress5 = 0.0;

		            }
		            double sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5 + progress6 + progress7 + progress8 + progress9);
		            progressPersonal.setProgress(sum);
		            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
		        }
		    });
		    sector.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {	
		        @Override
		        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		            if (!newValue.isEmpty()) {
		                progress6 = 0.1;

		            } else {
		                progress6 = 0.0;

		            }
		            double sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5 + progress6 + progress7 + progress8 + progress9);
		            progressPersonal.setProgress(sum);
		            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
		        }
		    });
			return sum_progress*100;
		    
	 }
	
	  @FXML
	  private void submitbtn(ActionEvent event) throws NamingException {

	    String jndiNameCategory ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote";
	    Context context = new InitialContext();
	    CompanyServiceRemote proxyCategory = (CompanyServiceRemote) context.lookup(jndiNameCategory);
	    
	      Company c =proxyCategory.findBy(logged.getId());
	      
	      c.setName(name.getText());
	      c.setAdress(adress.getText());
	      c.setCEO(ceo.getText());
	     // int i1 = Integer.parseInt(nbr.getText()); 
	      c.setNumber(Long.parseLong(nbr.getText()));
	      c.setReference(ref.getText());
	      c.setSector(sector.getValue());	      
	      proxyCategory.add(c);
	      
	 }
	
	

}
