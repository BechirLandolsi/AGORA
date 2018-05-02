package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import java.io.IOException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.EventServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.InvitationServiceRemote;


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

    private static long nombre;
    private static long count;
    private static long guestnombre;
    
    
    public static long getGuestnombre() {
		return guestnombre;
	}


	public static void setGuestnombre(long guestnombre) {
		InvitationRowController.guestnombre = guestnombre;
	}


	public static long getCount() {
		return count;
	}


	public static void setCount(long count) {
		InvitationRowController.count = count;
	}


	/**
     * Initializes the controller class.
     */
       
    
    
    String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/InvitationService!tn.esprit.b1.esprit1718b1businessbuilder.services.InvitationServiceRemote" ; 
	Context context1;
	
	String jndiName2 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ;
	Context context2;
	
	String jndiName3 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/EventService!tn.esprit.b1.esprit1718b1businessbuilder.services.EventServiceRemote" ;
	Context context3;
	
    
    @Override
    protected void updateItem(Company company, boolean empty){
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
            	 String jndiName2 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/EventService!tn.esprit.b1.esprit1718b1businessbuilder.services.EventServiceRemote" ; 
         		Context context2;
				
         			
           	    try {
					context1 = new InitialContext();
					InvitationServiceRemote proxy = (InvitationServiceRemote ) context1.lookup(jndiName1);
					
						context2 = new InitialContext();
						EventServiceRemote proxy2 = (EventServiceRemote) context2.lookup(jndiName2);
		         		
					
					//proxy.InviteCompanyToAnEvent(1, 84);
					nombre=EventRowController.getEntier();
					//System.out.println(nombre);
					//System.out.println(company.getId());
					proxy.InviteCompanyToAnEvent(company.getId(),nombre);
				    count=proxy.countnumberinvitation(proxy2.find(nombre));
				    guestnombre=proxy.countnumberguest(proxy2.find(nombre));
				    
					System.out.println(Long.toString(count));
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
           		 
           		
           		
           		
           		
            	 invite_company_butt.setDisable(true);
            	 tick_label.setVisible(true);
            	 already_label.setVisible(true);
            	 
            	 
             });
         }
    
    }
}


