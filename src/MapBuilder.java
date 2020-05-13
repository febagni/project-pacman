import java.util.ArrayList;

public class MapBuilder {
	final int width;
	final int height;
	private MapObject[][] map;
	private MapReader mapReader;

	MapBuilder (String fileName){
		mapReader = new MapReader(fileName);
		width = mapReader.getWidth();
		height = mapReader.getHeight();
	}
	
	void build() {
		map = new MapObject[height][width];
		ArrayList<String> rawMap = mapReader.inputGetter();
		
		for(String line : rawMap) {
			for(int i = 0; i < line.length() ; i++) {
				if(line.charAt(i) ==  '1') {
					System.out.print("#");
				}
				else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}
}
