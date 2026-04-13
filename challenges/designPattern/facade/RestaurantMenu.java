package challenges.designPattern.facade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantMenu {
	
	public  Map<String, List<String>> getMenu(){
		
		List<String> snacks = new SnacksMenu().getSnacks();
		List<String> mainCourse = new MainCourseMenu().getMainCourseMenu();
		List<String> desertMenu = new DesertMenu().getDesertMenu();
		
		Map<String, List<String>> restMenu = new HashMap<>();
		
		restMenu.put("desert", desertMenu);
		restMenu.put("mainCourse", mainCourse);
		restMenu.put("snacks", snacks);
		
		return restMenu;
		
	}

}
