import java.util.ArrayList;

public abstract class NonRandomMovement implements GhostMovement {

	Entity follower;
	Entity followed;
	
	NonRandomMovement(Entity follower, Entity followed) {
		this.follower = follower;
		this.followed = followed;
	}
	
	@Override
	public abstract int ghostMovement(ArrayList<Integer> possibleDirections);
}
