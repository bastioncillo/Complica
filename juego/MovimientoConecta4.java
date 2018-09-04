package tp.pr2.juego;

import tp.pr2.logica.Ficha;
import tp.pr2.logica.Tablero;

public class MovimientoConecta4 extends Movimiento {
	
	public MovimientoConecta4(int col, Ficha turno){
		super(col, turno);
	}
	
	// ---------------------------------- ESTABLECER FILA --------------------------------------
	// Comprueba si hay fichas en la columna para decidir en qu� fila introducir la nueva ficha.
	private int establecerFila(int col, Tablero tab) {
		int fila = ReglasComunes4EnLinea.establecerFila(col, tab);
		return fila;
	}
	
	// ---------------------------------- EJECUTA MOVIMIENTO ----------------------------------------
	// Coloca la ficha que le toca en el tablero, en el caso de que se pueda. 
	public boolean ejecutaMovimiento(Tablero tab) {
		boolean hecho = false;
		//Primero establecemos la fila donde colocar la ficha.
		this.fila = establecerFila(this.col, tab);
		//Luego se coloca la ficha en el tablero, si hay sitio en la columna elegida.
		if(this.fila >= 0){
			tab.colocarFicha(this.col, this.fila, turno);
			hecho = true;
		}
		return hecho;
	}
	
	// --------------------------------------- UNDO --------------------------------------------------
	// Deshace el �ltimo movimiento realizado
	public void undo(Tablero tab) {
		tab.colocarFicha(this.col, this.fila, Ficha.VACIA);
	}
}
