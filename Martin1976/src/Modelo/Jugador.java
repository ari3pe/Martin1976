package Modelo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Juego.Main;
import Juego.PantallaJuego;
import Juego.TecladoControl;

public class Jugador extends Personaje {

	PantallaJuego pantallaJ;
	TecladoControl tec;

	public Jugador(PantallaJuego pantallaJ, TecladoControl tec) {
		this.pantallaJ = pantallaJ;
		this.tec = tec;
		valoresDefault();
		getImagenJugador();
	}

	public void valoresDefault() {
		x = 100;
		y = 100;
		velocidad = 4;
		direccion = "down";
	}

	public void getImagenJugador() {
		try {
			down1 = ImageIO.read(getClass().getResourceAsStream("/Martin/martin_down_1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/Martin/martin_down_2.png"));
			up1 = ImageIO.read(getClass().getResourceAsStream("/Martin/martin_up_1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/Martin/martin_up_2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/Martin/martin_left_1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/Martin/martin_left_2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/Martin/martin_right_1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/Martin/martin_right_2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void update() {

		if (tec.subir == true || tec.bajar == true || tec.irDerecha == true || tec.irIzquierda == true) {

			if (tec.isSubir() == true) {
				direccion = "up";
				y -= velocidad;
			} else if (tec.isBajar() == true) {
				direccion = "down";
				y += velocidad;
			} else if (tec.isIrIzquierda() == true) {
				direccion = "left";
				x -= velocidad;
			} else if (tec.isIrDerecha() == true) {
				direccion = "right";
				x += velocidad;
			}

			spriteContador++;

			if (spriteContador > 12) {
				if (spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 1;
				}
				spriteContador = 0;
			}
		}

	}

	public void draw(Graphics2D g2) {
		// g2.setColor(Color.white);
		// g2.fillRect(x, y, pantallaJ.tileSize, pantallaJ.tileSize);

		BufferedImage image = null;

		switch (direccion) {
		case "up":
			if (spriteNum == 1) {
				image = up1;
			}
			if (spriteNum == 2) {
				image = up1;
			}

			break;
		case "down":
			if (spriteNum == 1) {
				image = down1;
			}
			if (spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if (spriteNum == 1) {
				image = left1;
			}
			if (spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if (spriteNum == 1) {
				image = right1;
			}
			if (spriteNum == 2) {
				image = right2;
			}
			break;

		}

		g2.drawImage(image, x, y, pantallaJ.tileSize, pantallaJ.tileSize, null);
	}
}
