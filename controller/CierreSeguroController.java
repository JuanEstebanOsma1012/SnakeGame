package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class CierreSeguroController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void salir(ActionEvent event) {

    	salirAction(event);
    	
    }

	@FXML
    void salirYGuardar(ActionEvent event) {

    	guardarAction();
    	salirAction(event);
    	
    }

	@FXML
    void cancelar(ActionEvent event) {

    	cancelarAction(event);
    	
    }
    
    public void cancelarAction(ActionEvent event) {

    	((Stage) (((Node) event.getSource()).getScene().getWindow())).close();
    	
	}

    public void salirAction(ActionEvent event) {
    	
    	Stage gameStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
    	
    	
	}
	
    public void guardarAction() {
		// TODO Auto-generated method stub
		
	}

    @FXML
    void initialize() {

    }
}

