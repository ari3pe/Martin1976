package Juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import Modelo.*;
import tile.*;

public class PantallaJuego extends JPanel implements Runnable {

	// Ajustes de pantalla
	final int originalTileSize = 16; // 16*16 pixels para TODO el juego, npcs, jugador, objetos, tiles del mapa..
	final int escala = 20; // para que los pj se vean en 48*48 pixeles en la pantalla

	public final int tileSize = originalTileSize * escala;
	public final int maxScreenColumnas = 16;
	public final int maxScreenFilas = 12;

	public final int pantallaAncho = tileSize * maxScreenColumnas; // 768 pixeles
	public final int pantallaLargo = tileSize * maxScreenFilas; // 576 pixeles

	int FPS = 60;
	
	
	TileRepresentante tp = new TileRepresentante(this);
	TecladoControl tec = new TecladoControl();
	Thread juegoThread;
	public ColocarObjetos colocarObj  = new ColocarObjetos(this);
	public Jugador jugador = new Jugador(this, tec);
	public SuperObjeto obj[] = new SuperObjeto[10];
	
	// constructor
	public PantallaJuego() {

		this.setPreferredSize(new Dimension(pantallaAncho, pantallaLargo));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); // para mejorar el rendimiento de renderizado
		this.addKeyListener(tec);
		this.setFocusable(true); // para q permita apretar muchas teclas repetidamente sin q se crashee
		this.requestFocusInWindow();
	}

	public void empezarJuegoHilo() {

		// instanciamos el hilo
		juegoThread = new Thread(this); // con el this le pasamos el constructor de la clase, por ende, todos sus
										// atributos también!
		// iniciamos el hilo
		juegoThread.start(); // llamamos automáticamente al método run()
	}

	@Override
	public void run() { // en este método creamos el bucle del juego, que va a ser básicamente el núcleo
						// del mismo.

		double drawInterval = 1000000000 / FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;

		while (juegoThread != null) {

			update();
			repaint();

			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime / 1000000;

				if (remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long) remainingTime);
				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// this.requestFocusInWindow();
		}
	}

	public void update() {
		jugador.update();
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; // convertimos los gráficos a graficos 2D

		tp.draw(g2);
		jugador.draw(g2);
		g2.dispose(); // paraAhorrarMemoria
	}
}
