/*
 * @file SpriteFactory.java
 * 
 * @brief Classe que implementa a fabrica abstrata para os sprites das entidades do jogo
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */

import java.util.HashMap;

public class SpriteFactory implements AbstractFactory<Skin> {

	HashMap<String,Skin> prototypeMap = new HashMap<>();	//HashMap utilizado pleo padrao prototype

    SpriteFactory() {
        prototypeMap.put("Classic", new Classic());
        prototypeMap.put("WildWest", new WildWest());
        prototypeMap.put("DeepSpace", new DeepSpace());
        prototypeMap.put("UnderTheSea", new UnderTheSea());
        prototypeMap.put("CovidMarket", new CovidMarket());
    }

    /*
     * @brief Método que realiza o clone do hashmap do padrao prototype
     */
    @Override
    public Skin create(String maptype) {
        return prototypeMap.get(maptype).clone();
    }

}
