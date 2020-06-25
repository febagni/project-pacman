import java.awt.event.KeyEvent;

public class PacManBoosted extends PacManDecorator {

	PacManBoosted(PacMan player) {
		super(player);
		lastBoostDrop = false;
	}

	@Override
	public boolean isAlreadyBoosted() {
		return true;
	}
	void setDirection() {this.direction = KeyEvent.VK_LEFT;}
	int getPoints() {return player.getPoints();}
	int getLives() {return player.getLives();}
	int getInitialPositionX() {return player.getInitialPositionX();}
	void setInitialPositionX(int x) {player.setInitialPositionX(x);}
	int getInitialPositionY() {return player.getInitialPositionY();}
	void setInitialPositionY(int y) {player.setInitialPositionY(y);}
	void addExtraPoints(int points) {player.addExtraPoints(points);}
	int getBoostedTime() {return player.getBoostedTime();}
	void setBoostedTime(int boostedTime) {player.setBoostedTime(boostedTime);}
	int getDirection() {return player.getDirection();}
	
	@Override
	public boolean playerEatGhost() {
		return true;
	}
	public void tick() {
		super.tick();
		if (player.getBoostedTime() > 0) {
			if (player.getBoostedTime() < 10) lastBoostDrop = true;
			player.setBoostedTime(player.getBoostedTime() - 1);;
		}
	}
}
