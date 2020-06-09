import java.util.HashMap;

public class SpriteFactory implements AbstractFactory<Map> {

	HashMap<String,Map> prototypeMap = new HashMap<>();

    SpriteFactory() {
        prototypeMap.put("Classic", new Classic());
        prototypeMap.put("WildWest", new WildWest());
        prototypeMap.put("DeepSpace", new DeepSpace());
    }

    @Override
    public Map create(String maptype) {
        return prototypeMap.get(maptype).clone();
    }

}
