import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/*
 * @file Classic.java
 * 
 * @brief Implementa o look-and-feel clássico do jogo
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */

public class Classic implements Skin {

	/*
	 * @brief Faz o clone para o look-and-feel clássico
	 */
	@Override
	public Skin clone() {
		SpritesManager.folder = "Classic/";
		@SuppressWarnings("unused")
		SoundManager sound = new SoundManager("audio/iliketosing.aif");	
		return new Classic();
	}
}
