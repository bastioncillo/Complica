package tp.pr2.juego;

import tp.pr2.logica.Ficha;
import tp.pr2.logica.Tablero;

public class MovimientoComplica extends Movimiento {
	//Atributos privados
	private boolean huecoHecho = false;
	private Ficha fichaPerdida = Ficha.VACIA;
	
	//Constructora
	public MovimientoComplica(int col, Ficha turno) {
		super(col, turno);
	}
	
	// ---------------------------------- ESTABLECER FILA --------------------------------------
	// Comprueba si hay fichas en la columna para decidir en qu� fila introducir la nueva ficha.
	private int establecerFila(int col, Tablero tab) {
		int fila = ReglasComunes4EnLinea.establecerFila(col, tab);
		return fila;
	}
	
	//-------------------------- HACER HUECO ---------------------------------------
	// Desplaza todas las ficha de la columna una posici�n hacia abajo
	public void hacerHueco(int col, Tablero tab){
		for(int i = tab.getAlto()-1; i > 0; i--){
			Ficha aux = tab.getFicha(col, i - 1);
			tab.colocarFicha(col, i, aux);
		}
	}
	
	//-------------------------- DESHACER HUECO ---------------------------------------
	// Desplaza todas las ficha de la columna una posici�n hacia abajo
	public void deshacerHueco(int col, Tablero tab){
		for(int i = 0; i < tab.getAlto() - 1; i++){
			Ficha aux = tab.getFicha(col, i+1);
			tab.colocarFicha(col, i, aux);
		}
	}
	
	// ---------------------------------- EJECUTA MOVIMIENTO ----------------------------------------
	// Coloca la ficha que le toca en el tablero. 
	public boolean ejecutaMovimiento(Tablero tab) {
		//Primero establecemos la fila donde colocar la ficha.
		this.fila = establecerFila(this.col, tab);
		//Luego se coloca la ficha en el tablero.
		if(this.fila >= 0){
			this.huecoHecho = false;
			tab.colocarFicha(this.col, this.fila, this.turno);
		}
		//Si no hay sitio en la columna elegida, las fichas se desplazan hacia abajo una posici�n.
		else{
			//Guardamos la ficha que se pierde en una atributo privado
			int alto =  tab.getAlto();
			this.fichaPerdida = tab.getFicha(this.col, alto-1);
			hacerHueco(this.col, tab);
			//Recordamos que se ha hecho hueco para usarlo luego en el "undo"
			this.huecoHecho = true;
			tab.colocarFicha(this.col, 0, this.turno);
		}
		return true;
	}
	
	// --------------------------------------- UNDO --------------------------------------------------
	// Deshace el �ltimo movimiento realizado
	public void undo(Tablero tab) {
		if(this.huecoHecho){
			//Solo utiliza este proceso si se hab�a tenido que desplazar la columna
			deshacerHueco(this.col, tab);
			int tope = tab.getAlto();
			tab.colocarFicha(this.col, tope-1, this.fichaPerdida);
		}
		else{
			tab.colocarFicha(this.col, this.fila, Ficha.VACIA);
		}
	}
}
