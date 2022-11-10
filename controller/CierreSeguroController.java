package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import utilities.Singleton;

public class CierreSeguroController implements Initializable {

	Singleton singleton = Singleton.getInstance();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	void salir(ActionEvent event) {
		salirAction();
	}

	@FXML
	void salirYGuardar(ActionEvent event) {
		guardarAction();
		salirAction();
	}

	@FXML
	void cancelar(ActionEvent event) {
		cancelarAction();
	}

	public void cancelarAction() {
		singleton.getGame().reanudarJuego();
		singleton.getGame().cerrarCierreSeguro();
	}

	public void salirAction() {

		try {
			singleton.getGame().switchToMenu();
			singleton.getGame().cerrarCierreSeguro();
		} catch (IOException e) {
			singleton.getGame().errorFatal();
			e.printStackTrace();
		}
	}

	public void guardarAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
