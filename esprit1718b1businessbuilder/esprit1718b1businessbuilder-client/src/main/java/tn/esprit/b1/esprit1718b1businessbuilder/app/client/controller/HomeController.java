/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import com.jfoenix.controls.JFXButton;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import org.controlsfx.control.textfield.TextFields;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.util.Callback;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.OrderLine;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Reserche;


import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote;


/**
 * FXML Controller class
 *
 * @author PEAR
 */
public class HomeController implements Initializable {

    @FXML
    private JFXButton btnSearch;
    @FXML
    private TextField search;

   
    @FXML
    private ListView<Company> list_company;
    @FXML
    private ListView<Produit> list_Recommandation;
    
    @FXML
    private Label companyPRE;

    @FXML
    private Label namePRE;

    @FXML
    private Label AdressPRE;

    @FXML
    private ImageView imgPRE;

    @FXML
    private Circle circle;
    @FXML
    private Circle circleCompanyRE;

    @FXML
    private Label companyRE;

    @FXML
    private Label companySectorRE;
    @FXML
    private Label nbrProduct_C_RE;

    @FXML
    private Label nbrProject_C_RE;
    
    private ObservableList<Company>  cplistSyn ;
    private ObservableList<Produit> produitRe ;
    private ObservableList<Company> cplist ;
    private Set<Company> hs = new HashSet<Company>();
    private ObservableList<Company> cplistservice ;
    private List<String> cplistname  = new ArrayList<>();
    private List<String> listservice  = new ArrayList<>();
    private List<String> cplist3s  = new ArrayList<>();
    private List<Company> test  = new ArrayList<>();
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	/////////////////////////////////////INITIALIZATION DES COMPANIES///////////////////////////////////////////////
   	 FXMLLoader lloader = new FXMLLoader(getClass().getResource("../gui/Main.fxml"));
     try {
         Parent rroot = lloader.load();
     } catch (IOException ex) {
        
     }
    	    String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 	
			CompanyServiceRemote proxy;
			try {
				 Context	context = new InitialContext();
				proxy = (CompanyServiceRemote) context.lookup(jndiName1);
				cplist = FXCollections.observableArrayList(proxy.findAllCompany());
			} catch (NamingException e) {
				e.printStackTrace();
			}
	 		list_company.setItems(cplist);
	 		list_company.setCellFactory(new Callback<ListView<Company>, javafx.scene.control.ListCell<Company>>()
	        {
				@Override
				public ListCell<Company> call(ListView<Company> param) {
					 return new CompanyRowController();
				}
	        });
	 		
	 		/*******************************autocomplete*********************************/
	 		
	 		
	 		String jndiName2 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 	
			 CompanyServiceRemote proxy2;
			 Context context;
			 Context contexts;
			
			 String jndiNames ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ServiceService!tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote" ; 
				
