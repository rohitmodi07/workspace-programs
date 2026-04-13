package challenges.designPattern.template;

public abstract class Game {
	
	public abstract void initialize();
	public abstract void endPlay();
	public abstract void startPlay();
	
	public final void play() {
		
		initialize();
		startPlay();
		endPlay();
		
	}

}
