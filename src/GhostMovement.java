/*
 * @file GhostMoviment.java
 * 
 * @brief Classe que representa o jogo e contem a main
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 05/2020
 * 
 */

import java.util.ArrayList;

public interface GhostMovement {
	int ghostMovement(ArrayList<Integer> possibleDirections);
}