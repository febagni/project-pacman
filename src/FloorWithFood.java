/*
 * @file FloorWithFood.java
 * 
 * @brief Classe filha de MapObject que representa o chao com comida
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 05/2020
 * 
 */
import java.awt.Color;
import java.awt.Graphics;

public class FloorWithFood extends MapObject {
	
	//Necessario para fabrica abstrata com hashmap
	@Override
	MapObject cloneMapObject(int x, int y) {
		FloorWithFood floorWithFood = new FloorWithFood();
		floorWithFood.setX(x);
		floorWithFood.setY(y);
		floorWithFood.setID(MapID.FloorWithFood);
		return floorWithFood;
	}
	
	/*
	 * @brief Renderiza todas as entidades
	 */
	public void render(Graphics graphic) {
		graphic.setColor(Color.black);
		graphic.fillRect(x*squareSize, y*squareSize, squareSize, squareSize);
		if(this.id == MapID.FloorWithFood) {
			graphic.setColor(Color.white);
			graphic.fillOval(squareSize*x+14, squareSize*y+14, squareSize-28, squareSize-28);
		}
	
	}

	/*
	 * @brief Funcao que faz todas as entidades do jogo atualizarem
	 */
	@Override
	public void tick() {
	}
}
