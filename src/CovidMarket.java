/*
 * @file CovidMarket.java
 * 
 * @brief Implementa o look-and-feel em tempos pandêmicos do jogo
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */

public class CovidMarket implements Skin {
	
	/*
	 * @brief Faz o clone para o look-and-feel Mercado em tempos de pandemia
	 */
	@Override
	public Skin clone() {
		SpritesManager.folder = "CovidMarket/";
		AudioPlayer.sourceFolder = "CovidMarket/";
		return new CovidMarket();
	}
}
