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
 * @date 06/2020
 * 
 */

public class Floor extends MapObject {
	
	
	public Floor() {
		spritePath = "PacManFloor.png";
		updateSprite();
	}
	
	/*
	 * @brief Implementação do padrão prototype: clona o objeto para criar os objetos pela fábrica abstrata
	 */
	@Override
	public GameObject clone() {
		Floor floor = new Floor();
		floor.setID(MapID.Floor);
		return floor;
	}

	//Nao utilizado 
	@Override
	public void tick() {}
}
