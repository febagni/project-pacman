/*
 * @file RandomMovement.java
 * 
 * @brief Classe que implementa estrategia do movimento aleatorio do fantasma  
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
import java.util.Random;

public class RandomMovement implements GhostMovement {

	/*
	 * @brief Executa a direção escolhida para o movimento dos fantasmas
	 */
	@Override
	public int ghostMovement(ArrayList<Integer> possibleDirections) {
		return possibleDirections.get(getRandomPosition(possibleDirections.size()));
	}

	/*
	 * @brief Gera uma direção aleatória para o fantasma seguir
	 */
	private int getRandomPosition(int max) {
		Random random = new Random();
		return random.nextInt(max); 
	}
	
}
