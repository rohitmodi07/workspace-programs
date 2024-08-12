package challenges.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class SignalClass {
	
	private List<Vehicle> vlist;
	
	public SignalClass() {
		this.vlist = new ArrayList<>();
	}
	
	public void addInTraffic(Vehicle v){
		vlist.add(v);
	}
	
	public void changeSignal(String signalColor) {
		if("Red".equals(signalColor)) {
			notifyVehiclesToStop();
		}else if("Green".equals(signalColor)) {
			notifyVehiclesToStart();
		}
	}
	
	public void notifyVehiclesToStop() {
		for(Vehicle v : vlist) {
			v.stop();
		}
	}
	
	public void notifyVehiclesToStart() {
		for(Vehicle v : vlist) {
			v.start();
		}
	}
	

}
