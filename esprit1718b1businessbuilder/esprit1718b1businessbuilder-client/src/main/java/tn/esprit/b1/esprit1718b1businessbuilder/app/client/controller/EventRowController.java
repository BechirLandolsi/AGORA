package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;

import tn.esprit.b1.esprit1718b1businessbuilder.services.EventServiceRemote;


/**
 * FXML Controller class
 *
 * @author Islem
 */
public class EventRowController extends ListCell<Event>  {

    @FXML
    private AnchorPane row;
    @FXML
    private Label eventtitlelabel;
    @FXML
    private Label event_address_label;
    @FXML
    private Label event_date_label;
    @FXML
    private Label event_sector_label;
    @FXML
    private Label event_privacy_label;
    @FXML
    private JFXButton view_details_butt;
    @FXML
    private JFXButton cancel_butt;
    @FXML
    private JFXButton invite_butt;
    
    private FXMLLoader EventLoader;
    
    private static long entier;
    

    public static long getEntier() {
		return entier;
	}


	public static void setEntier(long entier) {
		EventRowController.entier = entier;
	}


	/**
     * Initializes the controller class.
     */
     
	
	//*******************************************************************************************
	String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/EventService!tn.esprit.b1.esprit1718b1businessbuilder.services.EventServiceRemote" ; 
	Context context1;
	//*******************************************************************************************
    
	@Override
    protected  void updateItem (Event ev, boolean empty) {
       EventController ec = new EventController();
        
        if (empty || ev == null) {

             setText(null);
             setGraphic(null);

         } else {
             if (EventLoader == null) {
                 EventLoader = new FXMLLoader(getClass().getResource("../gui/EventRow.fxml"));
                 EventLoader.setController(this);

                 try {
                     EventLoader.load();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

             }
             
             eventtitlelabel.setText(ev.getEvent_name()+ " : " +ev.getEvent_type());
             event_address_label.setText(ev.getEvent_adress());
             event_sector_label.setText(ev.getEvent_sector());
             if(ev.isEvent_privacy()){event_privacy_label.setText("Private");}
             else{event_privacy_label.setText("Public");}
             Date d =ev.getEvent_date();
             DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
             String text = df.format(d);
             event_date_label.setText(text);
             setText(null);
             setGraphic(row);
            
            invite_butt.setOnAction(event->{
            	
            	Parent root;
				try {
				
					Stage Stage=new Stage();
					root = FXMLLoader.load(getClass().getResource("../gui/Invitation.fxml"));
		            Scene scene=new Scene(root);
		            Stage.setScene(scene);
		            Stage.show();
		            	
				} catch (IOException e) {
					Logger.getLogger(EventRowController.class.getName()).log(Level.SEVERE, null,e);
				} 
               
            	
            	
            });
            view_details_butt.setOnAction(event->entier=ev.getId_event());
            cancel_butt.setOnAction(event->{
            	entier=ev.getId_event();
            	Event e = new Event();

            	try {
        			context1 = new InitialContext();
        			EventServiceRemote proxy = (EventServiceRemote ) context1.lookup(jndiName1);
        			e=proxy.find(entier);
        			proxy.delete(e);
        		} catch (NamingException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
            
        		
            	
            });
           
         }
    }

    
}


