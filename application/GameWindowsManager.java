package application;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import auxiliaresGraficos.GraphicMap;
import controller.JuegoController;
import exceptions.JuegoNoGuardadoException;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Map;
import persistencia.GamePersistanceManager;

public class GameWindowsManager {

	Stage primaryStage;
	Stage exitAlertStage;
	
	Map map;

	FXMLLoader menuLoader;
	FXMLLoader gameLoader;
	FXMLLoader cierreSeguroLoader;

	public GameWindowsManager(Stage primaryStage) throws MalformedURLException {

		menuLoader = new FXMLLoader(new URL(
				"file:\\C:\\Users\\usuario\\Documents\\Espacios_de_trabajo\\eclipseNeon_workspace\\Snake\\src\\view\\Menu.fxml"));
		gameLoader = new FXMLLoader(new URL(
				"file:\\C:\\Users\\usuario\\Documents\\Espacios_de_trabajo\\eclipseNeon_workspace\\Snake\\src\\view\\Juego.fxml"));
		cierreSeguroLoader = new FXMLLoader(new URL(
				"file:\\C:\\Users\\usuario\\Documents\\Espacios_de_trabajo\\eclipseNeon_workspace\\Snake\\src\\view\\CierreSeguro.fxml"));

		this.primaryStage = primaryStage;

		exitAlertStage = new Stage();
		exitAlertStage.initModality(Modality.APPLICATION_MODAL);

	}

	public void restartMenuLoader() throws MalformedURLException {
		menuLoader = new FXMLLoader(new URL(
				"file:\\C:\\Users\\usuario\\Documents\\Espacios_de_trabajo\\eclipseNeon_workspace\\Snake\\src\\view\\Menu.fxml"));
	}

	public void restartGameLoader() throws MalformedURLException {
		
		gameLoader = new FXMLLoader(new URL(
				"file:\\C:\\Users\\usuario\\Documents\\Espacios_de_trabajo\\eclipseNeon_workspace\\Snake\\src\\view\\Juego.fxml"));
	}

	public void restartCierreSeguroLoader() throws MalformedURLException {
		cierreSeguroLoader = new FXMLLoader(new URL(
				"file:\\C:\\Users\\usuario\\Documents\\Espacios_de_trabajo\\eclipseNeon_workspace\\Snake\\src\\view\\CierreSeguro.fxml"));
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public Stage getExitAlertStage() {
		return exitAlertStage;
	}
	
	public Map getMap(){
		return this.map;
	}

	public FXMLLoader getMenuLoader() {
		return menuLoader;
	}

	public void setMenuLoader(FXMLLoader menuLoader) {
		this.menuLoader = menuLoader;
	}

	public FXMLLoader getGameLoader() {
		return gameLoader;
	}

	public void setGameLoader(FXMLLoader gameLoader) {
		this.gameLoader = gameLoader;
	}

	public FXMLLoader getCierreSeguroLoader() {
		return cierreSeguroLoader;
	}

	public void setCierreSeguroLoader(FXMLLoader cierreSeguroLoader) {
		this.cierreSeguroLoader = cierreSeguroLoader;
	}

	public void desplegarVentanaPrincipal() {
		if (!primaryStage.isShowing()) {
			primaryStage.show();
		}
	}

	public void switchToMenu() throws IOException {

		if (primaryStage != null && menuLoader != null) {

			restartMenuLoader();

			Scene scene = new Scene((Parent) menuLoader.load());
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();

			limpiarEventoCierreSeguro();
		}
	}

	private void limpiarEventoCierreSeguro() {

		primaryStage.setOnCloseRequest(event -> {});

	}

	public void switchToGame() throws IOException {

		if (primaryStage != null && gameLoader != null) {

			restartGameLoader();

			Scene scene = new Scene((Parent) gameLoader.load());
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();

			setearEventoCierreSeguro();
			
		}
	}
	
	private void cargarMapa() {
		
		try {
			this.map = GamePersistanceManager.deserializarMapa();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JuegoNoGuardadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void switchToGame(Map map) throws IOException {

		if (primaryStage != null && gameLoader != null) {

			restartGameLoader();

			Scene scene = new Scene((Parent) gameLoader.load());
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();

			setearEventoCierreSeguro();
		}
		
	}

	private void setearEventoCierreSeguro() {

		primaryStage.setOnCloseRequest((event) -> {

			event.consume();
			try {
				frenarJuego();
				openExitAssistant();
			} catch (IOException e) {
				errorFatal();
				e.printStackTrace();
			}

		});

	}

	public void openExitAssistant() throws IOException {

		if (exitAlertStage != null && cierreSeguroLoader != null) {

			restartCierreSeguroLoader();

			Scene scene = new Scene((Parent) cierreSeguroLoader.load());
			exitAlertStage.setScene(scene);
			exitAlertStage.showAndWait();
			
			setearEventoCancelarCierreSeguro();
		}

	}

	private void setearEventoCancelarCierreSeguro() {

		exitAlertStage.setOnCloseRequest(event -> {
			
			reanudarJuego();
			
		});
		
	}

	public void frenarJuego() {

		Timeline timeline = obtenerTimeline();

		if (timeline.getStatus() == Animation.Status.RUNNING) {
			timeline.pause();
		}
	}

	public void reanudarJuego() {

		Timeline timeline = obtenerTimeline();
		
		if (timeline.getStatus() == Animation.Status.PAUSED) {
			timeline.play();
		}
	}

	private Timeline obtenerTimeline() {

		if (gameLoader != null) {

			JuegoController juegoController = gameLoader.getController();
			Timeline timeline = juegoController.getTimeline();

			return timeline;
		} else {
			return null;
		}

	}

	public void errorFatal() {
		cerrarTodasLasVentanas();
		// mostrarMensajeErrorFatal();
	}

	private void cerrarTodasLasVentanas() {
		primaryStage = null;
		exitAlertStage = null;
	}

	public void cerrarCierreSeguro() {
		exitAlertStage.close();
	}

}