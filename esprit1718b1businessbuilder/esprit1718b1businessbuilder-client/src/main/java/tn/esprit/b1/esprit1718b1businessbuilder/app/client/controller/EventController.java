package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;



public class EventController implements Initializable {

    @FXML
    private JFXButton createevent;
    @FXML
    private JFXButton myevent;
    @FXML
    private AnchorPane addanchorepane;
    @FXML
    private JFXTextField eventname;
    @FXML
    private Label en;
    @FXML
    private Label ea;
    @FXML
    private JFXTextField eventname1;
    @FXML
    private Label ed;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onclick_create(ActionEvent event) {
    	addanchorepane.setVisible(true);
    }

    @FXML
    private void onclick_myevent(ActionEvent event) {
    }
    
}
