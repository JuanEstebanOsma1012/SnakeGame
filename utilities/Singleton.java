package utilities;

import java.util.ArrayList;

import application.GameWindowsManager;
import datos.MejoresPuntuaciones;
import javafx.stage.Stage;
import model.Map;
import model.Opciones;
import model.Snake;
import model.User;

public class Singleton {

	Map map;
	GameWindowsManager game;
	MejoresPuntuaciones mejoresPuntuaciones = new MejoresPuntuaciones();
	Opciones opciones = new Opciones();
	private int velocidad = opciones.getVelocidad();
	
	
	
	
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
	
	public MejoresPuntuaciones getMejoresPuntuaciones(){
		return mejoresPuntuaciones;
	}
	
	public int getVelocidad (){
		return velocidad;
	}
	public void setVelocidad (int velocidad){
		this.velocidad= velocidad;
	}
	


	public Opciones getOpciones() {
		return opciones;
	}

	public void setOpciones(Opciones opciones) {
		this.opciones = opciones;
	}
	
	
}
