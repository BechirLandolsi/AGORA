package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Bilan;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Partnership;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Project;
import tn.esprit.b1.esprit1718b1businessbuilder.services.BilanRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.PartnershipRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceService;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.NoResultException;

import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author bn
 */
public class ProjectController implements Initializable {

	
	@FXML
    private AnchorPane idanchor;
	
    @FXML
    private JFXButton btnajouter;
    
    @FXML
    private JFXButton btnajouterpartner;
       
    @FXML
    private JFXButton btnajouterproject;
    
    @FXML
    private TableView<Project> tab_project;
    
    @FXML
    private TableColumn<Project, String> col_name;
    @FXML
    private TableColumn<Project, String> col_service;
   
    @FXML
    private AnchorPane anchor1;

    @FXML
    private Label partnerLabel;
    
    @FXML
    private Label partnerLabel1;


    @FXML
    private AnchorPane anchor2;

    @FXML
    private JFXTextField projectnameEntry;

    @FXML
    private JFXComboBox <String> sectorcombobox;

    @FXML
    private RadioButton radio1;

    @FXML
    private RadioButton radio2;
    
    @FXML
    private JFXTextField purchase;

    @FXML
    private JFXTextField salaire;

    @FXML
    private JFXTextField energycost;

    @FXML
    private JFXTextField transpcost;

    @FXML
    private JFXTextField interestonloans;

    @FXML
    private JFXTextField rentcost;

    @FXML
    private JFXTextField capital;
    
    @FXML
    private JFXTextField product;

    
    @FXML
    private JFXComboBox <String> natureproectcombobox;
    

    @FXML
    private JFXTextField price;
    
    @FXML
    private Label remplirLabel;
    
    @FXML
    private Label remplirchampLabel;
    
    @FXML
    private JFXTextField stock;

    @FXML
    private Label stockLabel;
    

    @FXML
    private JFXButton btnajouterpartner1;
    
 /************************************************ Anchor pane 3 *************************************************/
    
    @FXML
    private AnchorPane anchor3;

    @FXML
    private Label label;

    @FXML
    private Label salesLabel;

    @FXML
    private Label CVLabel;

    @FXML
    private Label percentCVLabel;

    @FXML
    private Label MgLabel;

    @FXML
    private Label percentMgLabel;

    @FXML
    private Label CFLabel;

    @FXML
    private Label resultLabel;
    
    @FXML
    private Label SRLabel;

    @FXML
    private Label PointMortLabel;

    @FXML
    private Label fondDeRoulmntLabel;
    
    @FXML
    private ImageView happyimg;

    @FXML
    private ImageView sadimg;
    
    @FXML
    private Label StateLabel;
    
    
    
    /**
     * Initializes the controller class.
     */
    
	 private ObservableList<Project> listproject = FXCollections.observableArrayList();
	 ProjectService oe = new ProjectService();

	 
	 String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ProjectService!tn.esprit.b1.esprit1718b1businessbuilder.services.ProjectRemote" ; 
	 Context context1;
	 	 
	 String jndiName2 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/PartnershipService!tn.esprit.b1.esprit1718b1businessbuilder.services.PartnershipRemote" ; 
	 Context context2;
	 
	 String jndiName3 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ServiceService!tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote" ; 
	 Context context3;
	 
	 String jndiName4 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 
	 Context context4;
	 
	 String jndiName5 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/BilanService!tn.esprit.b1.esprit1718b1businessbuilder.services.BilanRemote" ; 
	 Context context5;
	 	 
	 Company c = null;
	 //ProjectRemote proxy;

   //  static Project o  ;

	 
	 public static Project p ;
	 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   	
   	 
    	 ObservableList<String> natureprojectList = FXCollections.observableArrayList();
         natureprojectList.add("Creation");
         natureprojectList.add("Recovery");
         natureproectcombobox.setItems(natureprojectList);
         	 
