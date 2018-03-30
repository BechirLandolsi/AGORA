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
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


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
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Reserche;


import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote;


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
    @FXML
    private ListView<Produit> list_Recommandation;
    
    
    

  
    //private ObservableList<String> cplist3s ;
    private ObservableList<Company> cplist ;
    private Set<Company> hs = new HashSet<Company>();
    private ObservableList<Company> cplistservice ;
    private List<String> cplistname  = new ArrayList<>();
    private List<String> listservice  = new ArrayList<>();
    private List<String> cplist3s  = new ArrayList<>();
    private List<Company> test  = new ArrayList<>();
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	/////////////////////////////////////INITIALIZATION DES COMPANIES///////////////////////////////////////////////
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
	 		
	 		/*******************************autocomplete*********************************/
	 		
	 		
	 		String jndiName2 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 	
			 CompanyServiceRemote proxy2;
			 Context context;
			 Context contexts;
			
			 String jndiNames ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ServiceService!tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote" ; 
				
			try {
				 context = new InitialContext();
				 proxy = (CompanyServiceRemote) context.lookup(jndiName2);
				
				 contexts = new InitialContext();
				 ServiceServiceRemote proxys = (ServiceServiceRemote) contexts.lookup(jndiNames);
					
				 cplistname = FXCollections.observableArrayList(proxy.findAllCompanyNames());
				 listservice =FXCollections.observableArrayList(proxys.getAllService());
				 cplistname.addAll(listservice);
				 
				// cplistname.addAll(listservice) ;
				 //System.out.println(cplistname.toString());
				 
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 TextFields.bindAutoCompletion(search, cplistname) ; 
	
	    		    	 
    }    

    @FXML
    private void makeSearch(ActionEvent event) throws NamingException {
    	String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 	
    	String jndiNames ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ServiceService!tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote" ; 
    	CompanyServiceRemote proxy;
		Context	context1 = new InitialContext();
		proxy = (CompanyServiceRemote) context1.lookup(jndiName1);
		ServiceServiceRemote proxys = (ServiceServiceRemote) context1.lookup(jndiNames);

    	
		//////////////////////////////////AFFICHAGE RECHERCHE/////////////////////////////////////////
    	String str = search.getText() ;
    	if (!str.equals("") ){
    		cplistservice =  FXCollections.observableArrayList(proxy.findAllCompanyByService(str));
    		cplist = FXCollections.observableArrayList(proxy.findAllCompanyByName(search.getText()));
    		cplist.addAll(cplistservice);
    	    System.out.println(cplist.toString());
     		list_company.setItems(cplist);
     		list_company.setCellFactory(new Callback<ListView<Company>, javafx.scene.control.ListCell<Company>>()
            {
    			@Override
    			public ListCell<Company> call(ListView<Company> param) {
    				 return new CompanyRowController();
    			}
            });
     		//////////////////////////AJOUT DE RECHERCHE//////////////////////////////////////
     		Reserche reserche = new Reserche() ;
     		reserche.setReserche(search.getText());
     		Company c =proxy.findBy(16);
     		System.out.println(c);
     		proxy.AddCompanyReserche(reserche, c);
    	}
    	else {

			cplist = FXCollections.observableArrayList(proxy.findAllCompany());
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
