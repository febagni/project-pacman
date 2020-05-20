import java.util.ArrayList;
import java.util.HashMap;

public class MapBuilder {

	final int width;
	final int height;
	private MapObject[][] map;
	private MapReader mapReader;
	HashMap<Character, MapObject> hashRepresentation = new HashMap<>();
	PacMan player = new PacMan();
	
	MapBuilder (String fileName) {
		mapReader = new MapReader(fileName);
		width = mapReader.getWidth();
		height = mapReader.getHeight();
		hashRepresentation.put('#', new Wall());
		hashRepresentation.put('.', new FloorWithFood());
		hashRepresentation.put(' ', new Floor());
		hashRepresentation.put('C', new Floor());
		hashRepresentation.put('M', new Floor());
		hashRepresentation.put('@', new FloorWithBoost());
	}
	
	GameObject[][] build() {
		map = new MapObject[height][width];
		ArrayList<String> rawMap = mapReader.inputGetter();
		int i = 0;           
		for(String line : rawMap) {	
			for(int j = 0; j < line.length() ; j++) {
				map[i][j] = hashRepresentation.get(line.charAt(j)).cloneMapObject(j, i);
				if (line.charAt(j) == 'C') {
					player.setRealX(i*32);
					player.setRealY(j*32);
				} 
			}
			i++;
		}
		player.setMap(map);
		return map;
	}
	PacMan getPlayer() {
		return player;
	}
	
	int getHeight() {
		return mapReader.getHeight();
	}
	
	int getWidth() {
		return mapReader.getWidth();
	}
}
