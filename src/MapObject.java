/*
 * @file MapObject.java
 * 
 * @brief Superclasse abstrata que implementa GameObject e representa todos os elementos estaticos 
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class MapObject implements GameObject {
	
	protected BufferedImage sprite; // Imagem que representa o objeto em questao
	protected int x; // Posicao x na matriz
	protected int y; // Posicao y na matriz
	protected MapID id; // ID do objeto
	protected String spritePath;   //Caminho dos sprites do objeto
	
	/*
	 * @brief Método abstrato para o padrao prototype
	 */
	public abstract GameObject clone();
	
	// Setters e getters
	@Override
	public MapID getID() {return id;}
	
	@Override
	public void setID(MapID id) {this.id = id;}
	
	@Override
	public int getX() {return x;}
																		
	@Override
	public int getY() {return y;}
	
	@Override
	public void setX(int x) {this.x = x;}
	
	@Override
	public void setY(int y) {this.y = y;}
	
	@Override
	public void setSpritePath(String spritePath) {this.spritePath = spritePath;}
	
	/*
	 * @brief Renderiza o objeto estatico
	 */
	@Override
	public void render(Graphics graphic) {
		graphic.drawImage(sprite, x*squareSize, y*squareSize, null);
	}
	
	/*
	 * @brief Atualiza o endereco do sprite do Map Object 
	 */
	public void updateSprite() {
		try {
			this.sprite = ImageIO.read(new File(SpritesManager.getFolder() + spritePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
