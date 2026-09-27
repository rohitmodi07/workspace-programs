package leetcode.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubString {
	
	/*
	 * Input: s = "zxyzxyz"

       Output: 3
	 */

    public static int lengthOfLongestSubstring(String st) {
        
    	if(st == null || st.isBlank())
    		return -1;
    	
    	Set<Character> cset = new HashSet<>();
    	
    	int k=0;
    	int maxLen = 0;
    	
    	for(int i=k; i<st.length();) {
    		
    		char c = st.charAt(i);
    		
    		if(!cset.add(c)) {
    			k++;
    			i = k;
    			maxLen = Math.max(maxLen, cset.size());
    			cset = new HashSet<>();
    		}else {
    			i++;
    			maxLen = Math.max(maxLen, cset.size());
    		}
    	}
    	
    	System.out.println(cset);
    	
    	return maxLen;
    }
    

    public static int lengthOfLongestSubstringNew(String st) {
        
    	if(st == null || st.isBlank())
    		return -1;
    	
    	Set<Character> cset = new HashSet<>();
    	
    	int k=0;
        int maxLen = 0;
    	
    	for(int i=0; i<st.length(); i++) {
    		
    		char c = st.charAt(i);
    		
    		while(cset.contains(c)) {
    			cset.remove(st.charAt(k));
    			k++;
    		}
    		
    		cset.add(c);
    		maxLen = Math.max(maxLen, i-k+1);
    	}
    	
    	System.out.println(cset);
    	
    	return maxLen;
    }
	
	
   public static void main(String[] args) {
	
	   
	   System.out.println(lengthOfLongestSubstring("zxyzxyzp"));
	   System.out.println(lengthOfLongestSubstring("dvdf"));
	   System.out.println(lengthOfLongestSubstring("xxxx"));
	   System.out.println(lengthOfLongestSubstring("abc"));
	   
	   
   }

}
