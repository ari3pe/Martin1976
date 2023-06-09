package Juego;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame ventana = new JFrame();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //para poder cerrar la ventana correctamente
		ventana.setResizable(false);
		ventana.setTitle("Martín 1976");
		
		PantallaJuego pantalla = new PantallaJuego();
		
		ventana.add(pantalla);
		ventana.pack(); //para poder ver la pantalla
		
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		
		pantalla.empezarJuegoHilo();
	}

}
