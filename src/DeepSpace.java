/*
 * @file DeepSpace.java
 * 
 * @brief Implementa o look-and-feel espaciais do jogo
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */

public class DeepSpace implements Skin {
	
	/*
	 * @brief Faz o clone para o look-and-feel espaciais
	 */
	@Override
	public Skin clone() {
		SpritesManager.folder = "DeepSpace/";
		return new DeepSpace();
	}

}
