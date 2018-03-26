package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Partnership;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;
import tn.esprit.b1.esprit1718b1businessbuilder.services.PartnershipRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author bn
 */
public class ProjectController implements Initializable {

    @FXML
    private JFXButton btnajouter;
    
    @FXML
    private JFXButton btnajouterpartner;
    
    
    @FXML
    private JFXButton btnajouterproject;
    
    @FXML
    private TableView<Project> tab_project;
    
    @FXML
    private TableColumn<Integer, Integer> col_project;
    @FXML
    private TableColumn<Project, String> col_name;
    @FXML
    private TableColumn<Project, String> col_service;
   
    @FXML
    private AnchorPane anchor1;

    @FXML
    private Label partnerLabel;


    @FXML
    private AnchorPane anchor2;

    @FXML
    private JFXTextField projectnameEntry;

    @FXML
    private JFXComboBox <String> servicecombobox;

    @FXML
    private RadioButton radio1;

    @FXML
    private RadioButton radio2;
    
    @FXML
    private JFXTextField purchase;

    @FXML
    private JFXTextField salaire;

    @FXML
    private JFXTextField energycost;

    @FXML
    private JFXTextField transpcost;

    @FXML
    private JFXTextField interestonloans;

    @FXML
    private JFXTextField rentcost;

    @FXML
    private JFXComboBox <String> natureproectcombobox;
    

    @FXML
    private JFXTextField price;
    
    @FXML
    private Label remplirLabel;
    
    @FXML
    private JFXTextField stock;

    @FXML
    private Label stockLabel;
    
    
    
    /**
     * Initializes the controller class.
     */
    
	 private ObservableList<Project> listproject = FXCollections.observableArrayList();
	 ProjectService oe = new ProjectService();

	 
	 String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ProjectService!tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote" ; 
	 Context context1;
	 
	 String jndiName2 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/PartnershipService!tn.esprit.b1.esprit1718b1businessbuilder.services.PartnershipRemote" ; 
	 Context context2;
	 
	 String jndiName3 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ServiceService!tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote" ; 
	 Context context3;
	 
