import java.util.HashMap;

public class MapFactory implements AbstractFactory<GameObject> {

    HashMap<String,GameObject> prototypeMap = new HashMap<>();

    MapFactory() {
        prototypeMap.put("Wall", new Wall());
        prototypeMap.put("Floor", new Floor());
        prototypeMap.put("FloorWithFood", new FloorWithFood());
        prototypeMap.put("FloorWithBoost", new FloorWithBoost());
        prototypeMap.put("FloorWithCherry", new FloorWithCherry());
        prototypeMap.put("Ghost", new Floor());
        prototypeMap.put("PacMan", new Floor());
    }

    @Override
    public GameObject create(String maptype) {
        return prototypeMap.get(maptype).clone();
    }

}