import java.util.HashMap;

public class SpriteFactory implements AbstractFactory<Skin> {

	HashMap<String,Skin> prototypeMap = new HashMap<>();

    SpriteFactory() {
        prototypeMap.put("Classic", new Classic());
        prototypeMap.put("WildWest", new WildWest());
        prototypeMap.put("DeepSpace", new DeepSpace());
        prototypeMap.put("UnderTheSea", new UnderTheSea());
        prototypeMap.put("CovidMarket", new CovidMarket());
    }

    @Override
    public Skin create(String maptype) {
        return prototypeMap.get(maptype).clone();
    }

}
