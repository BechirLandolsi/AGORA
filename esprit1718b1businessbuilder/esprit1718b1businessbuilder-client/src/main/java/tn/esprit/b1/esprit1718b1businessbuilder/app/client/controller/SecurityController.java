package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.animation.RotateTransition;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.UserServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.utilities.TimeBasedOneTimePasswordUtil;

public class SecurityController implements Initializable {

	public static Boolean asked = false ;
	public static String codefinal = "" ;
	public static final String ACCOUNT_SID = "AC4d4a4742b636ad7fd321f43800a2d11c";
	public static final String AUTH_TOKEN = "457aba64823219cdc55fe1b73465963e";
	
	   @FXML
	    private Label one;

	    @FXML
	    private Label two;

	    @FXML
	    private Label three;
    @FXML
    private TextField code;
    @FXML
	private MaterialDesignIconView iconClose;

    @FXML
    private JFXButton ask;
    
    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;
    @FXML
    private JFXButton log;
    
    private RotateTransition rotateTransition1, rotateTransition2, rotateTransition3; 
    
    @FXML
    private JFXCheckBox check;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	
    	
   
        rotateTransition1 = new RotateTransition(Duration.seconds(5), img1);
        rotateTransition2 = new RotateTransition(Duration.seconds(5), img2);
        rotateTransition3 = new RotateTransition(Duration.seconds(5), img3);
       

        RotateTransition[] transition = {rotateTransition1, rotateTransition2,
            rotateTransition3};

        for (RotateTransition rotateTransition : transition) {
            rotateTransition.setCycleCount(1);
            rotateTransition.setAutoReverse(false);
            rotateTransition.setFromAngle(720);
            rotateTransition.setToAngle(0);
        }

        

    }

    @FXML
	void closeStage(MouseEvent event) {
		iconClose.getScene().getWindow().hide();
	}
	
    @FXML
    void log(ActionEvent event) {
    		asked=true ;
    		//Thread.currentThread().interrupt();
    		if ( codefinal.equals(code.getText())){
    			 img2.setImage(new Image("file:///C:/Users/Mariem/git/esprit1718b1businessbuilder/esprit1718b1businessbuilder/esprit1718b1businessbuilder-client/src/main/java/tn/esprit/b1/esprit1718b1businessbuilder/app/client/images/synching.png"));
    	          two.setVisible(true);
    	            rotateTransition2.play();
    		
    			rotateTransition2.setOnFinished((ActionEvent event2) -> {
    	            img2.setImage(new Image("file:///C:/Users/Mariem/git/esprit1718b1businessbuilder/esprit1718b1businessbuilder/esprit1718b1businessbuilder-client/src/main/java/tn/esprit/b1/esprit1718b1businessbuilder/app/client/images/ok.png"));
    	           // lbl2.setStyle("-fx-background-color:#47A563");
    	          
    	        });
    		}
    }
    @FXML
    void askforlogin(ActionEvent event) throws GeneralSecurityException, InterruptedException {
    	
    Task<Integer> task = new Task<Integer>() {
    		
    	    @Override protected Integer call() throws Exception {
    	    	 System.out.println("1");
    	        int iterations;
    	        
    	        /*for (iterations = 0; iterations < 100000; iterations++) {
    	            if (asked==true) {
    	               break;
    	            }*/
    	        while(asked==false){
    	            String base32Secret = "NY4A5CPJZ46LXZCP";
    	    		String code;
    	    		try {
    	    			code = TimeBasedOneTimePasswordUtil.generateCurrentNumberString(base32Secret);
    	    			long diff = TimeBasedOneTimePasswordUtil.DEFAULT_TIME_STEP_SECONDS
        						- ((System.currentTimeMillis() / 1000) % TimeBasedOneTimePasswordUtil.DEFAULT_TIME_STEP_SECONDS);
        				
        					code = TimeBasedOneTimePasswordUtil.generateCurrentNumberString(base32Secret);
        					//System.out.println("Secret code = " + code + ", change in " + diff + " seconds");
        					Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        		            com.twilio.rest.api.v2010.account.Message msg =
        		            com.twilio.rest.api.v2010.account.Message.creator(new PhoneNumber("+21692339150"),
        		            new PhoneNumber("+16106248035"),"votre code securité est : "+ code).create();
        		            System.out.println (code);
        		            codefinal = code ;
        		            Thread.sleep(30000);        				
        					codefinal = code ;
        				
    	    		} catch (GeneralSecurityException e) {
    	    			// TODO Auto-generated catch block
    	    			e.printStackTrace();
    	    		}
    	            
    	        }
    	        
    	        return 0;
    	    }
    	    
    	};
    	new Thread(task).start();
    img1.setImage(new Image("file:///C:/Users/Mariem/git/esprit1718b1businessbuilder/esprit1718b1businessbuilder/esprit1718b1businessbuilder-client/src/main/java/tn/esprit/b1/esprit1718b1businessbuilder/app/client/images/synching.png"));
        one.setVisible(true);
    	rotateTransition1.setOnFinished((ActionEvent event1) -> {
            img1.setImage(new Image("file:///C:/Users/Mariem/git/esprit1718b1businessbuilder/esprit1718b1businessbuilder/esprit1718b1businessbuilder-client/src/main/java/tn/esprit/b1/esprit1718b1businessbuilder/app/client/images/ok.png"));
           // lbl1.setStyle("-fx-background-color:#47A563");
           
        });
        rotateTransition1.play();
			
    }
    
    @FXML
    void checkregister(ActionEvent event) throws NamingException, UnknownHostException, SocketException {
    	  img3.setImage(new Image("file:///C:/Users/Mariem/git/esprit1718b1businessbuilder/esprit1718b1businessbuilder/esprit1718b1businessbuilder-client/src/main/java/tn/esprit/b1/esprit1718b1businessbuilder/app/client/images/synching.png"));
         three.setVisible(true);
          rotateTransition3.play();
    	rotateTransition3.setOnFinished((ActionEvent event2) -> {
            img3.setImage(new Image("file:///C:/Users/Mariem/git/esprit1718b1businessbuilder/esprit1718b1businessbuilder/esprit1718b1businessbuilder-client/src/main/java/tn/esprit/b1/esprit1718b1businessbuilder/app/client/images/ok.png"));
        });	
    	/*********************************/
    	String jndiNameCategory = "esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote";
		Context context = new InitialContext();
		CompanyServiceRemote proxyCategory = (CompanyServiceRemote) context.lookup(jndiNameCategory);
		Company u = proxyCategory.findBy(LoginController.LoggedUser.getId());
		/*********************************/
		InetAddress ip;
		ip = InetAddress.getLocalHost();
		// System.out.println("Current IP address : " + ip.getHostAddress());
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);
		byte[] mac = network.getHardwareAddress();
		//System.out.print("Current MAC address : ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
		}
		/********************************/
		u.setMac(sb.toString());
		proxyCategory.update(u);
    }
}