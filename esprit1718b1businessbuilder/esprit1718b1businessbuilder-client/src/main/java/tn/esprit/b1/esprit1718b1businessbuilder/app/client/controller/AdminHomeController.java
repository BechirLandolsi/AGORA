/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import com.jfoenix.controls.JFXButton;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Nourelhouda
 */
public class AdminHomeController implements Initializable {

	 @FXML
	    private MaterialDesignIconView iconClose;

	    @FXML
	    private JFXButton btnHome;

	    @FXML
	    private JFXButton btnSales;

    @FXML
    private JFXButton btnProfile;
 
    @FXML
    private JFXButton btnClaims;
    @FXML
    private JFXButton btnSetting;
    @FXML
    private AnchorPane HolderAnchor;
    
    AnchorPane Home , Sales ,Profiles ;

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
    private void switchProfile(ActionEvent event) throws IOException {
    	Profiles = FXMLLoader.load(getClass().getResource("../gui/ProfilesAdmin.fxml"));
        setNode(Profiles);
    }

    @FXML
    private void switchHome(ActionEvent event) throws IOException {
    	Home = FXMLLoader.load(getClass().getResource("../gui/AdminDashboard.fxml"));
        setNode(Home);
    }

    @FXML
    private void switchInbox(ActionEvent event) throws IOException {
    	Sales = FXMLLoader.load(getClass().getResource("../gui/GlobalViewAdmin.fxml"));
        setNode(Sales);
    }

    @FXML
    private void switchClaims(ActionEvent event) {
    }

    @FXML
    private void switchSettings(ActionEvent event) {
    }
    
    @FXML
    void closeApp(MouseEvent event)throws Exception {
    	
    	iconClose.getScene().getWindow().hide();
        Stage news=new Stage();
        Parent root=FXMLLoader.load(getClass().getResource("../gui/Login.fxml"));
        Scene s=new Scene(root);
        news.setScene(s);
        news.show();

    }
}
