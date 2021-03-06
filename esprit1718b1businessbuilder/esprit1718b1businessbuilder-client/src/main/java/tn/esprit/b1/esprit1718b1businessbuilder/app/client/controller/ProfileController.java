package tn.esprit.b1.esprit1718b1businessbuilder.app.client.controller;

import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.Date;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.Company;
import tn.esprit.b1.esprit1718b1businessbuilder.entities.User;
import tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote;
import tn.esprit.b1.esprit1718b1businessbuilder.services.UserServiceRemote;

public class ProfileController implements Initializable {

	private static double progress1 = 0;
	private static double progress2 = 0;
	private static double progress3 = 0;
	private static double progress4 = 0;
	private static double progress5 = 0;
	private static double progress6 = 0;
	private static double progress7 = 0;
	private static double progress8 = 0;
	private static double progress9 = 0;
	private static double progress10 = 0;
	@FXML
	private TitledPane missing;

	@FXML
	private TitledPane update;

	@FXML
	private JFXButton submit;

	@FXML
	private JFXTextField adress;

	@FXML
	private JFXTextField ceo;

	@FXML
	private JFXTextField name;

	@FXML
	private JFXDatePicker date;

	@FXML
	private JFXTextField ref;

	@FXML
	private ProgressBar progressPersonal;

	@FXML
	private Label lblComplete;

	@FXML
	private Label labName;

	@FXML
	private Label labmail;

	@FXML
	private Label labceo;

	@FXML
	private Label labadress;

	@FXML
	private Label labsector;

	@FXML
	private Label labenbr;
	@FXML
	private JFXTextField updatename;

	@FXML
	private Label labmissing;

	@FXML
	private Label success;

	@FXML
	private JFXComboBox<String> updatesector;

	@FXML
	private JFXTextField updateref;

	@FXML
	private JFXDatePicker updatedate;

	@FXML
	private JFXTextField updateceo;

	@FXML
	private JFXTextField udateadress;

	@FXML
	private JFXButton updatesubmit;

	@FXML
	private ImageView img;

	@FXML
	private JFXButton logo;

	@FXML
	private JFXComboBox<String> sector;
	private ObservableList<String> list = FXCollections.observableArrayList("Secteur agricole",
			"Secteur agroalimentaire", "Secteur bancaire et financier", "Secteur de l'énergie",
			" Secteur de l'information", "Secteur de la communication et des médias", "Secteur de la distribution",
			"Secteur de la recherche", "Secteur de la santé", "Secteur des constructions mécaniques",
			"Secteur des industries chimiques", "Secteur des loisirs et du tourisme", "Secteur des matières premières",
			"Secteur des services", "Secteur des transports", "Secteur du bâtiment", "Secteur électronique",
			"Secteur informatique", "Secteur métallurgique", "Secteur textile");

