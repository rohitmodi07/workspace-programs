package challenges.core;

@FunctionalInterface
public interface FunctionalIDemo {

	public void show();
	static void show1() {
		System.out.println(" static method ");
	}
	default void show2() {
		System.out.println(" default method ");
	}
}
