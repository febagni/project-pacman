/*
 * @file NonRandomMovement.java
 * 
 * @brief Classe abstrata que implementa a interface de movimento
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */

import java.util.ArrayList;

public abstract class NonRandomMovement implements GhostMovement {

	Entity follower;
	Entity followed;
	
	NonRandomMovement(Entity follower, Entity followed) {
		this.follower = follower;
		this.followed = followed;
	}
	
	/*
	 * @brief Executa a direção escolhida para o movimento dos fantasmas
	 */
	@Override
	public abstract int ghostMovement(ArrayList<Integer> possibleDirections);
}