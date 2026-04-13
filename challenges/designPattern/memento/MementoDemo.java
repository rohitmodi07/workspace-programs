package challenges.designPattern.memento;

public class MementoDemo {
	
	public static void main(String[] args) {
		MementoOriginator morg = new MementoOriginator();
		MementoCareTaker mct = new MementoCareTaker();
		
		morg.setState("state #1");
		morg.setState("state #2");
		
		mct.addMementoState(morg.saveMementoState());
		
		System.out.println(" state :::: "+mct.getMemento(0).getState());
		
		
	}

}