	 Company c = null;
	 
	 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   	
   	 
   	
	try {

		context1 = new InitialContext();
		ProjectRemote proxy = (ProjectRemote) context1.lookup(jndiName1);
		
		  listproject = FXCollections.observableArrayList(proxy.getProjectsByCompany(16));
    	
 	      col_project.setId("1");;
    	  col_project.cellFactoryProperty();

    	  col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
    	  col_name.cellFactoryProperty();
         
    	  col_service.setCellValueFactory(new PropertyValueFactory<>("service"));
    	  col_service.cellFactoryProperty();
    	     	  
    	  tab_project.setItems(listproject); 
    	  
	} catch (NamingException e) {
		
		e.printStackTrace();
	}
    	
    	
    }    


    @FXML
    void tableclick(MouseEvent event) {

    	if (tab_project.getSelectionModel().getSelectedItem() != null) {
            Project o = tab_project.getSelectionModel().getSelectedItem();
           
            Long id = o.getId();
           try {
            context2 = new InitialContext();
            
            PartnershipRemote proxy = (PartnershipRemote) context2.lookup(jndiName2);
    		
    		String name =proxy.getPartnerByProject(id);
    		
    		partnerLabel.setText(name);

    	} catch (NamingException e) {
    		
    		e.printStackTrace();
    	}
    		
        }
		
    	
    }
    
    
    @FXML
    void btnajouter(ActionEvent event) {
    	
    	anchor1.setVisible(false);
    	anchor2.setVisible(true);
    
     ObservableList<String> natureprojectList = FXCollections.observableArrayList();
     natureprojectList.add("Cration");
     natureprojectList.add("Recovery");
     natureproectcombobox.setItems(natureprojectList);
     	 
    	try {
   	context3 = new InitialContext();
   	ServiceServiceRemote proxy = (ServiceServiceRemote) context3.lookup(jndiName3);
   	ObservableList<String> comboList = FXCollections.observableArrayList(proxy.getName());
   	servicecombobox.setItems(comboList);
    
    	}
    	catch (NamingException e)
    	{
    		e.printStackTrace();
    		
    	}
    	
    	
    }
    
    
    @FXML
    void btnajouterproject(ActionEvent event) {
    	
    	Project p = new Project();
    	Company c = new Company();
    	c.setId((long) 16);
    	
    	p.setName(projectnameEntry.getText());
    	p.setProjectNature(natureproectcombobox.getValue());
    	p.setService(servicecombobox.getValue());
    	p.setStock(Integer.parseInt(stock.getText()));
    	p.setPriceUnit(Float.parseFloat(price.getText()));
    	p.setPurchase(Float.parseFloat(purchase.getText()));
    	p.setEnergyCost(Float.parseFloat(energycost.getText()));
    	p.setTransportCost(Float.parseFloat(transpcost.getText()));
    	p.setEmployeeSalaire(Float.parseFloat(salaire.getText()));
    	p.setInterestOnLoans(Float.parseFloat(interestonloans.getText()));
    	p.setRentCost(Float.parseFloat(rentcost.getText()));
    	p.setProjectOwner(c);
    	
    	try {

    		context1 = new InitialContext();
    		ProjectRemote proxy = (ProjectRemote) context1.lookup(jndiName1);
    		
    		proxy.addProject(p);
    	
    	}
    	catch(NamingException e)
    	{
    		e.printStackTrace();
    	}
    		
    		
    }
    	
    	
    	
    @FXML
    void btnajouterpartner(ActionEvent event) {
    	
    }
   

    @FXML
    void floatkey1(KeyEvent event) {
    	
        if( (price.getText().trim().length()>0) )
        		{
         try {
            float i1 = Float.parseFloat(price.getText());
                    
             }
         catch (NumberFormatException e) {
            remplirLabel.setVisible(true);
            remplirLabel.setText("Please enter numerical values");
            }
        }
        
        else{
        	remplirLabel.setVisible(false);
            }
    	
    	

    }
    
    @FXML
    void floatkey2(KeyEvent event) {
    	
        if( (purchase.getText().trim().length()>0) )
        		{
         try {
            
            float i2 = Float.parseFloat(purchase.getText());
            
             }
         catch (NumberFormatException e) {
            remplirLabel.setVisible(true);
            remplirLabel.setText("Please enter numerical values");
            }
        }
        
        else{
        	remplirLabel.setVisible(false);
            }
    }
    
    
    @FXML
    void floatkey3(KeyEvent event) {
    	
        if( (energycost.getText().trim().length()>0) )
        		{
         try {
          
            float i3 = Float.parseFloat(energycost.getText());
           
             }
         catch (NumberFormatException e) {
            remplirLabel.setVisible(true);
            remplirLabel.setText("Please enter numerical values");
            }
        }
        
        else{
        	remplirLabel.setVisible(false);
            }
    }
    
    
    @FXML
    void floatkey4(KeyEvent event) {
    	
        if( (transpcost.getText().trim().length()>0) )
        		{
         try {
           
            float i4 = Float.parseFloat(transpcost.getText());
            
             }
         catch (NumberFormatException e) {
            remplirLabel.setVisible(true);
            remplirLabel.setText("Please enter numerical values");
            }
        }
        
        else{
        	remplirLabel.setVisible(false);
            }
    }
    
   
    
@FXML
void floatkey5(KeyEvent event) {
	
    if( salaire.getText().trim().length()>0 )
    		{
     try {
       
        float i5 = Float.parseFloat(salaire.getText());

        
         }
     catch (NumberFormatException e) {
        remplirLabel.setVisible(true);
        remplirLabel.setText("Please enter numerical values");
        }
    }
    
    else{
    	remplirLabel.setVisible(false);
        }
}


@FXML
void floatkey6(KeyEvent event) {
	
    if( interestonloans.getText().trim().length()>0 )
    		{
     try {
        
        float i6 = Float.parseFloat(interestonloans.getText());        
         }
     catch (NumberFormatException e) {
        remplirLabel.setVisible(true);
        remplirLabel.setText("Please enter numerical values");
        }
    }
    
    else{
    	remplirLabel.setVisible(false);
        }
}


@FXML
void floatkey7(KeyEvent event) {
	
    if( (rentcost.getText().trim().length()>0) )
    		{
     try {
       
        float i7 = Float.parseFloat(rentcost.getText());
        
         }
     catch (NumberFormatException e) {
        remplirLabel.setVisible(true);
        remplirLabel.setText("Please enter numerical values");
        }
    }
    
    else{
    	remplirLabel.setVisible(false);
        }
}

@FXML
void floatkey8(KeyEvent event) {
	
    if( (stock.getText().trim().length()>0) )
    		{
     try {
       
        int i7 = Integer.parseInt(stock.getText());
        
         }
     catch (NumberFormatException e) {
        stockLabel.setVisible(true);
        stockLabel.setText("Please enter an integer number");
        }
    }
    
    else{
    	stockLabel.setVisible(false);
        }
}
    
    
    
 
    
    
    
}
