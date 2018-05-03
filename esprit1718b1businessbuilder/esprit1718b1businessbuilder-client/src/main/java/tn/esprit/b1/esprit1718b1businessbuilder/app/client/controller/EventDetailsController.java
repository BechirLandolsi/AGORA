package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.EventDepense;
import tn.esprit.b1.esprit1718b1businessbuilder.services.EventServiceRemote;

/**
 * FXML Controller class
 *
 * @author Islem
 */
public class EventDetailsController implements Initializable {

    @FXML
    private AnchorPane holderPane;
    @FXML
    private Label invited_label;
    @FXML
    private Label guests_label;
    @FXML
    private Label refused_label;
    @FXML
    private JFXButton predict_butt;
    @FXML
    private Label new_type_label;
    @FXML
    private AnchorPane depenses_details_anchorepane1;
    @FXML
    private JFXTextField budget_label1;
    @FXML
    private JFXTextField foodbeverage_dep1;
    @FXML
    private JFXTextField marketing_dep1;
    @FXML
    private JFXTextField technique_visuel_label1;
    @FXML
    private JFXTextField accomandation_dep1;
    @FXML
    private JFXTextField planb_dep1;
    @FXML
    private JFXTextField entertainment_dep1;
    @FXML
    private JFXTextField transport_dep1;
    @FXML
    private FontAwesomeIconView calculate1;
    @FXML
    private TextField depenses_total_dep1;
    @FXML
    private Label error_label1;
    @FXML
    private PieChart dep_piechart1;
    @FXML
    private JFXTextField communication_dep1;
    @FXML
    private JFXTextField logistiqueu_dep1;
    @FXML
    private JFXButton calculate;

    /**
     * Initializes the controller class.
     */
    
    String jndiName3 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/EventService!tn.esprit.b1.esprit1718b1businessbuilder.services.EventServiceRemote" ;
	Context context3;
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	invited_label.setText(Long.toString(InvitationRowController.getCount()));
        guests_label.setText(Long.toString(InvitationRowController.getGuestnombre()));
        refused_label.setText(Long.toString(InvitationRowController.getCount()-InvitationRowController.getGuestnombre()));
    }    

    @FXML
    private void closeStage(MouseEvent event) {
    }

    @FXML
    private void onpredict_clicked(ActionEvent event) throws NamingException {
    	context3 = new InitialContext();
		EventServiceRemote proxy3 = (EventServiceRemote) context3.lookup(jndiName3);
    	long entier=EventRowController.getEntier();
    	String type=proxy3.find(entier).getEvent_type();
    	proxy3.FindEventType(type);
    	System.out.println(proxy3.FindEventType(type));
    	System.out.println(proxy3.find(entier));
    	System.out.println( proxy3.FindEventType(type)!=proxy3.find(entier));
    	if(!( proxy3.FindEventType(type)==proxy3.find(entier))){
    	depenses_details_anchorepane1.setVisible(true);
    	new_type_label.setText("You don't have an event type");
    
    	}
    	if(( proxy3.FindEventType(type)==proxy3.find(entier))){
        	//depenses_details_anchorepane1.setVisible(true);
        	new_type_label.setText("select below");
        	}
    }


    @FXML
    private void oncalculate_clicked(ActionEvent event) throws NamingException {
 	   System.out.println("islem");
 	try {
			context3 = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EventServiceRemote proxy3 = (EventServiceRemote) context3.lookup(jndiName3);
 	long entier=EventRowController.getEntier();
 EventDepense evd=new EventDepense();
 evd.setAccomondation(Float.parseFloat(accomandation_dep1.getText()));
 evd.setBudget(Float.parseFloat(budget_label1.getText()));
 evd.setCommunication(Float.parseFloat(communication_dep1.getText()));
 evd.setEntertainment(Float.parseFloat(entertainment_dep1.getText()));
 evd.setEvent(proxy3.find(entier));
 evd.setFoodbeverage(Float.parseFloat(foodbeverage_dep1.getText()));
 evd.setLogistique(Float.parseFloat(logistiqueu_dep1.getText()));
 evd.setMarketing(Float.parseFloat(marketing_dep1.getText()));
 evd.setPlanb(Float.parseFloat(planb_dep1.getText()));
 evd.setTechniquevisuel(Float.parseFloat(technique_visuel_label1.getText()));
 evd.setTransport(Float.parseFloat(transport_dep1.getText()));
 System.out.println(evd);
 float total =evd.getAccomondation()+evd.getCommunication()+evd.getEntertainment()+evd.getFoodbeverage()+evd.getLogistique()+evd.getMarketing()+
 		evd.getPlanb()+evd.getTechniquevisuel()+evd.getTransport();
 System.err.println(String.valueOf(total));
 if(total>evd.getBudget()){error_label1.setText("depenses are superior to Budget");}
 else{error_label1.setText("depenses calculated");}
 depenses_total_dep1.setText(String.valueOf(total));
 
    }
}
















    	
    	
    	
    	
    	
  
