package datos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MejoresPuntuaciones {

	private String textoEscritura;
	private String textoLectura;
	
	
	
	
	
	public MejoresPuntuaciones () {
		
	}
	

	public String getTextoEscritura() {
		return textoEscritura;
	}



	public void setTextoEscritura(String textoEscritura) {
		this.textoEscritura = textoEscritura;
	}



	public String getTextoLectura() {
		return textoLectura;
	}



	public void setTextoLectura(String textoLectura) {
		this.textoLectura = textoLectura;
	}




	public void guardarPuntuaciones(){
		  
		// poner aquí la ruta donde tenga el proyecto... hasta llegar a Puntuacion.txt
		File file = new File ("C:\\Users\\ljane\\OneDrive\\Documentos\\Programas de eclipse\\SnakeGame_Osma_Santi_Naty_JulianC\\src\\datos\\Puntuacion.txt");
		
		try {
			// nuevamente poner aquí la ruta donde tenga el proyecto... hasta llegar a Puntuacion.txt
            FileWriter fileWriter = new FileWriter("C:\\Users\\ljane\\OneDrive\\Documentos\\Programas de eclipse\\SnakeGame_Osma_Santi_Naty_JulianC\\src\\datos\\Puntuacion.txt");
            fileWriter.write( textoEscritura);
            fileWriter.close();
            
            
            
        } catch (Exception e) {
        	System.err.print ("No se pudo realizar la escritura");
        }
		
	}
	
	public void leerPuntuaciones(){



	}


	
	
	
	
	
	
	
}
