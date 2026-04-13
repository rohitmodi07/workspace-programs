package challenges.solidPrincipals.singleResponsibility;

public class BankService {
	
	public void deposit(int amount) {
		
	}
	
	public void withdraw(int amount) {
		
	}
	
	//following method should be in another class as Bank service must be responsible for deposit/withdraw instead of 
	// having other responsibility such as printing pass book, providing loan etc. extract loan responsibility in another class
	// and extract responsibility of printing pass book in another class
	
	public void getLoan(int amount, String loanType) {
		if("home".equals(loanType)) {
			// apply for home loan
		}else if("car".equals(loanType)) {
			// apply for car loan
		}
	}
	
	public void printPassBook() {
		// print all the transaction
	}

}
