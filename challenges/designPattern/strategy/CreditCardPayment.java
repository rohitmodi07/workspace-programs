package challenges.designPattern.strategy;

public class CreditCardPayment implements PaymentStrategy{

	@Override
	public void getPaymentDetails() {
		System.out.println(" get credit card details ");
		
	}

	@Override
	public void processPayment(double amount) {
		System.out.println(" processing credit card payment of "+amount);
		
	}

}
