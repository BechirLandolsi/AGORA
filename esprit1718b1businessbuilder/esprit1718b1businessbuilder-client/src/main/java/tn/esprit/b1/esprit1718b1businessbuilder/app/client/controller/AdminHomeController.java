package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Nourelhouda
 */
public class AdminHomeController implements Initializable {

    @FXML
    private JFXButton btnHome;
    @FXML
    private JFXButton btnPricing;
    @FXML
    private JFXButton btnContacts;
    @FXML
    private JFXButton btnWidgets;
    @FXML
    private JFXButton btnProfile;
    @FXML
    private JFXButton btnAlerts;
    @FXML
    private JFXButton btnControls;
    @FXML
    private AnchorPane holderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void switchPricing(ActionEvent event) {
    }

    @FXML
    private void switchContacts(ActionEvent event) {
    }

    @FXML
    private void switchWidget(ActionEvent event) {
    }

    @FXML
    private void switchProfile(ActionEvent event) {
    }

    @FXML
    private void switchAlert(ActionEvent event) {
    }

    @FXML
    private void switchControls(ActionEvent event) {
    }
    
}
