import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick() {
        for(GameObject tempObject : object) {
            tempObject.tick();
        }
    }

    public void render(Graphics g) {
    	for(GameObject tempObject : object) {
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.object.add(object);
    }

    public void removeObject(GameObject object) {
        this.object.remove(object);
    }
    
    public void addMap(MapObject[][] map, int height, int width) {
    	for (int i = 0; i < height; i++) {
    		for (int j = 0; j < width; j++) {
        		this.addObject(map[i][j]);
        	}
    	}
    }
}
