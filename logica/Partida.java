package tp.pr2.logica;

import tp.pr2.juego.Movimiento;
import tp.pr2.juego.ReglasJuego;

public class Partida {
	private Tablero tablero;
	private Ficha turno;
	private Ficha ganador;
	private ReglasJuego reglas;
	private Pila pila;
		
	public Partida(ReglasJuego reglas){
		this.reglas = reglas;
		this.tablero = reglas.iniciarTablero();
		this.turno = Ficha.BLANCA;
		this.pila = new Pila();
	}
	
	// ------------------------- RESET -------------------------------------
	// Reinicia la partida por completo
	public void reset(ReglasJuego reglas){
		this.reglas = reglas;
		this.tablero = reglas.iniciarTablero();
		this.turno = Ficha.BLANCA;
		this.pila = new Pila();
	}
	
	// ------------------------------- DIBUJAR TABLERO ---------------------------
	// Dibuja el tablero colocando las fichas correspondientes
	public String dibujarTablero(){
		return this.reglas.dibujarTablero(this.tablero);
	}
	
	// ---------------------------------- GET TURNO ------------------------------
	// Devuelve el turno del jugador
	public Ficha getTurno(){
		return this.turno;
	}
	
	// ---------------------------------- GET GANADOR ------------------------------
	// Devuelve el turno del jugador
	public Ficha getGanador(){
		return this.ganador;
	}
	
	// ------------------------------------- EJECUTAR MOVIMIENTO ----------------------------------------
	// Coloca una ficha en el tablero y comprueba si se acaba la partida o no.
	public boolean ejecutaMovimiento(Movimiento mov){
		boolean hecho = false;
		if(this.reglas.movimientoValido(mov, this.tablero)){
			if(mov.ejecutaMovimiento(this.tablero)){
				hecho = true;
				this.ganador = this.reglas.comprobarGanador(this.tablero, mov);
				if(this.ganador == null){
					this.pila.poner(mov);
				}
			}
		}
		return hecho;
	}
	
	// ------------------------------------------ TABLAS --------------------------------------------
	// Comprueba si se han formado tablas en el tablero
	public boolean tablas(Movimiento mov){
		return this.reglas.hayTablas(this.tablero, mov);
	}
	
	// ----------------------------------------- CAMBIA TURNO ---------------------------------------
	// Cambia el turno para que juegue el siguiente jugador
	public Ficha cambiaTurno(){
		this.turno = reglas.siguienteTurno(this.tablero, turno);
		return turno;
	}
	
	// ------------------------------------------ DESHACER -----------------------------------------
	// Deshace el �ltimo movimiento del jugador
	public void deshacer(){
		Movimiento anterior = this.pila.sacar();
		if (anterior != null) {
			anterior.undo(this.tablero);
			this.turno = cambiaTurno();
		}
	}
}	


