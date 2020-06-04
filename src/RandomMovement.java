import java.util.ArrayList;
import java.util.Random;

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
 * @date 05/2020
 * 
 */

public class RandomMovement implements GhostMovement {

	@Override
	public int ghostMovement(ArrayList<Integer> possibleDirections) {
		return possibleDirections.get(getRandomPosition(possibleDirections.size()));
	}

	private int getRandomPosition(int max) {
		Random random = new Random();
		return random.nextInt(max); 
	}
	
}
