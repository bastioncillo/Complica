package tp.pr2.juego;

import tp.pr2.logica.Ficha;
import tp.pr2.logica.Tablero;

public abstract class ReglasJuego {

	public abstract Tablero iniciarTablero();
	public abstract Ficha comprobarGanador(Tablero tab, Movimiento mov);
	public abstract boolean hayTablas(Tablero tab, Movimiento mov);
	public abstract Ficha siguienteTurno(Tablero tab, Ficha turno);
	public abstract boolean movimientoValido(Movimiento mov, Tablero tab);
	public abstract String dibujarTablero(Tablero tab);
}
