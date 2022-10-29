package model;

public class Cuerpo {

	private int posicionX;
	private int posicionY;

	public Cuerpo(int posicionX, int posicionY) {

		this.posicionX = posicionX;
		this.posicionY = posicionY;

	}

	public void setPosicionY(int posicionY) {
		if (posicionY >= 0) {
			this.posicionY = posicionY;
		}
	}

	public void setPosicionX(int posicionX) {
		if (posicionX >= 0) {
			this.posicionX = posicionX;
		}
	}

	public int getPosicionX() {
		return posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public boolean verificarConPunto(Point punto) {

		if (posicionX == punto.getPosicionX() && posicionY == punto.getPosicionY()) {
			return true;
		}

		return false;
	}

	public Cuerpo obtenerCabezaArriba() {
		return new Cuerpo(this.posicionX, this.posicionY - 1);
	}

	public Cuerpo obtenerCabezaAbajo() {
		return new Cuerpo(this.posicionX, this.posicionY + 1);
	}

	public Cuerpo obtenerCabezaDerecha() {
		return new Cuerpo(this.posicionX + 1, this.posicionY);
	}

	public Cuerpo obtenerCabezaIzquierda() {
		return new Cuerpo(this.posicionX - 1, this.posicionY);
	}

}
