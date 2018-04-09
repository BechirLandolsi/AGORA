package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.UserService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.UserServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.TimeBasedOneTimePasswordUtil;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author PEAR
 */

public class LoginController implements Initializable {
	
	public static User LoggedUser = null ;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private JFXTextField login;

    @FXML
    private JFXPasswordField password;

    @FXML
    private Label signup;
    
    @FXML
    private ImageView qr;
    
    public static StackPane mainRootPane;
    @FXML
    private StackPane rootPane;
    @FXML
    private Label erreur;
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	mainRootPane=rootPane;  
    	/******************************************/
    	
    }    

    @FXML
    private void doLogin(ActionEvent event) throws IOException, NamingException {
    	
    	String jndiNameCategory ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/UserService!tn.esprit.b1.esprit1718b1businessbuilder.services.UserServiceRemote";
    	Context context = new InitialContext();
    	UserServiceRemote proxyCategory = (UserServiceRemote) context.lookup(jndiNameCategory);
 
    	if ( (proxyCategory.findByLogin(login.getText()) == true) && (proxyCategory.findByPassword(password.getText()) == true) )  {
    	System.out.println("aa");
        btnLogin.getScene().getWindow().hide();
        Parent root=FXMLLoader.load(getClass().getResource("../gui/Main.fxml")); 
        Stage mainStage=new Stage();
        Scene scene=new Scene(root);
        mainStage.setScene(scene);
        mainStage.show();
        
        /*String base32Secret = "NY4A5CPJZ46LXZCP";
    	String keyId = "user@j256.com";*/
       // System.out.println("Image url = " + TimeBasedOneTimePasswordUtil.qrImageUrl(keyId, base32Secret));
       // qr.setId(TimeBasedOneTimePasswordUtil.qrImageUrl(keyId, base32Secret));
        
       /* final String imageURI = "http://www.developpez.com/template/images/logo.png"; 
        final Image image = new Image(imageURI);
        final ImageView imageView = new ImageView(image); 
        final Pane root = new Pane(); 
        root.getChildren().setAll(imageView); */
        
       }
    	else {
    		erreur.setText("Invalid UserName or Password !");
    }
    	 LoggedUser = proxyCategory.login(login.getText(), password.getText()) ;	
    }

    @FXML
    void doSignUp(MouseEvent event) {
    	setStage("../gui/Signup.fxml");

    	
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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}