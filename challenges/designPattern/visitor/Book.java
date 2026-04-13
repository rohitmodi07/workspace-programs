package challenges.designPattern.visitor;

public class Book implements ItemElement{
	
	private int price;
	private String isbn;
	
	public Book(int price, String isbn) {
		this.price = price;
		this.isbn = isbn;
	}
	
	public int getPrice() {
		return price;
	}

	@Override
	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
		
	}

}
