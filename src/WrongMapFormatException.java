/*
 * @file WrongMapFormatException.java
 * 
 * @brief Caso o usuario entre com um mapa nao retangular, essa excecao é levantada
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 05/2020
 * 
 */

public class WrongMapFormatException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	WrongMapFormatException(String message){
		System.out.println(message);
	}
}
