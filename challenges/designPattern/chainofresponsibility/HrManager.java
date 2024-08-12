package challenges.designPattern.chainofresponsibility;

public class HrManager extends Employee{
	

	@Override
	public void applyLeave(int numOfDays) {
		if(numOfDays>20 && numOfDays<=30) {
			System.out.println(" hr manager approved the leave");
		}else {
			System.out.println(" leave exceed 30 days, please meet in office for approval");
		}
		
	}

}
