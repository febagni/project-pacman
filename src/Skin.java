/*
 * @file Skin.java
 * 
 * @brief Interface para os look-and-feels da fábrica abstrata
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */

public interface Skin {
	
	/*
	 * @brief Faz o clone da skin para o look-and-feel do objeto do jogo
	 */
	Skin clone();
}
