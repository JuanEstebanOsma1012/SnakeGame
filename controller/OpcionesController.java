package controller;

import model.Opciones;
import model.User;
import utilities.Singleton;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;

public class OpcionesController {

	Singleton singleton = Singleton.getInstance();
	Opciones opciones = singleton.getOpciones();
	
	



    @FXML
    private Label lblUsuario;

    @FXML
    private TextField txtNombreNuevoUsuario;

    @FXML
    private Button btnVolver;

    @FXML
    private Button btnBorrarPerfil;

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private ChoiceBox choiseVelocidad = new ChoiceBox ();

    @FXML
    private Button btnSeleccionarPerfil;

    @FXML
    private ChoiceBox choiseUsuario = new ChoiceBox ();

    @FXML
    private Button btnCrearPerfil;

    @FXML
    private Button btnActuaizarPerfil;

    @FXML
    void crearPerfilAction(ActionEvent event) {
    	
    	
    	crearPerfil();
    	
    }

    private void crearPerfil() {
		
    	String nombre = txtNombreUsuario.getText();
    	
    	if (verificarNombre (nombre) == true){
    		String mensaje = opciones.crearUsuario(nombre);
    		if (mensaje.equals("se ha creado el perfil con éxito")){
    			actualizarChoice(opciones.getListaUsuarios(), nombre);
    		}
    		JOptionPane.showMessageDialog(null, mensaje);
    		
    		
    	}else{
    		JOptionPane.showMessageDialog(null, "No es valido el nombre");
    	}
    	limpiar();
	}

	private void limpiar() {
		txtNombreNuevoUsuario.setText("");
		txtNombreUsuario.setText("");
		
	}

	private void actualizarChoice(ArrayList<User> arrayList, String usuarioConectado) {
		
		
		choiseUsuario.getItems().clear();
		for (int i = 0; i < arrayList.size(); i++) {
			choiseUsuario.getItems().add(arrayList.get(i).getName());
		}
		lblUsuario.setText(usuarioConectado);
	}

	private boolean verificarNombre(String nombre) {
		boolean esApto = false;
		
		if (!nombre.equals("") && !nombre.equals(" ")){
			esApto = true;
		}
		
		
		return esApto;
	}

	@FXML
    void actualizarPerfilAction(ActionEvent event) {
    	
		actualizarPerfil();
		
    }

    private void actualizarPerfil() {

    	try {
    		String valor = (String) choiseUsuario.getValue();
    		String nombreNuevo = txtNombreNuevoUsuario.getText();
    		if (!valor.equals("") && verificarNombre(nombreNuevo)){
    			User userTemp = opciones.obtenerUsuario(valor);
    			userTemp.setName(nombreNuevo);
    			actualizarChoice(opciones.getListaUsuarios(), "usuario sin definir");
    			opciones.setUsuarioSeleccionado(null);
    			JOptionPane.showMessageDialog(null, "se ha actualizado el nombre con éxito");
    		}
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, "no ha seleccionado nada");
    	}

    	limpiar();

    }
    	@FXML
    	void borrarPerfilAction(ActionEvent event) {
    	borrar();
    }

    private void borrar() {
    	String valor = (String) choiseUsuario.getValue();
    	if (valor != null){
    		opciones.eliminarUsuario(valor);
    		actualizarChoice(opciones.getListaUsuarios(), "usuario sin definir");
    		opciones.setUsuarioSeleccionado(null);
			}
    	}
		

	@FXML
    void volverAction(ActionEvent event) {

    	volver();
    	
    }

	private void volver() {
		try {
			singleton.getGame().switchToMenu();
			singleton.getGame().cerrarCierreSeguro();
		} catch (IOException e) {
			singleton.getGame().errorFatal();
			e.printStackTrace();
		}
	}

	@FXML
	void seleccionarPerfilAction(ActionEvent event) {
		try {
			User usuarioSeleccionado = opciones.obtenerUsuario((String) choiseUsuario.getValue());
			opciones.setUsuarioSeleccionado(usuarioSeleccionado);
			actualizarChoice(opciones.getListaUsuarios(), usuarioSeleccionado.getName());

			volver();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no ha seleccionado nada");

		}
	}

	@FXML
	    void initialize() {
	        assert lblUsuario != null : "fx:id=\"lblUsuario\" was not injected: check your FXML file 'Opciones.fxml'.";
	        assert txtNombreNuevoUsuario != null : "fx:id=\"txtNombreNuevoUsuario\" was not injected: check your FXML file 'Opciones.fxml'.";
	        assert btnVolver != null : "fx:id=\"btnVolver\" was not injected: check your FXML file 'Opciones.fxml'.";
	        assert choiseVelocidad != null : "fx:id=\"choiseVelocidad\" was not injected: check your FXML file 'Opciones.fxml'.";
	        assert btnBorrarPerfil != null : "fx:id=\"btnBorrarPerfil\" was not injected: check your FXML file 'Opciones.fxml'.";
	        assert btnSeleccionarPerfil != null : "fx:id=\"btnSeleccionarPerfil\" was not injected: check your FXML file 'Opciones.fxml'.";
	        assert txtNombreUsuario != null : "fx:id=\"txtNombreUsuario\" was not injected: check your FXML file 'Opciones.fxml'.";
	        assert choiseUsuario != null : "fx:id=\"choiseUsuario\" was not injected: check your FXML file 'Opciones.fxml'.";
	        assert btnCrearPerfil != null : "fx:id=\"btnCrearPerfil\" was not injected: check your FXML file 'Opciones.fxml'.";
	        assert btnActuaizarPerfil != null : "fx:id=\"btnActuaizarPerfil\" was not injected: check your FXML file 'Opciones.fxml'.";
	       String temp = "usuario no definido";
	        if (opciones.getUsuarioSeleccionado() != null && opciones.getUsuarioSeleccionado().getName() != null){
	        	temp =opciones.getUsuarioSeleccionado().getName();
	        }
	        
	        actualizarChoice(opciones.getListaUsuarios(), temp);
	    }
}
	
