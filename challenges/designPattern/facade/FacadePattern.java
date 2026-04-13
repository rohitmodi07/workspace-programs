package challenges.designPattern.facade;

public class FacadePattern {
	
	public static void main(String[] args) {
		RestaurantMenu restMenu = new RestaurantMenu();
		System.out.println(restMenu.getMenu());
	}

}
