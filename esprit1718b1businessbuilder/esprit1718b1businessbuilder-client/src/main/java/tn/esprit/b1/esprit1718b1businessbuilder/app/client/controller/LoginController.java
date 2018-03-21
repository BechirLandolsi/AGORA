package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author PEAR
 */

public class LoginController implements Initializable {

    @FXML
    private JFXButton btnLogin;
    
    @FXML
    private Label signup;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void doLogin(ActionEvent event) throws IOException {
        btnLogin.getScene().getWindow().hide();
        Parent root=FXMLLoader.load(getClass().getResource("../gui/Main.fxml")); // c'est la même ligne eli f netbeans
        Stage mainStage=new Stage();
        Scene scene=new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
    }

    @FXML
    void DoSignUp(MouseEvent event) {

    }

}