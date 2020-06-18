
public class Difficulty1 extends GameState {
	
	Difficulty1(String mapFileName) {
		mapBuilder = new MapBuilder(mapFileName);
		map = mapBuilder.build();
		this.difficulty = 10;
		this.speed = 2;
		this.cherryChance = 0;
		this.boostedTime = 2.0f;
		this.lives = Integer.MAX_VALUE;
		this.pointMultiplier = 0.5f;
	}
}
