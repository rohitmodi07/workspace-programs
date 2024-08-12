package challenges.designPattern.chainofresponsibility;

public class TeamLead extends Employee{
	

	@Override
	public void applyLeave(int numOfDays) {
		if(numOfDays<=10) {
			System.out.println(" team lead approved the leave");
		}else {
			supervisor.applyLeave(numOfDays);
		}
		
	}

}
