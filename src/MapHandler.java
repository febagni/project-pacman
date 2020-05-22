import java.awt.Graphics;

public class MapHandler {
	
	PacMan player;
	
	GameObject[][] map;
	private int rows;
	private int columns;

	MapHandler(int rows, int columns){
		this.rows = rows;
		this.columns = columns;
		map = new GameObject[rows][columns];
	}
	public void setPlayer(PacMan player) {
		this.player = player;
	}
	
    public void tick() {
    	for(int i = 0; i < rows; i++) {
    		for(int j = 0; j < columns ; j++) {
    			map[i][j].tick();
    		}
    	}
    }
    
    public void renderMap(Graphics g) {
    	for(int i = 0; i < rows; i++) {
    		for(int j = 0; j < columns ; j++) {
    			map[i][j].render(g);
    		}
    	}
    }
    
    public void renderSquare(Graphics g, int i, int j) {
    	map[i][j].render(g);
    }
    
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
    
    public void addObject(GameObject object, int i, int j) {
    	map[i][j] = object;
    }
    
    public void addMap(GameObject[][] gameObjects) {
    	for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < columns; j++) {
        		this.addObject(gameObjects[i][j], i, j);
        	}
    	}
    }
}
