/*
 * @file MapHandler.java
 * 
 * @brief Classe que manuseia os objetos imoveis
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
import java.util.ArrayList;
import java.util.Random; 

public class MapHandler {
	
	PacManRegular player; //Objeto que representa o jogador
	GameObject[][] map; //Mapa dos objetos imoveis
	private int xLength; //Numero de linhas do mapa
	private int yLength; //Numero de colunas do mapa


	MapHandler(int rows, int columns){
		this.xLength = rows;
		this.yLength = columns;
		map = new GameObject[rows][columns];
	}
	
	/*
	 * @brief Set Player
	 */
	public void setPlayer(PacManRegular player) {
		this.player = player;
	}

    public void setMap(GameObject[][] gameObjects) {
    	for (int i = 0; i < xLength; i++) {
    		for (int j = 0; j < yLength; j++) {
        		this.addObject(gameObjects[i][j], i, j);
        	}
    	}
    }
    

    /*
	 * @brief Atualiza os objetos do mapa
	 */
    public void tick() {
    	for(int i = 0; i < xLength; i++) {
    		for(int j = 0; j < yLength ; j++) {
    			map[i][j].tick();
    		}
    	}
    }
    
    
    /*
	 * @brief Funcao que renderiza todos os objetos do mapa
	 */
    public void renderMap(Graphics g) {
    	for(int i = 0; i < xLength; i++) {
    		for(int j = 0; j < yLength ; j++) {
    			map[i][j].render(g);
    		}
    	}
    }
    
    /*
     * @brief Faz o update de todos os sprites
     */
    public void updateAllSprites() {
    	for(int i = 0; i < xLength; i++) {
    		for(int j = 0; j < yLength ; j++) {
    			map[i][j].updateSprite();
    		}
    	}
    }
    
    /*
	 * @brief Funcao que renderiza o objeto selecionado 
	 */
    public void renderSquare(Graphics g, int i, int j) {
    	map[i][j].render(g);
    }
    
    /*
     * @brief Adiciona o objeto ao mapa
     */
    public void addObject(GameObject object, int i, int j) {
    	map[i][j] = object;
    }  
}
