/*
 * @file GameObject.java
 * 
 * @brief Interface implementada por todos os objetos que fazem parte da abstracao do jogo (Jogador, parede, inimigos, etc.)
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

public interface GameObject {
	
//	static String folder = "/sprites/Classic";
	static final int squareSize = 32;	//Tamanho do bloco do jogo (em pixels)
	static final int step = 2;	//Velocidade das entidades moveis do jogo
	public void tick();	//Funcao que atualiza o objeto em questao
	public void render(Graphics g); //Funcao que renderiza o objeto em questao;
	
	//Getters e setters
	public int getX();
	public int getY();
	public void setX(int x);
	public void setY(int y);
	public MapID getID();
	public void setID(MapID id);
	public GameObject clone();
	public void updateSprite();
	
}
