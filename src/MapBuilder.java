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
 * @date 06/2020
 * 
 */
import java.util.ArrayList;

public class MapBuilder {

	final int width;	//Largura da matriz do mapa
	final int height;	//Altura da matriz do mapa
	private GameObject[][] map;	//Mapa de objetos imoveis do jogo
	private MapReader mapReader;	//Leitor do mapa
	private ArrayList<Ghost> ghosts;	//Lista com todos as entidades adversarias do jogo
	PacMan player = new PacMan();	//Entidade que representa o jogador
	int maxPoints;	//Contador de pontos maximos que o jogador pode obter
	int strategyIndex = 0;	//Indice das estrategias
	MapFactory mapFactory = new MapFactory();	//Inicializador da fabrica abstrata do mapa
	ArrayList<StrategyID> ids = new ArrayList<>();
	
	MapBuilder (String fileName) {
		ghosts = new ArrayList<Ghost>();
		mapReader = new MapReader(fileName); //Leitor do mapa
		width = mapReader.getWidth();
		height = mapReader.getHeight();
		ids.add(StrategyID.Random);
		ids.add(StrategyID.Follow);
		ids.add(StrategyID.Mixed);
		//ids.add(StrategyID.Escape);
		maxPoints = 0;
	}
	
	//Getters
		PacMan getPlayer() {return player;}
		public ArrayList<Ghost> getGhosts() {return ghosts;}
		int getHeight() {return mapReader.getHeight();}
		int getWidth() {return mapReader.getWidth();}
		int getMaxPoints() {return maxPoints;}
		
	/*
	 * @brief Constroi o mapa a partir do leitor, criando uma matriz com os objetos do jogo
	 */
	GameObject[][] build() {
		map = new GameObject[height][width];
		ArrayList<String> rawMap = mapReader.getInput(); //Mapa recebido em String
		int i = 0;           
		for(String line : rawMap) {	
			for(int j = 0; j < line.length() ; j++) {
				GameObject mapObject = mapFactory.create(String.valueOf(line.charAt(j)));//Coloca o objeto identificado em sua posicao correspondente
				mapObject.setX(j); mapObject.setY(i);
				map[i][j] = mapObject; 
				
				if (line.charAt(j) == 'C') { //Se for detectado um player, posiciona-lo na posicao encontrada
					player.setRealX(i*GameObject.squareSize);
					player.setRealY(j*GameObject.squareSize);
					player.setInitialPositionX(i*GameObject.squareSize);
					player.setInitialPositionY(j*GameObject.squareSize);
				} 
				else if (line.charAt(j) == 'M') { //Se for detectado um adversario, posiciona-lo na posicao encontrada
					StrategyID myLittleID = defineStrategy();
					Ghost myLittleGhost = new Ghost(i*GameObject.squareSize,j*GameObject.squareSize, myLittleID);
					myLittleGhost.setRealX(i*GameObject.squareSize);
					myLittleGhost.setRealY(j*GameObject.squareSize);
					myLittleGhost.setMap(map);
					ghosts.add(myLittleGhost);
				}
				else if (line.charAt(j) == '.') {	//Se for um food, adiciona 10 pontos para a contagem total de pontos
					maxPoints += 10;
				}
				else if (line.charAt(j) == '%') {	//Se for uma cherry, adiciona 100 pontos para a contagem total de pontos
					maxPoints += 100;
				}
			}
			i++;
		}
		player.setMap(map); //Atribui ao player o mapa criado
		return map;	//retorna o mapa
	}
	
	/*
	 * @brief Define a estrategia associada a cada ghost existente em uma dada ordem
	 */
	private StrategyID defineStrategy() {
		strategyIndex++;
		if(strategyIndex >= ids.size()) strategyIndex = 0;
		return ids.get(strategyIndex);
	}
}
