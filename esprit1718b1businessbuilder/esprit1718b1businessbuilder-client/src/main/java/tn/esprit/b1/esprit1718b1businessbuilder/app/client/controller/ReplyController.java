package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.util.List;
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
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Invitation;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.InvitationServiceRemote;

/**
 * FXML Controller class
 *
 * @author Islem
 */
public class ReplyController implements Initializable {

    @FXML
    private AnchorPane holderPane;
    @FXML
    private ListView<Invitation> list_view_reply;

    /**
     * Initializes the controller class.
     */
    
    String jndiName3 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/InvitationService!tn.esprit.b1.esprit1718b1businessbuilder.services.InvitationServiceRemote" ;
	Context context3;
	
	String jndiName2 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 
	Context context2;
	
	private ObservableList<Invitation> list;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
		try {
			context2 = new InitialContext();
			context3 = new InitialContext();
	   		InvitationServiceRemote proxy3 = (InvitationServiceRemote ) context3.lookup(jndiName3);
	   		CompanyServiceRemote proxy2 = (CompanyServiceRemote) context2.lookup(jndiName2);
	    	
	    	list = FXCollections.observableArrayList(proxy3.DisplayInvitationByCompany(proxy2.findBy((long)EventController.getIdloggeduse())));
	    	list_view_reply.setItems(list);
		    list_view_reply.setCellFactory(new Callback<ListView<Invitation>, javafx.scene.control.ListCell<Invitation>>()
		        {
					@Override
					public ListCell<Invitation> call(ListView<Invitation> param) {
						 return new ReplyRowController();
					}
		        });
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    	
    }    
    
}
