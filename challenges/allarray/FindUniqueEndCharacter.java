package challenges.allarray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindUniqueEndCharacter {
	
	//string - Rohit,  rett, roh
	
		public static Character getTheLastUniqueCharacter1(String str) {
			if(str == null || str.isEmpty())
				return null;
			
			Set<Character> hset = new HashSet<>();
			
			
			for(int i=0; i<str.length(); i++) {
				
				if(!hset.add(str.charAt(i))) {     //rett
				    for(int j=i; j>0; j--) {
				    	if(str.charAt(j) == str.charAt(i)) {
				    		j--;
				    	}else {
				    		return str.charAt(j);
				    	}
				    }
					
				}
			}
			return str.charAt(str.length()-1);
		}
		
		public static Character getTheLastUniqueCharacter(String str) {
			if(str == null || str.isEmpty())
				return null;
			
			List<Character> clist = new ArrayList<>();
			
			for(int i=0; i<str.length(); i++) {
				clist.add(str.charAt(i));
			}
			
			Set<Character> hset = new LinkedHashSet<>();
			
		    List<Character> newlist = clist.stream().filter(val -> hset.add(val)).collect(Collectors.toList());
		    if(hset.size() == clist.size()) {
		    	return newlist.get(newlist.size()-1);
		    }
		    
		    return newlist.get(newlist.size()-2);
		    
			
		}
		

		public static void main(String[] args) { 
			
			System.out.println(getTheLastUniqueCharacter("rohitt"));
			
	    }

}
