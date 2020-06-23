import java.awt.Graphics;

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
 * @date 06/2020
 * 
 */

public class FloorWithCherry extends MapObject{

	private boolean hasCherry;
	private int cherryChance;
	
    FloorWithCherry(){
    	hasCherry = true;
    	spritePath = "PacManFloorWithCherry.png";
    	updateSprite();
    }

    /*
	 * @brief Implementação do padrão prototype: clona o objeto para criar os objetos pela fábrica abstrata
	 */
    @Override
    public GameObject clone() {
        FloorWithCherry floor = new FloorWithCherry();
        floor.setID(MapID.FloorWithCherry);
        return floor;
    }
    
    public void setHasCherry(boolean hasCherry) {
    	this.hasCherry = hasCherry;
    }
   
    //Nao utilizado 
    @Override
    public void tick() {
    }
}