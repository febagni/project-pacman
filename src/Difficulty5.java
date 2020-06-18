
public class Difficulty5 extends GameState {

	Difficulty5(String mapFileName) {
		mapBuilder = new MapBuilder(mapFileName);
		map = mapBuilder.build();
		this.difficulty = 90;
		Entity.setStep(2);
		this.cherryChance = 500;
		this.boostedTime = 0.5f;
		this.lives = 1;
		this.pointMultiplier = 3;
	}

}
