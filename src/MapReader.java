import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MapReader {
	
	ArrayList<String> array = new ArrayList<String>();
	
	
	MapReader(String fileName) {
		readFile(fileName);	
	}
	
	void readFile(String fileName) {
		try {
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String data = scanner.nextLine();
				array.add(data);
			}
			scanner.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	boolean validMap() throws Exception {
		int firstSize = array.get(0).length();
		int size;
		for(String line: array) {
			size = line.length();
			if(size != firstSize) 
				throw new WrongMapFormatException("The map format must be rectangular");			
		}
		return true;
	}
	
	
	int getHeight() {
		return array.size();
	}
	
	int getWidth() {
		try {
			if(validMap())
				return array.get(0).length();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	ArrayList<String> inputGetter() {
		return array;
	}
	
	
}
