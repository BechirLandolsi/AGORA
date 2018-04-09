package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;


/**
 * FXML Controller class
 *
 * @author Islem
 */
public class InvitationRowController extends ListCell<Company> {

    @FXML
    private AnchorPane row;
    @FXML
    private Label company_name_label;
    @FXML
    private Label ceo_label;
    @FXML
    private Label number_label;
    @FXML
    private Label sector_label;
    @FXML
    private Label mail_label;
    @FXML
    private Label address_label;
    @FXML
    private JFXButton invite_company_butt;
    @FXML
    private FontAwesomeIconView tick_label;
    @FXML
    private Label already_label;
    private FXMLLoader companyLoader;

    /**
     * Initializes the controller class.
     */
       
    
    @Override
    protected void updateItem(Company company, boolean empty) {
    	 if (empty || company == null) {

             setText(null);
             setGraphic(null);

         } else {
             if (companyLoader == null) {
            	 companyLoader = new FXMLLoader(getClass().getResource("../gui/InvitationRow.fxml"));
            	 companyLoader.setController(this);

                 try {
                	 companyLoader.load();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

             }
             company_name_label.setText(company.getName());
             ceo_label.setText(company.getCEO());
             address_label.setText(company.getAdress());
             mail_label.setText(company.getEmail());
             number_label.setText(company.getNumber().toString());
             sector_label.setText(company.getSector());
            
           
             setText(null);
             setGraphic(row);
             
             invite_company_butt.setOnAction(event->{
            	 invite_company_butt.setDisable(true);
            	 tick_label.setVisible(true);
            	 already_label.setVisible(true);
             });
         }
    
    }
}


