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
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FloorWithCherry extends MapObject{

    FloorWithCherry(){
        try {
            sprite = ImageIO.read(new File("sprites/PacManFloorWithCherry"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void tick() {
    }

    @Override
    MapObject cloneMapObject(int x, int y) {
        FloorWithCherry floor = new FloorWithCherry();
        floor.setX(x);
        floor.setY(y);
        floor.setID(id);
        return floor;
    }
}