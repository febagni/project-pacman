import java.util.ArrayList;
import java.util.HashMap;

public class MapBuilder {
	final int width;
	final int height;
	private MapObject[][] map;
	private MapReader mapReader;
	

	HashMap<Character, MapObject> hashRepresentation = new HashMap<>();
	
	MapBuilder (String fileName){
		mapReader = new MapReader(fileName);
		width = mapReader.getWidth();
		height = mapReader.getHeight();
		hashRepresentation.put('#', new Wall());
		hashRepresentation.put('.', new FloorWithFood());
		hashRepresentation.put(' ', new Floor());
	}
	
	MapObject[][] build() {
		map = new MapObject[height][width];
		ArrayList<String> rawMap = mapReader.inputGetter();
		int i = 0;           
		for(String line : rawMap) {	
			for(int j = 0; j < line.length() ; j++) {
				map[i][j] = hashRepresentation.get(line.charAt(j)).cloneMapObject(i, j);
			}
			i++;
		}
		return map;
	}
	
	int getHeight() {
		return mapReader.getHeight();
	}
	
	int getWidth() {
		return mapReader.getWidth();
	}
}
