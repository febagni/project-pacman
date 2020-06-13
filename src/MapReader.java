/*
 * @file MapReader.java
 * 
 * @brief Classe de leitura do arquivo .txt que contem o mapa
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 05/2020
 * 
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MapReader {
	
	ArrayList<String> rawMap = new ArrayList<String>();	//	Mapa cru, lido do arquivo txt 
	
	MapReader(String fileName) {
		readFile(fileName);
		if(!validMap()) { //Caso o mapa seja invalido, imprime mensagem de erro e termina a execucao
			System.out.println("The map format is not valid.");
			System.exit(0);
		}
	}
	
	/*
	 * @brief	Faz a leitura do arquivo txt que contem o mapa
	 * 
	 * @param	Nome do arquivo
	 */
	void readFile(String fileName) {
		try {
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {	//enquanto existe o que ler no arquivo
				String data = scanner.nextLine();
				rawMap.add(data);	//adiciona na arraylist rawMap
			}
			scanner.close();	
		} catch (Exception e) {}
	}
	
	/*
	 * @brief Verifica se o mapa lido eh retangular
	 * 
	 * @return	Se o mapa eh retangular
	 */
	boolean rectangularMap() throws Exception {
		int widthReference = rawMap.get(0).length();
		for(String line: rawMap) {
			if(line.length() != widthReference) 
				throw new WrongMapFormatException("The map format must be rectangular");	//joga exception do formato errado do mapa 			
		}
		return true;
	}
	
	/*
	 * @brief Verifica se o mapa tem 4 paredes em seus 4 vertices
	 * 
	 * @return	Se o mapa tem paredes nos 4 vertices ou nao
	 */
	boolean hasCorners() throws Exception {
		if(rawMap.get(0).charAt(0) == '#' &&
			rawMap.get(0).charAt(getWidth()-1) == '#' &&
			rawMap.get(getHeight()-1).charAt(0) == '#' && 
			rawMap.get(getHeight()-1).charAt(getWidth()-1) == '#') 
			return true;	
		else {
			throw new WrongMapFormatException("The map must have '#' on 4 corners");	//joga exception, pois eh uma das definicoes do mapa para nao ter erro
		}
	}
	
	/*
	 * @brief Verifica se o mapa tem apenas um pacman
	 * 
	 * @return	Se o mapa tem apenas um pacman ou nao
	 */
	boolean hasOnePacman() throws Exception {
		int numberOfPacmans = 0;
		for(String line : rawMap) {
			for(int i = 0; i < line.length(); i++) {
				if(line.charAt(i) == 'C') numberOfPacmans++;
			}
		}
		if (numberOfPacmans == 1)
			return true;
		else
			throw new WrongMapFormatException("The map must have only ONE 'C'");	//joga exception, pois eh uma das definicoes do mapa para nao ter erro
	}
	
	/*
	 * @brief Verifica se o mapa eh valido, de acordo com as condicoes instruidas
	 * 
	 * @return	Se o mapa eh valido ou nao
	 */
	boolean validMap() {
		try {
			if(rectangularMap() && hasCorners() && hasOnePacman()) //O mapa deve ser retangular, ter parede em seus 4 vertices, e ter apenas um pacman
				return true;
		} catch (Exception e) {}
		return false;
	}
	
	//Getters
	
	int getHeight() { return rawMap.size(); }
	ArrayList<String> getInput() { return rawMap; }
	
	int getWidth() {
		try {
			if(rectangularMap()) return rawMap.get(0).length();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
