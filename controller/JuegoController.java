package controller;

import java.net.URL;
import java.util.ResourceBundle;

import auxiliaresGraficos.GraphicMap;
import enums.Direccion;
import exceptions.GameOverException;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import model.Map;
import model.Snake;


public class JuegoController implements Initializable {

	Snake snake = new Snake();
	Map map = new Map(snake);
	GraphicMap gm;
	Timeline timeline;
	Direccion direccionAux;

	@FXML
	private Canvas mapaJuego;
	
	@FXML
	private Label LblPuntos;

	@FXML
	private Button startGame;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		gm = new GraphicMap(mapaJuego, map);
		
		timeline = new Timeline(new KeyFrame(Duration.millis(100), e -> {
			
			map.setearDireccionCulebra(direccionAux);
			
			try {
				map.moverSnake();
			} catch (GameOverException e1) {
				timeline.stop();
				finalizarJuego();
			}
			gm.restartGraphicMap();
			
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
	
	public static void imprimirMapa(char[][] mapa) {

		for (int x = 0; x < mapa.length; x++) {
			System.out.print("|");
			for (int y = 0; y < mapa[x].length; y++) {
				System.out.print(mapa[x][y]);
				if (y != mapa[x].length - 1)
					System.out.print("  ");
			}
			System.out.println("|");
		}

	}

	public static void limpiarConsola() {

		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
}
