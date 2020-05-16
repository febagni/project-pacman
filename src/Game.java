import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
	
	/* Private Variables*/

	private static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running = false;
	private int width;
	private int height;
	private Handler handler;
	
	/*Game function that will be called when the game starts*/ 
	public Game(String mapFileName) {
		MapBuilder testMap = new MapBuilder(mapFileName);
		handler = new Handler();
		width = testMap.getWidth()*MapObject.squareSize;
		height = testMap.getHeight()*MapObject.squareSize;
		handler.addMap(testMap.build(), testMap.getHeight(), testMap.getWidth());
		new Window(width, height, "PAC MONSTROOOOOOOO :P", this);
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
        //int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) /ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if(running) render();
            //frames++;
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS " + frames);
                //frames = 0;
            }
       }
        stop();
	}
	
	private void render() {
		BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.setColor(Color.blue);
        graphics.fillRect(0, 0, width, height);
        handler.render(graphics);
        graphics.dispose();
        bufferStrategy.show();
	}

	private void tick() {
		handler.tick();
	}

	public static void main(String[] args) {
		new Game("testMap.txt");
	}
}
