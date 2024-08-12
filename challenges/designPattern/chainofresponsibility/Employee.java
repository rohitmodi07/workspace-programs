package challenges.designPattern.chainofresponsibility;

public abstract class Employee {

	protected Employee supervisor;
	
	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}
	
	public abstract void applyLeave(int numOfDays);
}
