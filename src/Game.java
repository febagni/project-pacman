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
	
	private GameState state;
	private static final long serialVersionUID = 1L; 
	private Thread thread;
	private boolean running = false; //Flag that indicates if the game is running
	private boolean muted = false; //Flag that indicates if the audio is muted
	private boolean paused = false; //Flag that indicates if the game is paused
	private boolean restart = false; //Flag that stops the game from rendering the map while it is being restarted
	private int width; //Largura da tela criada
	private int height; //Altura da tela criada
	private int maxPoints; //Numero maximo de pontos atingiveis pelo jogador
	private int fixedTickFlag = 0; //Numero de miniticks
	private String mapFileName; //Game's map path
	private static final int fixedTickMax = 60; //Numero de miniticks a serem atingidos a cada fixedTick
	private MapHandler mapHandler; //Handler dos objetos que nao se movem
	private EntityHandler entityHandler; //Handler dos objetos que se movem
	PacMan player; //Objeto que representa o jogador
	Window window; //Tela do jogo
	private int totalPoints = 0; //Pontos totais do jogador
	private AudioPlayer songPlayer;  //Game's music player
	public AudioPlayer easterEgg;	//Find out playing
	private boolean easterFlag = false;
	
	public Game(String mapFileName) {
		this.mapFileName = mapFileName;
		state = new Difficulty1(mapFileName);
		gamePrepare(mapFileName);
		setStateVariables();
		window = new Window(width, height, "Projeto Pacman", this); //Constroi janela do jogos
	}
	
	public void setPause(boolean paused) {this.paused = paused;} //Pauses the game
	public boolean isPaused() {return this.paused;} //Indicates if the game is paused
	public void setRestart(boolean restart) {this.restart = restart;} //Restarts the game
	public boolean isRestarting() {return this.restart;} //Indicates that the game is being restarted
	
	/*
	 * @brief prepares game (reads map from txt file, sets objects to their initial positions)
	 */
	public void gamePrepare(String newMapFile) {
		MapBuilder mapBuilder = new MapBuilder(newMapFile); //Le o mapa
		mapHandler = new MapHandler(mapBuilder.getHeight(), mapBuilder.getWidth()); //Constroi o handler com o mapa
		player = mapBuilder.getPlayer(); //Pega o jogador
		width = mapBuilder.getWidth()*MapObject.squareSize; //Pega as dimensoes da tela
		height = mapBuilder.getHeight()*MapObject.squareSize;
		mapHandler.setMap(mapBuilder.build()); //Constroi os objetos do mapa
		entityHandler = new EntityHandler(mapBuilder.getGhosts(), player); //Constroi handler para os objetos que se movem
		maxPoints = mapBuilder.getMaxPoints();	//Pega os pontos maximos que podem ser feitos no jogo
	}

	/*
	 * @brief Starts game thread
	 */
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	/*
	 * @brief Stops game thread
	 */
	public synchronized void stop() {
		try {
			//System.exit(-1);
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	/*
	 * @brief Sets the game difficulty
	 */
	private void setState(int difficulty, String mapFileName) {
		switch(difficulty) {
			case 1:
				this.state = new Difficulty1(mapFileName);
				break;
			case 2:
				this.state = new Difficulty2(mapFileName);
				break;
			case 3:
				this.state = new Difficulty3(mapFileName);
				break;
			case 4:
				this.state = new Difficulty4(mapFileName);
				break;
			case 5:
				this.state = new Difficulty5(mapFileName);
				break;
		}
	}
	
	/*
	 * @brief Sets the game variables that rely on the game state
	 */
	void setStateVariables(){
		player.setLives(state.getLives());
		player.setMaxBoostedTime(state.getBoostTime());
		songPlayer = new AudioPlayer(state.getLevelNumber());
		songPlayer.changeSound(AudioPlayer.initVolume);
		songPlayer.play();
	}
	
	/*
	 * @brief Update the audio for the look-n-feel
	 */
	public void updateAudio() {
		songPlayer.stop();
		songPlayer = new AudioPlayer(state.getLevelNumber());
		songPlayer.play();
	}
	
	/*
	 * @brief Toggles mute
	 */
	public void mute() {
		muted = !muted;
		if(muted) {
			songPlayer.changeSound(-10000.0f);
			if(easterFlag) easterEgg.changeSound(-10000.0f);
		} else {
			songPlayer.changeSound(AudioPlayer.initVolume);
			if(easterFlag) easterEgg.changeSound(AudioPlayer.initVolume);
		}
	}
	
	/*
	 * @brief EasterEgg routine
	 */
	public void easterEgg() {
		if (!easterFlag) {
			easterEgg = new AudioPlayer("kazzoo.aif");
		} else {
			easterEgg.stop();
		}
		easterFlag = !easterFlag;
	}
	
	/*
	 * @brief Pattern GameLoop: Game loop that keeps it updated in real time
	 */
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 120.0; //Amount of ticks per second
        double ns = 1000000000 / amountOfTicks; 
        double delta = 0;
        long timer = System.currentTimeMillis();
		@SuppressWarnings("unused")
		int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if(running) render();
            frames++;
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
            }
       }    
       stop();
	}
	
	/*
	 * @brief Renders all game objects
	 */
	private void render() {
		//Use with BufferedImage
		if(!restart) {
			BufferStrategy bufferStrategy = this.getBufferStrategy();
			if (bufferStrategy == null) {
				this.createBufferStrategy(3);
				return;
			}
			Graphics graphics = bufferStrategy.getDrawGraphics();
			mapHandler.renderMap(graphics);
			entityHandler.render(graphics);
			graphics.dispose();
			bufferStrategy.show();
		}
	}
	
	/*
	 * @brief Returns whether the player got all obligatory points in the game
	 */
	public boolean gotAllPoints() {
		return player.getPoints() >= maxPoints;
	}
	
	/*
	 * @brief Updates all game objects skins
	 */
	public void setSkin() {
		mapHandler.updateAllSprites();
		entityHandler.updateAllSprites();
	}

	/*
	 * @brief Updates all game objects (positions, directions, etc.)
	 */
	private void tick() {
		if(!paused) {
			if(player.getLives() == 0) {
				System.out.println("Perdeu :(");
				paused = true;
			}
			mapHandler.tick();
			entityHandler.tick();
			if(entityHandler.playerDied()) {
				entityHandler.playerDeathReset();
				if(player.getLives()>100) System.out.println("Vidas: INFINITAS");
				else System.out.println("Vidas:" + player.getLives());
			}
			if(player.getBoostedTime() >= state.getBoostTime() - 1) {
				if(!player.isAlreadyBoosted()) this.player = new PacManBoostDecorator(player);
				entityHandler.setAllGhostsEscape();
				entityHandler.setPlayer(player);
			}
			if(player.getBoostedTime() <= 360) {
				entityHandler.setEndOfEscape();
			}
			
			if(player.lastBoostDrop) {
				this.player = player.getPlayer();
				entityHandler.setPlayer(player);
				entityHandler.setAllGhostsOriginalStrategy();
			}
			if(gotAllPoints()) {
				if(state.getLevelNumber() == 5) {
					paused = true;
				}
				totalPoints += (int)(state.getPointMultiplier()*player.totalPoints());
				System.out.println("Ganhou!!!");
				System.out.println("Pontuacao: " + Integer.toString(totalPoints));
				paused = true;
			}
			fixedTick();
		}
	}
	
	/*
	 * @brief Resets game in the current level
	 */
	public void reset() {
		restart = true;
		if(gotAllPoints()) totalPoints -= (int)(state.getPointMultiplier()*player.totalPoints());
		gamePrepare(mapFileName);
		songPlayer.stop();
		setStateVariables();
	}
	
	/*
	 * @brief Prepares the game for the next level
	 */
	public void nextLevel() {	
		restart = true;
		gamePrepare(mapFileName);
		if(state.getLevelNumber() < 5) {
			setState(state.getLevelNumber() + 1, mapFileName);
			System.out.println("Nivel:" + state.getLevelNumber());
		} else {
			System.out.println("Voce � o bich�o mesmo ein doido");
			stop();
		}
		songPlayer.stop();
		setStateVariables();
	}
	
	/*
	 * @brief Pauses the game (lowers song volume as well)
	 */
	public void pause() {
		paused = !paused;
		if(paused) songPlayer.changeSound(-35.0f);
		else songPlayer.changeSound(AudioPlayer.initVolume);
		
	}
	
	/*
	 * @brief fixed tick (works like the tick, but with a smaller frequency)
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
	 * @brief main function
	 */
	public static void main(String[] args) {
		new Game(args[0]);
	}
}
