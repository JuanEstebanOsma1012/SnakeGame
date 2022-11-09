package auxiliaresGraficos;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import model.Cuerpo;
import model.Map;
import model.Point;
import model.Snake;
import utilities.Constants;

public class GraphicMap {

	Canvas graphicMap;
	GraphicsContext gc;
	Map map;
	
	public GraphicMap(Canvas graphicMap, Map map) {
		this.graphicMap = graphicMap;
		this.map = map;
		
		this.gc = graphicMap.getGraphicsContext2D();
	}

	public void restartGraphicMap(){
		
		aplanarMapaGrafico();
		dibujarCulebraGrafica();
		dibujarPuntoGrafico();
		
	}
	
	private void dibujarPuntoGrafico() {

		Point punto = map.getPunto();
		if (punto != null) {
			
			gc.setFill(Paint.valueOf("0000ff"));
			gc.fillRoundRect(punto.getPosicionX()*Constants.LONGITUD_CUADRADO, punto.getPosicionY()*Constants.LONGITUD_CUADRADO, Constants.LONGITUD_CUADRADO, Constants.LONGITUD_CUADRADO, 50, 50);
		}
	}

	private void dibujarCulebraGrafica() {
		
		Snake snakeAux = map.getSnake();
		
		dibujarCabezaGrafica(snakeAux.getCabeza());
		
		//pinta toda la culebra menos la cabeza
		for (int i = 0; i < snakeAux.getCuerposCulebra().size() - 1; i++) {
			
			gc.setFill(Paint.valueOf("000000"));
			gc.fillRoundRect(snakeAux.getCuerposCulebra().get(i).getPosicionX()*Constants.LONGITUD_CUADRADO, snakeAux.getCuerposCulebra().get(i).getPosicionY()*Constants.LONGITUD_CUADRADO, Constants.LONGITUD_CUADRADO, Constants.LONGITUD_CUADRADO, 20, 20);
			
			gc.setFill(Paint.valueOf("00ff00"));
			gc.fillRoundRect(snakeAux.getCuerposCulebra().get(i).getPosicionX()*Constants.LONGITUD_CUADRADO + 2, snakeAux.getCuerposCulebra().get(i).getPosicionY()*Constants.LONGITUD_CUADRADO + 2, Constants.LONGITUD_CUADRADO - 4, Constants.LONGITUD_CUADRADO - 4, 20, 20);
		}
	}

	private void dibujarCabezaGrafica(Cuerpo cuerpo) {

		gc.setFill(Paint.valueOf("000000"));
		gc.fillRoundRect(cuerpo.getPosicionX()*Constants.LONGITUD_CUADRADO, cuerpo.getPosicionY()*Constants.LONGITUD_CUADRADO, Constants.LONGITUD_CUADRADO, Constants.LONGITUD_CUADRADO, 20, 20);
		
		gc.setFill(Paint.valueOf("00ff00"));
		gc.fillRoundRect(cuerpo.getPosicionX()*Constants.LONGITUD_CUADRADO + 2,cuerpo.getPosicionY()*Constants.LONGITUD_CUADRADO + 2, Constants.LONGITUD_CUADRADO - 4, Constants.LONGITUD_CUADRADO - 4, 20, 20);
		
		gc.setFill(Paint.valueOf("000000"));
		gc.fillOval(cuerpo.getPosicionX()*Constants.LONGITUD_CUADRADO + 15, cuerpo.getPosicionY()*Constants.LONGITUD_CUADRADO + 15, 20, 20);
		
	}

	private void aplanarMapaGrafico() {
		
		gc.setFill(Paint.valueOf("ff0000"));
		gc.fillRoundRect(0, 0, graphicMap.getWidth(), graphicMap.getHeight(), 20, 20);
		
	}

	public Canvas getGraphicMap() {
		return graphicMap;
	}

	public void setGraphicMap(Canvas graphicMap) {
		this.graphicMap = graphicMap;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
	
}
