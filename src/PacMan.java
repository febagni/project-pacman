import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PacMan extends Entity {

	protected boolean boosted;
	protected int points;
	
	public PacMan(){
		boosted = false;
		points = 0;
		frame = 0;
		try {
			sprite = ImageIO.read(new File("sprites/pacman.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.direction = KeyEvent.VK_LEFT;
	}
	
	void movement() {
		if (map[getX()][getY()].getID() == MapID.FloorWithFood) {
			map[getX()][getY()].setID(MapID.Floor); 
			points++;
		} else if (map[getX()][getY()].getID() == MapID.FloorWithBoost) {
			map[getX()][getY()].setID(MapID.Floor);
			boosted = true;
		}
		frame++;
		if (frame>5*animationSlowness) {
			frame = 0;
		}
		
//		if (isOnEdge()) {
//			//mmovimento de teletransporte
//		} else {
//			//movimento normal
//		}
		switch (direction) {
			case KeyEvent.VK_UP:
				//Checa se está centralizado no eixo y
				if(realY - getY()*32 != 0)
					break;
				if (canGo("up")) {
					speedX = -step;
					speedY = 0;
				} 
				else {
					speedX = 0;
					if ((!canGo("right") && speedY > 0) || (!canGo("left") && speedY < 0)) speedY = 0;
				}
				
				break;
			case KeyEvent.VK_DOWN:
				if(realY - getY()*32 != 0 )
					break;
				if (canGo("down")) {
					speedX = step;
					speedY = 0;
				}
				else {
					speedX = 0;
					if ((!canGo("right") && speedY > 0) || (!canGo("left") && speedY < 0)) speedY = 0;
				}
				
				break;
			case KeyEvent.VK_LEFT:
				if(realX - getX()*32 != 0 )
					break;
				if (canGo("left")) {
					speedY = -step;
					speedX = 0;
				}
				else {
					speedY = 0;
					if ((!canGo("down") && speedX > 0) || (!canGo("up") && speedX < 0)) speedX = 0;
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(realX - getX()*32 != 0 )
					break;
				if (canGo("right")) {
					speedY = step;
					speedX = 0;
				}
				else {
					speedY = 0;
					if ((!canGo("down") && speedX > 0) || (!canGo("up") && speedX < 0)) speedX = 0;
				}
				break;
		}
		realX += speedX;
		realY += speedY;
		if(getX() < 1 && speedX < 0) {
			realX = (xLength + 1)*squareSize ;
		}
		else if(getX() >= xLength + 1 && speedX > 0) {
			realX = 0;
		}
		if(getY() < 1 && speedY < 0) {
			realY = (yLength + 1)*squareSize ;
		}
		else if(getY() >= yLength + 1 && speedY > 0) {
			realY = 0;
		}

	}

	public void tick() {
		movement();
		System.out.print("points = " + points + " | ");
		System.out.println("boosted = " + boosted);
	}

	public void render(Graphics graphic) {
		int animationDirection = KeyEvent.VK_LEFT;
		if(speedX > 0) animationDirection = KeyEvent.VK_DOWN;
		else if(speedX < 0) animationDirection = KeyEvent.VK_UP;
		else if(speedY > 0) animationDirection = KeyEvent.VK_RIGHT;
		else if(speedY < 0) animationDirection = KeyEvent.VK_LEFT;
		graphic.drawImage(sprite.getSubimage((frame/(2*animationSlowness))*30, (animationDirection - 37)*30, 28, 28)
				, realY+2, realX+2, null);
	}
}
