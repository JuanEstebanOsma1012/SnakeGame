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
		
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("./datos/SnakeData.xml")));
		outputStream.writeObject(map);
		outputStream.close();
		
	}
	
	public static Map deserializarMapa() throws IOException, ClassNotFoundException, JuegoNoGuardadoException {
		
		File file = new File("./datos/SnakeData.xml");
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
