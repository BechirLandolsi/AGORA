package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import java.io.File;
import java.io.IOException;

import org.controlsfx.control.Rating;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;

public class ProductRowController extends ListCell<Produit>{

	 @FXML
	    private AnchorPane cellP;

	    @FXML
	    private ImageView imgRowP;

	    @FXML
	    private Label desc;

	    @FXML
	    private Label stock;

	    @FXML
	    private Label price;

	    @FXML
	    private ImageView imgRowC;

	    @FXML
	    private Label company;

	    @FXML
	    private Label address;

	    @FXML
	    private Rating rate;
	    
    private FXMLLoader mLLoader;
    @Override
    protected void updateItem(Produit produit, boolean empty) {
    	 if (empty || produit == null) {

             setText(null);
             setGraphic(null);

         } else {
             if (mLLoader == null) {
                 mLLoader = new FXMLLoader(getClass().getResource("../gui/ProductRow.fxml"));
                 mLLoader.setController(this);

                 try {
                     mLLoader.load();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

             }
             desc.setText(produit.getDescription());
             stock.setText(String.valueOf(produit.getStock()));
             price.setText(String.valueOf(produit.getPrice()));
             company.setText( produit.getSupplier().getName());
             address.setText(produit.getSupplier().getAdress());
             rate.setRating(produit.getSupplier().getRate());
            

            
             File file = new File("D:/4inoB1/pdev_workspace/esprit1718b1businessbuilder/esprit1718b1businessbuilder/esprit1718b1businessbuilder-client/target/classes/tn/esprit/b1/esprit1718b1businessbuilder/app/client/images/" + produit.getPath());
             Image img = new Image(file.toURI().toString());
             imgRowP.setImage(img);
             
             File file1 = new File("D:/4inoB1/pdev_workspace/esprit1718b1businessbuilder/esprit1718b1businessbuilder/esprit1718b1businessbuilder-client/target/classes/tn/esprit/b1/esprit1718b1businessbuilder/app/client/images/" + produit.getSupplier().getImage());
             Image img1 = new Image(file1.toURI().toString());
             imgRowC.setImage(img1);
             
             
             setText(null);
             setGraphic(cellP);
             
         }
    
    }
}
