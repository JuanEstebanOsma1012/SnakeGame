package model;

import java.io.Serializable;

import enums.Direccion;
import exceptions.GameOverException;
import utilities.Constants;

public class Map implements Serializable {

	private char[][] map;
	private Snake snake;
	private Point punto;
	private int cantidadPuntos;

	public Map(Snake snake) {

		this.snake = snake;
		inicializarMapa();

		generarNuevoPunto();
//		try {
//			recargarMapa();
//		} catch (GameOverException e) {
//			e.printStackTrace();
//		}
		
	}

	public void inicializarMapa() {

		map = new char[Constants.DIMENSION_Y][Constants.DIMENSION_X];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = ' ';
			}
		}
	}
	
	
	
	public int getCantidadPuntos() {
		return cantidadPuntos;
	}

	public void setCantidadPuntos(int cantidadPuntos) {
		this.cantidadPuntos = cantidadPuntos;
	}

	public Point getPunto(){
		return punto;
	}
	
	public Snake getSnake(){
		return snake;
	}

	public char[][] getMap() {
		return map;
	}

//	public void recargarMapa() throws GameOverException {
//		
//		aplanarMapa();
//		dibujarCulebra();
//		dibujarPunto();
//		
//	}

//	private void dibujarPunto() {
//		map[punto.getPosicionY()][punto.getPosicionX()] = '+';
//	}
//
//	private void dibujarCulebra() throws GameOverException {
//		try {
//			
//			for (int i = 0; i < snake.getCuerposCulebra().size(); i++) {
//				map[snake.getCuerposCulebra().get(i).getPosicionY()][snake.getCuerposCulebra().get(i).getPosicionX()] = '-';
//			}
//			
//		} catch (ArrayIndexOutOfBoundsException e) {
//			throw new GameOverException();
//		}
//	}
//
//	private void aplanarMapa() {
//
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				map[i][j] = '*';
//			}
//		}
//	}

	public void moverSnake() throws GameOverException {

		snake.moverCuerpo();
		if (verificarCabezaEnPunto()){
			this.cantidadPuntos ++;
		}
		if (snake.verificarColisionConCuerpo() || snake.verificarColisionConBorde()) {
			throw new GameOverException();
		} else {
			
			if (!verificarCabezaEnPunto()) {
				snake.eliminarCola();
			} else {
				generarNuevoPunto();
			}
			
//			recargarMapa();
			
		}
	}

	public void setearDireccionCulebra(Direccion direccion) {

		snake.setDireccion(direccion);
	}

	public void generarNuevoPunto() {

		punto = new Point((int) (Math.random() * (Constants.DIMENSION_X - 1)), (int) (Math.random() * (Constants.DIMENSION_Y - 1)));

		if (snake.puntoEnCulebra(punto)) {
			generarNuevoPunto();
		}

	}

	public boolean verificarCabezaEnPunto() {

		if (punto != null && snake.getCabeza().getPosicionX() == punto.getPosicionX()
				&& snake.getCabeza().getPosicionY() == punto.getPosicionY()) {

			return true;
		}else{
			return false;
		}

		

	}
	
	

}
