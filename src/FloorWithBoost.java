/*
 * @file FloorWithBoost.java
 * 
 * @brief Classe filha de MapObject que representa o chao com poderzinho
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

public class FloorWithBoost extends MapObject {
	
	FloorWithBoost(){
		spritePath = "Floor.png";
	}
	
	//Necessario para fabrica abstrata com hashmap
	@Override
	public GameObject clone() {
		FloorWithBoost floorWithBoost = new FloorWithBoost();
//		floorWithBoost.setX(x);
//		floorWithBoost.setY(y);
		floorWithBoost.setID(MapID.FloorWithBoost);
		return floorWithBoost;
	}
	
	/*
	 * @brief Renderiza o chao com poderzinho
	 */	
	@Override
	public void render(Graphics graphic) {
		graphic.setColor(Color.black);
		graphic.fillRect(x*squareSize, y*squareSize, squareSize, squareSize);
		if(this.id == MapID.FloorWithBoost) {
			graphic.setColor(Color.yellow);
			graphic.fillOval(squareSize*x+10, squareSize*y+10, squareSize-20, squareSize-20);
		}
	}

	//Nao utilizado ainda
	@Override
	public void tick() {
	}

}
