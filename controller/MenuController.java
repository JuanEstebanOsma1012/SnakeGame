package controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import utilities.Singleton;

public class MenuController implements Initializable {

	JuegoController juegoController;

	@FXML
	private Button btnContinuarJuego;

	@FXML
	void continuarJuego(ActionEvent event) {

	}

	@FXML
	void iniciarJuego(ActionEvent event) {

		try {
			iniciarJuegoAction(event);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@FXML
	void opcionesJuego(ActionEvent event) {

	}

	@FXML
	void mejoresPuntuaciones(ActionEvent event) {

	}

	private void iniciarJuegoAction(ActionEvent event) throws IOException {

		switchToGame();

	}

	public void switchToGame() throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(new URL(
				"file:\\C:\\Users\\usuario\\Documents\\Espacios_de_trabajo\\eclipseNeon_workspace\\Snake\\src\\view\\Juego.fxml"));

		Parent root = loader.load();
		Scene scene = new Scene(root);

		Stage currentStage = Singleton.getInstance().getPrimaryStage();

		currentStage.setScene(scene);
		currentStage.centerOnScreen();

	}

	public void setJuegoController(JuegoController juegoController) {
		this.juegoController = juegoController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		Stage currentStage = Singleton.getInstance().getPrimaryStage();

		currentStage.setOnCloseRequest((event) -> {});

	}

}
