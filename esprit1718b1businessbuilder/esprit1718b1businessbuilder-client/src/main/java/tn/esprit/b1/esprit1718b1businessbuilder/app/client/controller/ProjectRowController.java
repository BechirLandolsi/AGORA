package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;




import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.controlsfx.control.GridCell;
import org.controlsfx.control.Rating;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Event;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;
import tn.esprit.b1.esprit1718b1businessbuilder.services.EventServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.PartnershipRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote;

public class ProjectRowController extends ListCell<Project> {

    @FXML
    private AnchorPane cell;

    @FXML
    private Label nameLabel;

    @FXML
    private Label serviceLabel;

    @FXML
    private Label adress;

    @FXML
    private Label sector1;

    @FXML
    private Label sector11;

    @FXML
    private Label sector12;

    @FXML
    private Label productLabel;

    @FXML
    private Label stateLabel;

    @FXML
    private Label stateLabel1;

    @FXML
    private Label scoreLabel;

    @FXML
    private Label partnerLabel;

    @FXML
    private Label sector121;
    
    @FXML
    private Label countLabel;
    
    private FXMLLoader mLLoader;
    
    @FXML
    private JFXButton btnajouterpartner1;
    
    @FXML
    private JFXButton btnsupprimerproject;
    

/*******************************************************************************************************************/
    
    String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ProjectService!tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote" ; 
	 Context context1;
	 
	 String jndiName2 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/PartnershipService!tn.esprit.b1.esprit1718b1businessbuilder.services.PartnershipRemote" ; 
	 Context context2;
    
    
    
 /**************************************************************************************************************/
  
	   static Project project1;
	   
	   
    
    @Override
    protected void updateItem(Project project, boolean empty) {
    	
    
    	
    	 if (empty || project == null) {

             setText(null);
             setGraphic(null);

         } else {
             if (mLLoader == null) {
                 mLLoader = new FXMLLoader(getClass().getResource("../gui/ProjectRow.fxml"));
                 mLLoader.setController(this);

                 try {
                     mLLoader.load();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

             }
             nameLabel.setText(project.getName());
             serviceLabel.setText(project.getService());
             productLabel.setText(project.getProduct());
             if(project.isState()==true)
             {
             stateLabel.setText("Stable project");
             }
             else  stateLabel.setText("UnStable project");
             
             scoreLabel.setText(String.valueOf(project.getQuality()));
             countLabel.setText(String.valueOf(project.getCount()));
             
             try {
           	  
                 context2 = new InitialContext();
                 
                 PartnershipRemote proxy = (PartnershipRemote) context2.lookup(jndiName2);
         		List <String> names = new ArrayList<>();
         				names=proxy.getPartnerByProject(project.getId());
         		
         		
         		if(names.isEmpty())
         		
         		{
         		
     	 		partnerLabel.setText("You do not have partners in this project"); 
     	 		btnajouterpartner1.setVisible(true);
     	 		
     	 		btnajouterpartner1.setOnMouseClicked(projet->project1=project);
     	 		//btnsupprimerproject.setOnMouseClicked(event->project1=project);
     	 		btnsupprimerproject.setVisible(true);
     	 		btnsupprimerproject.setOnAction(projet->{
     	 			
     	 				try {
							context1 = new InitialContext();
							ProjectRemote proxy1= (ProjectRemote) context1.lookup(jndiName1);
							
	             			proxy1.delete(project);

						} catch (NamingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
                 		             		
             		
                 	
                 });
     	 		
     	 		
     	 		
         		}
         		
         		else
         		{   
         			btnajouterpartner1.setVisible(false);
         			partnerLabel.setText(names.get(0));
         			
         		}
         		
         		
         		

         	} catch (NamingException e) {
         		
         		e.printStackTrace();
         	}
       	

            
        	
           
             
             setText(null);
             setGraphic(cell);
         }
    	 
    	 
    	
    
    }
    

    
    @FXML
    void btnajouterpartner1(ActionEvent event) throws IOException {
    	 
    	
    	 Stage news=new Stage();
         Parent root=FXMLLoader.load(getClass().getResource("../gui/Partnership.fxml"));
         Scene s=new Scene(root);
         news.setScene(s);
         news.show();

    }
    
    @FXML
    void btnsupprimerproject(ActionEvent event) throws NamingException {
    	
    
    	
    }
    
    @FXML
    void pickproject(MouseEvent event) {

    }
    	
   
}
