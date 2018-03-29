package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Produit;

public class ProductRowReController extends ListCell<Produit> {

    @FXML
    private AnchorPane cellre;

    @FXML
    private ImageView imgRowre;

    @FXML
    private Label nameP;

    @FXML
    private Label stockP;

    @FXML
    private Label priceP;
    private FXMLLoader mLLoader;
    
    
    @Override
    protected void updateItem(Produit produit, boolean empty) {
    	 if (empty || produit == null) {

             setText(null);
             setGraphic(null);

         } else {
             if (mLLoader == null) {
                 mLLoader = new FXMLLoader(getClass().getResource("../gui/ProductRowRe.fxml"));
                 mLLoader.setController(this);

                 try {
                     mLLoader.load();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

             }
             nameP.setText(produit.getDescription());
             stockP.setText(String.valueOf(produit.getStock()));
             priceP.setText(String.valueOf(produit.getPrice()+" DT"));
             File file = new File("C:/Users/Ahmed/git/esprit1718b1businessbuilder/esprit1718b1businessbuilder/esprit1718b1businessbuilder-client/target/classes/tn/esprit/b1/esprit1718b1businessbuilder/app/client/images/" + produit.getPath());
             Image img = new Image(file.toURI().toString());
             imgRowre.setImage(img);
             setText(null);
             setGraphic(cellre);
         }
    
    }
}
