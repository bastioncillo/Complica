package tp.pr2.juego;

import tp.pr2.logica.Ficha;
import tp.pr2.logica.Tablero;

public class ReglasConecta4 extends ReglasJuego {

	public static final int ANCHO = 7;
	public static final int ALTO = 7;
	
	public ReglasConecta4() {
		super();
	}
	
	// --------------------------------------- INICIAR TABLERO ---------------------------------------
	// Crea un tablero seg�n los datos introducidos.
	public Tablero iniciarTablero() {
		return new Tablero(ANCHO, ALTO);
	}
	
	// ---------------------------------------- COMPROBAR GANADOR ------------------------------------------
	// Comprueba si hay un ganador de la partida seg�n la �tima ficha introducida.
	public Ficha comprobarGanador(Tablero tab, Movimiento mov) {
		Ficha ganador;
		if(comprobarFila(mov.col, mov.fila, tab)){
			ganador = mov.turno;
		}
		else if(comprobarColumna(mov.col, mov.fila, tab)){
			ganador = mov.turno;
		}
		else if(comprobarDiagonalAscendente(mov.col, mov.fila, tab)){
			ganador = mov.turno;
		}
		else if(comprobarDiagonalDescendente(mov.col, mov.fila, tab)){
			ganador = mov.turno;
		}
		else{
			ganador = null;
		}
		return ganador;
	}
	
	// -------------------------------------- COMPROBAR FILA --------------------------------------------
	// Comprueba si se han enlazado cuatro fichas del mismo color en una fila del tablero.
	private boolean comprobarFila(int col, int fila, Tablero tab){
		return ReglasComunes4EnLinea.comprobarFila(col, fila, tab);
	}
	
	// ----------------------------------- COMPROBAR COLUMNA ----------------------------------
	// Comprueba si hay cuatro fichas del mismo color en una columna del tablero.
	private boolean comprobarColumna(int col, int fila, Tablero tab){
		return ReglasComunes4EnLinea.comprobarColumna(col, fila, tab);
	}
		
	// --------------------------------------- COMPROBAR DIAGONAL DESCENDENTE -------------------------------
	// Comprueba si hay cuatro fichas del mismo color consecutivas en una diagonal del tablero.
	private boolean comprobarDiagonalDescendente(int col, int fila, Tablero tab){
		return ReglasComunes4EnLinea.comprobarDiagonalDescendente(col, fila, tab);
	}
	
	// --------------------------------------- COMPROBAR DIAGONAL ASCENDENTE -------------------------------
	// Comprueba si hay cuatro fichas del mismo color consecutivas en una diagonal del tablero.
	private boolean comprobarDiagonalAscendente(int col, int fila, Tablero tab){
		return ReglasComunes4EnLinea.comprobarDiagonalAscendente(col, fila, tab);
	}
	
	//-------------------------- COMPROBAR SI HAY TABLAS ----------------------------------
	//Cuenta el n�mero de posiciones ocupadas en el tablero, para ver si hay tablas.
	public boolean hayTablas(Tablero tab, Movimiento mov) {
		return ReglasComunes4EnLinea.hayTablas(tab, mov);
	}
	
	// ----------------------------------- CAMBIAR TURNO ---------------------------------
	// Cambia el color de la ficha a introducir seg�n el turno que corresponda.
	public Ficha siguienteTurno(Tablero tab, Ficha turno) {
		return ReglasComunes4EnLinea.siguienteTurno(tab, turno);
	}
	
	// ---------------------------- DIBUJAR TABLERO ----------------------------
	// Dibuja el tablero colocando las fichas correspondientes.
	public String dibujarTablero(Tablero tab) {
		return ReglasComunes4EnLinea.dibujarTablero(tab);
	}
	
	// ---------------------------- MOVIMIENTO V�LIDO --------------------------
	// Comprueba si un movimiento es v�lido
	public boolean movimientoValido(Movimiento mov, Tablero tab) {
		return ReglasComunes4EnLinea.movimientoValido(mov, tab);
	}

}