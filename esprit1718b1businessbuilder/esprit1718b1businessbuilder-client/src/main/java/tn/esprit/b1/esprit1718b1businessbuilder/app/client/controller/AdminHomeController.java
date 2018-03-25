/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Nourelhouda
 */
public class AdminHomeController implements Initializable {

    @FXML
    private JFXButton btnHome;
    @FXML
    private JFXButton btnProfile;
    @FXML
    private JFXButton btnInbox;
    @FXML
    private JFXButton btnClaims;
    @FXML
    private JFXButton btnSetting;
    @FXML
    private AnchorPane HolderAnchor;
    
    AnchorPane Home ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	 try {
             // here you must put the path of our node 
         	Home = FXMLLoader.load(getClass().getResource("../gui/AdminDashboard.fxml"));
              
             setNode(Home);
         } catch (IOException ex) {
             Logger.getLogger(AdminHomeController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }    
    
    //Set selected node to a content holder
    private void setNode(Node node) {
    	HolderAnchor.getChildren().clear();
    	HolderAnchor.getChildren().add((Node) node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }




    @FXML
    private void switchProfile(ActionEvent event) {
    }

    @FXML
    private void switchHome(ActionEvent event) {
    }

    @FXML
    private void switchInbox(ActionEvent event) {
    }

    @FXML
    private void switchClaims(ActionEvent event) {
    }

    @FXML
    private void switchSettings(ActionEvent event) {
    }
    
}
