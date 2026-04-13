package challenges.solidPrincipals.depenInver;

public class PaymentApp {
	
	private CardPayment cardPayment;
	
	public PaymentApp() {
		cardPayment = new DebitCard();
	}
	
	public void pay() {
		cardPayment.pay();
	}

}
