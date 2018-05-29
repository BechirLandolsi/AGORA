package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.UserServiceRemote;

public class SecretQuestion implements Initializable {

    @FXML
    private JFXButton btn;
    @FXML
    private Label question;

    @FXML
    private TextField reponse;

    @FXML
    private MaterialDesignIconView iconClose;
    
    @FXML
    private Label labeltryy;
    
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	String jndiNameCategory = "esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote";
		Context context = null;
		try {
			context = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			UserServiceRemote proxyCategory = (UserServiceRemote) context.lookup(jndiNameCategory);
			User u = LoginController.LoggedUser ;
			question.setText(u.getSecretquestion());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
    @FXML
    void apply(ActionEvent event) throws NamingException, IOException {
    	String jndiNameCategory = "esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote";
		Context context = new InitialContext();
		UserServiceRemote proxyCategory = (UserServiceRemote) context.lookup(jndiNameCategory);
		User u = LoginController.LoggedUser ;
		Company c = (Company)u;
    	if (reponse.getText().equals(u.getResponse())){
    		 question.getScene().getWindow().hide();
    		 String format = "dd/MM/yy H:mm:ss";
				java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format ); 
				java.util.Date da = new java.util.Date();
				c.setSubDate(da);
				proxyCategory.update(c);
		        Parent root=FXMLLoader.load(getClass().getResource("../gui/Skeleton.fxml")); 
		        Stage mainStage=new Stage();
		        Scene scene=new Scene(root);
		        mainStage.setScene(scene);
		        mainStage.show();
    	}
    	
    	else {
    		labeltryy.setVisible(true);
    	}

    }
    
    @FXML
    void closeStage(MouseEvent event) {
    	iconClose.getScene().getWindow().hide();
    }

	

}
