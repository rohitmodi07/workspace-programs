package challenges.designPattern.strategy;

public class OrderProcessing {
	
	private PaymentStrategy paymentStrategy;
	
	// strategy to initialize payment type via constructor
	public OrderProcessing(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}
	
	// strategy to accept payment via setter method
	public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}
	
	public void completeOrder(double amount) {
		paymentStrategy.getPaymentDetails();
		paymentStrategy.processPayment(amount);
	}

}
