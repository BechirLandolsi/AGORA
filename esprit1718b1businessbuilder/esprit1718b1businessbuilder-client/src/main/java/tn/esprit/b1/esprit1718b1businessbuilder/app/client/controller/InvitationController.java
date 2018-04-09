package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;


/**
 *
 * @author danml
 */
public class InvitationController implements Initializable {

    @FXML
    private AnchorPane holderPane;
    
    
    @FXML
    private ListView<Company> invitationcompany_list_view;

    private ObservableList<Company> cplist ;
    
    String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 	
	CompanyServiceRemote proxy;
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
     	
		try {
			 Context	context = new InitialContext();
			proxy = (CompanyServiceRemote) context.lookup(jndiName1);
			cplist = FXCollections.observableArrayList(proxy.findAllCompany());
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		invitationcompany_list_view.setItems(cplist);
		invitationcompany_list_view.setCellFactory(new Callback<ListView<Company>, javafx.scene.control.ListCell<Company>>()
        {
			@Override
			public ListCell<Company> call(ListView<Company> param) {
				 return new InvitationRowController();
			}
        });
 		

    }


    
}
