package challenges.designPattern.memento;

public class MementoOriginator {
	
	private String state;
	
	public String getState() {
		return this.state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public Memento saveMementoState() {
		return new Memento(state);
	}
	
	public void getMementoState(Memento memento) {
		this.state = memento.getState();
	}

}
