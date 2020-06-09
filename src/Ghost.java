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
import java.awt.Graphics;
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
	
	/*
	 * @brief Desenha a imagem a partir de um png que contem todos os frames para a animacao do personagem.
	 */
	@Override
	public void render(Graphics graphic) {
		graphic.drawImage(sprite.getSubimage((frame/(2*animationSlowness))*30, (direction - 37)*30, 28, 28)
				, realY+2, realX+2, null);
	}
	@Override
	public GameObject clone() {
		// TODO Auto-generated method stub
		return null;
	}
}
