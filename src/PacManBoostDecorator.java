
public class PacManBoostDecorator extends PacManDecorator {

	PacManBoostDecorator(PacMan player) {
		super(player);
		lastBoostDrop = false;
	}

	@Override
	public boolean isAlreadyBoosted() {
		return true;
	}
	
	@Override
	public boolean playerEatGhost() {
		return true;
	}
	public void tick() {
		super.tick();
		if (player.getBoostedTime() > 0) {
			if (player.getBoostedTime() < 2) lastBoostDrop = true;
			player.setBoostedTime(player.getBoostedTime() - 1);;
		}
	}

	
}
