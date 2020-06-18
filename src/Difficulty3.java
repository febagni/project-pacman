
public class Difficulty3 extends GameState {

	Difficulty3(String mapFileName) {
		mapBuilder = new MapBuilder(mapFileName);
		map = mapBuilder.build();
		this.difficulty = 50;
		Entity.setStep(1);
		this.cherryChance = 100;
		this.boostedTime = 1;
		this.lives = 3;
		this.pointMultiplier = 1;
	}

}
