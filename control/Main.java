package tp.pr2.control;

import tp.pr2.logica.Partida;
import tp.pr2.juego.*;

public class Main {
	static ReglasJuego reglas = new ReglasConecta4();
	
	public static void main(String[] args) {
		// El main crea los objetos para partida y controlador e inicia la ejecución del programa.
		Controlador controlador = new Controlador(new Partida(reglas));
		controlador.run();
	}
}
