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

public class PacMan extends Entity {

	protected int boostedTimeMax;	// numero maximos de ticks para o pacman continuar boostado
	protected int boostedTime;	//ticks restantes para o pacman continuar boostado
	protected boolean lastBoostDrop;
	protected int points;	//contador dos pontos
	protected int extraPoints;	//pontos extras relacionados a cherries
	protected int lastDirection = KeyEvent.VK_LEFT; //Variavel que contem a ultima direcao que o Pacman estava olhando
	protected int lives; //Quantidade de vidas que o jogador tem sobrando
	protected int initialPositionX;	//Posicao x inicial do pacman 
	protected int initialPositionY;	//Posicao y inicial do pacman
	
	public PacMan(){
		spritePath = "pacman.png";
		lastBoostDrop = false;
		lives = 3;  //Inicia o jogo com tres vidas (por enquanto)
		boostedTime = 0;	//inicializa como falso
		points = 0;	//inicializa os pontos como zero
		frame = 0;	//inicializa a frame como zero
		this.direction = KeyEvent.VK_LEFT;	//inicializa a direcao para a esquerda 
		updateSprite();	//faz o update dos sprites
	}
	
	//Getters e Setters
	void setDirection() {this.direction = KeyEvent.VK_LEFT;}
	int getPoints() {return points;}
	int getLives() {return lives;}
	int getInitialPositionX() {return initialPositionX;}
	void setInitialPositionX(int x) {this.initialPositionX = x;}
	int getInitialPositionY() {return initialPositionY;}
	void setInitialPositionY(int y) {this.initialPositionY = y;}
	
	/*
	 * @brief Faz o update das lives, se o pacman morre
	 */
	void updateLives() {
		lives--;
	}
	void setLives(int lives) {
		this.lives = lives;
	}
	
	void setBoostedTime(int boostedTimeMax) {this.boostedTimeMax = boostedTimeMax;}
	
	/*
	 * @brief Metodo que atualiza o chao que o pacman esta atravessando
	 */
	void updateTile() {
		//se a posicao do pacman for:
		if (map[getX()][getY()].getID() == MapID.FloorWithFood) {	//chao com comida
			map[getX()][getY()].setID(MapID.Floor);	//atualiza para o chao normal
			map[getX()][getY()].setSpritePath(SpritesManager.getSpritePath(MapID.Floor));
			map[getX()][getY()].updateSprite();
			points += 10;	//e soma um para a contagem de pontos 
		} else if (map[getX()][getY()].getID() == MapID.FloorWithBoost) {	//chao com boost
			map[getX()][getY()].setID(MapID.Floor);	//atualiza para o chao normal
			map[getX()][getY()].setSpritePath(SpritesManager.getSpritePath(MapID.Floor));
			map[getX()][getY()].updateSprite();
			boostedTime = boostedTimeMax;	//seta o boosted como verdade
		} else if (map[getX()][getY()].getID() == MapID.FloorWithCherry) {	//chao com a cherry
			map[getX()][getY()].setID(MapID.Floor);	//atualiza para chao normal
			map[getX()][getY()].setSpritePath(SpritesManager.getSpritePath(MapID.Floor));
			map[getX()][getY()].updateSprite();
			extraPoints += 100;	//soma os pontos extras
		}
	}
	
	int totalPoints() {
		return (points+extraPoints);
	}
	
	boolean isBoosted() {
		return boostedTime>0;
	}
	
	/*
	 * @brief Atualiza o valor do frame de forma ciclica
	 */
	void updateAnimation() {
		frame++;
		if(frame>5*animationSlowness) frame = 0;
	}
	
	/*
	 * @brief Tick do pacman
	 */
	public void tick() {
		updateTile();
		updateAnimation();
		updateSpeed();
		updateMovement();
		if (boostedTime > 0) {
			if (boostedTime == 1) lastBoostDrop = true;
			boostedTime--;
		}
		
	}
	
	@Override
	public GameObject clone() {
		return null;
	}
}