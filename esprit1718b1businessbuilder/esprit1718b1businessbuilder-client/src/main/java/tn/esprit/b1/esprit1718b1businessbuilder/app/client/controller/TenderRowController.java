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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Tender;
import java.util.stream.Collectors;
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
    
    private FXMLLoader tenderLoader;

    @Override
    protected void updateItem (Tender tender, boolean empty){
        TenderController tc = new TenderController();
        
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
             TenderTitle.setText(tender.getTitle());
             TenderContent.setText(tender.getContent());
             //DatePost.setText(tender.getPublishedDate());
             setText(null);
             setGraphic(row);
            
             Apply.setOnAction(event->System.out.println(tender.getId()));
             row.setOnMouseClicked(event->tc.setLblLocation(tender.getCompanyTender().getName()));
             
         }
    }

    
}
