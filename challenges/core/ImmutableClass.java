package challenges.core;

import java.util.HashMap;
import java.util.Map;

public final class ImmutableClass {

	private final int id;
	private final String name;
	private final Map<String, String> hmap;
	
	public ImmutableClass(int id, String name, Map<String, String> hmap) {
		this.id = id;
		this.name = name;
		
		Map<String, String> temp = new HashMap<>();
		
		for(Map.Entry<String, String> entry : hmap.entrySet()) {
			temp.put(entry.getKey(), entry.getValue());
		}
		this.hmap = temp;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Map<String, String> getHmap() {
       Map<String, String> temp = new HashMap<>();
		
		for(Map.Entry<String, String> entry : this.hmap.entrySet()) {
			temp.put(entry.getKey(), entry.getValue());
		}
		return temp;
	}
	
	
}
