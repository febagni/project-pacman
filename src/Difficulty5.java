
public class Difficulty5 extends GameState {

	Difficulty5(String mapFileName) {
		levelNumber = 5;
		mapBuilder = new MapBuilder(mapFileName);
		map = mapBuilder.build();
		EntityHandler.setMixedFollowRate(90);
		Entity.setStep(2);
		this.cherryChance = 500;
		this.boostedTime = 600;
		this.lives = 1;
		this.pointMultiplier = 3;
	}
}