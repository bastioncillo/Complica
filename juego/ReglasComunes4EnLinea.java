package tp.pr2.juego;

import tp.pr2.logica.Ficha;
import tp.pr2.logica.Tablero;

public class ReglasComunes4EnLinea {
	
	// ---------------------------------- ESTABLECER FILA --------------------------------------
	// Comprueba si hay fichas en la columna para decidir en quï¿½ fila introducir la nueva ficha.
	public static int establecerFila(int col, Tablero tab) {
		boolean encontrado = false;
		int fila = 0;
		while(!encontrado && fila < tab.getAlto()){
			// En el caso de que se encuentre una ficha blanca o negra en la columna introducida, se coloca la siguiente justo encima.
			if (tab.getFicha(col, fila) == Ficha.BLANCA || tab.getFicha(col, fila) == Ficha.NEGRA){
				encontrado = true;
				fila--;
			}
			// Si no se encuentra ninguna ficha en toda la columna, se coloca la ficha en la casilla de mï¿½s abajo.
			else if (fila == tab.getAlto() - 1){
				encontrado = true;
			}
			// Si no se encuentra una ficha en esa fila, se pasa a la siguiente.
			else {
				fila++;
			}
		}
		return fila;
	}
		
	// -------------------------------------- COMPROBAR FILA --------------------------------------------
	// Comprueba si se han enlazado cuatro fichas del mismo color en una fila del tablero.
	public static boolean comprobarFila(int col, int fila, Tablero tab){
		boolean hayCuatro = false;
		int contFichas = 1, colAux = col;
		// Va sumando mientras las fichas en columnas consecutivas sean iguales y no se salga del tablero...
		while (!hayCuatro && (colAux < tab.getAncho() - 1) && (tab.getFicha(col, fila) == tab.getFicha(colAux+1, fila))) {
			contFichas++;
			colAux++;
			// Si encuentra 4 fichas seguidas, se pone a true.
			if(contFichas == 4){
				hayCuatro = true;
			}
		}
		//Reiniciamos colAux a su valor original.
		colAux = col;
		// Repite el procedimiento con columnas anteriores.
		while(!hayCuatro && (colAux > 0) && (tab.getFicha(col, fila) == tab.getFicha(colAux-1, fila)) ){
			contFichas++;
			colAux--;
			if(contFichas == 4){
				hayCuatro = true;
			}
		}
		return hayCuatro;
	}
		
	// ----------------------------------- COMPROBAR COLUMNA ----------------------------------
	// Comprueba si hay cuatro fichas del mismo color en una columna del tablero.
	public static boolean comprobarColumna(int col, int fila, Tablero tab){
		boolean hayCuatro = false;
		int contFichas = 1, filaAux = fila;
		// Va sumando mientras las fichas en filas consecutivas sean del mismo color y no se salga del tablero...
		while (!hayCuatro && (filaAux < tab.getAlto() - 1) && (tab.getFicha(col, fila) == tab.getFicha(col, filaAux+1))) {
			contFichas++;
			filaAux++;
			// Si encuentra cuatro fichas seguidas, se pone a true.
			if(contFichas == 4){
				hayCuatro = true;
			}
		}
		//Reiniciamos filaAux a su valor original
		filaAux = fila;
		// Realiza el mismo procedimiento con filas anteriores.
		while(!hayCuatro && (filaAux > 0) && (tab.getFicha(col, fila) == tab.getFicha(col, filaAux-1))){
			contFichas++;
			filaAux--;
			if(contFichas == 4){
				hayCuatro = true;
			}
		}
		return hayCuatro;
	}
		
