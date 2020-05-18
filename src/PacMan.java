import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PacMan implements KeyListener{


	public void init() {}


	public boolean isOver() { return over; }
	public String getTitle() { return title; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public int getDelay() { return delay; }
	public void resize(int width, int height) {}

	public void keyTyped(KeyEvent e) {
	}
	
	public void keyReleased(KeyEvent e) {
	}
	
	//***********************************************************************
	
	final int STEP = 2;
	
	BufferedImage pacman;
	int frame;
	
	String mapFileName = "map.txt";
	MapReader mr = new MapReader(mapFileName);
	MapBuilder mb = new MapBuilder(mapFileName);
	
	protected boolean over;
	protected String title;
	protected int width = mr.getColumns()+500;
	protected int height = mr.getRows()+500;
	protected int delay = 30;
	
	int rows = mr.getRows();
	int columns = mr.getColumns(); 	
	
	int screenWidth = columns*STEP;
	int screenHeight = rows*STEP;
	
	int direction;
	int currentColumn;
	int currentRow;
	
	
	public PacMan() {
		title = "PacMan monstao";
		frame = 0;
		direction = KeyEvent.VK_RIGHT;
		currentColumn = mb.getPacmanInitialColumn();
		currentRow = mb.getPacmanInitialRow();
		try {
			pacman = ImageIO.read(new File("images/packman.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main (String args[]) {
		GameApplication.start(new PacMan());
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (37 <= key && key <= 40) {
			direction = key;
		}
	}

	
	public void update() {
		frame++;
		if (frame>5) {
			frame = 0;
		}
		
		switch(direction) {
		case KeyEvent.VK_LEFT:	//37
			if (currentColumn > 0) {
				if(mb.charAt(currentRow, currentColumn-1) != '#') {
					currentColumn -= 1;
				}
			}
			break;
		case KeyEvent.VK_RIGHT:	//39
			if (currentColumn < columns-1) {
				if(mb.charAt(currentRow, currentColumn+1) != '#') {
					currentColumn += 1;
				}
			}
			break;
		case KeyEvent.VK_UP:	//38
			if (currentRow > 0) {
				if(mb.charAt(currentRow-1, currentColumn) != '#') {
					currentRow -= 1;
				}
			}
			break;
		case KeyEvent.VK_DOWN:	//40
			if (currentRow < rows-1) {
				if(mb.charAt(currentRow+1, currentColumn) != '#') {
					currentRow += 1;
				}
			}
			break;
		}
		
		if (currentColumn < 0) currentColumn = 0;
		else if (currentColumn > width - 28 - STEP) currentColumn = width - 28 - STEP; //28 é a largura/diametro do pacman
		
		if (currentRow < 0) currentRow = 0;
		else if (currentRow > height-55-STEP) currentRow = height - 55 - STEP;
	}
	
	public void draw(Graphics2D g) {
		g.drawImage(pacman.getSubimage((frame/2)*30, (direction-37)*30, 28, 28), currentColumn*STEP-14, currentRow*STEP-14, null);
	}
	

}
