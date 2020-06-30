/*
 * @file Difficulty2.java
 * 
 * @brief Implements the difficulty number 2 for the game
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */
public class Difficulty2 extends GameState {
	
	Difficulty2(String mapFileName) {
		levelNumber = 2;							// The number of the level
		mapBuilder = new MapBuilder(mapFileName);
		map = mapBuilder.build();
		EntityHandler.setMixedFollowRate(30);		// Sets the follow rate (30% follow, 70% random)
		Entity.setStep(1);							// All entities move one pixel per tick
		this.boostedTime = 1800;					// Sets the boosted time to last 1800 ticks
		this.lives = 4;								// Sets lives to 4
		this.pointMultiplier = 1;					// Multiplies all points by 1
		this.songPath = "dif2.aif";					// Sets the song path to dif2
	}
}
