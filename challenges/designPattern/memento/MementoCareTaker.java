package challenges.designPattern.memento;

import java.util.ArrayList;
import java.util.List;

public class MementoCareTaker {
	
	private List<Memento> mementoList = new ArrayList<>();
	
	public void addMementoState(Memento state) {
		this.mementoList.add(state);
	}
	
	public Memento getMemento(int index) {
		return mementoList.get(index);
	}

}
