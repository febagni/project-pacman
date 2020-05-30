/*
 * @file EntityHandler.java
 * 
 * @brief Handler dos objetos que se movem
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
import java.util.ArrayList;

public class EntityHandler {
	
	ArrayList<Ghost> ghosts; //Array com todos os fantasmas do jogo
	PacMan player; //Objeto jogador 
	
	EntityHandler(ArrayList<Ghost> ghosts, PacMan player) {
		this.ghosts = ghosts;
		this.player = player;
	}
	
	/*
	 * @brief Funcao que faz todas as entidades do jogo atualizarem
	 */
	public void tick() {
		for(Ghost ghost : ghosts) {
			ghost.tick();
		}
		player.tick();
	}
	
	/*
	 * @brief Funcao que retorna o module
	 */
	public int absolute(int x) {
		return (x >= 0) ? x:-x;
	}
	
	/*
	 * @brief Funcao que retorna se o jogador encostou no fantasma
	 */
	public boolean playerTouchedGhost() {
		for(Ghost ghost : ghosts) {
			int xDistance, yDistance;
			xDistance = player.getRealX() - ghost.getRealX();
			yDistance = player.getRealY() - ghost.getRealY();
			if(absolute(xDistance) < MapObject.squareSize - 10 && absolute(yDistance) < MapObject.squareSize - 10) //10 é um fator de ajuste visual
				return true;
		}
		return false;
	}
	
	
	/*
	 * @brief Renderiza todas as entidades
	 */
	public void render(Graphics graphics) {
		for(Ghost ghost : ghosts) {
			ghost.render(graphics);
		}
		player.render(graphics);
	}
}
