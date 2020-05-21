import java.awt.Graphics;

public class MapHandler {
	
	PacMan player;
	
	GameObject[][] map;
	private int columns;
	private int rows;

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
    	    	renderSquare(g, i+m, j+n);
    		}
    	}
    }
    
    public void addObject(GameObject object, int i, int j) {
    	map[i][j] = object;
    }
    
    public void renderEntityTrace(Graphics graphic, Entity entity) {
    	renderSquare(graphic, entity.getX(), entity.getY());
    	if(entity.getX() != entity.getLastX() || entity.getY() != entity.getLastY()) {
    		renderSquare(graphic, entity.getLastX(), entity.getLastY());
    		entity.setLastX(entity.getX());
    		entity.setLastY(entity.getY());
    	}
    }

    public void addMap(GameObject[][] gameObjects, int height, int width) {
    	for (int i = 0; i < height; i++) {
    		for (int j = 0; j < width; j++) {
        		this.addObject(gameObjects[i][j], i, j);
        	}
    	}
    }
}
