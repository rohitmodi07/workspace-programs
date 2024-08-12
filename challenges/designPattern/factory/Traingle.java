package challenges.designPattern.factory;

public class Traingle implements Shape{
	
	int height = 10;
	
	public int area(int base) {
		return 1/2*base*height;
	}

}
