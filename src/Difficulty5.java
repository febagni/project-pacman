/*
 * @file Difficulty5.java
 * 
 * @brief Implements the hardest difficulty for the game
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */
public class Difficulty5 extends GameState {

	Difficulty5(String mapFileName) {
		levelNumber = 5;							// The number of the level
		mapBuilder = new MapBuilder(mapFileName);
		map = mapBuilder.build();
		EntityHandler.setMixedFollowRate(90);		// Sets the follow rate (90% follow, 10% random)
		Entity.setStep(2);							// All entities move two pixels per tick
		this.boostedTime = 600;						// Sets the boosted time to last 600 ticks
		this.lives = 1;								// Sets lives to 1
		this.pointMultiplier = 3;					// Multiplies all points by 3
		this.songPath = "dif5.aif";					// Sets the song path to dif5
	}
}