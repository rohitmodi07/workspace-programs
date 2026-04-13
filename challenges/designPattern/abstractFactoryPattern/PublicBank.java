package challenges.designPattern.abstractFactoryPattern;

public interface PublicBank {
	
	AccountFactory getAccountDepartment(String accountType);
	LoanFactory getLoanDepartment(String loanType);

}
