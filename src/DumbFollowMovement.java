/*
 * @file DumbFollowMovement.java
 * 
 * @brief Implementa a estratégia de seguir o Pacman nos fantasmas
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

public class DumbFollowMovement extends NonRandomMovement {

	ArrayList<Integer> priorityDirection;
	
	DumbFollowMovement(Entity follower, Entity followed) {
		super(follower, followed);
	}
	
	/*
	 * @brief Define a prioridade da direção do movimento dos fantasmas
	 */
	private void setPreferredDirection() {
		int deltaX = follower.getRealX() - followed.getRealX();
		int deltaY = follower.getRealY() - followed.getRealY();
		if (deltaX*deltaX > deltaY*deltaY) {
			priorityDirection.add((deltaX > 0)? KeyEvent.VK_UP: KeyEvent.VK_DOWN);
			priorityDirection.add((deltaY > 0)? KeyEvent.VK_LEFT: KeyEvent.VK_RIGHT);
		}
		else {
			priorityDirection.add((deltaY > 0)? KeyEvent.VK_LEFT: KeyEvent.VK_RIGHT);
			priorityDirection.add((deltaX > 0)? KeyEvent.VK_UP: KeyEvent.VK_DOWN);
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
