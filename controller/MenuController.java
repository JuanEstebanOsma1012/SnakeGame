package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import utilities.Singleton;

public class MenuController implements Initializable {

	Singleton singleton = Singleton.getInstance();

	@FXML
	private Button btnContinuarJuego;

	@FXML
	void continuarJuego(ActionEvent event) {

	}

	@FXML
	void iniciarJuego(ActionEvent event) {
		iniciarJuegoAction(event);
	}

	@FXML
	void opcionesJuego(ActionEvent event) {

	}

	@FXML
	void mejoresPuntuaciones(ActionEvent event) {

	}

	private void iniciarJuegoAction(ActionEvent event) {

		try {
			singleton.getGame().switchToGame();
		} catch (IOException e) {

			singleton.getGame().errorFatal();
			
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		

	}

}
