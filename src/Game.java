import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
	
	/* Private Variables*/

	private static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running = false;
	private int width;
	private int height;
	private MapHandler mapHandler;
	private EntityHandler entityHandler;
	PacMan player;
	Window window;
	
	private int testFlag = 0;
	
	/*Game function that will be called when the game starts*/ 
	
	public Game(String mapFileName) {
		MapBuilder testMap = new MapBuilder(mapFileName);
		mapHandler = new MapHandler(testMap.getHeight(), testMap.getWidth());
		player = testMap.getPlayer();
		entityHandler = new EntityHandler(testMap.getGhosts(), player);
		width = testMap.getWidth()*MapObject.squareSize;
		height = testMap.getHeight()*MapObject.squareSize;
		mapHandler.addMap(testMap.build(), testMap.getHeight(), testMap.getWidth());
		window = new Window(width, height, "Pacman", this);
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) /ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if(running) render();
            frames++;
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS " + frames);
                frames = 0;
            }
       }
        
       stop();
	}
		
	private void render() {
		//Use with BufferedImage
		BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();
        if (testFlag == 0) {
        	mapHandler.renderMap(graphics);
        	testFlag ++;
        }
        if(window.panelMoved()) {
        	mapHandler.renderMap(graphics);
        }
        mapHandler.renderChunk(graphics, player.getX(), player.getY());
        //criar um entity handler para mexer com o player e os fantasmas
        entityHandler.render(graphics);
        //entre o comentario de cima e esse
        graphics.dispose();
        bufferStrategy.show();
	}

	private void tick() {
		mapHandler.tick();
		entityHandler.tick();
	}
	
	public static void main(String[] args) {
		new Game("map.txt");
	}
}
