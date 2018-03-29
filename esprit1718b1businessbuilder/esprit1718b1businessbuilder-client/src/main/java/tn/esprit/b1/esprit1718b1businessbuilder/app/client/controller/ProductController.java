package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

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

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote;

public class ProductController   implements Initializable {


	
	   @FXML
	    private TextField searchP;

	    @FXML
	    private JFXButton btnSearch;

	    @FXML
	    private ListView<Produit> ListP;

	    @FXML
	    private ListView<Produit> listPRe;
	    private ObservableList<Produit> ProductList ;
        private ObservableList<Company> cplist3 ;
        private List<Company> test  = new ArrayList<>();
        private List<String> cplist3s  = new ArrayList<>();
        private Set<Company> hs = new HashSet<Company>();
        private ObservableList<Produit> listefinale  = FXCollections.<Produit>observableArrayList();
    @FXML
    void makeSearch(ActionEvent event) {
    	
    }
	
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	
    	 FXMLLoader lloader = new FXMLLoader(getClass().getResource("../gui/Main.fxml"));
         try {
             Parent rroot = lloader.load();
         } catch (IOException ex) {
            
         }
///////////////////////////////////////////////INITILIZATIONRECOMMANDATION/////////////////////////////////////////////////////////////////////////////////////////////////////
    	 String jndiName2 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 	
		 String jndiNames ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ServiceService!tn.esprit.b1.esprit1718b1businessbuilder.services.ServiceServiceRemote" ; 

    	 CompanyServiceRemote proxy2;
		 Context context;
		 Context contexts;
    	 CompanyServiceRemote proxy3;
			
			try {
				 String service ;
				 Context	context3 = new InitialContext();
				 contexts = new InitialContext();
				 proxy3 = (CompanyServiceRemote) context3.lookup(jndiName2);
				 ServiceServiceRemote proxys = (ServiceServiceRemote) contexts.lookup(jndiNames);
				 cplist3s = proxys.ResercheListe(31);
				// System.out.println(cplist3s);
		     for( String s : cplist3s  ){			    	 
		    	 //System.out.println(s);
					 test = proxy3.findAllCompanyByService(s);
					// System.out.println(cplist3);
					 for(Company c : test){		
						// System.out.println(c);
						 // System.out.println(",yntbrve");
					            if (!hs.contains(c)){
					                hs.add(c);
					                //System.out.println(hs);
					        }
						}
				 }
				 
		     
			} catch (NamingException e) {
				e.printStackTrace();
			}
			List<Produit> listp = new ArrayList<>();
			 try {
				contexts = new InitialContext();
				 ServiceServiceRemote proxys = (ServiceServiceRemote) contexts.lookup(jndiNames);
				 
				 
					for(Company c : hs) {
						listp=	proxys.findProductByCompany(c) ;
					}
					
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			listefinale.addAll(listp); 
			listPRe.setItems(listefinale);
			listPRe.setCellFactory(new Callback<ListView<Produit>, javafx.scene.control.ListCell<Produit>>()
	        {
				@Override
				public ListCell<Produit> call(ListView<Produit> param) {
					 return new ProductRowReController();
				}
	        });
      /////////////////////////////////////////////////INITIALIAZE PRODUCT/////////////////////////////////////////////////////////////////////////
		
			   String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ProductService!tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote" ; 	
			 
			     try {
			         Parent rroot = lloader.load();
			     } catch (IOException ex) {
			        
			     }
			     ProductServiceRemote proxy;
						try {
							 Context	context1 = new InitialContext();
							proxy = (ProductServiceRemote) context1.lookup(jndiName1);
							ProductList = FXCollections.observableArrayList(proxy.findAllProduct());
						} catch (NamingException e) {
							e.printStackTrace();
						}
						ListP.setItems(ProductList);
						ListP.setCellFactory(new Callback<ListView<Produit>, javafx.scene.control.ListCell<Produit>>()
				        {
							@Override
							public ListCell<Produit> call(ListView<Produit> param) {
								 return new ProductRowController();
							}
				        });
		 		
			
			
			
	}
	


}
