/*
 * @file GetawayMovement.java
 * 
 * @brief Implementa a estratégia de fugir do Pacman nos fantasmas
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GetawayMovement extends NonRandomMovement {

	ArrayList<Integer> priorityDirection; //Array in which are stored the directions in a order of priority 
	
	GetawayMovement(Entity follower, Entity followed) {
		super(follower, followed);
	}

	/*
	 * @brief Define a prioridade da direção do movimento dos fantasmas
	 */
	private void setPreferredDirection() {
		int deltaX = follower.getRealX() - followed.getRealX();
		int deltaY = follower.getRealY() - followed.getRealY();
		if(deltaY==0){
			priorityDirection.add(KeyEvent.VK_LEFT);
			priorityDirection.add(KeyEvent.VK_RIGHT);
		} if (deltaX == 0) {
			priorityDirection.add(KeyEvent.VK_UP);
			priorityDirection.add(KeyEvent.VK_DOWN);
		} if(deltaX*deltaX > deltaY*deltaY){
			priorityDirection.add(!(deltaY > 0)? KeyEvent.VK_LEFT: KeyEvent.VK_RIGHT);
			priorityDirection.add(!(deltaX > 0)? KeyEvent.VK_UP: KeyEvent.VK_DOWN);
		} else if(deltaX*deltaX < deltaY*deltaY){
			priorityDirection.add(!(deltaX > 0)? KeyEvent.VK_UP: KeyEvent.VK_DOWN);
			priorityDirection.add(!(deltaY > 0)? KeyEvent.VK_LEFT: KeyEvent.VK_RIGHT);
		}
	}
	
	/*
	 * @brief Executa a direção escolhida para o movimento dos fantasmas
	 */
	@Override
	public int ghostMovement(ArrayList<Integer> possibleDirections) {
		priorityDirection = new ArrayList<Integer>();
		setPreferredDirection();
		for(int direction : priorityDirection) {
			if (possibleDirections.contains(direction)) {
				return direction;
			}
		}
		return KeyEvent.VK_LEFT;
	}
}
