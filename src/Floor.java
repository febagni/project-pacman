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
import java.awt.Graphics;

public class Floor extends MapObject {
	
	//Necessario para fabrica abstrata com hashmap
	@Override
	MapObject cloneMapObject(int x, int y) {
		Floor floor = new Floor();
		floor.setX(x);
		floor.setY(y);
		floor.setID(MapID.Floor);
		return floor;
	}

	//Não utilizado ainda
	@Override
	public void tick() {
	}

	//Renderiza o chao
	@Override
	public void render(Graphics graphic) {
		ImageImporter image = new ImageImporter("sprites/PacManFloor.png");
		image.paintComponent(graphic, x*squareSize, y*squareSize);
	}
}
