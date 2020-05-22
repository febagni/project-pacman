/*
 * @file Wall.java
 * 
 * @brief Classe filha de MapObject que representa a parede
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

public class Wall extends MapObject {
	
	public Wall() {
		try {
			sprite = ImageIO.read(new File("sprites/PacManWall.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Necessario para fabrica abstrata com hashmap
	@Override
	MapObject cloneMapObject(int x, int y) {
		Wall wall = new Wall();
		wall.setX(x);
		wall.setY(y);
		wall.setID(MapID.Wall);
		return wall;
	}
	
	//Não utilizado ainda
	@Override
	public void tick() {
		//In construction
	}
}
