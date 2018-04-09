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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Tender;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Beshir
 */
public class MyTendersController implements Initializable {

    @FXML
    private ListView<Tender> list_MyTenders;
    @FXML
    private JFXButton AddTender;
    @FXML
    private StackPane rootPane;
    
    public static AnchorPane staticPane;
    public static StackPane mainRootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnAddTender(ActionEvent event) {
        setStage("../gui/AddMyTender.fxml");
    }
    
    private void setStage(String fxml) {
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
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
