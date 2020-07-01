/*
 * @file UnderTheSea.java
 * 
 * @brief Implementa o look-and-feel subnáutico do jogo
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */

public class UnderTheSea implements Skin {

	/*
	 * @brief Faz o clone para o look-and-feel subnáutico
	 */
	@Override
	public Skin clone() {
		SpritesManager.folder = "UnderTheSea/";
		AudioPlayer.sourceFolder = "UnderTheSea/";
		return new UnderTheSea();
	}
}
