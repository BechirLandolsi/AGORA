/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import com.jfoenix.controls.JFXButton;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

import org.controlsfx.control.Rating;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Tender;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ITender;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


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
    private ListView<Tender> list_Tenders;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblPhone;
    @FXML
    private Label lblLocation;
    @FXML
    private Rating CompanyRate;
    
    private ObservableList<Tender> tendersList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
        String jndiNameTender="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/TenderService!tn.esprit.b1.esprit1718b1businessbuilder.services.ITender";
        ITender proxy;
		try {
			 Context context = new InitialContext();
			proxy = (ITender) context.lookup(jndiNameTender);
			tendersList = FXCollections.observableArrayList(proxy.findAll());
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
    private void doSearch(ActionEvent event) {
    }

    public Label getLblLocation() {
        return lblLocation;
    }

    public void setLblLocation(String lblLocation) {
        this.lblLocation.setText(lblLocation); 
    }

    

    

    
}
