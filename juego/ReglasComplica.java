package tp.pr2.juego;

import tp.pr2.logica.Ficha;
import tp.pr2.logica.Tablero;

public class ReglasComplica extends ReglasJuego {

	public static int ANCHO = 4;
	public static int ALTO  = 7;
	
	public ReglasComplica(){
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
		boolean c4N = c4Negras(tab), c4B = c4Blancas(tab);
		if(c4N && !c4B){
			ganador = Ficha.NEGRA;
		}
		else if(!c4N && c4B){
			ganador = Ficha.BLANCA;
		}
		else{
			ganador = null;
		}
		return ganador;
	}
	
	//------------------------------------- COMPROBAR GANADOR NEGRAS ------------------------------------
	//Comprueba si las fichas negras han hecho 4 en raya
	private boolean c4Negras(Tablero tab){
		boolean c4 = false;
		/*Como solo queremos que mire el tablero hasta que haya cuatro en linea, usamos un bucle "while"
		 * que imita un bucle "for", y que nos permite salir antes de llegar al tope del recorrido*/
		int i = 0;
		while(i < ALTO && !c4){
			int j = 0;
			while(j < ANCHO && !c4){
				//Solo realiza la comprobaci�n si las fichas son negras
				if(tab.getFicha(j, i) == Ficha.NEGRA){
					if(comprobarFila(j, i, tab)){
						c4 = true;
					}
					else if(comprobarColumna(j, i, tab)){
						c4 = true;
					}
					else if(comprobarDiagonalAscendente(j, i, tab)){
						c4 = true;
					}
					else if(comprobarDiagonalDescendente(j, i, tab)){
						c4 = true;
					}
					else{
						c4 = false;
					}
				}
				j++;
			}
			i++;
		}
		return c4;
	}
	
	//------------------------------------- COMPROBAR GANADOR BLANCAS ------------------------------------
	//Comprueba si las fichas blancas han hecho 4 en raya
	private boolean c4Blancas(Tablero tab){
		boolean c4 = false;
		/*Como solo queremos que mire el tablero hasta que haya cuatro en linea, usamos un bucle "while"
		 * que imita un bucle "for", y que nos permite salir antes de llegar al tope del recorrido*/
		int i = 0;
		while(i < ALTO && !c4){
			int j = 0;
			while(j < ANCHO && !c4){
				//Solo realiza la comprobaci�n si las fichas son blancas
				if(tab.getFicha(j, i) == Ficha.BLANCA){
					if(comprobarFila(j, i, tab)){
						c4 = true;
					}
					else if(comprobarColumna(j, i, tab)){
						c4 = true;
					}
					else if(comprobarDiagonalAscendente(j, i, tab)){
						c4 = true;
					}
					else if(comprobarDiagonalDescendente(j, i, tab)){
						c4 = true;
					}
					else{
						c4 = false;
					}
				}
				j++;
			}
			i++;
		}
		return c4;
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
	//Este m�todo no tiene  uso aqu�.
	public boolean hayTablas(Tablero tab, Movimiento mov) {
		return false;
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