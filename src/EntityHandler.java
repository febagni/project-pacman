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
		//setAllStrategies();	//SE CHAMAR AQUI DÁ ERRO, PQ OCORREM TICKS ANTES DE SETAR AS ESTRATEGIAS
	}
	
	private void setAllStrategies() {
		for (Ghost ghost: ghosts) {
			if(ghost.getStrategyID() == StrategyID.Follow) {
				ghost.setStrategy(new DumbFollowMovement(ghost, player));
			} else if(ghost.getStrategyID() == StrategyID.Random) {
				ghost.setStrategy(new RandomMovement());
			} else if(ghost.getStrategyID() == StrategyID.Mixed) {
				ghost.setStrategy(new RandomMovement());
			} else if(ghost.getStrategyID() == StrategyID.Escape) {
				ghost.setStrategy(new GetawayMovement(ghost, player));
			}
		}
	}
	
	/*
	 * @brief Funcao que faz todas as entidades do jogo atualizarem
	 */
	public void tick() {
		setAllStrategies();	//NAO DEVERIA TER QUE DEFINIR A CADA TICK!!!
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
			if(absolute(xDistance) < MapObject.squareSize - 10 && absolute(yDistance) < MapObject.squareSize - 10) //10 � um fator de ajuste visual
				return true;
		}
		return false;
	}
	public void playerDeathReset() {
		player.updateLives();
		player.setRealX(player.getInitialPositionX());
		player.setRealY(player.getInitialPositionY());
		player.setDirection();
		for(Ghost ghost: ghosts) {
			ghost.setRealX(ghost.getInitX());
			ghost.setRealY(ghost.getInitY());
		}
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
