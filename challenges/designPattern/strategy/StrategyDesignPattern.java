package challenges.designPattern.strategy;

public class StrategyDesignPattern {
	
	public static void main(String[] args) {
		
		OrderProcessing op = new OrderProcessing(new DebitCardPayment());
		op.completeOrder(100);
		
		op.setPaymentStrategy(new CreditCardPayment());
		op.completeOrder(200);
		
	}

}
