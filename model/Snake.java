package model;

import java.util.ArrayList;

import enums.Direccion;
import utilities.Constants;

public class Snake {

	private Direccion direccion;
	private ArrayList<Cuerpo> cuerposCulebra = new ArrayList<Cuerpo>();

	public Snake() {

		direccion = Direccion.DERECHA;
		añadirCuerposCulebra();

	}

	private void añadirCuerposCulebra() {

		for (int i = 0; i < 3; i++) {
			cuerposCulebra.add(0, new Cuerpo(((int) Constants.DIMENSION_X / 2) - i, (int) Constants.DIMENSION_Y / 2));
		}
	}

	public void moverCuerpo() {

		switch (direccion) {
		case ARRIBA:
			cuerposCulebra.add(getCabeza().obtenerCabezaArriba());
			break;

		case ABAJO:
			cuerposCulebra.add(getCabeza().obtenerCabezaAbajo());
			break;

		case DERECHA:
			cuerposCulebra.add(getCabeza().obtenerCabezaDerecha());
			break;

		case IZQUIERDA:
			cuerposCulebra.add(getCabeza().obtenerCabezaIzquierda());
			break;

		}

	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		
		if ((this.direccion != Direccion.ABAJO && direccion == Direccion.ARRIBA) ||
			(this.direccion != Direccion.ARRIBA && direccion == Direccion.ABAJO) ||
			(this.direccion != Direccion.DERECHA && direccion == Direccion.IZQUIERDA) ||
			(this.direccion != Direccion.IZQUIERDA && direccion == Direccion.DERECHA)) {
			
			this.direccion = direccion;
		
		}
	}

	public ArrayList<Cuerpo> getCuerposCulebra() {
		return cuerposCulebra;
	}

	public void setCuerposCulebra(ArrayList<Cuerpo> cuerposCulebra) {
		this.cuerposCulebra = cuerposCulebra;
	}

	public boolean puntoEnCulebra(Point punto) {

		for (Cuerpo cuerpo : cuerposCulebra) {
			
			if (cuerpo.verificarConPunto(punto)) {
				
				return true;
				
			}
		}
		
		return false;
	}

	public Cuerpo getCabeza() {
		return cuerposCulebra.get(cuerposCulebra.size() - 1);
	}

	public void eliminarCola() {
		cuerposCulebra.remove(0);
	}

	public boolean verificarColisionConCuerpo() {
		for (int i = 0; i < cuerposCulebra.size() - 1; i++) {
			if (getCabeza().getPosicionX() == cuerposCulebra.get(i).getPosicionX() && getCabeza().getPosicionY() == cuerposCulebra.get(i).getPosicionY()) {
				return true;
			}
		}
		
		return false;
	}

	public boolean verificarColisionConBorde() {
		if (getCabeza().getPosicionX() >= Constants.DIMENSION_X || getCabeza().getPosicionY() >= Constants.DIMENSION_Y) {
			return true;
		}
		return false;
	}

}
