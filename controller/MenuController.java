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

	private void iniciarJuegoAction(ActionEvent event) throws IOException {

		Stage gameStage = (Stage) (((Node) event.getSource()).getScene().getWindow());

		Parent root = FXMLLoader.load(new URL(
				"file:\\C:\\Users\\usuario\\Documents\\Espacios_de_trabajo\\eclipseNeon_workspace\\Snake\\src\\view\\Juego.fxml"));
		Scene scene = new Scene(root);

		gameStage.setOnCloseRequest((value) -> {

			value.consume();
			mostrarVentanaSeguraCierre();

		});

		gameStage.setScene(scene);
		gameStage.show();
		gameStage.centerOnScreen();

	}

	private void mostrarVentanaSeguraCierre() {
		// TODO Auto-generated method stub

	}

	@FXML
	void opcionesJuego(ActionEvent event) {

	}

	@FXML
	void mejoresPuntuaciones(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
