package challenges.designPattern.factory;

public class TestAbstractFactoryPattern {
	
	private AbFactory abf;
	
	public TestAbstractFactoryPattern(String objType) {
		if("shape".equals(objType)) {
			abf = new ShapeDetails();
		}else if("sports".equals(objType)) {
			abf = new SportsDetails();
		}
	}
	
	public Shape getShapeObject() {
		return abf.createShape();
	}
	
	public Sports getSportsObject() {
		return abf.playSport();
	}
	
	public static void main(String[] args) {
		TestAbstractFactoryPattern tp = new TestAbstractFactoryPattern("shape");
		tp.getShapeObject().area(10);
		tp.getSportsObject().play();
	}

}
