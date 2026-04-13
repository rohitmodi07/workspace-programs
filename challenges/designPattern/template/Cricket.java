package challenges.designPattern.template;

public class Cricket extends Game{

	@Override
	public void initialize() {
		System.out.println(" Cricket game initialized");
		
	}

	@Override
	public void endPlay() {
		System.out.println(" Cricket game play ends ");
		
	}

	@Override
	public void startPlay() {
		System.out.println(" Cricket game play starts ");
		
	}

}
