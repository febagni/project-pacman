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
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PacMan extends Entity {

	protected boolean boosted;	//verdadeira se o pacman comeu um boost
	protected int points;	//contador dos pontos
	protected int lastDirection = KeyEvent.VK_LEFT; //Variavel que contem a ultima direcao que o Pacman estava olhando
	
	public PacMan(){
		boosted = false;	//inicializa como falso
		points = 0;	//inicializa os pontos como zero
		frame = 0;	//inicializa a frame como zero
		this.direction = KeyEvent.VK_LEFT;	//inicializa a direcao para a esquerda 
		try {
			sprite = ImageIO.read(new File("sprites/pacman.png"));	//le o a imagem com os sprites do pacman
		} catch (IOException e) {
			e.printStackTrace();	
		}
		
	}
	
	/*
	 * @brief Metodo que atualiza o chao que o pacman esta atravessando
	 */
	void updateTile() {
		//se a posicao do pacman for:
		if (map[getX()][getY()].getID() == MapID.FloorWithFood) {	//chao com comida
			map[getX()][getY()].setID(MapID.Floor);	//atualiza para o chao normal
			points++;	//e soma um para a contagem de pontos 
		} else if (map[getX()][getY()].getID() == MapID.FloorWithBoost) {	//chao com boost
			map[getX()][getY()].setID(MapID.Floor);	//atualiza para o chao normal
			boosted = true;	//seta o boosted como verdade
		} else if (map[getX()][getY()].getID() == MapID.FloorWithCherry) {	//chao com a cherry
			map[getX()][getY()].setID(MapID.Floor);	//atualiza para chao normal
			points += 100;	//soma os pontos extras
		}
	}
	
	/*
	 * @brief Atualiza o valor do frame de forma ciclica
	 */
	void updateAnimation() {
		frame++;
		if(frame>5*animationSlowness) frame = 0;
	}
	
	/*
	 * @brief Atualiza o valor da velocidade do pacman
	 */
	void updateSpeed() {
		switch (direction) {
		case KeyEvent.VK_UP:
			moveUp();
			break;
		case KeyEvent.VK_DOWN:
			moveDown();
			break;
		case KeyEvent.VK_LEFT:
			moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			moveRight();
			break;
		}
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

	/*
	 * @brief Renderiza o sprite e realiza animacao do pacman
	 */
	public void render(Graphics graphic) {
		int animationDirection;
		if(speedX > 0) animationDirection = KeyEvent.VK_DOWN;
		else if(speedX < 0) animationDirection = KeyEvent.VK_UP;
		else if(speedY > 0) animationDirection = KeyEvent.VK_RIGHT;
		else if(speedY < 0) animationDirection = KeyEvent.VK_LEFT;
		else animationDirection = lastDirection;
		graphic.drawImage(sprite.getSubimage((frame/(2*animationSlowness))*30, (animationDirection - 37)*30, 28, 28)
				, realY+2, realX+2, null);
		lastDirection = animationDirection;
	}
}