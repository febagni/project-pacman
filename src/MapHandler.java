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

public class MapHandler {
	
	PacMan player; //Objeto que representa o jogador
	GameObject[][] map; //Mapa dos objetos imoveis
	private int xLength; //Numero de linhas do mapa
	private int yLength; //Numero de colunas do mapa

	MapHandler(int rows, int columns){
		this.xLength = rows;
		this.yLength = columns;
		map = new GameObject[rows][columns];
	}
	
	// Setters
	public void setPlayer(PacMan player) {
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
	 * @brief Funcao que renderiza o objeto selecionado e seus arredores
	 */
    // A funcao nao esta sendo utilizada por enquanto
    public void renderChunk(Graphics g, int i, int j) {
    	for(int m = -1; m < 2; m++) {
    		for (int n = -1; n < 2; n++) {
    			if (!(i+m >= 0 && i+m < map.length) && (j+n >= 0 && j+n < map[0].length)) {
                    renderSquare(g, map.length - 1, j+n);
                    renderSquare(g, 0, j+n);
                } else if (!(j+n >= 0 && j+n < map[0].length) && (i+m >= 0 && i+m < map.length)) { 
                    renderSquare(g, i+m, map[0].length - 1);
                    renderSquare(g, i+m, 0);
                } else if((j+n >= 0 && j+n < map[0].length) && (i+m >= 0 && i+m < map.length))
                    renderSquare(g, i+m, j+n);
    		}
    	}
    }
    
    // Adiciona o objeto ao mapa
    public void addObject(GameObject object, int i, int j) {
    	map[i][j] = object;
    }  
}
