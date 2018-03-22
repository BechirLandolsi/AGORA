/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import com.jfoenix.controls.JFXButton;


import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author PEAR
 */
public class HomeController implements Initializable {

    @FXML
    private JFXButton btnSearch;
    @FXML
    private TextField search;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	String [] suggestion = {"ahmedddd","ahmed","nour","nouuuuur"};
    	TextFields.bindAutoCompletion(search, suggestion) ; 
    }    

    @FXML
    private void makeSearch(ActionEvent event) {
    	
    }
    
}
