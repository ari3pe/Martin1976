package Modelo;

import java.awt.image.BufferedImage;

import Juego.PantallaJuego;
import Juego.TecladoControl;

public class Personaje {

	int x;
	int y;
	int velocidad;
	
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	public String direccion;
	
	public int spriteContador = 0;
	public int spriteNum = 1;
}
