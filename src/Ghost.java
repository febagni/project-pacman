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
	GhostMovement strategy;	//estrategia do fantasma
	int bufferedMovementFlag = 0;	//cooldown para a mudanca de direcao do fantasma
	private StrategyID sId;	//id da estrategia relacionada ao objeto fantasma
	private String colorPath;
	
	public Ghost (int x, int y, StrategyID id) {
		initX = x;
		initY = y;
		sId = id;
		if(sId == StrategyID.Follow) {
			colorPath = "RedBlinky.png";
		} else if(sId == StrategyID.Random) {
			colorPath = "PinkPinky.png";
		} else if(sId == StrategyID.Mixed) {
			colorPath = "OrangeClyde.png";
		}
		updateSprite();
		this.direction = KeyEvent.VK_LEFT;
	}
	
	
	//Getters e Setters
	public int getInitX() {return initX;}
	public int getInitY() {return initY;}
	public StrategyID getStrategyID() {return sId;}
	public void setStrategyID(StrategyID id) {sId = id;}
	void setStrategy(GhostMovement strategy) {this.strategy = strategy;}
	
	void setOriginalStrategy() {
		if(colorPath.contains("Red")) {
			sId = StrategyID.Follow;
		} else if(colorPath.contains("Pink")) {
			sId = StrategyID.Random;
		} else if(colorPath.contains("Orange")) {
			sId = StrategyID.Mixed;
		}
	}

	/*
	 * @brief Faz o update da velocidade, movimento e animacao dos fantasmas
	 */
	@Override
	public void tick() {
		if((possibleDirections().size()!=2 || isStopped()) && bufferedMovementFlag >= 15) {
			this.direction = strategy.ghostMovement(possibleDirections());	
			bufferedMovementFlag = 0;
		}
//		if(sId == StrategyID.Escape || sId == StrategyID.EndOfEscape) {
//			if(!isStopped()) setSpeed(0, 0);
//			else updateSpeed();
//		} else {
//			updateSpeed();
//		}
		updateSpeed();
		bufferedMovementFlag ++;
		updateMovement();
		updateAnimation();
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
	
	@Override
	public void updateSprite() {
		//define a skin do sprite de acordo com a sua estrategia
		if(sId == StrategyID.Escape) {
			spritePath = "ScaryWary.png";
		} else if(sId == StrategyID.EndOfEscape) {
			spritePath = "Transition" + colorPath;
		} else {
			spritePath = colorPath;
		}
		super.updateSprite();
	}
}
