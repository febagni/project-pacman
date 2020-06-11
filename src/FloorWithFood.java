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

public class FloorWithFood extends MapObject {
	
	FloorWithFood() {
		spritePath = "PacManFloorWithFood.png";
		updateSprite();
	}
	
	//Necessario para fabrica abstrata com hashmap
	@Override
	public GameObject clone() {
		FloorWithFood floorWithFood = new FloorWithFood();
//		floorWithFood.setX(x);
//		floorWithFood.setY(y);
		floorWithFood.setID(MapID.FloorWithFood);
		return floorWithFood;
	}

    //Nao utilizado ainda
	@Override
	public void tick() {
	}
}
