/*
 * @file Difficulty1.java
 * 
 * @brief Implements the easiest difficulty for the game
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */
public class Difficulty1 extends GameState {
	
	Difficulty1(String mapFileName) {
		levelNumber = 1; 							// The number of the level
		mapBuilder = new MapBuilder(mapFileName);
		map = mapBuilder.build();					
		EntityHandler.setMixedFollowRate(10);		// Sets the follow rate (10% follow, 90% random)
		Entity.setStep(1);							// All entities move one pixel per tick
		this.boostedTime = 1800;					// Sets the boosted time to last 1800 ticks
		this.lives = Integer.MAX_VALUE;				// Sets lives to maximum
		this.pointMultiplier = 0.5f;				// Multiplies all points by 1/2
		this.songPath = "dif1.aif";					// Sets the song path to dif1
	}
}
