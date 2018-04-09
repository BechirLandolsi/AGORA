package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.text.DateFormat;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.EventServiceRemote;


/**
 * FXML Controller class
 *
 * @author Islem
 */
public class EventController implements Initializable{


    @FXML
    private AnchorPane addanchorepane;
    @FXML
    private JFXTextField eventname;
    @FXML
    private JFXTextField eventaddress;
    @FXML
    private JFXDatePicker eventdate;
    @FXML
    private JFXToggleButton yes;
    @FXML
    private Label alert_label;
    @FXML
    private JFXComboBox<String> combo_sector;
    @FXML
    private JFXComboBox<String> combo_type;
    @FXML
    private JFXButton search_button;
    @FXML
    private ListView<Event> event_list_view;
    @FXML
    private TextField searching;
    @FXML
    private JFXToggleButton privacy;
    @FXML
    private JFXButton updatebutt;
    @FXML
    private JFXButton saveevent;
    @FXML
    private FontAwesomeIconView alert_img;
    @FXML
    private FontAwesomeIconView success_img;
    @FXML
    private Label success_label;
    @FXML
    private JFXButton refresh_butt;
	
	
	/**
     * Initializes the controller class.
     */
	
	//this variable give us the id of the event from the list view (from another controller )
    //that's why it is declared a static variable
    private static long nombre;
    private ObservableList<Event> event_list;
    private ObservableList<String> all_sectors = FXCollections.observableArrayList();
    //private ObservableList<Event> comingonly;
    
    /* Getters And Setters */
    public static long getNombre() {
		return nombre;
	}

	public static void setNombre(long nombre) {
		EventController.nombre = nombre;
	}
    
    
	//*********************************************************************************************************
    String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/EventService!tn.esprit.b1.esprit1718b1businessbuilder.services.EventServiceRemote" ; 
	Context context1;
	 
	String jndiName2 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ;
	Context context2;
	
