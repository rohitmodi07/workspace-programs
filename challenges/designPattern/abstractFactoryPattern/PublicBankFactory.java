package challenges.designPattern.abstractFactoryPattern;

public class PublicBankFactory implements PublicBank{


	@Override
	public AccountFactory getAccountDepartment(String accountType) {
		return new AccountFactory(accountType);
	}


	@Override
	public LoanFactory getLoanDepartment(String loanType) {
		return new LoanFactory(loanType);
	}

	

}
