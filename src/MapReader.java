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
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
	
	/*
	 * @brief Verifica a validade do mapa lido
	 * 
	 * @return	Se mapa eh valido
	 */
	boolean validMap() throws Exception {
		int widthReference = rawMap.get(0).length();
		for(String line: rawMap) {
			if(line.length() != widthReference) 
				throw new WrongMapFormatException("The map format must be rectangular");	//joga exception do formato errado do mapa 			
		}
		return true;
	}
	
	//GETTERS
	
	int getHeight() { return rawMap.size(); }
	ArrayList<String> getInput() { return rawMap; }
	
	int getWidth() {
		try {
			if(validMap()) return rawMap.get(0).length();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
