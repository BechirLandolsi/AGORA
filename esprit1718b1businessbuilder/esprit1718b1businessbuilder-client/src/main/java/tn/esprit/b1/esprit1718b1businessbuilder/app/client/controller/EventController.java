package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.EventServiceRemote;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class EventController implements Initializable {

    @FXML
    private AnchorPane addanchorepane;
    @FXML
    private JFXTextField eventname;
    @FXML
    private Label en;
    @FXML
    private Label ea;
    @FXML
    private Label ed;
    @FXML
    private JFXTextField eventaddress;
    @FXML
    private JFXDatePicker eventdate;
    @FXML
    private JFXButton createeventbutt;
    @FXML
    private Label es;
    @FXML
    private JFXTextField eventsector;
    @FXML
    private Label ep;
    @FXML
    private JFXToggleButton yes;
    @FXML
    private TableView<Event> event_tab;
    @FXML
    private TableColumn<Event, String> evname;
    @FXML
    private TableColumn<Event, String> evaddress;
    @FXML
    private TableColumn<Event, Date> evdate;
    @FXML
    private TableColumn<Event, String> evsector;
    @FXML
    private TableColumn<Event, Boolean> evprofitable;
    @FXML
    private Label alert_label;
    @FXML
    private JFXButton invite_butt;
    @FXML
    private JFXButton view_details_butt;
    @FXML
    private JFXButton delete_butt;
    @FXML
    private JFXComboBox<String> combo_search;
    @FXML
    private JFXTextField search_field;
    @FXML
    private JFXDatePicker search_picker;
    @FXML
    private JFXButton search_butt;
    /**
     * Initializes the controller class.
     */
    //////////******************************************************************************************
    private ObservableList<Event> event_list = FXCollections.observableArrayList();
    
    
	 String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/EventService!tn.esprit.b1.esprit1718b1businessbuilder.services.EventServiceRemote" ; 
	 Context context1;
	 //Company c = null;


	 String jndiName4 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 
	 Context context4;
	 
	/////////**********************************************************************************************
    
	 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	 try {
    	    context1 = new InitialContext();
    		EventServiceRemote proxy = (EventServiceRemote ) context1.lookup(jndiName1);
   			
    	     event_list = FXCollections.observableArrayList(proxy.findAll());
    	    
    	     evname.setCellValueFactory(new PropertyValueFactory<>("event_name"));
    	     evaddress.setCellValueFactory(new PropertyValueFactory<>("event_adress"));
    	     evdate.setCellValueFactory(new PropertyValueFactory<>("event_date"));
    	     evprofitable.setCellValueFactory(new PropertyValueFactory<>("event_profitable"));
    	     evsector.setCellValueFactory(new PropertyValueFactory<>("event_sector"));
    	  
    	     event_tab.setItems( event_list); 
    	     
    	} catch (NamingException e) {
    			
    			e.printStackTrace();
    		}
    	 ObservableList<String> type_list = FXCollections.observableArrayList("Event Name","Event Date");
    	 combo_search.setItems(type_list);

    }    
    
    
    /////////**********************************************************************************************
    
    @FXML
    private void onclick_createevent(ActionEvent event) throws NamingException, ParseException {
    	
    	context4 = new InitialContext();
       	CompanyServiceRemote proxy2 = (CompanyServiceRemote) context4.lookup(jndiName4);
       	
    	Event e = new Event();
    	Company c = new Company();
    	c.setId((long) 2);
    	System.out.println(c.getId());

        //the data entered by the user
    	e.setEvent_name(eventname.getText());
    	e.setEvent_adress(eventaddress.getText());
    	e.setEvent_profitable(yes.isSelected());
    	e.setEvent_sector(eventsector.getText());
    	LocalDate a = eventdate.getValue();
    	java.sql.Date d = java.sql.Date.valueOf(a);
    	
    	///get the system date
    	String format = "dd/MM/yy H:mm:ss";
		java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
		java.util.Date da = new java.util.Date(); 
		
    	//control datepicker so the user can not enter a previous date
    	if(d.after(da)){
    	e.setEvent_date(d);
    	}
    	else
    	{
    	System.out.println("error date");
    	}
    	e.setCompany_organizer(c);
    	System.out.println(e.getCompany_organizer());
    	
    	
    	context1 = new InitialContext();
		EventServiceRemote proxy = (EventServiceRemote ) context1.lookup(jndiName1);
		//if(alert_label.equals("")){
		proxy.save(e);
		System.out.println("ajout avec succes");
		
    }

    
    
    /////////**********************************************************************************************
   
    @FXML
    private void eventclicked(MouseEvent event) throws NamingException {
    	if (event_tab.getSelectionModel().getSelectedItem() != null) {
          //Event e = event_tab.getSelectionModel().getSelectedItem();
        //  Long id = e.getId_event();
          
    	}
    	try {
			context1 = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EventServiceRemote proxy = (EventServiceRemote ) context1.lookup(jndiName1);
		
    	proxy.delete(proxy.find(event_tab.getSelectionModel().getSelectedItem().getId_event()));
    	int selectedIndex = event_tab.getSelectionModel().getSelectedIndex();
    	event_tab.getItems().remove(selectedIndex);    }

    @FXML
    private void oninvitebutt_clicked(ActionEvent event) {
    	
    }

    @FXML
    private void onviewdetails_clicked(ActionEvent event) {
    	
    }
    
    @FXML
    private void ondeletebutt_clicked(ActionEvent event) {
    	if (event_tab.getSelectionModel().getSelectedItem() != null) {
            Event e = event_tab.getSelectionModel().getSelectedItem();
            Long id = e.getId_event();
    	}
		
    	
    }

    @FXML
    private void onsearchbutt_clicked(ActionEvent event) {
     String type = combo_search.getValue();
     if(type=="Event Name"){
    	 search_field.setVisible(true);
    	 search_picker.setVisible(false);
     }
     if(type=="Event Date"){
    	 search_picker.setVisible(true);
    	 search_field.setVisible(false);
    	 
     }
    }


    
}
