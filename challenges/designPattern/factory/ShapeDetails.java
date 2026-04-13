package challenges.designPattern.factory;

public class ShapeDetails implements AbFactory{

	@Override
	public Shape createShape() {
		return new Circle();
	}

	@Override
	public Sports playSport() {
		return new Cricket();
	}

	

	

}