	User logged = LoginController.LoggedUser;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String jndiNameCategory = "esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/UserService!tn.esprit.b1.esprit1718b1businessbuilder.services.UserServiceRemote";
		Context context = null;
		User logged = LoginController.LoggedUser;
		DecimalFormat decimalFormat = new DecimalFormat("###.#");
		decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
		progress10 = logged.getProgress() / 100;
		progressPersonal.setProgress(progress10);
		lblComplete.setText(decimalFormat.format(progress10 * 100) + "% complete");
		if (logged.getProgress() < 80.0) {
			missing.setVisible(true);

			updateProgress2();
		} else {
			update.setVisible(true);
		}
		/***********************************************************************************************/
		sector.setItems(list);
		updatesector.setItems(list);
		/***********************************************************************************************/
		String jndiName = "esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote";
		Context context2 = null;
		try {
			context2 = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CompanyServiceRemote proxy;
		try {
			proxy = (CompanyServiceRemote) context2.lookup(jndiName);
			Company c = proxy.findBy(logged.getId());
			// System.out.println(c.getAdress());
			labadress.setText(c.getAdress());
			labceo.setText(c.getCEO());
			labmail.setText(c.getEmail());
			labName.setText(c.getName());
			labenbr.setText(c.getNumber().toString());
			labsector.setText(c.getSector());

			/*
			 * File file = new File(
			 * "C:/Users/Mariem/git/esprit1718b1businessbuilder/esprit1718b1businessbuilder/esprit1718b1businessbuilder-client/src/main/java/tn/esprit/b1/esprit1718b1businessbuilder/app/client/images/"
			 * + c.getImage()); Image imgg = new Image(file.toURI().toString());
			 * img.setImage(imgg);
			 */

			/************************************************************/
			updateceo.setText(c.getCEO());
			updatename.setText(c.getName());
			updateref.setText(c.getReference());
			updatesector.setValue(c.getSector());
			// updatenbr.setText(c.getNumber().toString());
			udateadress.setText(c.getAdress());

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**********************************************************************************************/

	}

	public Double updateProgress2() {
		DecimalFormat decimalFormat = new DecimalFormat("###.#");
		decimalFormat.setRoundingMode(RoundingMode.HALF_UP);

		// progressPersonal.setProgress(0.00);
		double sum_progress = progress10 + progress1 + progress2 + progress3 + progress4 + progress5 + progress6
				+ progress7 + progress8 + progress9;

		name.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.isEmpty()) {
					progress1 = 0.1;

				} else {
					progress1 = 0.0;

				}
				double sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5 + progress6
						+ progress7 + progress8 + progress9);
				progressPersonal.setProgress(sum);
				lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
			}
		});

		ref.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.isEmpty()) {
					progress2 = 0.1;

				} else {
					progress2 = 0.0;

				}
				double sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5 + progress6
						+ progress7 + progress8 + progress9);
				progressPersonal.setProgress(sum);
				lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
			}
		});

		ceo.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.isEmpty()) {
					progress3 = 0.1;

				} else {
					progress3 = 0.0;

				}
				double sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5 + progress6
						+ progress7 + progress8 + progress9);
				progressPersonal.setProgress(sum);
				lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
			}
		});
		adress.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.isEmpty()) {
					progress4 = 0.1;

				} else {
					progress4 = 0.0;

				}
				double sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5 + progress6
						+ progress7 + progress8 + progress9);
				progressPersonal.setProgress(sum);
				lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
			}
		});

		sector.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.isEmpty()) {
					progress6 = 0.1;

				} else {
					progress6 = 0.0;

				}
				double sum = (progress10 + progress1 + progress2 + progress3 + progress4 + progress5 + progress6
						+ progress7 + progress8 + progress9);
				progressPersonal.setProgress(sum);
				lblComplete.setText(decimalFormat.format(sum * 100) + "% complete");
			}
		});
		return sum_progress * 100;

	}

	@FXML
	private void submitbtn(ActionEvent event) throws NamingException {

		String jndiNameCategory = "esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote";
		Context context = new InitialContext();
		CompanyServiceRemote proxyCategory = (CompanyServiceRemote) context.lookup(jndiNameCategory);

		Company c = proxyCategory.findBy(logged.getId());

		c.setName(name.getText());
		c.setAdress(adress.getText());
		c.setCEO(ceo.getText());
		// int i1 = Integer.parseInt(nbr.getText());
		// c.setNumber(Long.parseLong(nbr.getText()));
		c.setReference(ref.getText());
		c.setSector(sector.getValue());
		c.setProgress(updateProgress2());
		LocalDate a = date.getValue();
    	java.sql.Date d = java.sql.Date.valueOf(a);
    	c.setCreationDate(d);

		proxyCategory.add(c);
		labmissing.setVisible(true);
		labadress.setText(c.getAdress());
		labceo.setText(c.getCEO());
		labmail.setText(c.getEmail());
		labName.setText(c.getName());
		labenbr.setText(c.getNumber().toString());
		labsector.setText(c.getSector());
		
	
	}

	@FXML
	void updatesubmitbtn(ActionEvent event) throws NamingException {
		String jndiNameCategory = "esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote";
		Context context = new InitialContext();
		CompanyServiceRemote proxyCategory = (CompanyServiceRemote) context.lookup(jndiNameCategory);

		Company c = proxyCategory.findBy(logged.getId());
		c.setName(updatename.getText());
		c.setAdress(udateadress.getText());
		c.setCEO(updateceo.getText());

		// c.setNumber(Long.parseLong(updatenbr.getText()));
		c.setReference(updateref.getText());
		c.setSector(updatesector.getValue());
		
		LocalDate a = updatedate.getValue();
    	java.sql.Date d = java.sql.Date.valueOf(a);
    	c.setCreationDate(d);

		proxyCategory.update(c);
		success.setVisible(true);
		labadress.setText(c.getAdress());
		labceo.setText(c.getCEO());
		labmail.setText(c.getEmail());
		labName.setText(c.getName());
		labenbr.setText(c.getNumber().toString());
		labsector.setText(c.getSector());

	}

	@FXML
	void uploadlogo(ActionEvent event) throws MalformedURLException, NamingException {
		/*
		 * FileChooser fc = new FileChooser(); File selectedFile =
		 * fc.showOpenDialog(null); if (selectedFile != null) {
		 * 
		 * String imageFile = selectedFile.toURI().toURL().toString(); Image
		 * image = new Image(imageFile); img.setImage(image); String
		 * jndiNameCategory
		 * ="esprit1718b1businessbuilder-ear/esprit1718b1businessbuilder-service/CompanyService!tn.esprit.b1.esprit1718b1businessbuilder.services.CompanyServiceRemote";
		 * Context context = new InitialContext(); CompanyServiceRemote
		 * proxyCategory = (CompanyServiceRemote)
		 * context.lookup(jndiNameCategory); Company c
		 * =proxyCategory.findBy(logged.getId()); c.setImage(imageFile);
		 * 
		 * } else { System.out.println("file doesn't exist"); }
		 */
	}

}
