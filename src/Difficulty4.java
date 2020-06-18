
public class Difficulty4 extends GameState {

	Difficulty4(String mapFileName) {
		mapBuilder = new MapBuilder(mapFileName);
		map = mapBuilder.build();
		this.difficulty = 70;
		Entity.setStep(1);
		this.cherryChance = 200;
		this.boostedTime = 0.75f;
		this.lives = 2;
		this.pointMultiplier = 2;
	}
}
