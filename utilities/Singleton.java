package utilities;

import application.GameWindowsManager;
import javafx.stage.Stage;
import model.Map;
import model.Snake;

public class Singleton {

	Map map;
	GameWindowsManager game;

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

	private void inicializarDatos() {}
	
	public void setGame(GameWindowsManager game){
		this.game = game;
	}
	
	public GameWindowsManager getGame(){
		return game;
	}
	
	public Map getMap(){
		return map;
	}
}
