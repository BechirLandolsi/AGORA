/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Tender;
import java.util.stream.Collectors;
import org.ocpsoft.prettytime.PrettyTime;
import javafx.event.EventHandler;

/**
 * FXML Controller class
 *
 * @author Beshir
 */
public class TenderRowController extends ListCell<Tender> {

    
    @FXML
    private Label TenderTitle;
    @FXML
    private JFXButton Apply;
    @FXML
    private TextArea TenderContent;
    @FXML
    private JFXButton DatePost;
    @FXML
    private AnchorPane row;
    @FXML
    private JFXButton Status;
    
    private FXMLLoader tenderLoader;
    
    final Tooltip tooltip = new Tooltip();
    
    private static Company entreprise;
    
	public static Company getEntreprise() {
		return entreprise;
	}



	public static void setEntreprise(Company entreprise) {
		TenderRowController.entreprise = entreprise;
	}



	@Override
    protected void updateItem (Tender tender, boolean empty){
		PrettyTime p = new PrettyTime();
		
        if (empty || tender == null) {

             setText(null);
             setGraphic(null);

         } else {
             if (tenderLoader == null) {
                 tenderLoader = new FXMLLoader(getClass().getResource("../gui/TenderRow.fxml"));
                 tenderLoader.setController(this);
                 try {
                     tenderLoader.load();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

             }
             
             tooltip.setText(tender.getTitle());
             TenderTitle.setText(tender.getTitle());
             TenderTitle.setTooltip(tooltip);
             TenderContent.setText(tender.getContent());
             DatePost.setText("Posted "+ p.format(tender.getPublishedDate()));
             
             if((tender.getDeadline().before(Calendar.getInstance().getTime())) || (tender.getDeadline().equals(Calendar.getInstance().getTime()))){
            	 Status.setText("Closed");
            	 Apply.setDisable(true);
             }
             else{
            	 Status.setText(tender.getDeadline().toString());
             }
             
           //Apply.setOnAction(event->tender.getCompanyTender().getName());
            row.setOnMouseClicked(event->entreprise=tender.getCompanyTender());
            System.out.println(entreprise);
             
             setText(null);
             setGraphic(row);
            
                       
         }
        
    }
    
}
