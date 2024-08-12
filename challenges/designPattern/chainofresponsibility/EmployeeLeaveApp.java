package challenges.designPattern.chainofresponsibility;

public class EmployeeLeaveApp {

	public static void main(String[] args) {
		
		TeamLead tl = new TeamLead();
		ProjectLead pl = new ProjectLead();
		HrManager hr = new HrManager();
		
		tl.setSupervisor(pl);
		pl.setSupervisor(hr);
		
		tl.applyLeave(10);
		tl.applyLeave(20);
		tl.applyLeave(30);
		tl.applyLeave(35);

	}

}
