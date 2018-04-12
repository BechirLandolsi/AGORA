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
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.apache.http.impl.io.SocketOutputBuffer;
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
    
    @FXML
    private TextField title;
    
    public static StackPane mainRootPane;
    private StackPane rootPane;
    
    final Tooltip tooltip = new Tooltip();
    
    private static long idTender;
    
    
    public static long getIdTender() {
		return idTender;
	}

	public static void setIdTender(long idTender) {
		MyTendersRowController.idTender = idTender;
	}

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
             
             update.setOnAction(event->System.out.println(tender.getId()));
             //idTender=tender.getId();
             setText(null);
             setGraphic(row);
            
                       
         }
        
    }
    
    /*private void setStage(String fxml) {
        try {
            //dim overlay on new stage opening
            Region veil = new Region();
            veil.setPrefSize(1100, 650);
            veil.setStyle("-fx-background-color:rgba(0,0,0,0.3)");
            Stage newStage = new Stage();
            Parent parent = FXMLLoader.load(getClass().getResource(fxml));
            
            Scene scene = new Scene(parent);
            scene.setFill(Color.TRANSPARENT);
            newStage.setScene(scene);
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.initStyle(StageStyle.TRANSPARENT);
            newStage.getScene().getRoot().setEffect(new DropShadow());
            newStage.showingProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue) {
                    rootPane.getChildren().add(veil);
                } else if (rootPane.getChildren().contains(veil)) {
                    rootPane.getChildren().removeAll(veil);
                }
                
            });
            newStage.centerOnScreen();
            newStage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/
}
