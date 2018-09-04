package tp.pr2.juego;

import tp.pr2.logica.*;

public abstract class Movimiento {
	protected int col;
	protected Ficha turno;
	protected int fila;
		
	public Movimiento(int col, Ficha turno) {
		this.col = col;
		this.turno = turno;
	}
	
	public Ficha getTurno() {
		return this.turno;
	}
	
	public int getCol(){
		return this.col;
	}
	
	public int getFila(){
		return this.fila;
	}
	
	public abstract boolean ejecutaMovimiento(Tablero tab);
	public abstract void undo(Tablero tab);
}
