package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import javafx.scene.layout.AnchorPane;

import javafx.util.Callback;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Order;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote;


public class ProfilesAdmlnController  implements Initializable {
	 @FXML
	    private AnchorPane HolderAnchor;

	    @FXML
	    private JFXListView<Company> listview;
	    
	    @FXML
	    private JFXTextField search;
	    
	    @FXML
	    private Label companyName;

	    @FXML
	    private Label companyCEO;

	    @FXML
	    private Label ps;

	    @FXML
	    private Label quantity;

	    @FXML
	    private Label sales;


	    private ObservableList<Company> cplist ;
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 	
			CompanyServiceRemote proxy;
			
			 
			try {
				 Context	context = new InitialContext();
				proxy = (CompanyServiceRemote) context.lookup(jndiName1);
				
				
				cplist = FXCollections.observableArrayList(proxy.findAllCompany());
				setBest();
			} catch (NamingException e) {
				e.printStackTrace();
			}
			//System.out.println(cplist);
			
	 		
			
			listview.setItems(cplist);
	             
			listview.setCellFactory(new Callback<ListView<Company>, ListCell<Company>>() {
			          

				@Override
				public ListCell<Company> call(ListView<Company> param) {
					// TODO Auto-generated method stub
					return new GridRowController() ;
				}
			});
			
			
			 search.textProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> observable,String oldValue, String newValue) {
					String jndiName="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/OrderService!tn.esprit.b1.esprit1718b1businessbuilder.services.OrderServiceRemote";
					
				    OrderServiceRemote proxy1 ; 
					
					Context context1;
					try {
						context1 = new InitialContext();
						proxy1 =(OrderServiceRemote) context1.lookup(jndiName);
					
					String str = search.getText() ;
			    	if (!str.equals("") ){
			    		cplist = FXCollections.observableArrayList(proxy1.findAllCompanyByName(search.getText()));
			    		
			    	  //  System.out.println(cplist.toString());
			    		listview.setItems(cplist);
			             
						listview.setCellFactory(new Callback<ListView<Company>, ListCell<Company>>() {
						          

							@Override
							public ListCell<Company> call(ListView<Company> param) {
								// TODO Auto-generated method stub
								return new GridRowController() ;
							}
						});
			    	}
			    	else {

			    		String jndiName1 ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote" ; 	
						CompanyServiceRemote proxy;
						try {
							 Context	context = new InitialContext();
							proxy = (CompanyServiceRemote) context.lookup(jndiName1);
							cplist = FXCollections.observableArrayList(proxy.findAllCompany());
						} catch (NamingException e) {
							e.printStackTrace();
						}
						listview.setItems(cplist);
			             
						listview.setCellFactory(new Callback<ListView<Company>, ListCell<Company>>() {
						          

							@Override
							public ListCell<Company> call(ListView<Company> param) {
								// TODO Auto-generated method stub
								return new GridRowController() ;
							}
						});
				 		
			    	}

					} catch (NamingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					
				}
				
			});
				
			 
			
		}
		
		public void setBest() throws NamingException {
			String jndiNameProduit ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ProductService!tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote" ;
			 ProductServiceRemote proxy1 ;
			 Context	context = new InitialContext();
			 proxy1 = (ProductServiceRemote) context.lookup(jndiNameProduit);
			 for (Object[] o : proxy1.bestSales()){
			    	
		    	 Produit p = new Produit();
		    	 p= (Produit)o[1] ;
		    	 long qt = (long)o[0];
		    	 Order order = new Order();
		    	 order = (Order)o[2];
		    	 companyName.setText(p.getSupplier().getName());
		    	 companyCEO.setText(p.getSupplier().getCEO());
		    	 quantity.setText(String.valueOf(qt)); 
		    	 sales.setText(String.valueOf(order.getAmount()));
		    	 ps.setText(p.getDescription());
		    	 
		    	 
	 	    	  
		    	
		    }
		}
}
