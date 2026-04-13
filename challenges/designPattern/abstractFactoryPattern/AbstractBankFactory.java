package challenges.designPattern.abstractFactoryPattern;

public class AbstractBankFactory {
	
	public static void main(String[] args) {
		
		PublicBankFactory pbf = new PublicBankFactory();
		
		LoanFactory lf = pbf.getLoanDepartment("personal");
		lf.provideLoan();
		
		AccountFactory af = pbf.getAccountDepartment("current");
		af.createAccount();
	    
	    
		
	}

}
