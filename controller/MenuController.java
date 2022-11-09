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

public class MenuController implements Initializable {

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

		Stage currentStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
		
		switchToGame(currentStage);

	}
	
	public void switchToGame(Stage currentStage) throws IOException{

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(new URL(
				"file:\\C:\\Users\\usuario\\Documents\\Espacios_de_trabajo\\eclipseNeon_workspace\\Snake\\src\\view\\Juego.fxml"));
		
		Parent root = loader.load();
		
		JuegoController juegoController = loader.getController();
		
		Scene scene = new Scene(root);

		currentStage.setOnCloseRequest((value) -> {

			value.consume();
			try {
				juegoController.mostrarVentanaSeguraCierre();
			} catch (IOException e) {
				e.printStackTrace();
			}

		});

		currentStage.setScene(scene);
		currentStage.show();
		currentStage.centerOnScreen();
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
