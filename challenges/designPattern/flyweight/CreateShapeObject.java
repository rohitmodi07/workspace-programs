package challenges.designPattern.flyweight;

import java.util.HashMap;
import java.util.Map;


public class CreateShapeObject {
	
	Map<String, Shape> smap;
	
	public CreateShapeObject() {
		smap = new HashMap<>();
	}
	
	public Shape getShapeObj(String shapeType) {
		if(smap.containsKey(shapeType)) {
			System.out.println(" object already exist hence return the existing obj ");
			return smap.get(shapeType);
		}else {
			if("circle".equals(shapeType)) {
				System.out.println(" created circle object ");
				smap.put(shapeType, new Circle());
			}else if("triangle".equals(shapeType)) {
				System.out.println(" created triangle object ");
				smap.put(shapeType, new Triangle());
			}
		}
		
		return null;
		
	}

}