			try {
				 context = new InitialContext();
				 proxy = (CompanyServiceRemote) context.lookup(jndiName2);
				
				 contexts = new InitialContext();
				 ServiceServiceRemote proxys = (ServiceServiceRemote) contexts.lookup(jndiNames);
					
				 cplistname = FXCollections.observableArrayList(proxy.findAllCompanyNames());
				 listservice =FXCollections.observableArrayList(proxys.getAllService());
				 cplistname.addAll(listservice);
				 
				// cplistname.addAll(listservice) ;
				 //System.out.println(cplistname.toString());
				 
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 TextFields.bindAutoCompletion(search, cplistname) ; 
	////////////////////////////////////////INITIALIZE /// RECOMMANDATION//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    	 
	    	 
	    	
			   String jndiNameP ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ProductService!tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote" ; 	
			   ProductServiceRemote proxyP;
				try {
					 String service ;
					 Context contextP = new InitialContext();
					 proxyP = (ProductServiceRemote) contextP.lookup(jndiNameP);
					 List<Object[]> list = proxyP.findBestProduct();
					 long max = 0 ;
					OrderLine ord = new OrderLine() ;
					    for (Object[] o : list){
					    	OrderLine product = (OrderLine)o[1] ; 
					    	//System.out.println(sector.toString());
					    	
					    	long count = (long)o[0] ; 
					    	
					    	//System.out.println(count);
					    	if(count > max){
					    		max = count ;
					    		ord = product ;
					    		
					    	}
					    }
		
					 System.out.println(ord.getProd().getDescription());	 
					 //produitRe.add(ord.getProd()) ;
					 namePRE.setText(ord.getProd().getDescription());
					 AdressPRE.setText(ord.getProd().getSupplier().getAdress());
					 companyPRE.setText(ord.getProd().getSupplier().getName());
					 
		           /*  File file = new File(("D:/4inoB1/pdev_workspace/esprit1718b1businessbuilder/esprit1718b1businessbuilder/esprit1718b1businessbuilder-client/target/classes/tn/esprit/b1/esprit1718b1businessbuilder/app/client/images/"+ord.getProd().getPath()));
		            Image img = new Image(file.toURI().toString());
		            
		            //imgPRE.setImage(img);
		            circle.setFill(new ImagePattern(img));*/
		            
				} catch (NamingException e) {
					e.printStackTrace();
				}
				
	//////////////////////////////////BEST COMPANY/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				String jndiNameC ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 	
				 CompanyServiceRemote proxyC;
				 
				 try {
					context = new InitialContext();
					proxyC = (CompanyServiceRemote) context.lookup(jndiNameC);
					List<Object[]> list = proxyC.bestCompany();
					Company c = new Company(); 
					long max = 0 ;
				    for (Object[] o : list){
				    	
				    	Company company = (Company)o[1] ; 
				    	//System.out.println(company.toString());
				    	long count = (long)o[0] ; 
				    	//System.out.println(count);
				    	
				    	if(count > max){
				    		max = count ;
				    		c = company ;
				    	}
				    	 
				    }
				    nbrProduct_C_RE.setText(String.valueOf(max));
				    companyRE.setText(c.getName());
				    companySectorRE.setText(c.getSector());
				    
				    nbrProject_C_RE.setText(String.valueOf(proxyC.nbProjectByCompany(c)));
				   // System.out.println( proxyC.nbProjectByCompany(c));
				   File file = new File("D:/4inoB1/pdev_workspace/esprit1718b1businessbuilder/esprit1718b1businessbuilder/esprit1718b1businessbuilder-client/target/classes/tn/esprit/b1/esprit1718b1businessbuilder/app/client/images/" + c.getImage());
		           Image img = new Image(file.toURI().toString());
		           circleCompanyRE.setFill(new ImagePattern(img));
				    
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				
				
				
				
    }    

    @FXML
    private void makeSearch(ActionEvent event) throws NamingException {
    	String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 	
    	String jndiNames ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ServiceService!tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote" ; 
    	CompanyServiceRemote proxy;
		Context	context1 = new InitialContext();
		proxy = (CompanyServiceRemote) context1.lookup(jndiName1);
		ServiceServiceRemote proxys = (ServiceServiceRemote) context1.lookup(jndiNames);

    	
		//////////////////////////////////AFFICHAGE RECHERCHE/////////////////////////////////////////
    	String str = search.getText() ;
    	if (!str.equals("") ){
    		cplistservice =  FXCollections.observableArrayList(proxy.findAllCompanyByService(str));
    		cplist = FXCollections.observableArrayList(proxy.findAllCompanyByName(search.getText()));
    		cplistSyn = FXCollections.observableArrayList(proxys.findCompanyBysynonyme(search.getText()));
    		cplist.addAll(cplistservice);
    		cplist.addAll(cplistSyn);
    	    System.out.println(cplist.toString());
     		list_company.setItems(cplist);
     		list_company.setCellFactory(new Callback<ListView<Company>, javafx.scene.control.ListCell<Company>>()
            {
    			@Override
    			public ListCell<Company> call(ListView<Company> param) {
    				 return new CompanyRowController();
    			}
            });
     		//////////////////////////AJOUT DE RECHERCHE//////////////////////////////////////
     		Reserche reserche = new Reserche() ;
     		reserche.setReserche(search.getText());
     		Company c =proxy.findBy((long)33);
     		System.out.println(c);
     		proxy.AddCompanyReserche(reserche, c);
    	}
    	else {

			cplist = FXCollections.observableArrayList(proxy.findAllCompany());
	 		list_company.setItems(cplist);
	 		list_company.setCellFactory(new Callback<ListView<Company>, javafx.scene.control.ListCell<Company>>()
	        {
				@Override
				public ListCell<Company> call(ListView<Company> param) {
					 return new CompanyRowController();
				}
	        });
	 		
    	}

    } 
    
}
