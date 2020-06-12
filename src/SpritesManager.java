/*
 * @file SpritesManager.java
 * 
 * @brief Classe auxiliar para acessar os arquivos dos sprites
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */

public class SpritesManager {
	
	static final String mainFolder = "sprites/";
	static String folder = "Classic/";
	
	/*
	 * @brief Get the folder path to the sprite
	 */
	static String getFolder() {	return mainFolder + folder;}
	
	/*
	 * @brief Get the sprite file name
	 */
	static String getSpritePath (MapID id) {
		switch (id) {
			case Floor :
				return "PacManFloor.png";
			case Wall :
				return "PacManWall.png";
			case FloorWithFood :
				return "PacManFloorWithFood.png";
			case FloorWithBoost :
				return "PacManFloorWithBoost.png";
			case FloorWithCherry : 
				return "PacManFloorWithCherry.png";
		}
		return null;
	}
}
