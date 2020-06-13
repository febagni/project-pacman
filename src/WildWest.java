/*
 * @file WildWest.java
 * 
 * @brief Implementa o look-and-feel faroéstico do jogo
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */

public class WildWest implements Skin {

	/*
	 * @brief Faz o clone para o look-and-feel faroéstico
	 */
	@Override
	public Skin clone() {
		SpritesManager.folder = "WildWest/";
		return new WildWest();
	}

}
