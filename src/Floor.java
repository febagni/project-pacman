/*
 * @file Floor.java
 * 
 * @brief Classe filha de MapObject que representa o chao
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 05/2020
 * 
 */
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Floor extends MapObject {
	
	public Floor() {
		try {
			sprite = ImageIO.read(new File("sprites/PacManFloor.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Necessario para fabrica abstrata com hashmap
	@Override
	public GameObject clone() {
//		Floor floor = new Floor();
//		floor.setX(x);
//		floor.setY(y);
//		floor.setID(MapID.Floor);
		return new Floor();
	}

	//N�o utilizado ainda
	@Override
	public void tick() {
	}
}