	// --------------------------------------- COMPROBAR DIAGONAL DESCENDENTE -------------------------------
	// Comprueba si hay cuatro fichas del mismo color consecutivas en una diagonal del tablero.
	public static boolean comprobarDiagonalDescendente(int col, int fila, Tablero tab){
		boolean hayCuatro = false;
		int contFichas = 1, colAux = col, filaAux = fila;
		// Va sumando si encuentra fichas del mismo color consecutivas avanzando una fila y una columna y no se sale del tablero...
		while(!hayCuatro && (colAux < tab.getAncho() - 1) && (filaAux < tab.getAlto() - 1) && (tab.getFicha(col, fila) == tab.getFicha(colAux+1, filaAux+1))){
			contFichas++;
			colAux++;
			filaAux++;
			// Si encuentra cuatro fichas consecutivas, se pone a true.
			if(contFichas == 4){
				hayCuatro = true;
			}
		}
		//Reiniciamos el valor de colAux y filaAux a su valor original.
		colAux = col;
		filaAux = fila;
		// Realiza el mismo procedimiento con filas y columnas anteriores.
		while(!hayCuatro && (colAux > 0) && (filaAux > 0) && (tab.getFicha(col, fila) == tab.getFicha(colAux-1, filaAux-1))){
			contFichas++;
			colAux--;
			filaAux--;
			if(contFichas == 4){
				hayCuatro = true;
			}
		}
		return hayCuatro;
	}
	
	// --------------------------------------- COMPROBAR DIAGONAL ASCENDENTE -------------------------------
	// Comprueba si hay cuatro fichas del mismo color consecutivas en una diagonal del tablero.
	public static boolean comprobarDiagonalAscendente(int col, int fila, Tablero tab){
		boolean hayCuatro = false;
		int contFichas = 1, colAux = col, filaAux = fila;
		// Va sumando si encuentra fichas del mismo color consecutivas avanzando una fila y una columna y no se sale del tablero...
		while(!hayCuatro && (colAux < tab.getAncho() - 1) && (filaAux > 0) && (tab.getFicha(col, fila) == tab.getFicha(colAux+1, filaAux-1))){
			contFichas++;
			colAux++;
			filaAux--;
			// Si encuentra cuatro fichas consecutivas, se pone a true.
			if(contFichas == 4){
				hayCuatro = true;
			}
		}
		//Reiniciamos el valor de colAux y filaAux a su valor original.
		colAux = col;
		filaAux = fila;
		// Realiza el mismo procedimiento con filas y columnas anteriores.
		while(!hayCuatro && (colAux > 0) && (filaAux < tab.getAlto() - 1) && (tab.getFicha(col, fila) == tab.getFicha(colAux-1, filaAux+1))){
			contFichas++;
			colAux--;
			filaAux++;
			if(contFichas == 4){
				hayCuatro = true;
			}
		}
		return hayCuatro;
	}
	
	// ---------------------------- DIBUJAR TABLERO ----------------------------
	// Dibuja el tablero colocando las fichas correspondientes.
	public static String dibujarTablero(Tablero tab) {
		return tab.dibujarTablero(tab);
	}
	
	// ---------------------------- MOVIMIENTO VÁLIDO --------------------------
	// Comprueba si un movimiento es válido
	public static boolean movimientoValido(Movimiento mov, Tablero tab) {
		boolean valido = true;
		if(mov.getCol() < 0 || mov.getCol() >= tab.getAncho()){
			valido = false;
		}
		return valido;
	}
	
	// ----------------------------------- CAMBIAR TURNO ---------------------------------
	// Cambia el color de la ficha a introducir según el turno que corresponda.
	public static Ficha siguienteTurno(Tablero tab, Ficha turno) {
		if (turno == Ficha.BLANCA || turno == Ficha.VACIA) {
			turno = Ficha.NEGRA;
		}
		else {
			turno = Ficha.BLANCA;
		}
		return turno;
	}
	
	//-------------------------- COMPROBAR SI HAY TABLAS ----------------------------------
	//Cuenta el número de posiciones ocupadas en el tablero, para ver si hay tablas.
	public static boolean hayTablas(Tablero tab, Movimiento mov) {
		boolean tablas = false;
		int c_ocupadas = 0;
		for(int i = 0; i < tab.getAncho(); i++){
			for(int j = 0; j < tab.getAlto(); j++){
				if(tab.getFicha(i, j) == Ficha.BLANCA || tab.getFicha(i, j) == Ficha.NEGRA){
					c_ocupadas = c_ocupadas + 1;
				}
			}
		}
		if(c_ocupadas == tab.getAncho()*tab.getAlto()){
			tablas = true;
		}
		return tablas;
	}
}


