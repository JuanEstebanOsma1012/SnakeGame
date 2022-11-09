package utilities;

import javafx.stage.Stage;
import model.Map;
import model.Snake;

public class Singleton {

	Map map;
	Stage primaryStage;
	Stage auxStage;

	// ------------------------------ Singleton
	// ------------------------------------------------
	// Clase estatica oculta. Tan solo se instanciara el singleton una vez
	private static class SingletonHolder {
		// El constructor de Singleton puede ser llamado desde aquí al ser
		// protected
		private final static Singleton eINSTANCE = new Singleton();

	}

	// Método para obtener la instancia de nuestra clase
	public static Singleton getInstance() {
		return SingletonHolder.eINSTANCE;
	}

	public Singleton() {
		inicializarDatos();
	}

	private void inicializarDatos() {

		map = new Map(new Snake());
		auxStage = new Stage();
		
	}
	
	public Map getMap(){
		return map;
	}
	
	public void setPrimaryStage(Stage primaryStage){
		this.primaryStage = primaryStage;
	}
	
	public Stage getPrimaryStage(){
		return primaryStage;
	}
	
	public Stage getAuxStage(){
		return auxStage;
	}
}
