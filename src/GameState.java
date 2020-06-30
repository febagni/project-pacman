
public abstract class GameState {
	
	protected int levelNumber;
	protected int mixedFollowRate;
	protected int speed;
	protected int cherryChance;
	protected int boostedTime;
	protected int lives;
	protected GameObject[][] map;
	protected float pointMultiplier;
	protected MapBuilder mapBuilder;
	protected String songPath;
	
	/*
	 * @brief getters da classe 
	 */
	int getLevelNumber() {return this.levelNumber;}
	int getMixedFollowRate() {return this.mixedFollowRate;}
	int getSpeed() {return this.speed;}
	int getBoostTime(){return this.boostedTime;}
	int getLives(){return this.lives;}
	GameObject[][] getMap(){return this.map;}
	float getPointMultiplier() {return this.pointMultiplier;}
	String getSongPath() {return this.songPath;}
}
