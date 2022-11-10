package controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import auxiliaresGraficos.GraphicMap;
import enums.Direccion;
import exceptions.GameOverException;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import model.Map;
import model.Snake;
import utilities.Singleton;

public class JuegoController implements Initializable {

	Map map;
	
	GraphicMap gm;
	Timeline timeline;
	Direccion direccionAux;
	
	MenuController menuController;
	CierreSeguroController cierreSeguroController;

	@FXML
	private Canvas mapaJuego;

	@FXML
	private Label LblPuntos;

	@FXML
	private Button startGame;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		if (hayMapaCargado()) {
			map = obtenerMapaCargado();
		} else {
			map = new Map(new Snake());
		}
		
		gm = new GraphicMap(mapaJuego, map);

		gm.restartGraphicMap();
		
		timeline = new Timeline(new KeyFrame(Duration.millis(200), e -> {

			map.setearDireccionCulebra(direccionAux);

			try {
				map.moverSnake();
				gm.restartGraphicMap();
			} catch (GameOverException e1) {
				
				finalizarJuego();
				timeline.stop();
			}

		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		
	}

	@FXML
	void empezarJuego(ActionEvent event) {

		setearEventoTeclado(event);
		startGame.setDisable(true);

		timeline.play();

	}

	private void finalizarJuego() {

		System.out.println("hola mundo");

	}

	private void setearEventoTeclado(ActionEvent event) {

		((Node) event.getSource()).getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {

				String tecla = event.getText();

				switch (tecla) {
				case "w":
					direccionAux = Direccion.ARRIBA;
					break;

				case "a":
					direccionAux = Direccion.IZQUIERDA;
					break;

				case "s":
					direccionAux = Direccion.ABAJO;
					break;

				case "d":
					direccionAux = Direccion.DERECHA;
					break;

				}

			}
		});

	}

	public Timeline getTimeline() {
		return this.timeline;
	}

}
