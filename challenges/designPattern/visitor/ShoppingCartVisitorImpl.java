package challenges.designPattern.visitor;

public class ShoppingCartVisitorImpl implements ShoppingCartVisitor{

	@Override
	public int visit(Book book) {
		
		return book.getPrice();
		
	}

	@Override
	public int visit(Fruit fruit) {
		
		return fruit.getPrice();
		
	}

}
