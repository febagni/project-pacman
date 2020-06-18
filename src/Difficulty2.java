
public class Difficulty2 extends GameState {
	
	Difficulty2(String mapFileName) {
		mapBuilder = new MapBuilder(mapFileName);
		map = mapBuilder.build();
		this.difficulty = 30;
		this.speed = 2;
		this.cherryChance = 50;
		this.boostedTime = 1.5f;
		this.lives = 4;
		this.pointMultiplier = 1;
	}

}