        	try {
       	context4 = new InitialContext();
       	CompanyServiceRemote proxy = (CompanyServiceRemote) context4.lookup(jndiName4);
       	Set <String> hashset = new HashSet<>();
       	hashset.addAll(proxy.getAllSectors());
       	ObservableList<String> comboList = FXCollections.observableArrayList(hashset);
       	sectorcombobox.setItems(comboList);
        
        	}
        	catch (NamingException e)
        	{
        		e.printStackTrace();
        		
        	}
    	
   	
	try {

		context1 = new InitialContext();
		ProjectRemote proxy = (ProjectRemote) context1.lookup(jndiName1);
		
		  listproject = FXCollections.observableArrayList(proxy.getProjectsByCompany((long) 2));
    	
 	     // col_project.setId("1");
    	  //col_project.cellFactoryProperty();
    	  
    	  col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
    	  col_name.cellFactoryProperty();
         
    	  col_service.setCellValueFactory(new PropertyValueFactory<>("service"));
    	  col_service.cellFactoryProperty();
    	     	  
    	  tab_project.setItems(listproject); 
    	  
	} catch (NamingException e) {
		
		e.printStackTrace();
	}
    	
    	
    }    


   @FXML
    void tableclick(MouseEvent event) {

    	if (tab_project.getSelectionModel().getSelectedItem() != null) {
    		 Project o = new Project();
    		 o = tab_project.getSelectionModel().getSelectedItem();
      	     Long id = o.getId();
          
           try {
        	  
            context2 = new InitialContext();
            
            PartnershipRemote proxy = (PartnershipRemote) context2.lookup(jndiName2);
    		List <String> names = new ArrayList<>();
    				names=proxy.getPartnerByProject(id);
    		
    		///partnerLabel.setVisible(true);
			//partnerLabel.setText(name);
    		
    		
    		if(names.isEmpty())
    		
    		{
    		partnerLabel.setVisible(false);
			partnerLabel1.setVisible(true);
	 		partnerLabel1.setText("You do not have partners in this project"); 
	 		btnajouterpartner1.setVisible(true);
    		}
    		
    		else
    		{   
    			btnajouterpartner1.setVisible(false);
    			partnerLabel1.setVisible(false);
    			partnerLabel.setVisible(true);
    			partnerLabel.setText(names.get(0));
    			
    			
    		}
    		
    	

    	} catch (NamingException e) {
    		
    		e.printStackTrace();
    	}
    		
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
    void btnajouter(ActionEvent event) {
    	
    	anchor1.setVisible(false);
    	anchor2.setVisible(true);
     	
    }
    
   
    @FXML
    void btnajouterproject(ActionEvent event) throws IOException, NamingException {
    	 	
    	
    	Company c = new Company();
    	c.setId((long) 2);
    	
    	
          	
        boolean n = false;
    	
        if ( projectnameEntry.getText().equals("") ) { n=true; remplirchampLabel.setText("Please fill in all the fields"); }
        if (  stock.getText().equals("") ) { n=true; remplirchampLabel.setText("Please fill in all the fields"); }
        if (  price.getText().equals("")  ) { n=true; remplirchampLabel.setText("Please fill in all the fields"); }
        if (  purchase.getText().equals("") ) { n=true; remplirchampLabel.setText("Please fill in all the fields"); }
        if (  energycost.getText().equals("") ) { n=true; remplirchampLabel.setText("Please fill in all the fields"); }
        if (  transpcost.getText().equals("") ) { n=true; remplirchampLabel.setText("Please fill in all the fields"); }
        if (  salaire.getText().equals("") ) { n=true; remplirchampLabel.setText("Please fill in all the fields"); }
        if (  interestonloans.getText().equals("") ) { n=true; remplirchampLabel.setText("Please fill in all the fields"); }
        if (  rentcost.getText().equals("") ) { n=true; remplirchampLabel.setText("Please fill in all the fields"); }
        if (  capital.getText().equals("") ) { n=true; remplirchampLabel.setText("Please fill in all the fields"); }
        if (  product.getText().equals("") ) { n=true; remplirchampLabel.setText("Please fill in all the fields"); }
        //if (  natureproectcombobox.getValue()!="" ) { n=true; remplirchampLabel.setText("Please fill in all the fields"); }
      //  if (  sectorcombobox.getValue()!="") { n=true; remplirchampLabel.setText("Please fill in all the fields"); }


        if (n==true)
       	{
    		 remplirchampLabel.setText("Please fill in all the fields");
    		
    	}
    	
    	
    	if (n==false)
    	{context1 = new InitialContext();
		 ProjectRemote proxy = (ProjectRemote) context1.lookup(jndiName1);
		 
		 p = new Project();
	    	
	    	
	    	p.setName(projectnameEntry.getText());
	    	p.setProjectNature(natureproectcombobox.getValue());
	    	p.setService(sectorcombobox.getValue());
	    	p.setStock(Integer.parseInt(stock.getText()));
	    	p.setPriceUnit(Float.parseFloat(price.getText()));
	    	p.setPurchase(Float.parseFloat(purchase.getText()));
	    	p.setEnergyCost(Float.parseFloat(energycost.getText()));
	    	p.setTransportCost(Float.parseFloat(transpcost.getText()));
	    	p.setEmployeeSalaire(Float.parseFloat(salaire.getText()));
	    	p.setInterestOnLoans(Float.parseFloat(interestonloans.getText()));
	    	p.setRentCost(Float.parseFloat(rentcost.getText()));
	    	p.setCapital(Float.parseFloat(capital.getText()));
	    	p.setProduct(product.getText());
	    	p.setState(false);
	    	p.setProjectOwner(c);

	    	float CA = p.getStock()*p.getPriceUnit();
	    	float CV =p.getPurchase()+p.getEnergyCost()+p.getTransportCost();
	    	float percentCV = (CV/CA)*100 ;
	    	float Mg = CA-CV;
	    	float percentMg= (Mg/CA)*100;
	    	float CF = p.getRentCost()+p.getEmployeeSalaire()+p.getInterestOnLoans();
	    	float result = Mg-CF;
	    	float SR = CF/Mg;
	    	float PM = (SR/CA)*12;
	    	//float FR= (p.getCapital()+p.getInterestOnLoans())-(p.getTransportCost()+p.getEnergyCost());
	    	float FR =(float) (502.5);
	    	
	    	if (FR>0)
	    	{
	    		happyimg.setVisible(true);
	    		StateLabel.setTextFill(Color.GREEN);
	    		p.setState(true);
	    		StateLabel.setText("Your financial state is stable");
	    	}
	    	
	    	if (FR<0)
	    	{
	    		sadimg.setVisible(true);
	    		p.setState(false);
	    		StateLabel.setTextFill(Color.RED);
	    		StateLabel.setText("Your financial state is in danger");

	    		
	    	}	
	    
	    	Bilan b = new Bilan();
	    	b.setCA(CA);
	    	b.setCF(CF);
	    	b.setCV(CV);
	    	b.setMargeSurCoutV(Mg);
	    	b.setResult(result);
	    	b.setSR(SR);
	    	b.setPM(PM);
	    	b.setFR(FR);
	    	
	     	salesLabel.setText(String.valueOf(CA));
	      	
	    	CVLabel.setText(String.valueOf(CV));
	    	percentCVLabel.setText(String.valueOf(percentCV)+"%");
	    	
	    	MgLabel.setText(String.valueOf(Mg));
	    	percentMgLabel.setText(String.valueOf(percentMg)+"%");
	    	
	    	CFLabel.setText(String.valueOf(CF));
	    	
	    	resultLabel.setText(String.valueOf(result));
	    	
	    	SRLabel.setText(String.valueOf(SR));
	    	
	    	PointMortLabel.setText(String.valueOf(PM));
	    	
	    	fondDeRoulmntLabel.setText(String.valueOf(FR));
	    	
	    	
	    	
	    	
	    		anchor2.setVisible(false);
	    		anchor3.setVisible(true);
	        	label.setText(p.getName());
		 proxy.addProject(p,b);
		 
    	}
		 
    		
    }

   

    @FXML
    void floatkey1(KeyEvent event) {
    	
        if( (price.getText().trim().length()>0) )
        		{
         try {
            float i1 = Float.parseFloat(price.getText());
                    
             }
         catch (NumberFormatException e) {
            remplirLabel.setVisible(true);
            remplirLabel.setText("Please enter numerical values");
            }
        }
        
        else{
        	remplirLabel.setVisible(false);
            }
    	
    	

    }
    
    @FXML
    void floatkey2(KeyEvent event) {
    	
        if( (purchase.getText().trim().length()>0) )
        		{
         try {
            
            float i2 = Float.parseFloat(purchase.getText());
            
             }
         catch (NumberFormatException e) {
            remplirLabel.setVisible(true);
            remplirLabel.setText("Please enter numerical values");
            }
        }
        
        else{
        	remplirLabel.setVisible(false);
            }
    }
    
    
    @FXML
    void floatkey3(KeyEvent event) {
    	
        if( (energycost.getText().trim().length()>0) )
        		{
         try {
          
            float i3 = Float.parseFloat(energycost.getText());
           
             }
         catch (NumberFormatException e) {
            remplirLabel.setVisible(true);
            remplirLabel.setText("Please enter numerical values");
            }
        }
        
        else{
        	remplirLabel.setVisible(false);
            }
    }
    
    
    @FXML
    void floatkey4(KeyEvent event) {
    	
        if( (transpcost.getText().trim().length()>0) )
        		{
         try {
           
            float i4 = Float.parseFloat(transpcost.getText());
            
             }
         catch (NumberFormatException e) {
            remplirLabel.setVisible(true);
            remplirLabel.setText("Please enter numerical values");
            }
        }
        
        else{
        	remplirLabel.setVisible(false);
            }
    }
    
   
    
@FXML
void floatkey5(KeyEvent event) {
	
    if( salaire.getText().trim().length()>0 )
    		{
     try {
       
        float i5 = Float.parseFloat(salaire.getText());

        
         }
     catch (NumberFormatException e) {
        remplirLabel.setVisible(true);
        remplirLabel.setText("Please enter numerical values");
        }
    }
    
    else{
    	remplirLabel.setVisible(false);
        }
}


@FXML
void floatkey6(KeyEvent event) {
	
    if( interestonloans.getText().trim().length()>0 )
    		{
     try {
        
        float i6 = Float.parseFloat(interestonloans.getText());        
         }
     catch (NumberFormatException e) {
        remplirLabel.setVisible(true);
        remplirLabel.setText("Please enter numerical values");
        }
    }
    
    else{
    	remplirLabel.setVisible(false);
        }
}


@FXML
void floatkey7(KeyEvent event) {
	
    if( (rentcost.getText().trim().length()>0) )
    		{
     try {
       
        float i7 = Float.parseFloat(rentcost.getText());
        
         }
     catch (NumberFormatException e) {
        remplirLabel.setVisible(true);
        remplirLabel.setText("Please enter numerical values");
        }
    }
    
    else{
    	remplirLabel.setVisible(false);
        }
}

@FXML
void floatkey8(KeyEvent event) {
	
    if( (stock.getText().trim().length()>0) )
    		{
     try {
       
        int i7 = Integer.parseInt(stock.getText());
        
         }
     catch (NumberFormatException e) {
        stockLabel.setVisible(true);
        stockLabel.setText("Please enter an integer number");
        }
    }
    
    else{
    	stockLabel.setVisible(false);
        }
    
    
}

@FXML
void floatkey9(KeyEvent event) {
	
    if( capital.getText().trim().length()>0 )
    		{
     try {
        
        float i6 = Float.parseFloat(capital.getText());        
         }
     catch (NumberFormatException e) {
        remplirLabel.setVisible(true);
        remplirLabel.setText("Please enter numerical values");
        }
    }
    
    else{
    	remplirLabel.setVisible(false);
        }
}


@FXML
void floatkey10(KeyEvent event) {
	


}
    
@FXML
void tableclick1(MouseEvent event) {

}
    
@FXML
void btnajouterpartner(ActionEvent event) throws IOException 
{
	
	 //menuScheduling.getScene().getWindow().hide();
     Stage news=new Stage();
     Parent root=FXMLLoader.load(getClass().getResource("../gui/Partnership.fxml"));
     Scene s=new Scene(root);
     news.setScene(s);
     news.show();
	

}



  

} 
    
    
    

