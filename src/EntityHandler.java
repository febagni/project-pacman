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
 * @date 06/2020
 * 
 */

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class EntityHandler {
	
	ArrayList<Ghost> ghosts; //Array com todos os fantasmas do jogo
	PacMan player; //Objeto jogador
	protected static int mixedFollowRate;	//Dificuldade da persegui��o
	
	EntityHandler(ArrayList<Ghost> ghosts, PacMan player) {
		this.ghosts = ghosts;
		this.player = player;
		setAllStrategies();
	}
	
	void setPlayer(PacMan player) {this.player = player;}
	
	/*
	 * @brief Setter da dificuldade do jogo 
	 */
	public static void setMixedFollowRate(int newFollowRate) {mixedFollowRate = newFollowRate;}
	
	/*
	 * @brief Setter das estrat�gias aos fantasmas
	 */
	private void setAllStrategies() {
		for (Ghost ghost: ghosts) {
			updateGhostStrategy(ghost);
		}
	}
	/*
	 * @brief Updates a ghost strategy based on their StrategyID
	 */
	private void updateGhostStrategy(Ghost ghost) {
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
	
	/*
	 * @brief Set All ghosts to escape (used when player eats boost)
	 */
	public void setAllGhostsEscape() {
		for(Ghost ghost: ghosts) {
			ghost.setStrategyID(StrategyID.Escape);
			ghost.setStrategy(new GetawayMovement(ghost, player));
			ghost.updateSprite();
		}
	}
	
	/*
	 * @brief Set all ghosts who haven't been eaten to the End of Escape strategy
	 */
	public void setEndOfEscape() {
		for(Ghost ghost: ghosts) {
			if(ghost.getStrategyID() == StrategyID.Escape) {
				ghost.setStrategyID(StrategyID.EndOfEscape);
				ghost.updateSprite();
			}
		}
	}
	
	/*
	 * @brief Sets a single ghost to its original strategy
	 */
	public void setSingleGhostOriginalStrategy(Ghost ghost) {
		ghost.setOriginalStrategy();
		ghost.updateSprite();
		updateGhostStrategy(ghost);
	}
	
	/*
	 * @brief Sets all ghosts to their original strategy
	 */
	public void setAllGhostsOriginalStrategy() {
		for(Ghost ghost: ghosts) {
			ghost.setOriginalStrategy();
			ghost.updateSprite();
		}
		setAllStrategies();
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
	 * @brief Funcao que faz todas as entidades do jogo atualizarem uma quantidade fixas de ticks
	 */
	public void fixedTick() {
		for(Ghost ghost : ghosts) {
			updateStrategy(ghost);
		}
	}
	
	/*
	 * @brief Funcao atualiza os endere�os dos sprites
	 */
	public void updateAllSprites() {
		for(Ghost ghost : ghosts) {
			ghost.updateSprite();
		}
		player.updateSprite();
	}
	
	/*
	 * @brief Faz a escolha da estrategia do ghost com estrategia mixed 
	 */
	private void updateStrategy(Ghost ghost) {
		if(ghost.getStrategyID() == StrategyID.Mixed) {
			int randomNumber = randomNumber();
			if(randomNumber < mixedFollowRate) {
				ghost.setStrategy(new DumbFollowMovement(ghost, player));
			}
			else {
				ghost.setStrategy(new RandomMovement());
			}
		}
	}
	
	/*
	 * @brief Generates a random number between 0 and 100
	 */
	private int randomNumber() { 
		Random random = new Random();
		return random.nextInt(100);
	}
	
	/*
	 * @brief Funcao que retorna o module
	 */
	public int absolute(int x) {return (x >= 0) ? x:-x;}
	
	/*
	 * @brief Funcao que retorna se o jogador encostou no fantasma
	 */
	public boolean playerDied() {
		for(Ghost ghost : ghosts) {
			int xDistance, yDistance;
			xDistance = player.getRealX() - ghost.getRealX();
			yDistance = player.getRealY() - ghost.getRealY();
			if(absolute(xDistance) < MapObject.squareSize - 10 && absolute(yDistance) < MapObject.squareSize - 10) //10 � um fator de ajuste visual
				if(player.playerEatGhost() && ((ghost.getStrategyID() == StrategyID.Escape) || (ghost.getStrategyID() == StrategyID.EndOfEscape))) {
					player.addExtraPoints(100);
					ghostDeathReset(ghost);
				} else {
					return true;
				}
		}
		return false;
	}
	
	/*
	 * @brief Resets ghost position and strategy (used after pacman eats ghost)
	 */
	private void ghostDeathReset(Ghost ghost) {
		@SuppressWarnings("unused")
		AudioPlayer soundeffect = new AudioPlayer("KilledGhost.aif");
		ghost.setRealX(ghost.getInitX());
		ghost.setRealY(ghost.getInitY());
		setSingleGhostOriginalStrategy(ghost);
	}
	
	/*
	 * @brief Faz o reset das posicoes iniciais das entidades quando o player morre
	 */
	public void playerDeathReset() {
		@SuppressWarnings("unused")
		AudioPlayer soundeffect = new AudioPlayer("Death.aif");
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
