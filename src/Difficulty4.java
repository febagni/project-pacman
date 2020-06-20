
public class Difficulty4 extends GameState {

	Difficulty4(String mapFileName) {
		levelNumber = 4;
		mapBuilder = new MapBuilder(mapFileName);
		map = mapBuilder.build();
		EntityHandler.setMixedFollowRate(70);
		Entity.setStep(1);
		this.cherryChance = 200;
		this.boostedTime = 900;
		this.lives = 2;
		this.pointMultiplier = 2;
	}
}
