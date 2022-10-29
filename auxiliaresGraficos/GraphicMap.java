package auxiliaresGraficos;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
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
		for (int i = 0; i < snakeAux.getCuerposCulebra().size(); i++) {
			
			gc.setFill(Paint.valueOf("00ff00"));
			gc.fillRoundRect(snakeAux.getCuerposCulebra().get(i).getPosicionX()*Constants.LONGITUD_CUADRADO, snakeAux.getCuerposCulebra().get(i).getPosicionY()*Constants.LONGITUD_CUADRADO, Constants.LONGITUD_CUADRADO, Constants.LONGITUD_CUADRADO, 20, 20);
		}
	}

	private void aplanarMapaGrafico() {

		gc.setFill(Paint.valueOf("ff0000"));
		gc.fillRoundRect(0, 0, graphicMap.getWidth(), graphicMap.getHeight(), 50, 50);
		
//		for (int i = 0; i < map.getMap().length; i++) {
//			for (int j = 0; j < map.getMap()[i].length; j++) {
//				
//				gc.setFill(Paint.valueOf("ff0000"));
//				gc.fillRect(j*Constants.LONGITUD_CUADRADO, i*Constants.LONGITUD_CUADRADO, Constants.LONGITUD_CUADRADO, Constants.LONGITUD_CUADRADO);
//			}
//		}
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
