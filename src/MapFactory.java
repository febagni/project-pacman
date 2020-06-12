/*
 * @file MapFactory.java
 * 
 * @brief Classe que implementa a fabrica abstrata para os elementos mapa
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

public class MapFactory implements AbstractFactory<GameObject> {

    HashMap<String,GameObject> prototypeMap = new HashMap<>();	//HashMap utilizado pelo padrao prototype

    MapFactory() {
        prototypeMap.put("#", new Wall());
        prototypeMap.put(" ", new Floor());
        prototypeMap.put(".", new FloorWithFood());
        prototypeMap.put("@", new FloorWithBoost());
        prototypeMap.put("%", new FloorWithCherry());
        prototypeMap.put("M", new Floor());
        prototypeMap.put("C", new Floor());
    }

    /*
     * @brief Método que realiza o clone do hashmap do padrao prototype
     */
    @Override
    public GameObject create(String maptype) {
        return prototypeMap.get(maptype).clone();
    }
}