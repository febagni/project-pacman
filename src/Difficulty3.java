
public class Difficulty3 extends GameState {

	Difficulty3(String mapFileName) {
		levelNumber = 3;
		mapBuilder = new MapBuilder(mapFileName);
		map = mapBuilder.build();
		EntityHandler.setMixedFollowRate(50);
		Entity.setStep(1);
		this.cherryChance = 3;
		this.boostedTime = 1200;
		this.lives = 3;
		this.pointMultiplier = 1;
	}

}
