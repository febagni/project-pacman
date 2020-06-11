
public class SpritesManager {
	
	static final String mainFolder = "sprites/";
	static String folder = "Classic/";
	static String getFolder() {	return mainFolder + folder;}
	static String getSpritePath (MapID id) {
		switch (id) {
			case Floor :
				return "PacManFloor.png";
			case Wall :
				return "PacManWall.png";
			case FloorWithFood :
				return "PacManFloorWithFood.png";
			case FloorWithBoost :
				return "PacManFloorWithBoost.png";
			case FloorWithCherry : 
				return "PacManFloorWithCherry.png";
		}
		return null;
	}
}
