package challenges.designPattern.factory;

public class Circle implements Shape{
	
	public int area(int radius) {
		return (int) (3.14 * radius*radius);
	}

}
