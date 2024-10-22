/*
 * @file Pacman.java
 * 
 * @brief Super Class made for implementing the decorator
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */
import java.awt.event.KeyEvent;

public abstract class PacMan extends Entity {
	
	public abstract boolean playerEatGhost(); //Indicates if the player eated a ghost
	public abstract boolean isAlreadyBoosted(); //Indicates if the player has just gotten a boost
	
	protected int boostedTimeMax;	// numero maximos de ticks para o pacman continuar boostado
	protected int boostedTime;	//ticks restantes para o pacman continuar boostado
	protected boolean lastBoostDrop; //Indicates that the boost is over
	protected int points;	//contador dos pontos
	protected int extraPoints;	//pontos extras relacionados a cherries
	protected int lastDirection = KeyEvent.VK_LEFT; //Variavel que contem a ultima direcao que o Pacman estava olhando
	protected int lives; //Quantidade de vidas que o jogador tem sobrando
	protected int initialPositionX;	//Posicao x inicial do pacman 
	protected int initialPositionY;	//Posicao y inicial do pacman
	
	/*
	 * @brief Setters e Getters
	 */
		void setDirection() {this.direction = KeyEvent.VK_LEFT;}
		int getPoints() {return points;}
		int getLives() {return lives;}
		int getInitialPositionX() {return initialPositionX;}
		void setInitialPositionX(int x) {this.initialPositionX = x;}
		int getInitialPositionY() {return initialPositionY;}
		void setInitialPositionY(int y) {this.initialPositionY = y;}
		void addExtraPoints(int points) {this.extraPoints += points;}
		int getBoostedTime() {return this.boostedTime;}
		void setBoostedTime(int boostedTime) {this.boostedTime = boostedTime;}
		int getBoostedTimeMax() {return this.boostedTimeMax;}
		void setBoostedTimeMax(int boostedTimeMax) {this.boostedTimeMax = boostedTimeMax;} 
		int getDirection() {return this.direction;}
		abstract PacMan getPlayer();
		
		/*
		 * @brief Faz o update das lives, se o pacman morre
		 */
		void updateLives() {
			lives--;
		}
		void setLives(int lives) {
			this.lives = lives;
		}
		
		/*
		 * @brief Method that actualize the time being boosted
		 */
		void setMaxBoostedTime(int boostedTimeMax) {this.boostedTimeMax = boostedTimeMax;}
		
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
				@SuppressWarnings("unused")
				AudioPlayer soundeffect = new AudioPlayer("Boost.aif");
				setBoostedTime(getBoostedTimeMax());	//seta o boosted como verdade
			} else if (map[getX()][getY()].getID() == MapID.FloorWithCherry) {	//chao com a cherry
				map[getX()][getY()].setID(MapID.Floor);	//atualiza para chao normal
				map[getX()][getY()].setSpritePath(SpritesManager.getSpritePath(MapID.Floor));
				map[getX()][getY()].updateSprite();
				@SuppressWarnings("unused")
				AudioPlayer soundeffect = new AudioPlayer("Cherry.aif");
				extraPoints += 100;	//soma os pontos extras
			}
		}

		/*
		 * @brief Method that adds the points obtained with the normal points, cherries and ghosts
		 */
		int totalPoints() {
			return (points+extraPoints);
		}
		
		/*
		 * @brief Method that returns the player's time left boosted
		 */
		boolean boostedTime() {
			return boostedTime>0;
		}
		
		/*
		 * @brief Atualiza o valor do frame de forma ciclica
		 */
		void updateAnimation() {
			frame++;
			if(frame>5*animationSlowness) frame = 0;
		}
		
}
