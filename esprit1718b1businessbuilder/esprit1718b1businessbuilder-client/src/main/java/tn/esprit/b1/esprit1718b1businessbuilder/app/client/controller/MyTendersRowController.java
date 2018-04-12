/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import org.ocpsoft.prettytime.PrettyTime;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Tender;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ITender;

/**
 * FXML Controller class
 *
 * @author Beshir
 */
public class MyTendersRowController extends ListCell<Tender> {

    @FXML
    private AnchorPane row;
    @FXML
    private Label TenderTitle;
    @FXML
    private TextArea TenderContent;
    @FXML
    private JFXButton DatePost;
    @FXML
    private JFXButton update;
    @FXML
    private JFXButton delete;
    
    private FXMLLoader MytenderLoader;
    
    final Tooltip tooltip = new Tooltip();

    @Override
    protected void updateItem (Tender tender, boolean empty){
    	
    	String jndiNameTender="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/TenderService!tn.esprit.b1.esprit1718b1businessbuilder.services.ITender";
    	Context context;
    	
    	
		PrettyTime p = new PrettyTime();
		
        if (empty || tender == null) {

             setText(null);
             setGraphic(null);

         } else {
             if (MytenderLoader == null) {
            	 MytenderLoader = new FXMLLoader(getClass().getResource("../gui/MyTendersRow.fxml"));
            	 MytenderLoader.setController(this);
                 try {
                	 MytenderLoader.load();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

             }
             
             tooltip.setText(tender.getTitle());
             TenderTitle.setText(tender.getTitle());
             TenderTitle.setTooltip(tooltip);
             TenderContent.setText(tender.getContent());
             DatePost.setText("Posted "+ p.format(tender.getPublishedDate()));
              
             try {
     			context = new InitialContext();
     			ITender proxyTender=(ITender)context.lookup(jndiNameTender);
     			delete.setOnAction(event->proxyTender.delete(tender));
     		} catch (NamingException e1) {
     			e1.printStackTrace();
     		}
             
             setText(null);
             setGraphic(row);
            
                       
         }
        
    }

}
