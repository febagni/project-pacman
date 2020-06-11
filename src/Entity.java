/*
 * @file Entity.java
 * 
 * @brief Implementa a interface GameObject para objetos moveis no jogo (= entidade)
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Entity implements GameObject {
	
	protected int x;	//coordenada x da entidade na matriz do mapa
	protected int y;	//coordenada y da entidade na matriz do mapa
	protected MapID id;	//identidade do objeto
	protected GameObject[][] map;	//matriz dos objetos do mapa
	protected int direction;	//direcao da entidade
	protected int frame;	//frame da animacao do sprite da entidade
	protected BufferedImage sprite;	//sprite da entidade
	protected final int animationSlowness = 3;	//fator da velocidade da animacao
	protected int realX, realY;	//coordenadas do sprite da entidade na tela
	protected int speedX, speedY;	//velocidades nos eixos cartesianos do sprite na tela
	protected int xLength, yLength;	//tamanho da matriz nos eixos
	protected String spritePath; // Caminho dos sprites dos objetos
	/*
	 * @brief Setters e Getters para algumas caracteristicas
	 */
	public void setRealX(int x) {realX = x;}
	public void setRealY(int y) {realY = y;}
	public int getRealX() {return realX;}
	public int getRealY() {return realY;}
	public void setSpritePath (String spritePath) {
		this.spritePath = spritePath;
	}
	public void setMap(GameObject[][] map2) {
		this.map = map2;
		xLength = map2.length;
		yLength = map2[0].length;
	}
	@Override
	public int getX() {return (realX+(squareSize/2))/squareSize;}
	@Override
	public int getY() {return (realY+(squareSize/2))/squareSize;}
	@Override
	public MapID getID() {return id;}
	@Override
	public void setX(int x) {this.x = x;}
	@Override
	public void setY(int y) {this.y = y;}
	@Override
	public void setID(MapID id) {this.id = id;}
	
	/*
	 * @brief Verifica se o objeto na posicao x, y == parede
	 */
	protected boolean isNotAWall(int x, int y) {
		return map[x][y].getID() != MapID.Wall;
	}
	
	public abstract GameObject clone();
	
	/*
	 * @brief Funcoes booleanas que verificam a posicao relativa do sprite em comparacao com o centro de seu bloco no eixo X
	 */
	protected boolean centeredOnX() {return realX - getX()*squareSize == 0;}

	protected boolean higherThanCenterOnX() {return realX - getX()*squareSize > 0;}
	
	protected boolean lowerThanCenterOnX() {return realX - getX()*squareSize < 0;}
	/*
	 * @brief Funcoes booleanas que verificam a posicao relativa do sprite em comparacao com o centro de seu bloco no eixo Y
	 */
	protected boolean centeredOnY() {return realY - getY()*squareSize == 0;}
	
	protected boolean higherThanCenterOnY() {return realY - getY()*squareSize > 0;}
	
	protected boolean lowerThanCenterOnY() {return realY - getY()*squareSize < 0;}
	
	/*
	 * @brief Verifica se o sprite esta na borda do mapa
	 */
	protected boolean isOnEdge() {
		if (speedX != 0 && (getX() == xLength -1 || getX() == 0)) return true;	//se a entidade esta se movendo no eixo x e esta em seus extremos
		else if (speedY != 0 && (getY() == yLength -1 || getY() == 0)) return true;	//se a entidade esta se movendo no eixo y e esta em seus extremos
		else return false;
	}
	
	/*
	 * @brief Verifica se a entidade está parada
	 */
	protected boolean isStoped() {
		return (speedX == 0 && speedY == 0);
	}
	
	/*
	 * @brief Verifica se a entidade pode se mover na direcao indicada
	 * 
	 * @param	direction	Direcao da entidade
	 * 
	 * @return Se pode ou nao seguir
	 */
	protected boolean canGo(String direction) {
		if (direction == "up") {
			if (isOnEdge()) return ( isNotAWall(xLength-1, getY()) || !centeredOnX()); 
			return (isNotAWall(getX()-1, getY()) || !centeredOnX());
		} else if (direction == "down") {
			if (isOnEdge()) return (isNotAWall(0, getY()) || !centeredOnX());
			return (isNotAWall(getX()+1, getY()) || !centeredOnX());
		}
		else if (direction == "left"){
			if (isOnEdge()) return (isNotAWall(getX(), yLength-1) || !centeredOnY());
			return (isNotAWall(getX(), getY()-1) || !centeredOnY());
		}
		else if (direction == "right") {
			if (isOnEdge()) return (isNotAWall(getX(), 0) || !centeredOnY());
			return (isNotAWall(getX(), getY()+1) || !centeredOnY());
		}
		return false;
	}
	
	/*
	 * @brief Verifica se a entidade esta andando no eixo y e tem que parar 
	 */
	boolean hasToStopY() {
		return (!canGo("right") && speedY > 0) || (!canGo("left") && speedY < 0);
	}
	
	/*
	 * @brief Verifica se a entidade esta andando no eixo x e tem que parar 
	 */
	boolean hasToStopX() {
		return ((!canGo("down") && speedX > 0) || (!canGo("up") && speedX < 0));
	}
	
	/*
	 * @brief Setter da velocidade da entidade em ambos os eixos  
	 */
	void setSpeed(int speedX, int speedY) {
		this.speedX = speedX;
		this.speedY = speedY;
	}
	
	/*
	 * @brief Atualiza posicao do pacman corrigindo se ele sai do mapa 
	 */
	void updateMovement() {
		realX += speedX;
		realY += speedY;
		if(getX() <= 0 && speedX < 0 && (lowerThanCenterOnX())) realX = (xLength - 1)*squareSize;
		else if(getX() >= xLength - 1  && speedX > 0 && (higherThanCenterOnX())) realX = 0;
		if(getY() <= 0 && speedY < 0 && (lowerThanCenterOnY())) realY = (yLength - 1)*squareSize;
		else if(getY() >= yLength - 1  && speedY > 0 && (higherThanCenterOnY())) realY = 0;	
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
	 * @brief Movimento da entidade para cima 
	 */
	void moveUp() {
		if(!centeredOnY()) return;
		if (canGo("up")) setSpeed(-step, 0);	
		else if (hasToStopY()) setSpeed(0, 0);
		else setSpeed(0, speedY);
	}
	
	/*
	 * @brief Movimento da entidade para baixo
	 */
	void moveDown() {
		if(!centeredOnY()) return;
		if (canGo("down")) setSpeed(step, 0);
		else if (hasToStopY()) setSpeed(0, 0);
		else setSpeed(0, speedY);
	}
	
	/*
	 * @brief Movimento da entidade para a esquerda
	 */
	void moveLeft() {
		if(!centeredOnX()) return;
		if (canGo("left")) setSpeed(0, -step);
		else if (hasToStopX()) setSpeed(0, 0);
		else setSpeed(speedX, 0);
	}
	
	/*
	 * @brief Movimento da entidade para a direita 
	 */
	void moveRight() {
		if(!centeredOnX()) return;
		if (canGo("right")) setSpeed(0, step);
		else if (hasToStopX()) setSpeed(0, 0);
		else setSpeed(speedX, 0);
	}
	
	// funcoes abstratas a serem implementadas pelas subclasses
	@Override
	public abstract void tick();
	
	public abstract void fixedTick();
	
	@Override
	public abstract void render(Graphics g);
	
	public void updateSprite() {
		try {
			this.sprite = ImageIO.read(new File(SpritesManager.getFolder() + this.spritePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
