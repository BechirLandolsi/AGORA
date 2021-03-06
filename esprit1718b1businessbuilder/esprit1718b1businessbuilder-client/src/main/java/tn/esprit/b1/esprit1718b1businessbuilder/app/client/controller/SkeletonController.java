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
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

/**
 *
 * @author PEAR
 */
public class SkeletonController implements Initializable {

    @FXML
    private AnchorPane holderPane;
    

    AnchorPane contacts,alerts,Home,profiles,widgets,controls,main,Projects,Products,Events,Tender;

    @FXML
    private JFXButton btnHome;
    @FXML
    private JFXButton btnEvents;
    @FXML
    private JFXButton btnTenders;
    @FXML
    private JFXButton btnProfile;
    @FXML
    private JFXButton btnControls;
    @FXML
    private JFXButton btnExit;
    @FXML
    private JFXButton btnProjects;
    @FXML
    private JFXButton btnProduct;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // here you must put the path of our node 
        	Home = FXMLLoader.load(getClass().getResource("../gui/Home.fxml"));
            setNode(Home);
        } catch (IOException ex) {
            Logger.getLogger(SkeletonController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Set selected node to a content holder
    private void setNode(Node node) {
        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);

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
    	profiles = FXMLLoader.load(getClass().getResource("../gui/Profile.fxml"));
         setNode(profiles);  
    }


    @FXML
    private void switchControls(ActionEvent event) {
        
    }

    @FXML
    private void switchHome(ActionEvent event) {
         setNode(Home);
         
    }

    @FXML
    private void switchEvents(ActionEvent event) throws IOException {
    	 Events = FXMLLoader.load(getClass().getResource("../gui/Event.fxml"));
         setNode(Events);
    }

    @FXML
    private void switchTenders(ActionEvent event)throws IOException {
          Tender = FXMLLoader.load(getClass().getResource("../gui/Tender.fxml"));
          setNode(Tender);
    }

    @FXML
    private void switchProjects(ActionEvent event) throws IOException{
    	
    	 Projects = FXMLLoader.load(getClass().getResource("../gui/Project.fxml"));
         setNode(Projects);
    	
    }
    @FXML
    private void switchProduct(ActionEvent event) throws IOException{
    	
    	 Products = FXMLLoader.load(getClass().getResource("../gui/Product.fxml"));
         setNode(Products);
    	
    }    

    @FXML
    private void switchExit(ActionEvent event) throws Exception {
    	
    	btnExit.getScene().getWindow().hide();
        Stage news=new Stage();
        Parent root=FXMLLoader.load(getClass().getResource("../gui/Login.fxml"));
        Scene s=new Scene(root);
        news.setScene(s);
        news.show();
    }

}
