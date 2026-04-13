package challenges.designPattern.visitor;

public interface ItemElement {
	
	int accept(ShoppingCartVisitor visitor);

}
