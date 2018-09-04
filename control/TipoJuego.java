package tp.pr2.control;
///////////////////////////////////////////////
public enum TipoJuego {
	C4, CO;
	
	public String toString() {
		String simbolo = " ";
		if (this == C4) {
			simbolo = "Conecta 4";
		}
		else if (this == CO) {
			simbolo = "Complica";
		}
		return simbolo;
	}
///////////////////////////////////////////////
}
