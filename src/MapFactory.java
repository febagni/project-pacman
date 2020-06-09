import java.util.HashMap;

public class MapFactory implements AbstractFactory<GameObject> {

    HashMap<String,GameObject> prototypeMap = new HashMap<>();

    MapFactory() {
        prototypeMap.put("#", new Wall());
        prototypeMap.put(" ", new Floor());
        prototypeMap.put(".", new FloorWithFood());
        prototypeMap.put("@", new FloorWithBoost());
        prototypeMap.put("%", new FloorWithCherry());
        prototypeMap.put("M", new Floor());
        prototypeMap.put("C", new Floor());
    }

    @Override
    public GameObject create(String maptype) {
        return prototypeMap.get(maptype).clone();
    }

}