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
 * @date 06/2020
 * 
 */


public class FloorWithBoost extends MapObject {
	
	FloorWithBoost(){
		spritePath = "PacManFloorWithBoost.png";
		updateSprite();
	}
	
	/*
	 * @brief Implementação do padrão prototype: clona o objeto para criar os objetos pela fábrica abstrata
	 */
	@Override
	public GameObject clone() {
		FloorWithBoost floorWithBoost = new FloorWithBoost();
		floorWithBoost.setID(MapID.FloorWithBoost);
		return floorWithBoost;
	}

	//Nao utilizado 
	@Override
	public void tick() {
	}
}
