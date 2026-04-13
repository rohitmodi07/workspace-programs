package challenges.designPattern.factory;

public class SportsDetails implements AbFactory{

	@Override
	public Shape createShape() {
		return new Traingle();
	}

	@Override
	public Sports playSport() {
		return new Football();
	}

}
