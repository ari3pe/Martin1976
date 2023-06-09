package tile;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import Juego.PantallaJuego;

public class TileRepresentante {

	PantallaJuego pj;
	Tile[] tile;

	public TileRepresentante(PantallaJuego pj) {
		this.pj = pj;
		tile = new Tile[10];
		getTileImagen();
	}

	public void getTileImagen() {

		try {
			tile[0] = new Tile();
			tile[0].imagen = ImageIO.read(getClass().getResourceAsStream(""));

			tile[1] = new Tile();
			tile[1].imagen = ImageIO.read(getClass().getResourceAsStream(""));

			tile[2] = new Tile();
			tile[2].imagen = ImageIO.read(getClass().getResourceAsStream(""));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void draw(Graphics2D g2) {

		int columna = 0;
		int fila = 0;
		int x = 0;
		int y = 0;

		while (columna < pj.maxScreenColumnas && fila < pj.maxScreenFilas) {

			g2.drawImage(tile[0].imagen, x, y, pj.tileSize, pj.tileSize, null);
			columna++;
			x += pj.tileSize;
			
			if(columna == pj.maxScreenColumnas) {
				columna = 0;
				x = 0;
				fila++;
				y+= pj.tileSize;
			}

		}
	}
}
