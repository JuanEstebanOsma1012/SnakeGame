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
	
	public void switchToMenu(Stage currentStage) throws IOException{
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(new URL(
				"file:\\C:\\Users\\usuario\\Documents\\Espacios_de_trabajo\\eclipseNeon_workspace\\Snake\\src\\view\\Menu.fxml"));
		
		Parent root = loader.load();
		
		MenuController menuController = loader.getController();
		
		Scene scene = new Scene(root);

		currentStage.setScene(scene);
		currentStage.show();
		currentStage.centerOnScreen();
		
	}

	public void mostrarVentanaSeguraCierre() throws IOException {

		Stage auxStage = new Stage();
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(new URL("file:\\C:\\Users\\usuario\\Documents\\Espacios_de_trabajo\\eclipseNeon_workspace\\Snake\\src\\view\\CierreSeguro.fxml"));
		
		Parent root = loader.load();
		
		CierreSeguroController cierreSeguroController = loader.getController();
		
		Scene scene = new Scene(root);
		
		auxStage.setScene(scene);
		
		auxStage.setOnCloseRequest((event) -> {
			event.consume();
			auxStage.close();
		});
		
		auxStage.centerOnScreen();
		auxStage.showAndWait();
		
	}

}
