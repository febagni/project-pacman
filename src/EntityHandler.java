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
	public boolean playerTouchedGhost() {
		boolean touched = false;
		for(Ghost ghost : ghosts) {
			int xDistance, yDistance;
			xDistance = player.getRealX() - ghost.getRealX();
			yDistance = player.getRealY() - ghost.getRealY();
			if((xDistance < MapObject.squareSize || xDistance > -MapObject.squareSize) && (yDistance < MapObject.squareSize || yDistance > -MapObject.squareSize))
				touched = true;
		}
		return touched;
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
