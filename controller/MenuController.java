package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import auxiliaresGraficos.GraphicMap;
import exceptions.JuegoNoGuardadoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import model.Map;
import persistencia.GamePersistanceManager;
import utilities.Singleton;

public class MenuController implements Initializable {

	Singleton singleton = Singleton.getInstance();

	@FXML
	private Button btnContinuarJuego;

	@FXML
	void continuarJuego(ActionEvent event) {
		continuarJuegoAction();
	}

	@FXML
	void iniciarJuego(ActionEvent event) {
		iniciarJuegoAction();
	}

	@FXML
	void opcionesJuego(ActionEvent event) {

	}

	@FXML
	void mejoresPuntuaciones(ActionEvent event) {

	}
	
	private void continuarJuegoAction() {

		try {
			singleton.getGame().switchToGame();
		} catch (IOException e) {

			singleton.getGame().errorFatal();
			
			e.printStackTrace();
		}
		
	}

	private void iniciarJuegoAction() {

		try {
			singleton.getGame().switchToGame();
		} catch (IOException e) {

			singleton.getGame().errorFatal();
			
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		try {
			
			map = GamePersistanceManager.deserializarMapa();
			
		} catch (JuegoNoGuardadoException e) {
			btnContinuarJuego.setDisable(true);
		} catch (Exception e){
			e.printStackTrace();
		}

	}

}
