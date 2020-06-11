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


public class FloorWithBoost extends MapObject {
	
	FloorWithBoost(){
		//TO DO: adicionar imagem do FloorWithBoost, e substituir esse diretorio
		spritePath = "PacManFloorWithBoost.png";
		updateSprite();
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

	//Nao utilizado ainda
	@Override
	public void tick() {
	}

}
