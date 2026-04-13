package challenges.designPattern.visitor;

public class Fruit implements ItemElement{
	
	private int price;
	private String name;
	
	public Fruit(int price, String name) {
		this.price = price;
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}

	@Override
	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
		
	}

}
