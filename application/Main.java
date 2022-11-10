package application;

import javafx.application.Application;
import javafx.stage.Stage;
import utilities.Singleton;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Singleton singleton = Singleton.getInstance();
		
		singleton.setGame(new GameWindowsManager(primaryStage));
		singleton.getGame().switchToMenu();
		singleton.getGame().desplegarVentanaPrincipal();
		
	}
	
}
