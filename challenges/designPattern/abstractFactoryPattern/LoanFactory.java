package challenges.designPattern.abstractFactoryPattern;

public class LoanFactory {
	
	private LoanDepartment loanD;
	private String loanType;
	
	public LoanFactory(String loanType) {
		
		this.loanType = loanType;
		
		if("home".equals(loanType)) {
			loanD = new HomeLoan();
		}else if("personal".equals(loanType)) {
			loanD = new PersonalLoan();
		}
	}
	
	public void provideLoan() {
		if("home".equals(loanType)) {
			loanD.provideLoan();
		}else if("personal".equals(loanType)) {
			loanD.provideLoan();
		}else {
			System.out.println(" only for home and persoanl loan ");
		}
	}

}
