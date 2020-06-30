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
 * @date 06/2020
 * 
 */

public class FloorWithFood extends MapObject {
	
	FloorWithFood() {
		spritePath = "PacManFloorWithFood.png";
		updateSprite();
	}
	
	/*
	 * @brief Implementação do padrão prototype: clona o objeto para criar os objetos pela fábrica abstrata
	 */
	@Override
	public GameObject clone() {
		FloorWithFood floorWithFood = new FloorWithFood();
		floorWithFood.setID(MapID.FloorWithFood);
		return floorWithFood;
	}

    //Nao utilizado 
	@Override
	public void tick() {
	}
}
