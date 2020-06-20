
public class Difficulty2 extends GameState {
	
	Difficulty2(String mapFileName) {
		levelNumber = 2;
		mapBuilder = new MapBuilder(mapFileName);
		map = mapBuilder.build();
		EntityHandler.setMixedFollowRate(30);
		Entity.setStep(1);
		this.cherryChance = 50;
		this.boostedTime = 1800;
		this.lives = 4;
		this.pointMultiplier = 1;
	}

}
