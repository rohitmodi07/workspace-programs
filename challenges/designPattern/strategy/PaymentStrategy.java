package challenges.designPattern.strategy;

public interface PaymentStrategy {
	
	void getPaymentDetails();
	void processPayment(double amount);

}
