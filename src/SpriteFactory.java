import java.util.HashMap;

public class SpriteFactory implements AbstractFactory<Map> {

	HashMap<String,Map> prototypeMap = new HashMap<>();

    SpriteFactory() {
        prototypeMap.put("Normal", new Classic());
        prototypeMap.put("VelhoOeste", new WildWest());
        prototypeMap.put("EspacoSideral", new DeepSpace());
    }

    @Override
    public Map create(String maptype) {
        return prototypeMap.get(maptype).clone();
    }

}
