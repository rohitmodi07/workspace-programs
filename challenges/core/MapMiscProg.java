package challenges.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapMiscProg {
	
public static void createMap(String name) { //johnson
		
		Map<Character, Integer> nmap = new HashMap<>();
		
		for(int i=0; i<name.length(); i++) {
			char c = name.charAt(i);
			if(nmap.containsKey(c)) {
				nmap.put(c, nmap.get(c)+1);
			}else {
				nmap.put(c, 1);
			}
		}
		
		System.out.println(" formed map is :::: "+nmap);
		
		List<Character> maxOccurrence = new ArrayList<>();
		
		for(Map.Entry<Character, Integer> m : nmap.entrySet()) {
			if(m.getValue()>1) {
				maxOccurrence.add(m.getKey());
			}
		}
		
		//System.out.println(" list is ::: "+maxOccurrence);
		
        Map<Integer, List<Character>> newmap = new TreeMap<>();
        List<Character> clist = new ArrayList<>();
		
		for(Map.Entry<Character, Integer> m : nmap.entrySet()) {
			if(newmap.containsKey(m.getValue())) {
				List<Character> nlist = newmap.get(m.getValue());
				nlist.add(m.getKey());
				newmap.put(m.getValue(), nlist);
			}else {
				List<Character> nlist = new ArrayList<>();
				nlist.add(m.getKey());
				newmap.put(m.getValue(), nlist);
			}
		}
		
		System.out.println(" new map is ::::: "+newmap);
		System.out.println(" max occurred character :::: "+newmap.get(newmap.size()));
		
	}
	

	public static void main(String[] args) { 
		
		createMap("johnson");
		
    }

}
