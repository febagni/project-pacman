/*
 * @file Difficulty3.java
 * 
 * @brief Implements the difficulty number 3 for the game
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */
public class Difficulty3 extends GameState {

	Difficulty3(String mapFileName) {
		levelNumber = 3;							// The number of the level
		mapBuilder = new MapBuilder(mapFileName);
		map = mapBuilder.build();
		EntityHandler.setMixedFollowRate(50);		// Sets the follow rate (50% follow, 50% random)
		Entity.setStep(1);							// All entities move one pixel per tick
		this.boostedTime = 1200;					// Sets the boosted time to last 1800 ticks
		this.lives = 3;								// Sets lives to 3
		this.pointMultiplier = 1;					// Multiplies all points by 1
		this.songPath = "dif3.aif";					// Sets the song path to dif3
	}
}
