package datos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

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




	public void guardarPuntuaciones(String usuario){
		  
		// poner aquí la ruta donde tenga el proyecto... hasta llegar a Puntuacion.txt
		File file = new File ("C:\\Users\\ljane\\OneDrive\\Documentos\\Programas de eclipse\\SnakeGame_Osma_Santi_Naty_JulianC\\src\\datos\\Puntuacion.txt");
		
		try {
			// nuevamente poner aquí la ruta donde tenga el proyecto... hasta llegar a Puntuacion.txt
            FileWriter fileWriter = new FileWriter("C:\\Users\\ljane\\OneDrive\\Documentos\\Programas de eclipse\\SnakeGame_Osma_Santi_Naty_JulianC\\src\\datos\\Puntuacion.txt",true);
            fileWriter.write(usuario + " "+textoEscritura+"\n");
            fileWriter.close();
            
            
            
        } catch (Exception e) {
        	System.err.print ("No se pudo realizar la escritura");
        }

	}

	public String leerPuntuaciones(){

		String leido = "";


		File file = new File ("C:\\Users\\ljane\\OneDrive\\Documentos\\Programas de eclipse\\SnakeGame_Osma_Santi_Naty_JulianC\\src\\datos\\Puntuacion.txt");
		int tamanio = (int) file.length();


		
		try {
			FileReader fr = new FileReader ("C:\\Users\\ljane\\OneDrive\\Documentos\\Programas de eclipse\\SnakeGame_Osma_Santi_Naty_JulianC\\src\\datos\\Puntuacion.txt");
			int content;
			
			
			try {
				while ((content = fr.read()) != -1) {
					leido += ((char) content);

				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "error al leer");
				e.printStackTrace();
			}


		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "error al acceder a la ruta");
			e.printStackTrace();
		}


		return leido;	


	}












}

