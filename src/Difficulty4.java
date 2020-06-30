/*
 * @file Difficulty4.java
 * 
 * @brief Implements the difficulty number 4 for the game
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */
public class Difficulty4 extends GameState {

	Difficulty4(String mapFileName) {
		levelNumber = 4;							// The number of the level
		mapBuilder = new MapBuilder(mapFileName);
		map = mapBuilder.build();
		EntityHandler.setMixedFollowRate(70);		// Sets the follow rate (70% follow, 30% random)
		Entity.setStep(1);							// All entities move one pixel per tick
		this.boostedTime = 900;						// Sets the boosted time to last 900 ticks
		this.lives = 2;								// Sets lives to 2
		this.pointMultiplier = 2;					// Multiplies all points by 2
		this.songPath = "dif4.aif";					// Sets the song path to dif4
	}
}
