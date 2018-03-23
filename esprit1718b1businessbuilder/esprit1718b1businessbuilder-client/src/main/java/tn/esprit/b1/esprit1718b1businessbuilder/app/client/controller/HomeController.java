/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;

import org.controlsfx.control.textfield.TextFields;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;

import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;


/**
 * FXML Controller class
 *
 * @author PEAR
 */
public class HomeController implements Initializable {

    @FXML
    private JFXButton btnSearch;
    @FXML
    private TextField search;

   
    @FXML
    private ListView<Company> list_company;

    private ObservableList<Company> cplist ;
    private List<String> cplistname  = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   	 FXMLLoader lloader = new FXMLLoader(getClass().getResource("../gui/Main.fxml"));
     try {
         Parent rroot = lloader.load();
     } catch (IOException ex) {
        
     }
    	    String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 	
			CompanyServiceRemote proxy;
			try {
				 Context	context = new InitialContext();
				proxy = (CompanyServiceRemote) context.lookup(jndiName1);
				cplist = FXCollections.observableArrayList(proxy.findAllCompany());
			} catch (NamingException e) {
				e.printStackTrace();
			}
	 		list_company.setItems(cplist);
	 		list_company.setCellFactory(new Callback<ListView<Company>, javafx.scene.control.ListCell<Company>>()
	        {
				@Override
				public ListCell<Company> call(ListView<Company> param) {
					 return new CompanyRowController();
				}
	        });
	 		
	 		/****************************************************************/
	 		
	 		
	 		String jndiName2 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 	
			 CompanyServiceRemote proxy2;
			 Context context;
			try {
				context = new InitialContext();
				 proxy = (CompanyServiceRemote) context.lookup(jndiName2);
				 cplistname = FXCollections.observableArrayList(proxy.findAllCompanyNames());
				 //System.out.println(cplistname.toString());
				 
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 TextFields.bindAutoCompletion(search, cplistname) ; 
    }    

    @FXML
    private void makeSearch(ActionEvent event) throws NamingException {
    	String str = search.getText() ;
    	if (!str.equals("") ){
    		String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 	
    		CompanyServiceRemote proxy;
    	
    			 Context	context = new InitialContext();
    			proxy = (CompanyServiceRemote) context.lookup(jndiName1);
    			cplist = FXCollections.observableArrayList(proxy.findAllCompanyByName(search.getText()));
    			System.out.println(cplist.toString());
    	
     		list_company.setItems(cplist);
     		list_company.setCellFactory(new Callback<ListView<Company>, javafx.scene.control.ListCell<Company>>()
            {
    			@Override
    			public ListCell<Company> call(ListView<Company> param) {
    				 return new CompanyRowController();
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
	 		list_company.setItems(cplist);
	 		list_company.setCellFactory(new Callback<ListView<Company>, javafx.scene.control.ListCell<Company>>()
	        {
				@Override
				public ListCell<Company> call(ListView<Company> param) {
					 return new CompanyRowController();
				}
	        });
	 		
    	}
    	
    	 
    } 
    
}
