import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	
	public Rectangle gameButton = new Rectangle(Game.WIDTH / 2 + 120, 150, 100, 50);
	public Rectangle creditsButton = new Rectangle(Game.WIDTH / 2 + 120, 150, 100, 50);
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.red);
		g.drawString("PACMAN", Game.WIDTH/2,100);
		
		g2d.draw(gameButton);
		g2d.draw(creditsButton);
	}
		
}
