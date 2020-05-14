import java.util.ArrayList;
import java.util.HashMap;

public class MapBuilder {
	final int width;
	final int height;
	private MapObject[][] map;
	private MapReader mapReader;

	HashMap<Character, MapID> hashRepresentation = new HashMap<>();
	
	
	MapBuilder (String fileName){
		mapReader = new MapReader(fileName);
		width = mapReader.getWidth();
		height = mapReader.getHeight();
//		hashRepresentation.put('#', new Wall());
	}
	
	void build() {
		map = new MapObject[height][width];
		ArrayList<String> rawMap = mapReader.inputGetter();
		int i = 0;           ;
		for(String line : rawMap) {	
			for(int j = 0; j < line.length() ; j++) {
//				map[i][j] = 
			}
			i++;
		}
	}
}
