/*
 * @file GameState.java
 * 
 * @brief Abstract class that defines how the different difficulties will work
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */

public abstract class GameState {
	
	protected int levelNumber; //Current level
	protected int mixedFollowRate; //Difficulty
	protected int speed; //Game Speed
	protected int boostedTime; //Boosted state's duration
	protected int lives; //Player's number of lives
	protected GameObject[][] map; //Game's map
	protected float pointMultiplier; //Different values of point for different difficulties
	protected MapBuilder mapBuilder;
	protected String songPath;
	
	/*
	 * @brief getters da classe 
	 */
	int getLevelNumber() {return this.levelNumber;} //Returns the level the player is in currently
	int getMixedFollowRate() {return this.mixedFollowRate;} //Returns the rate in which the ghosts change between following the player and being random
	int getSpeed() {return this.speed;} //Returns the game speed
	int getBoostTime(){return this.boostedTime;} //Returns the time the player is at the boosted state
	int getLives(){return this.lives;}
	GameObject[][] getMap(){return this.map;}
	float getPointMultiplier() {return this.pointMultiplier;}
	String getSongPath() {return this.songPath;}
}
