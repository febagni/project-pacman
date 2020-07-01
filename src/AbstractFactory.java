/*
 * @file AbstractFactory.java
 * 
 * @brief Classe auxiliar à implementação da fábrica abstrata
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 */

public interface AbstractFactory<T> {
	
	T create(String type);
}