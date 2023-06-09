package Juego;

import Modelo.Favor;

public class ColocarObjetos {

	PantallaJuego pj;
	
	public ColocarObjetos(PantallaJuego pj) {
		this.pj = pj;
	}
	
	public void setObjetos() {
		pj.obj[0] = new Favor(); //min 9
	}
}
