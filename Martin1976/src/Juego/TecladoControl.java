package Juego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TecladoControl implements KeyListener {

	public boolean subir;
	public boolean bajar;
	public boolean irIzquierda;
	public boolean irDerecha;

	public boolean isSubir() {
		return subir;
	}

	public void setSubir(boolean subir) {
		this.subir = subir;
	}

	public boolean isBajar() {
		return bajar;
	}

	public void setBajar(boolean bajar) {
		this.bajar = bajar;
	}

	public boolean isIrIzquierda() {
		return irIzquierda;
	}

	public void setIrIzquierda(boolean irIzquierda) {
		this.irIzquierda = irIzquierda;
	}

	public boolean isIrDerecha() {
		return irDerecha;
	}

	public void setIrDerecha(boolean irDerecha) {
		this.irDerecha = irDerecha;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// noUsamosEsteMetodo
	}

	@Override
	public void keyPressed(KeyEvent e) { // teclas pulsadas
		int teclaPresionada = e.getKeyCode();

		if (teclaPresionada == KeyEvent.VK_W) {
			subir = true;
		}
		if (teclaPresionada == KeyEvent.VK_A) {
			irIzquierda = true;
		}
		if (teclaPresionada == KeyEvent.VK_S) {
			bajar = true;
		}
		if (teclaPresionada == KeyEvent.VK_D) {
			irDerecha = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) { // teclas liberadas
		int teclaLiberada = e.getKeyCode();

		if (teclaLiberada == KeyEvent.VK_W) {
			subir = false;
		}
		if (teclaLiberada == KeyEvent.VK_A) {
			irIzquierda = false;
		}
		if (teclaLiberada == KeyEvent.VK_S) {
			bajar = false;
		}
		if (teclaLiberada == KeyEvent.VK_D) {
			irDerecha = false;
		}
	}

}
