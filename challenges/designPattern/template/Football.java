package challenges.designPattern.template;

public class Football extends Game{

	@Override
	public void initialize() {
		System.out.println(" Football game initialized");
		
	}

	@Override
	public void endPlay() {
		System.out.println(" Football game play ends ");
		
	}

	@Override
	public void startPlay() {
		System.out.println(" Football game play starts ");
		
	}

}
