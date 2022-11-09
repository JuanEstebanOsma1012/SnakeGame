package application;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utilities.Singleton;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Singleton.getInstance().setPrimaryStage(primaryStage);
		
		Parent root = FXMLLoader.load(
				new URL("file:\\C:\\Users\\usuario\\Documents\\Espacios_de_trabajo\\eclipseNeon_workspace\\Snake\\src\\view\\Menu.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}

}