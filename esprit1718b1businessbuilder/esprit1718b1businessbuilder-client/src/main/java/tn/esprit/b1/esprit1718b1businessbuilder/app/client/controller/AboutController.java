
package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author PEAR
 */
public class AboutController implements Initializable{

    @FXML
    private MaterialDesignIconView iconClose;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    @FXML
    private void closeStage(MouseEvent event) {
        iconClose.getScene().getWindow().hide();
    }
    
}
