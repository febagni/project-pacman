package pacman;

public interface FabricaAbstrata<T> {
	T create(String type);
}
