package challenges.designPattern.abstractFactoryPattern;

public class AccountFactory {
	
	private String accountType;
	private AccountDepartment accD;
	
	public AccountFactory(String accountType) {
		this.accountType = accountType;
		
		if("saving".equals(accountType)) {
			accD = new SavingAccount();
		}else if("current".equals(accountType)) {
			accD = new CurrentAccount();
		}
	}
	
	public void createAccount() {
		if("saving".equals(accountType)) {
			accD.createAccount();;
		}else if("current".equals(accountType)) {
			accD.createAccount();
		}else {
			System.out.println(" only saving and current account supported ");
		}
	}

}
