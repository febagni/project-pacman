package pacman;

public class Normal implements Map {

	@Override
	public void Display() {
		
	}
	
	@Override
	public Map clone() {
		return new Normal();
	}
}
