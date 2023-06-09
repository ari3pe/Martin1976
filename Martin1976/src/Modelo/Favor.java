package Modelo;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Favor extends SuperObjeto{

	public Favor() {
		
		nombre = "favor";
		try{
			imagen = ImageIO.read(getClass().getResourceAsStream("/Objetos/favorcito.png"));
		}catch(IOException e) {
			e.printStackTrace();
		};
		
	}
}
