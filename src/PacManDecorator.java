/*
 * @file PacmanDecorator.java
 * 
 * @brief Pacman's Decorator
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public abstract class PacManDecorator extends PacMan {

	PacMan player; //The Pacman Object being decorated
	
	void setDirection() {this.direction = KeyEvent.VK_LEFT;} //Sets the starting direction as left
	
	/*
	 * @brief Setters e Getters
	 */
	int getPoints() {return player.getPoints();}
	int getLives() {return player.getLives();}
	int getInitialPositionX() {return player.getInitialPositionX();}
	void setInitialPositionX(int x) {player.setInitialPositionX(x);}
	int getInitialPositionY() {return player.getInitialPositionY();}
	void setInitialPositionY(int y) {player.setInitialPositionY(y);}
	void addExtraPoints(int points) {player.addExtraPoints(points);}
	int getBoostedTime() {return player.getBoostedTime();}
	void setBoostedTime(int boostedTime) {player.setBoostedTime(boostedTime);}
	int getBoostedTimeMax() {return player.getBoostedTime();}
	void setBoostedTimeMax(int boostedTimeMax) {player.setBoostedTime(boostedTimeMax);;} 
	int getDirection() {return player.getDirection();}
	public int getRealX() {return player.getRealX();}
	public int getRealY() {return player.getRealY();}
	int totalPoints() {return (player.points+player.extraPoints);}
	public void setRealX(int x) {player.setRealX(x);}
	public void setRealY(int y) {player.setRealY(y);}	
	public void updateLives() {player.lives--;}
	public void updateSprite() {player.updateSprite();}
	
	PacManDecorator(PacMan player) {
		this.player = player;
	}
	
	@Override
	public GameObject clone() {
		return null;
	}

	@Override
	public void tick() {
		player.tick();
	}
	
	public void render(Graphics g) {
		player.render(g);
	}
	
	@Override
	PacMan getPlayer() {return this.player;}
}
