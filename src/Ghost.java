/*
 * @file Ghost.java
 * 
 * @brief Classe que representa os inimigos do jogo (fantasmas). Extende Entity pois eh um objeto movel.
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 05/2020
 * 
 */
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Ghost extends Entity {
	
	GhostMovement strategy;
	
	public Ghost (int realX, int realY) {
		this.realX = realX;
		this.realY = realY;
		try {
			sprite = ImageIO.read(new File("sprites/RedBlinky.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.direction = KeyEvent.VK_LEFT;
	}
	
	@Override
	public void tick() {
//		Checa se chegou numa bifurcação
		if(possibleDirections().size()!=2) {
			
		}
		
		
//		verifica pra onde consegue andar
//		escolhe o caminho pelo strategyy
	}
	
	public ArrayList<Integer> possibleDirections() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		return list;
	}
	
	/*
	 * @brief Desenha a imagem a partir de um png que contem todos os frames para a animacao do personagem.
	 */
	@Override
	public void render(Graphics graphic) {
		graphic.drawImage(sprite.getSubimage((frame/(2*animationSlowness))*30, (direction - 37)*30, 28, 28)
				, realY+2, realX+2, null);
	}
	
}
