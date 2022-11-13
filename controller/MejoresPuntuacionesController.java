package controller;

	import java.io.IOException;
import java.net.URL;
	import java.util.ResourceBundle;

import datos.MejoresPuntuaciones;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
	import javafx.scene.control.Button;
	import javafx.scene.control.TextArea;
import utilities.Singleton;

public class MejoresPuntuacionesController {

	Singleton singleton = Singleton.getInstance();
	
	MejoresPuntuaciones mejoresPuntuaciones = singleton.getMejoresPuntuaciones();
	

	    @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private Button btnVolverPuntiacion;

	    @FXML
	    private TextArea txtAreaPuntuacion;

	   

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
	    void initialize() {
	        assert btnVolverPuntiacion != null : "fx:id=\"btnVolverPuntiacion\" was not injected: check your FXML file 'MejoresPuntuaciones.fxml'.";
	        assert txtAreaPuntuacion != null : "fx:id=\"txtAreaPuntuacion\" was not injected: check your FXML file 'MejoresPuntuaciones.fxml'.";

	    }
	}

	

