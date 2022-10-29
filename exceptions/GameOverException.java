package exceptions;

@SuppressWarnings("serial")
public class GameOverException extends Exception {

	public GameOverException() {
		super("fin del juego, muy malo");
	}
	
}
