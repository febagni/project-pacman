/*
 * @file MapBuilder.java
 * 
 * @brief Classe que constroi o mapa de objetos do jogo a partir do arquivo .txt
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 05/2020
 * 
 */
import java.util.ArrayList;
import java.util.HashMap;

public class MapBuilder {

	final int width;	//Largura da matriz do mapa
	final int height;	//Altura da matriz do mapa
	private MapObject[][] map;	//Mapa de objetos imoveis do jogo
	private MapReader mapReader;	//Leitor do mapa
	private ArrayList<Ghost> ghosts;	//Lista com todos as entidades adversarias do jogo
	HashMap<Character, MapObject> charMap = new HashMap<>();	//HashMap que contem os caracteres do jogo
	PacMan player = new PacMan();	//Entidade que representa o jogador
	

	//Getters
	PacMan getPlayer() {return player;}
	public ArrayList<Ghost> getGhosts() {return ghosts;}
	int getHeight() {return mapReader.getHeight();}
	int getWidth() {return mapReader.getWidth();}
	
	MapBuilder (String fileName) {
		ghosts = new ArrayList<Ghost>();
		mapReader = new MapReader(fileName); //Leitor do mapa
		width = mapReader.getWidth();
		height = mapReader.getHeight();
		
		//Definicoes de qual caractere representa qual objeto no jogo
		charMap.put('#', new Wall());
		charMap.put('.', new FloorWithFood());
		charMap.put(' ', new Floor());
		charMap.put('C', new Floor()); //Representa o jogador, mas no mapa eh um chao
		charMap.put('M', new Floor()); //Representa um adversario, mas no mapa eh um chao
		charMap.put('@', new FloorWithBoost());
		charMap.put('%', new FloorWithCherry());
	}
	/*
	 * @brief Constroi o mapa a partir do leitor, criando uma matriz com os objetos do jogo
	 */
	GameObject[][] build() {
		map = new MapObject[height][width];
		ArrayList<String> rawMap = mapReader.getInput(); //Mapa recebido em String
		int i = 0;           
		for(String line : rawMap) {	
			for(int j = 0; j < line.length() ; j++) {
				map[i][j] = charMap.get(line.charAt(j)).cloneMapObject(j, i);	//Coloca o objeto identificado em sua posicao correspondente
				if (line.charAt(j) == 'C') { //Se for detectado um player, posiciona-lo na posicao encontrada
					player.setRealX(i*GameObject.squareSize);
					player.setRealY(j*GameObject.squareSize);
				} 
				else if (line.charAt(j) == 'M') { //Se for detectado um adversario, posiciona-lo na posicao encontrada
					ghosts.add((new Ghost(i*32,j*32)));				}
			}
			i++;
		}
		player.setMap(map); //Atribui ao player o mapa criado
		return map;
	}
}
