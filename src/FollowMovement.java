import java.util.ArrayList;

public abstract class FollowMovement implements GhostMovement {

	Entity follower;
	Entity followed;
	
	FollowMovement(Entity follower, Entity followed) {
		this.follower = follower;
		this.followed = followed;
	}
	
	@Override
	public abstract int ghostMovement(ArrayList<Integer> possibleDirections);
}
