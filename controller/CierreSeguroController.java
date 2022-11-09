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

	JuegoController juegoController;
	Stage beforeStage;

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

		reanudarJuego();

		Stage auxStage = Singleton.getInstance().getAuxStage();
		auxStage.close();

	}

	public void salirAction() {

		Stage currentStage = Singleton.getInstance().getAuxStage();

		try {
			juegoController.switchToMenu();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		currentStage.close();

	}

	public void guardarAction() {
		// TODO Auto-generated method stub

	}

	private void reanudarJuego() {

		juegoController.reanudarTimeline();

	}

	public void setJuegoController(JuegoController juegoController) {
		this.juegoController = juegoController;
	}

	public void setBeforeStage(Stage beforeStage) {
		this.beforeStage = beforeStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Stage auxStage = Singleton.getInstance().getAuxStage();

		auxStage.setOnCloseRequest((event) -> {

			event.consume();
			cancelarAction();

		});

	}
}
