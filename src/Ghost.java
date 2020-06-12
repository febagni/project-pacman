/*
 * @file Ghost.java
 * 
 * @brief Classe que representa os inimigos do jogo (fantasmas). Extende Entity pois eh um objeto movel.
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 05/2020
 * 
 */

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Ghost extends Entity {
	
	protected int initX, initY; //posicao inicial do fantasma
	GhostMovement strategy;
	int bufferedMovementFlag = 0;
	private StrategyID sId;
	
	public Ghost (int x, int y, StrategyID id) {
		initX = x;
		initY = y;
		sId = id;
		if(id == StrategyID.Follow) {
			spritePath = "RedBlinky.png";
		} else if(id == StrategyID.Random) {
			spritePath = "PinkPinky.png";
		} else if(id == StrategyID.Mixed) {
			spritePath = "OrangeClyde.png";
		} else if(id == StrategyID.Escape) {
			spritePath = "CyanInky.png";
		}
		updateSprite();
		this.direction = KeyEvent.VK_LEFT;
	}
	public int getInitX() {return initX;}
	public int getInitY() {return initY;}
	public StrategyID getStrategyID() {return sId;}
	
	void setStrategy(GhostMovement strategy) {
		this.strategy = strategy;
	}

	@Override
	public void tick() {
		if((possibleDirections().size()!=2 || isStoped()) && bufferedMovementFlag >= 30) {
			this.direction = strategy.ghostMovement(possibleDirections());	
			bufferedMovementFlag = 0;
		}
		bufferedMovementFlag ++;
		updateSpeed();
		updateMovement();
		updateAnimation();
	}
	
	public void fixedTick() {
	}
	
	/*
	 * @brief Verifica e retorna lista de posições possíveis
	 */
	private ArrayList<Integer> possibleDirections() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (canGo("up")) list.add(KeyEvent.VK_UP);
		if (canGo("down")) list.add(KeyEvent.VK_DOWN);
		if (canGo("left")) list.add(KeyEvent.VK_LEFT);
		if (canGo("right")) list.add(KeyEvent.VK_RIGHT);
		return list;
	}
	
	@Override
	public GameObject clone() {
		return null;
	}
}
