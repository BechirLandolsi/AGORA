package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.util.Duration;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectService;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * FXML Controller class
 *
 * @author bn
 */
public class ProjectController implements Initializable {

    @FXML
    private JFXButton btnajouter;
    @FXML
    private TableView<Project> tab_project;
    
    @FXML
    private TableColumn<Project, Integer> col_project;
    @FXML
    private TableColumn<Project, String> col_service;
    
    /**
     * Initializes the controller class.
     */
    
	 private ObservableList<Project> listproject = FXCollections.observableArrayList();
	 ProjectService oe = new ProjectService();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   	 System.out.println("erffff");
   	 
   	String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ProjectService!tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote" ; 
	
	Context context;
	try {

		context = new InitialContext();
		ProjectRemote proxy = (ProjectRemote) context.lookup(jndiName1);
		
			listproject = FXCollections.observableArrayList(proxy.getAllProject());
    	
 	      col_project.setCellValueFactory(new PropertyValueFactory<>("id"));
    	  col_project.cellFactoryProperty();

         
    	  col_service.setCellValueFactory(new PropertyValueFactory<>("service"));
    	  col_service.cellFactoryProperty();

    	      	  
    	  tab_project.setItems(listproject); 
    	  
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    	
    	
    }    

    @FXML
    private void btnajouter(ActionEvent event) {
    }
 
    
    
    
}
