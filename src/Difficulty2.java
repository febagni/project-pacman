
public class Difficulty2 extends GameState {
	
	Difficulty2(String mapFileName) {
		mapBuilder = new MapBuilder(mapFileName);
		map = mapBuilder.build();
		EntityHandler.setDifficulty(30);
		Entity.setStep(1);
		this.cherryChance = 50;
		this.boostedTime = 1.5f;
		this.lives = 4;
		this.pointMultiplier = 1;
	}

}
