package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.UserService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.UserServiceRemote;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class SignupController implements Initializable {
	private static double progress1 = 0;
    private static double progress2 = 0;
    private static double progress3 = 0;
    private static double progress4 = 0;
    private static double progress5 = 0;
    private static double progress6 = 0;
    private static double progress7 = 0;
    private static double progress8 = 0;
    private static double progress9 = 0;
    private static double progress10 = 0;
	
	@FXML
	private ProgressBar progressPersonal;

	@FXML
	private Label lblComplete;

    @FXML
    private MaterialDesignIconView iconClose;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField login;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXPasswordField password2;

    @FXML
    private JFXButton register;
    @FXML
    private Label warning1;
    @FXML
    private Label warning2;
    @FXML
    private Label warning;
    
    public static Double progress ; 
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
        updateProgress();
       

	}
	
    
    
    
    
    public Double updateProgress() {
    DecimalFormat decimalFormat = new DecimalFormat("###.#");
    decimalFormat.setRoundingMode(RoundingMode.HALF_UP);

    //progressPersonal.setProgress(0.00);       
    double sum_progress = progress10 + progress1 + progress2 + progress3 + progress4 + progress5 + progress6 + progress7 + progress8 + progress9;
    
    email.textProperty().addListener(new ChangeListener<String>() {	
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if (!newValue.isEmpty()) {
                progress1 = 0.1;

            } else {
                progress1 = 0.0;

            }
            double sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5 + progress6 + progress7 + progress8 + progress9);
            progressPersonal.setProgress(sum);
            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
        }
    });
    
    login.textProperty().addListener(new ChangeListener<String>() {	
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if (!newValue.isEmpty()) {
                progress2 = 0.1;

            } else {
                progress2 = 0.0;

            }
            double sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5 + progress6 + progress7 + progress8 + progress9);
            progressPersonal.setProgress(sum);
            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
        }
    });
    
    password2.textProperty().addListener(new ChangeListener<String>() {	
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if (!newValue.isEmpty()) {
                progress3 = 0.1;

            } else {
                progress3 = 0.0;

            }
            double sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5 + progress6 + progress7 + progress8 + progress9);
            progressPersonal.setProgress(sum);
            lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
        }
    });
    
    return sum_progress * 100 ;
    
    }
    @FXML
    void closeStage(MouseEvent event) {
    	 iconClose.getScene().getWindow().hide();
    }

    @FXML
    void register(ActionEvent event) throws NamingException {
    	String jndiNameCategory ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote";
    	Context context = new InitialContext();
    	UserServiceRemote proxyCategory = (UserServiceRemote) context.lookup(jndiNameCategory);
    	
    	Company u = new Company ();
    	u.setEmail(email.getText());
    	u.setLogin(login.getText());
    	u.setPassword(password2.getText());
    	u.setRole("member");
    	
    	u.setNumber(0);
    	u.setRate(0);
    	
    	if(password.getText().equals(password2.getText())){
    	register.setDisable(false); 
    	 progress = updateProgress();
    	 u.setProgress(progress);
    	proxyCategory.save(u);
    	
    	}
    	else {
    		//register.setDisable(true);
    		warning.setText("Password do not matches ! ");   		
    	}
    	
    	//System.out.println(updateProgress());
    }
    
    @FXML
    void test1(KeyEvent  event ) {
    	 String masque = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+"+"[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
         Pattern pattern = Pattern.compile(masque);
         Matcher controler = pattern.matcher(email.getText());
         
         if (controler.matches()){            
             warning1.setVisible(false);
             System.out.println ("lol");
             register.setDisable(false);                            
         }
         else{
         warning1.setVisible(true);
         warning1.setText("please type a valid email address !");
         register.setDisable(true);
         }
    }
    
    @FXML
    void test2(KeyEvent event) throws NamingException {
    	String jndiNameCategory ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/UserService!tn.esprit.b1.esprit1718b1businessbuilder.services.UserServiceRemote";
    	Context context = new InitialContext();
    	UserServiceRemote proxyCategory = (UserServiceRemote) context.lookup(jndiNameCategory);
    	Boolean r = proxyCategory.findByLogin(login.getText());
        warning2.setVisible(false);

    	if (r==true){
            warning2.setVisible(true);
            warning2.setText("Login already exists !");
    	}
    	
    }
	
    
    
    
    

}
