package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javafx.util.Duration;

import tn.esprit.b1.esprit1718b1businessbuilder.entities.Admin;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;

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
    @FXML
    private ImageView qr2;
   
    public static final String ACCOUNT_SID = "ACb12b823cb956312800f45ad12ffdb72b";
	public static final String AUTH_TOKEN = "47af9a87502d0a04ad82036e1d7f463a";

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
    private void doLogin(ActionEvent event) throws IOException, NamingException, GeneralSecurityException, InterruptedException {
    	
    	String jndiNameCategory ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/UserService!tn.esprit.b1.esprit1718b1businessbuilder.services.UserServiceRemote";
    	Context context = new InitialContext();
    	UserServiceRemote proxyCategory = (UserServiceRemote) context.lookup(jndiNameCategory);
    	
    	String base32Secret = "NY4A5CPJZ46LXZCP";
		String code;
		try {
			code = TimeBasedOneTimePasswordUtil.generateCurrentNumberString(base32Secret);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
    	if ( (proxyCategory.findByLogin(login.getText()) == true) && (proxyCategory.findByPassword(password.getText()) == true) )  {
    	System.out.println("1");
    	LoggedUser = proxyCategory.login(login.getText(), password.getText()) ;	
		
    		if(LoggedUser!=null && LoggedUser instanceof Company) {
    			System.out.println("3");
    			
    			
    	        /**************************************************************/

    	    	InetAddress ip;
    	    	try {
    	    			
    	    		ip = InetAddress.getLocalHost();
    	    		//System.out.println("Current IP address : " + ip.getHostAddress());
    	    		
    	    		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
    	    			
    	    		byte[] mac = network.getHardwareAddress();
    	    			
    	    			
    	    		StringBuilder sb = new StringBuilder();
    	    		for (int i = 0; i < mac.length; i++) {
    	    			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
    	    		}
    	    		
    	    		System.out.println(sb.toString());
    	    		
    	    		if (LoggedUser.getMac().equals(sb.toString()) ){
    	    			System.out.println("2");
    	    			 btnLogin.getScene().getWindow().hide();
    	    		        Parent root=FXMLLoader.load(getClass().getResource("../gui/Skeleton.fxml")); 
    	    		        Stage mainStage=new Stage();
    	    		        Scene scene=new Scene(root);
    	    		        mainStage.setScene(scene);
    	    		        mainStage.show();
    	    		        
    	    	   }
    	    		else {
    	    			   			
    	    			setStage("../gui/Security.fxml");
    	    
    	    		}
    	            
    	    			
    	    	} catch (UnknownHostException e) {
    	    		
    	    		e.printStackTrace();
    	    		
    	    	} catch (SocketException e){
    	    			
    	    		e.printStackTrace();
    	    			
    	    	}
    	   }
    	 else if (LoggedUser!=null && LoggedUser instanceof Admin) {
    	        btnLogin.getScene().getWindow().hide();
    	        Parent root=FXMLLoader.load(getClass().getResource("../gui/AdminHome.fxml")); 
    	        Stage mainStage=new Stage();
    	        Scene scene=new Scene(root);
    	        mainStage.setScene(scene);
    	        mainStage.show();
    	       
    	    	 }


    		
    	
      
       

       }
    	
    	else {   		
    		erreur.setText("Invalid UserName or Password !"); 		
    }
    	    	 //LoggedUser = proxyCategory.login(login.getText(), password.getText()) ;	

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