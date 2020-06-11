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

public class FloorWithCherry extends MapObject{

    FloorWithCherry(){
    	spritePath = "PacManFloorWithCherry.png";
    	updateSprite();
    }

    //Necessario para fabrica abstrata com hashmap
    @Override
    public GameObject clone() {
        FloorWithCherry floor = new FloorWithCherry();
//        floor.setX(x);
//        floor.setY(y);
        floor.setID(MapID.FloorWithCherry);
        return floor;
    }
    
    //Nao utilizado ainda
    @Override
    public void tick() {
    }
}