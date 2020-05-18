import java.util.ArrayList;

public class MapBuilder {

	final int columns;
	final int rows;
	private MapReader mapReader;
	
	int pacmanInitialRow;
	int pacmanInitialColumn;
	
	ArrayList<String> rawMap;
	
	MapBuilder (String fileName) {
		mapReader = new MapReader(fileName);
		columns = mapReader.getColumns();
		rows = mapReader.getRows();
		rawMap = mapReader.inputGetter();
		build();

	}
	
	void build() {
		int i = 0;           
		for(String line : rawMap) {	
			for(int j = 0; j < line.length() ; j++) {
				switch(line.charAt(j)) {
				case '1':
					pacmanInitialRow = j;
					pacmanInitialColumn = i;
					break;
				
				}
			}
			i++;
		}
	}
	
	int getPacmanInitialRow() {
		return pacmanInitialRow;
	}
	
	int getPacmanInitialColumn() {
		return pacmanInitialColumn;
	}
	
	char charAt(int row, int column) {
		return rawMap.get(row).charAt(column);
	}
	
}
