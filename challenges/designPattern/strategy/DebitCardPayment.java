package challenges.designPattern.strategy;

public class DebitCardPayment implements PaymentStrategy{

	@Override
	public void getPaymentDetails() {
		System.out.println(" get debit card details ");
		
	}

	@Override
	public void processPayment(double amount) {
		System.out.println(" processing debit card payment of "+amount);
		
	}

}
