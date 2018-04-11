/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.TenderQualification;

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
    
    private ObservableList<String> all_qualifications = FXCollections.observableArrayList();
    private ObservableList<String> all_categories = FXCollections.observableArrayList();
    @FXML
    private ComboBox<String> combo_qualif;
    @FXML
    private ComboBox<String> combo_cat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	combo_qualif.getItems().addAll("Same Country","Reached Profile 90%","Has at least 3 stars","Has at least 4 stars");
    	combo_cat.getItems().addAll("IT","Industry","Banking","Construction");
    	
    }    

    @FXML
    private void closeStage(MouseEvent event) {
        iconClose.getScene().getWindow().hide();
    }

    @FXML
    private void post(ActionEvent event) {
    }
    
}
