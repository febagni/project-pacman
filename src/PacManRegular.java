/*
 * @file PacMan.java
 * 
 * @brief Classe que implementa o jogador = pacman, como entidade (elemento movel do jogo)
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 05/2020
 * 
 */

import java.awt.event.KeyEvent;

public class PacManRegular extends PacMan {

	public PacManRegular(){
		spritePath = "pacman.png"; //Sets the initial spritePath as the pacman png
		lastBoostDrop = false; //Sets that the boost is over
		boostedTime = 0;	//inicializa como falso
		points = 0;	//inicializa os pontos como zero
		frame = 0;	//inicializa a frame como zero
		this.direction = KeyEvent.VK_LEFT;	//inicializa a direcao para a esquerda 
		updateSprite();	//faz o update dos sprites
	}
	
	/*
	 * @brief Tick do pacman
	 */
	public void tick() {
		updateTile();
		updateAnimation();
		updateSpeed();
		updateMovement();
	}
	
	@Override
	public GameObject clone() {
		return null;
	}

	@Override
	public boolean playerEatGhost() {
		return false;
	}

	@Override
	public boolean isAlreadyBoosted() {
		return false;
	}
	
	@Override
	PacMan getPlayer() {return this;}
}