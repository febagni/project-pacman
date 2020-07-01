/*
 * @file NonRandomMovement.java
 * 
 * @brief Pacman Decorator that implements the boosts function
 * 
 * @author Alexandre Marques Carrer <alexandrecarrer@usp.br>
 * @author Felipe Bagni <febagni@usp.br> 
 * @author Gabriel Yugo Kishida <gabriel.kishida@usp.br>
 * @author Gustavo Azevedo Correa <guazco@usp.br>
 * 
 * @date 06/2020
 * 
 */

public class PacManBoostDecorator extends PacManDecorator {

	PacManBoostDecorator(PacMan player) {
		super(player);
		lastBoostDrop = false;
	}

	@Override
	public boolean isAlreadyBoosted() {
		return true;
	}
	
	@Override
	public boolean playerEatGhost() {
		return true;
	}
	
	/*
	 * @brief Tick that controls the boosted time and lower it with time
	 */
	public void tick() {
		super.tick();
		if (player.getBoostedTime() > 0) {
			if (player.getBoostedTime() < 2) lastBoostDrop = true;
			player.setBoostedTime(player.getBoostedTime() - 1);;
		}
	}

	
}
