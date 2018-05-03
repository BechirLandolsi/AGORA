/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Tender;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderCategory;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderQualification;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ITender;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ITenderCategory;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ITenderQualification;
import tn.esprit.b1.esprit1718b1businessbuilder.services.TenderService;

/**
 * FXML Controller class
 *
 * @author Beshir
 */
public class AddMyTenderController implements Initializable {

    @FXML
    private MaterialDesignIconView iconClose;
    @FXML
    private JFXButton post;

    private ObservableList<TenderCategory> all_categories = FXCollections.observableArrayList();
    @FXML
    private ComboBox<TenderCategory> combo_cat;

    /**
     * Initializes the controller class.
     */
    
    String jndiNameCategory ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/TenderCategoryService!tn.esprit.b1.esprit1718b1businessbuilder.services.ITenderCategory" ; 
    String jndiNameQualification ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/TenderQualificationService!tn.esprit.b1.esprit1718b1businessbuilder.services.ITenderQualification" ; 
    String jndiNameTender="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/TenderService!tn.esprit.b1.esprit1718b1businessbuilder.services.ITender";
	Context context;
    @FXML
    private JFXCheckBox sameCountry;
    @FXML
    private JFXCheckBox has4stars;
    @FXML
    private JFXCheckBox has3stars;
    @FXML
    private JFXCheckBox has3projects;
    @FXML
    private JFXCheckBox has80profile;
    @FXML
    private JFXDatePicker deadline;
    @FXML
    private TextField title;
    @FXML
    private TextArea content;
	
		
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	
    	try {
			context = new InitialContext();
			ITenderCategory proxyCategory = (ITenderCategory) context.lookup(jndiNameCategory);
			
			all_categories= FXCollections.observableArrayList(proxyCategory.findAll());
				
		} catch (NamingException e) {
			e.printStackTrace();
		}
    	
    	combo_cat.getItems().addAll(all_categories);
    	   	
    }    

    @FXML
    private void closeStage(MouseEvent event) {
        iconClose.getScene().getWindow().hide();
    }

    @FXML
    private void post(ActionEvent event) throws NamingException, ParseException {
    	String jndiNameQualification ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/TenderQualificationService!tn.esprit.b1.esprit1718b1businessbuilder.services.ITenderQualification" ; 
		ITenderQualification proxyQualification = (ITenderQualification) context.lookup(jndiNameQualification);
		
    	TenderService ts = new TenderService();
    	User loggedUser = LoginController.LoggedUser ;
    	
    	Tender tender = new Tender();
    	context = new InitialContext();
    	ITender proxyTender=(ITender)context.lookup(jndiNameTender);
    //********************************************************************Récuperation des données depuis la GUI***************************************	
    	String title=this.title.getText();
    	String content=this.content.getText();
    	TenderCategory category= combo_cat.getValue();
    	Date publishedDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
    	
    	java.sql.Date datepicker = java.sql.Date.valueOf(this.deadline.getValue());
    	String deadline =new SimpleDateFormat("dd/MM/yyyy").format(datepicker);
    	java.util.Date finalDeadline = new SimpleDateFormat("dd/MM/yyyy").parse(deadline);
    
    	//*********************************************Creation de nouveau Tender**********************************************************************	
    	
    	tender.setTitle(title);
    	tender.setContent(content);
    	tender.setDeadline(finalDeadline);
    	tender.setPublishedDate(publishedDate);
    	ts.affectTenderToCompanyCategory(tender, loggedUser, category);
    	Long id =proxyTender.add(tender);
    	tender.setId(id);
    	
    	if (sameCountry.isSelected()) {
    		
    		proxyTender.affectTenderToQualification(tender,proxyQualification.findByName(sameCountry.getText()));
    		System.out.println("bien affecté à same country");
    	}
    	
    	if(has4stars.isSelected()){
    		proxyTender.affectTenderToQualification(tender,proxyQualification.findByName(has4stars.getText()));
    		System.out.println("bien affecté à 4 étoiles");
    	}
    	
    	if(has3stars.isSelected()){
    		proxyTender.affectTenderToQualification(tender,proxyQualification.findByName(has3stars.getText()));
    		System.out.println("bien affecté à 3 étoiles");
    	}
    	
    	if(has3projects.isSelected()){
    		proxyTender.affectTenderToQualification(tender,proxyQualification.findByName(has3projects.getText()));
    		System.out.println("bien affecté à 3 projets");
    	}
    	
    	if(has80profile.isSelected()){
    		proxyTender.affectTenderToQualification(tender,proxyQualification.findByName(has80profile.getText()));
    		System.out.println("bien affecté à 80 % du profile");
    	}
    }
    
 
}