    //**********************************************************************************************************

	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	 
	    try {
			context1 = new InitialContext();
		    EventServiceRemote proxy = (EventServiceRemote ) context1.lookup(jndiName1);
		
		    
//************************************************ Displaying Events in the List view  **************************************************
//***************************************************************************************************************************************		
	
	     event_list = FXCollections.observableArrayList(proxy.UpComingEvents());
	     //remind_list= FXCollections.observableArrayList(proxy.EventReminder(event_list));
	     all_sectors=FXCollections.observableArrayList(proxy.DisplaySector());
	     //comingonly = FXCollections.observableArrayList(proxy.UpComingEvents());
	     //List view
	     event_list_view.setItems(event_list);
	     event_list_view.setCellFactory(new Callback<ListView<Event>, javafx.scene.control.ListCell<Event>>()
	        {
				@Override
				public ListCell<Event> call(ListView<Event> param) {
					 return new EventRowController();
				}
	        });
	     
	    } catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    //setting combox values
	    combo_sector.getItems().addAll(all_sectors);
	    combo_type.getItems().addAll("Product Launch"," Company Milestones","Trade Shows","Appreciation Events");
    }    



    
    
  //************************************************ View the details in the fields  **************************************************
  //***************************************************************************************************************************************	    
    @FXML
    private void on_search_clicked(ActionEvent event) throws NamingException {
    	Event e = new Event();

    	try {
			context1 = new InitialContext();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
		EventServiceRemote proxy = (EventServiceRemote ) context1.lookup(jndiName1);
		
	    //remind_list= FXCollections.observableArrayList(proxy.EventReminder(event_list));
    	nombre=EventRowController.getEntier();
    	System.out.println(nombre);
    	eventname.setText(proxy.find(nombre).getEvent_name());
    	eventaddress.setText(proxy.find(nombre).getEvent_adress());
    	combo_sector.setEditable(true);
        combo_type.setEditable(true);
    	combo_type.setValue(proxy.find(nombre).getEvent_type());
    	combo_sector.setValue(proxy.find(nombre).getEvent_sector());
    	if(proxy.find(nombre).getEvent_profitable()){yes.setSelected(true);}
    	if(proxy.find(nombre).isEvent_privacy()){privacy.setSelected(true);}
    	updatebutt.setVisible(true);
    	updatebutt.setDisable(false);
        saveevent.setDisable(true);
        
      //set the date picker
        if(proxy.find(nombre).getEvent_date()!=null){
        LocalDate ld = ((java.sql.Date) proxy.find(nombre).getEvent_date()).toLocalDate();
        eventdate.setValue(ld); 
            }
        else eventdate.setValue(null); 
        
    	
        
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
       // LocalDate localDate = LocalDate.parse(text, formatter);
        //eventdate.setValue(d);
        Date d = proxy.find(nombre).getEvent_date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String text = df.format(d);
   
       
      
    }
     
   void refresh (Event e){
    	event_list_view.getItems().clear();
		event_list_view.getItems().addAll(e);
    }
    
  //************************************************ Adding a new Event  **************************************************
  //***************************************************************************************************************************************	

    @FXML
    private void on_save_clicked(ActionEvent event) throws NamingException {
    	context2 = new InitialContext();
       	CompanyServiceRemote proxy2 = (CompanyServiceRemote) context2.lookup(jndiName2);
       	
    	Event e = new Event();
    	Company c = new Company();
    	boolean check=true;
        //eventdate.setValue(null);
        //the data entered by the user
    	e.setEvent_name(eventname.getText());
    	e.setEvent_adress(eventaddress.getText());
    	e.setEvent_profitable(yes.isSelected());
    	e.setEvent_sector(combo_sector.getValue());
    	e.setEvent_privacy(privacy.isSelected());
    	e.setEvent_type(combo_type.getValue());
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
    	check=false;
    	}
    	System.out.println(e.getCompany_organizer());
    	System.out.println(check);
    	
    	context1 = new InitialContext();
		EventServiceRemote proxy = (EventServiceRemote ) context1.lookup(jndiName1);
		
		//data control : empty fields 
		
		System.out.println(verifyempty());
		
		if(verifyempty())
		{
		alert_label.setText("All Field Are Required");
		alert_img.setVisible(true);
		success_img.setVisible(false);
		success_label.setText("");}
		else  if(check==false)
		{
		alert_label.setText("You Can't Enter An Anterior Date");
		alert_img.setVisible(true);
		success_img.setVisible(false);
		success_label.setText("");;
	     }	
		
		else if(check && !(verifyempty()))
		{
			
		proxy.save(e);
		alert_label.setText("");
		alert_img.setVisible(false);
		success_img.setVisible(true);
		success_label.setText("Your Event Has Been Added Successfully");
		//rafraichir l'affichage dans list view 
		refresh(e);
		//emptyfields();
		
		}
		//event_list = FXCollections.observableArrayList(proxy.findAll());

    }
   
    
  //************************************************ Update an existing Event  **************************************************
  //***************************************************************************************************************************************	
  
    @FXML
    private void update_clicked(ActionEvent event) throws NamingException {
    	Event e = new Event();

    	try {
			context1 = new InitialContext();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
		EventServiceRemote proxy = (EventServiceRemote ) context1.lookup(jndiName1);
    	nombre=EventRowController.getEntier();
    	e=proxy.find(nombre);
    	e.setEvent_name(eventname.getText());
    	e.setEvent_adress(eventaddress.getText());
    	e.setEvent_profitable(yes.isSelected());
    	e.setEvent_sector(combo_sector.getValue());
    	e.setEvent_privacy(privacy.isSelected());
    	e.setEvent_type(combo_type.getValue());
    	LocalDate a = eventdate.getValue();
    	java.sql.Date d = java.sql.Date.valueOf(a);
    	
    	if(verifyempty())
    	{
    		alert_label.setText("All Field Are Required");
    		alert_img.setVisible(true);
    		success_img.setVisible(false);
    		success_label.setText("");}
    	else
    	{proxy.update(e);}
    	updatebutt.setDisable(true);
    	saveevent.setDisable(false);
    	emptyfields();
    }

  //************************************************  Empty Fields After Action **************************************************
  //***************************************************************************************************************************************	
    private void emptyfields()
    {
     	eventaddress.setText("");
    	eventname.setText("");
    	combo_sector.setValue("");
    	combo_type.setValue("");
    	privacy.setSelected(false);
    	yes.setSelected(false);
    	eventdate.setValue(null);
    	
    }

  //************************************************ Controle Saisie Empty fields  **************************************************
  //***************************************************************************************************************************************	
   
    
    private boolean verifyempty(){
    	if(eventname.getText().equals("") || eventaddress.getText().equals("") || combo_sector.getValue().equals("") || combo_type.getValue().equals("")|| eventdate.getValue()==null)	
    	{return true;}
    	else{return false;}
    }
    
    
    
    @FXML
    private void on_refresh_clicked(ActionEvent event) {
    }

  //************************************************ Controle Saisie Anterior Date  **************************************************
  //***************************************************************************************************************************************	
    
}
