package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author PEAR
 */

public class Agora extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
    	
        Parent root = FXMLLoader.load(getClass().getResource("../gui/Login.fxml"));
        
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

