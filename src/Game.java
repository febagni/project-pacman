/*
 * @file Game.java
 * 
 * @brief Classe que representa o jogo e contem a main
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 05/2020
 * 
 */

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L; 
	private Thread thread;
	private boolean running = false;
	private boolean firstRender = true; //Ve se eh a primeira iteracao
	private int width; //Largura da tela criada
	private int height; //Altura da tela criada
	private int maxPoints; //Numero maximo de pontos atingiveis pelo jogador
	private int fixedTickFlag = 0; //Numero de miniticks
	private static final int fixedTickMax = 60; //Numero de miniticks a serem atingidos a cada fixedTick
	private MapHandler mapHandler; //Handler dos objetos que nao se movem
	private EntityHandler entityHandler; //Handler dos objetos que se movem
	PacMan player; //Objeto que representa o jogador
	Window window; //Tela do jogo
	
	public Game(String mapFileName) {
		MapBuilder mapBuilder = new MapBuilder(mapFileName); //Le o mapa
		mapHandler = new MapHandler(mapBuilder.getHeight(), mapBuilder.getWidth()); //Constroi o handler com o mapa
		player = mapBuilder.getPlayer(); //Pega o jogador
		width = mapBuilder.getWidth()*MapObject.squareSize; //Pega as dimensoes da tela
		height = mapBuilder.getHeight()*MapObject.squareSize;
		mapHandler.setMap(mapBuilder.build()); //Constroi os objetos do mapa
		entityHandler = new EntityHandler(mapBuilder.getGhosts(), player); //Constroi handler para os objetos que se movem
		window = new Window(width, height, "Projeto Pacman", this); //Constroi janela do jogos
		maxPoints = mapBuilder.getMaxPoints();	//Pega os pontos maximos que podem ser feitos no jogo
	}

	/*
	 * @brief Inicia thread do jogo
	 */
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	/*
	 * @brief Para a thread do jogo
	 */
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	/*
	 * @brief Pattern GameLoop: Loop do jogo que mantem ele atualizado em tempo real
	 */
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0; //Frequencia em Hz de ticks
        double ns = 1000000000 / amountOfTicks; 
        double delta = 0;
        long timer = System.currentTimeMillis();
        
        @SuppressWarnings("unused")
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
	
	/*
	 * @brief Funcao que renderiza todos os objetos do jogo
	 */
	private void render() {
		//Use with BufferedImage
		BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();
        //Primeira iteracao: renderiza o mapa inteiro
        if (firstRender) {
        	mapHandler.renderMap(graphics);
        	firstRender = false;
        }      
        mapHandler.renderMap(graphics);
        entityHandler.render(graphics);
        graphics.dispose();
        bufferStrategy.show();
	}
	
	/*
	 * @brief Funcao que devolve se o jogador ja pegou todos os pontos presentes no mapa
	 */
	private boolean gotAllPoints() {
		return player.getPoints() >= maxPoints;
	}
	
	/*
	 * @brief Faz o update de todos os sprites do jogo
	 */
	public void setSkin() {
		mapHandler.updateAllSprites();
		entityHandler.updateAllSprites();
	}

	/*
	 * @brief Atualiza os objetos do jogo
	 */
	private void tick() {
		if(player.getLives() == 0) {
			System.out.println("Perdeu :(");
			stop();
		}
		mapHandler.tick();
		entityHandler.tick();
		if(entityHandler.playerTouchedGhost()) {
			entityHandler.playerDeathReset();
			System.out.println("Vidas:" + player.getLives());
		}
		if(gotAllPoints()) {
			System.out.print("Ganhou!!!");
			stop();
		}
		fixedTick();
	}
	
	/*
	 * @brief O fixed tick é um tick com intervalo maior
	 * @brief Os ghosts de estrategia mista usam o fixed tick como referencia para escolher a estrategia 
	 */
	private void fixedTick() {
		if(fixedTickFlag < fixedTickMax) {
			fixedTickFlag++;
		} else {
			entityHandler.fixedTick();
			fixedTickFlag = 0;
		}
	}
	
	/*
	 * @brief Funcao main
	 */
	public static void main(String[] args) {
		new Game(args[0]);
	}
}
