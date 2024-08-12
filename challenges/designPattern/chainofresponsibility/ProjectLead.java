package challenges.designPattern.chainofresponsibility;

public class ProjectLead extends Employee{
	

	@Override
	public void applyLeave(int numOfDays) {
		if(numOfDays>10 && numOfDays<=20) {
			System.out.println(" project lead approved the leave");
		}else {
			supervisor.applyLeave(numOfDays);
		}
		
	}

}
