package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import exceptions.JuegoNoGuardadoException;
import model.Map;

public class GamePersistanceManager {
	
	public static void serializarMapa(Map map) throws IOException{
		
		File file = new File("C:\\Users\\usuario\\Documents\\Espacios_de_trabajo\\eclipseNeon_workspace\\Snake\\src\\datos\\SnakeData.dat");
		
		if (file.exists()) {
			file.createNewFile();
		}
		
		System.out.println(map.getSnake().getCabeza().getPosicionX());
		
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
		outputStream.writeObject(map);
		outputStream.close();
		
	}
	
	public static Map deserializarMapa() throws IOException, ClassNotFoundException, JuegoNoGuardadoException {
		
		File file = new File("C:\\Users\\usuario\\Documents\\Espacios_de_trabajo\\eclipseNeon_workspace\\Snake\\src\\datos\\SnakeData.dat");
		if (file.exists()) {
			
			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
			Map map = (Map) inputStream.readObject();
			inputStream.close();
			return map;
			
		} else {
			throw new JuegoNoGuardadoException("no hay ningun juego guardado");
		}
		
	}
	
}
