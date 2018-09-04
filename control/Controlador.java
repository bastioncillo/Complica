package tp.pr2.control;

import java.util.Scanner;

import tp.pr2.juego.*;
import tp.pr2.logica.Ficha;
import tp.pr2.logica.Partida;

public class Controlador {
	private Partida partida;
	private Movimiento mov;
	private ReglasJuego reglas;
	private Scanner in;
	private TipoJuego jugandoA;
	
	// -------------------------------------- CONSTRUCTORA ---------------------------------------
	public Controlador(Partida partida){
		this.partida = partida;
		this.in = new java.util.Scanner(System.in);
		this.reglas = new ReglasConecta4();
	}
	
	// ----------------------------- EJECUCI�N DEL PROGRAMA ---------------------------------------
	public void run(){
		// Variables locales
		Ficha color = Ficha.BLANCA;
		this.jugandoA = TipoJuego.C4;
		int col;
		boolean conecta4 = false;
		
		// Presenta la informaci�n del principio de la partida.
		System.out.println(this.partida.dibujarTablero());
		System.out.println("Juegan Blancas");
		System.out.println("salir / jugar c4 / jugar co / poner / deshacer / reiniciar");
		System.out.println("Que quieres hacer?: ");
		// Se solicita al usuario que introduzca la acci�n a realizar.
		String orden = this.in.nextLine();
		
		while(!orden.equalsIgnoreCase("salir")){
			// Si el usuario elige "jugar c4"...
			if (orden.equalsIgnoreCase("jugar c4")) {
				this.jugandoA = TipoJuego.C4;
				this.reglas = new ReglasConecta4();
				this.partida.reset(this.reglas);
				color = this.partida.getTurno();
			}
			// Si el usuario elige "jugar co"...
			else if (orden.equalsIgnoreCase("jugar co")) {
				this.jugandoA = TipoJuego.CO;
				this.reglas = new ReglasComplica();
				this.partida.reset(this.reglas);
				color = this.partida.getTurno();
			}
			// Si el usuario elige "poner"...
			else if(orden.equalsIgnoreCase("poner")){
				// ...se le pide que introduzca la columna en la que quiere introducir la ficha.
				System.out.println("Elige una columna: ");
				try {
					col = Integer.parseInt(this.in.nextLine()) - 1;
				}catch (NumberFormatException e){col = -1;}
				if (this.jugandoA == TipoJuego.C4) {
					this.mov = new MovimientoConecta4(col, this.partida.getTurno());
				}
				else { 
					this.mov = new MovimientoComplica(col, this.partida.getTurno());
				}
				//Llamamos a ejecutaMovimiento, que se encarga de controlar cada jugada
				if(this.partida.ejecutaMovimiento(this.mov)){
					if(this.partida.getGanador() == Ficha.BLANCA){
						System.out.println("Ganan las Blancas");
						conecta4 = true;
					}
					else if(this.partida.getGanador() == Ficha.NEGRA){
						System.out.println("Ganan las Negras");
						conecta4 = true;
					}
					else{
						//si no ha habido ning�n ganador, se comprueba si se producen tablas
						if(this.partida.tablas(this.mov)){
							conecta4 = true;
							System.out.println("La partida ha acabado en tablas");
						}
						//si no hay tablas, se cambia el turno para el siguiente jugador
						else{
							color = this.partida.cambiaTurno();
						}
					}
				}
				else { //Si no se ha podido ejecutar el movimiento, se informa al usuario 
					System.out.println("Movimineto no valido");
				}
			}	
			// Si el usuario elige "deshacer"... 
			else if(orden.equalsIgnoreCase("deshacer")){
				this.partida.deshacer();
				color = this.partida.getTurno();
			}
			
			// Si el usuario elige "reiniciar"...
			else if(orden.equalsIgnoreCase("reiniciar")){
				// ...se resetea el tablero por completo y se avisa al usuario.
				this.partida.reset(reglas);
				if (color == Ficha.NEGRA) {
					color = Ficha.BLANCA;
				}
				System.out.println("Tablero reiniciado");
			}
			
			// Si el usuario introduce cualquier instrucci�n que no hayamos contemplado, muestra un mensaje de error.
			else{
				System.out.println("La orden introducida no existe");
			}
		
			// Si nadie ha ganado, y tampoco hay tablas: la partida continua.
			if(!conecta4){
				System.out.println(this.partida.dibujarTablero());
				// Se indica al jugador qui�n juega.
				if(color == Ficha.BLANCA){
					System.out.println("Juegan Blancas");
				}
				else{
					System.out.println("Juegan Negras");
				}
				System.out.println("salir / jugar c4 / jugar co / poner / deshacer / reiniciar");
				System.out.println("Que quieres hacer?: ");
				// Se vuelve a introducir una instrucci�n y se repite todo el proceso de nuevo.
				orden = in.nextLine();
			}
			else{
				System.out.println(this.partida.dibujarTablero());
				orden = "salir";
			}
		}
	}
}