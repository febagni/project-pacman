
public class Difficulty1 extends GameState {
	
	Difficulty1(String mapFileName) {
		levelNumber = 1;
		mapBuilder = new MapBuilder(mapFileName);
		map = mapBuilder.build();
		EntityHandler.setMixedFollowRate(10);
		Entity.setStep(1);
		this.cherryChance = 0;
		this.boostedTime = 2.0f;
		this.lives = Integer.MAX_VALUE;
		this.pointMultiplier = 0.5f;
	}
}
