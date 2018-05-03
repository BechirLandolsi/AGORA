package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Invitation;
import tn.esprit.b1.esprit1718b1businessbuilder.services.InvitationServiceRemote;

/**
 * FXML Controller class
 *
 * @author Islem
 */
public class ReplyRowController extends ListCell<Invitation>  {

	 @FXML
	    private AnchorPane row;
	    @FXML
	    private JFXButton invite_company_butt;
	    @FXML
	    private Label Invitation_name;
	    @FXML
	    private Label event_name_label;
	    @FXML
	    private Label event_date_label;
	    @FXML
	    private Label sending_date_label;
	    @FXML
	    private Label host_company_mail;
	    @FXML
	    private Label address_event_label;
	    @FXML
	    private JFXButton decline_invit_butt;

    /**
     * Initializes the controller class.
     */
  
    private FXMLLoader InvitationLoader;
    
    String jndiName3 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/InvitationService!tn.esprit.b1.esprit1718b1businessbuilder.services.InvitationServiceRemote" ;
	Context context3;
    @Override
    protected  void updateItem (Invitation i, boolean empty) {

        
        if (empty || i == null) {

             setText(null);
             setGraphic(null);

         } else {
             if (InvitationLoader == null) {
            	 InvitationLoader = new FXMLLoader(getClass().getResource("../gui/ReplyRow.fxml"));
            	 InvitationLoader.setController(this);

                 try {
                	 InvitationLoader.load();
                	 if(i.isGuest_Response()){invite_company_butt.setDisable(true);
                	 decline_invit_butt.setDisable(true);}
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

             }
             
             Invitation_name.setText("Invitation :"+i.getEvent().getEvent_name());
             event_name_label.setText(i.getEvent().getEvent_name()+":"+i.getEvent().getEvent_type());
             address_event_label.setText(i.getEvent().getEvent_adress());
             Date d =i.getEvent().getEvent_date();
             Date d1=i.getInvitationDate();
             DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
             String text = df.format(d);
             event_date_label.setText(text);
             host_company_mail.setText(i.getEvent().getCompany_organizer().getEmail());  
             String dateenvoi=df.format(d1);
             sending_date_label.setText(dateenvoi);
             setText(null);
             setGraphic(row);
            invite_company_butt.setOnAction(event->{
            	try {
					context3 = new InitialContext();
					InvitationServiceRemote proxy3 = (InvitationServiceRemote ) context3.lookup(jndiName3);

	            	 Invitation invit=proxy3.replyToInvitation(i.getGuest(),i.getEvent(), true);
	            	 System.out.println(invit);
	            	 invite_company_butt.setDisable(true);
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
           		
            });
            decline_invit_butt.setOnAction(event->decline_invit_butt.setDisable(false));
}
}
}