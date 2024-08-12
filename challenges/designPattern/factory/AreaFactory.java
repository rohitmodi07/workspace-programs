package challenges.designPattern.factory;

public class AreaFactory {
	
	public Shape findArea(String shape) {
		if("circle".equals(shape)) {
			return new Circle();
		}else if("triangle".equals(shape)) {
			return new Traingle();
		}else {
			return null;
		}
	}

}
