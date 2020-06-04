import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GetawayMovement extends NonRandomMovement {

	GetawayMovement(Entity follower, Entity followed) {
		super(follower, followed);
	}
	
	ArrayList<Integer> priorityDirection;
	@Override
	public int ghostMovement(ArrayList<Integer> possibleDirections) {
		priorityDirection = new ArrayList<Integer>();
		setPreferredDirection();
		for(int direction : priorityDirection) {
			if (possibleDirections.contains(direction)) {
				return direction;
			}
		}
		return KeyEvent.VK_LEFT;
	}
	private void setPreferredDirection() {
		int deltaX = follower.getRealX() - followed.getRealX();
		int deltaY = follower.getRealY() - followed.getRealY();
		if(deltaY==0){
			priorityDirection.add(KeyEvent.VK_LEFT);
			priorityDirection.add(KeyEvent.VK_RIGHT);
		} if (deltaX == 0) {
			priorityDirection.add(KeyEvent.VK_UP);
			priorityDirection.add(KeyEvent.VK_DOWN);
		} if(deltaX*deltaX > deltaY*deltaY){
			priorityDirection.add(!(deltaY > 0)? KeyEvent.VK_LEFT: KeyEvent.VK_RIGHT);
			priorityDirection.add(!(deltaX > 0)? KeyEvent.VK_UP: KeyEvent.VK_DOWN);
		} else if(deltaX*deltaX < deltaY*deltaY){
			priorityDirection.add(!(deltaX > 0)? KeyEvent.VK_UP: KeyEvent.VK_DOWN);
			priorityDirection.add(!(deltaY > 0)? KeyEvent.VK_LEFT: KeyEvent.VK_RIGHT);
		}
	}
	
}
