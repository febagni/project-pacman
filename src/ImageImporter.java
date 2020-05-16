import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImageImporter extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
	
    public ImageImporter(String imagePath) {
        try {                
           image = ImageIO.read(new File(imagePath));
        } catch (Exception e) {
        	e.printStackTrace();
        } 
    }	
    protected void paintComponent(Graphics g, int x, int y) {
        super.paintComponent(g);
        g.drawImage(image, x, y, this);            
    }

}
