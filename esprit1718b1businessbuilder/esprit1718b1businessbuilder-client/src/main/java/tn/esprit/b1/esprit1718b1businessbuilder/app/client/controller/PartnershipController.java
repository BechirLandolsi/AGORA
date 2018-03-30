package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Bilan;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Partnership;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;
import tn.esprit.b1.esprit1718b1businessbuilder.services.BilanRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.PartnershipRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Spinner;
import javafx.scene.control.SplitMenuButton;
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

import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author bn
 */
public class PartnershipController implements Initializable {

	 @FXML
	    private JFXComboBox<String> sectorcombo;

	    @FXML
	    private JFXComboBox<String> companiescombo;

	 
	    
/***********************************************************************************************************************/
	    
	    
		 String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 
		 Context context1;
		 
		 private ObservableList<Project> sectors = FXCollections.observableArrayList();
		 CompanyService oe = new CompanyService();
		 
		// static String sector;

		 
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
		   	context1 = new InitialContext();
		   	CompanyServiceRemote proxy = (CompanyServiceRemote) context1.lookup(jndiName1);
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
	
	
	 @FXML
	    void help(MouseEvent event) throws NamingException {
		 
		 
		  
		   	String sector= sectorcombo.getValue();
		   	
		   	//System.out.println(sector);
		   
		   context1 = new InitialContext();
		   CompanyServiceRemote proxy = (CompanyServiceRemote) context1.lookup(jndiName1);
		
		   ObservableList<String> companies = FXCollections.observableArrayList(proxy.FindBySector(sector));
				companiescombo.setItems(companies);
		 

	    }


	 
	

	
}	
