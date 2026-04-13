package challenges.designPattern.visitor;

import java.util.*;
public class ShoppingClient {
	
	public static void main(String[] args) {
		
		List<ItemElement> itemList = Arrays.asList(new Book(10, "isbn"), new Book(20, "isbn"), 
				new Fruit(30, "apple"));
		
		int totalCost = calculatePrice(itemList);
		System.out.println(" total cost : "+totalCost);
		
		
	}

	private static int calculatePrice(List<ItemElement> itemList) {
		
		ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
		int sum = 0;
		
		for(ItemElement ie : itemList) {
			sum = sum + ie.accept(visitor);
		}
		
		return sum;
	}

}
