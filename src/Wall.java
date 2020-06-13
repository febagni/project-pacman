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
 * @date 06/2020
 * 
 */

public class Wall extends MapObject {
	
	public Wall() {
		spritePath = "PacManWall.png";
		updateSprite();
	}
	
	//Nao utilizado ainda
	@Override
	public void tick() {}

	/*
	 * @brief Método clone do padrao prototype
	 */
	@Override
	public GameObject clone() {
		Wall wall = new Wall();
		wall.setID(MapID.Wall);
		return wall;
	}
}
