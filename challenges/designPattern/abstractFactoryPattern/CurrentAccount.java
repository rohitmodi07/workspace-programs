package challenges.designPattern.abstractFactoryPattern;

public class CurrentAccount implements AccountDepartment{

	@Override
	public void createAccount() {
		System.out.println(" open current account ");
		
	}

}
