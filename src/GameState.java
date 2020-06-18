
public abstract class GameState {
	
	protected int difficulty;
	protected int speed;
	protected int cherryChance;
	protected float boostedTime;
	protected int lives;
	protected GameObject[][] map;
	protected float pointMultiplier;
	protected MapBuilder mapBuilder;
	/*
	 * @brief getters da classe 
	 */
	int getDifficulty() {return this.difficulty;}
	int getSpeed() {return this.speed;}
	int getCherryChance() {return this.cherryChance;}
	float getBoostTime(){return this.boostedTime;}
	int getLives(){return this.lives;}
	GameObject[][] getMap(){return this.map;}
	float getPointMultiplier() {return this.pointMultiplier;}
}
