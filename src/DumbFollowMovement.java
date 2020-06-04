import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class DumbFollowMovement extends FollowMovement {

	DumbFollowMovement(Entity follower, Entity followed) {
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
		if (deltaX*deltaX > deltaY*deltaY) {
			priorityDirection.add((deltaX > 0)? KeyEvent.VK_UP: KeyEvent.VK_DOWN);
			priorityDirection.add((deltaY > 0)? KeyEvent.VK_LEFT: KeyEvent.VK_RIGHT);
		}
		else {
			priorityDirection.add((deltaY > 0)? KeyEvent.VK_LEFT: KeyEvent.VK_RIGHT);
			priorityDirection.add((deltaX > 0)? KeyEvent.VK_UP: KeyEvent.VK_DOWN);
		}
	}
}
