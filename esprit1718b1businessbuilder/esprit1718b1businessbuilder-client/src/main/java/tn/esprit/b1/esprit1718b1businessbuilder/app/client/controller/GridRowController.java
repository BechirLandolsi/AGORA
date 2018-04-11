package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;




import java.io.File;
import java.io.IOException;

import org.controlsfx.control.GridCell;
import org.controlsfx.control.Rating;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;

public class GridRowController extends ListCell<Company> {

	@FXML
    private AnchorPane cell;
	
	@FXML
    private Label ceo;

    @FXML
    private Label sector;

    @FXML
    private Label telefone;

    @FXML
    private Label name;

    @FXML
    private Label adress;

    @FXML
    private Rating rate;
    
    @FXML
    private ImageView img;
    
    @FXML
    private Circle circle;
    
    @FXML
    private JFXButton show;

    private FXMLLoader mLLoader;
    
    @Override
    protected void updateItem(Company company, boolean empty) {
    	 if (empty || company == null) {

             setText(null);
             setGraphic(null);

         } else {
             if (mLLoader == null) {
                 mLLoader = new FXMLLoader(getClass().getResource("../gui/GridRow.fxml"));
                 mLLoader.setController(this);

                 try {
                     mLLoader.load();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

             }
             name.setText(company.getName());
             ceo.setText(company.getCEO());
             adress.setText(company.getAdress());
             
             telefone.setText(company.getNumber().toString());
             sector.setText(company.getSector());
             rate.setRating(company.getRate());
             
             File file = new File(("D:/4inoB1/pdev_workspace/esprit1718b1businessbuilder/esprit1718b1businessbuilder/esprit1718b1businessbuilder-client/target/classes/tn/esprit/b1/esprit1718b1businessbuilder/app/client/images/"+company.getImage()));
           
             Image img1 = new Image(file.toURI().toString());
             img.setImage(img1);
             
             circle.setFill(new ImagePattern(img1));
             setText(null);
             setGraphic(cell);
         }
    
    }
    @FXML
	    void showDashboard(ActionEvent event) {

	    }
}
