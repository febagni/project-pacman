package pacman;

import java.util.HashMap;

public class MapFactory implements FabricaAbstrata<Map> {

	HashMap<String,Map> prototypeMap = new HashMap<>();
	
	MapFactory(){
		prototypeMap.put("Normal", new Normal());
		prototypeMap.put("VelhoOeste", new VelhoOeste());
		prototypeMap.put("EspacoSideral", new EspacoSideral());
	}
	
	@Override
	public Map create(String maptype) {
		return prototypeMap.get(maptype).clone();
	}
	
}
