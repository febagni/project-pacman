/*
 * @file FloorWithCherry.java
 * 
 * @brief Classe filha de MapObject que representa o chao com a cereja
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 05/2020
 * 
 */
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FloorWithCherry extends MapObject{

    FloorWithCherry(){
        try {
            sprite = ImageIO.read(new File("sprites/PacManFloorWithCherry.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Necessario para fabrica abstrata com hashmap
    @Override
    MapObject cloneMapObject(int x, int y) {
        FloorWithCherry floor = new FloorWithCherry();
        floor.setX(x);
        floor.setY(y);
        floor.setID(MapID.FloorWithCherry);
        return floor;
    }
    
    /*
	 * @brief Renderiza o chao com cereja
	 */
    @Override
	public void render(Graphics graphic) {
    	graphic.setColor(Color.black);
		graphic.fillRect(x*squareSize, y*squareSize, squareSize, squareSize);
		if(this.id == MapID.FloorWithCherry) { //Se o ID mudar o jogador ja passou pelo bloco
			graphic.drawImage(sprite,x*squareSize,y*squareSize,null);
		}
	}
    
    //Nao utilizado ainda
    @Override
    public void tick() {
    }
}