package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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
	
	boolean perfil = false;
	
	
	@FXML
	private Button btnContinuarJuego;

	@FXML
	void continuarJuego(ActionEvent event) {
		try {
			continuarJuegoAction();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (JuegoNoGuardadoException e) {

			System.out.println("mal");
			
			e.printStackTrace();
		}
	}

	@FXML
	void iniciarJuego(ActionEvent event) {
		
		this.perfil = singleton.getOpciones().getHayUsuarios();
		
		if (perfil == true && singleton.getOpciones().getUsuarioSeleccionado() != null){
			iniciarJuegoAction();
		}else{
			JOptionPane.showMessageDialog(null, "Tienes que escoger tu perfil en 'OPCIONES' ");
		}
		
	}

	@FXML
	void opcionesJuego(ActionEvent event) {
		try {
			singleton.getGame().switchToOpciones();
		} catch (IOException e) {
			System.out.println("error al ir a opciones");
			e.printStackTrace();
		}
		
		
	}

	@FXML
	void mejoresPuntuaciones(ActionEvent event) {

	}
	
	private void continuarJuegoAction() throws ClassNotFoundException, JuegoNoGuardadoException {

		try {
			singleton.getGame().setMap(GamePersistanceManager.deserializarMapa());
			
			singleton.getGame().switchToGameSaved();
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
		

	}

}
