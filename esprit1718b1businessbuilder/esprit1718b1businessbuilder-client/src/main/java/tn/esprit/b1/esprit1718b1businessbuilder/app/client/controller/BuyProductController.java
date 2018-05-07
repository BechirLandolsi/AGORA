package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;
import tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote;

public class BuyProductController implements Initializable  {

	 @FXML
	    private JFXTextField quantity;

	    @FXML
	    private JFXComboBox<?> combo_curr;

	    @FXML
	    private JFXButton buy;

	    @FXML
	    private Circle circleP;

	    @FXML
	    private Label stockP;

	    @FXML
	    private Label priceP;

	    @FXML
	    private Label eventtitlelabel;

	    @FXML
	    private Label eventtitlelabel1;

	    @FXML
	    private Label priceF;

	    @FXML
	    private Label CurrF;

	    @FXML
	    private Label CurrencyP;

	    @FXML
	    private Label price11;

	    
    private static Produit produit;
    
	public static Produit getProduit() {
		return produit;
	}



	public static void setProduit(Produit produit) {
		BuyProductController.produit = produit;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		produit=ProductRowController.getProduit();
		CurrencyP.setText(produit.getSupplier().getCurrency());
		priceP.setText(String.valueOf(produit.getPrice()));
		stockP.setText(String.valueOf(produit.getStock()));
		File file = new File("C:/Users/Ahmed/git/esprit1718b1businessbuilder/esprit1718b1businessbuilder/esprit1718b1businessbuilder-client/target/classes/tn/esprit/b1/esprit1718b1businessbuilder/app/client/images/" + produit.getPath());
        Image img = new Image(file.toURI().toString());
        circleP.setFill(new ImagePattern(img));
       
       
			
		
	}
	@FXML
    void on_save_clicked(ActionEvent event) {
		 String jndiNameP ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/ProductService!tn.esprit.b1.esprit1718b1businessbuilder.services.ProductServiceRemote" ; 	
		   ProductServiceRemote proxyP;
			Company c =  (Company) LoginController.LoggedUser ;
				 String service ;
				 Context contextP;
				try {
					float price = 0 ;
				
					price = 	Float.parseFloat(quantity.getText()) * produit.getPrice() ; 
					 contextP = new InitialContext();
					 proxyP = (ProductServiceRemote) contextP.lookup(jndiNameP);
					float a = proxyP.currencyConvertion(produit.getSupplier().getCurrency(), c.getCurrency(), price) ;
					 priceF.setText(String.valueOf(a));
					 CurrF.setText(c.getCurrency());
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    }

}
