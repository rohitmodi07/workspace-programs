package challenges.designPattern.factory;

public class TestFactoryPattern {
	
   public static void main(String[] args) throws InterruptedException {
		
		AreaFactory af = new AreaFactory();
		
		var circle = af.findArea("circle");
		System.out.println(circle.area(10));
		
	}
	

}
