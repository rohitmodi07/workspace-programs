package leetcode.slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllPermutationOfString {
	
	public static List<String> allStringPermutation(String st, String result, List<String> slist){
    	if(st.isEmpty()) {
    		slist.add(result);
    	}
    	
    	for(int i=0; i<st.length(); i++) {
    		
    		char ch = st.charAt(i);
    		
    		String remaining = st.substring(0,i) + st.substring(i+1);
    		allStringPermutation(remaining, result+ch, slist);
    	}
    	return slist;
    	
    }

    
    public static void main(String[] args) {
        
    	System.out.println(" all permutation :::: "+allStringPermutation("abc", "", new ArrayList<>()));
    	
    }

}
