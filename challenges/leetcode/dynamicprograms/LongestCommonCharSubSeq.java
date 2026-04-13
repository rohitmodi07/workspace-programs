package leetcode.dynamicprograms;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

import stages.TestProgram;

public class LongestCommonCharSubSeq {
	
	// longest common subsequence in a string
	
		public static int longestCommonCharSubSeq(String st1, String st2) { // "cat", "crabt"
			
			if(st1 == null || st1.isEmpty() || st2 == null || st2.isEmpty())
				return -1;
			int j=0;
			int count = 0;
			
			for(int i=0; i<st1.length(); i++) {
				char cst1 = st1.charAt(i);
				
				while(j<st2.length()) {
					char cst2 = st2.charAt(j);
					j++;
					if(cst1 == cst2) {
						count++;
						break;
					}
				}
			}
			return count;
			
		}
	    

		public static int longestCommonSubsequence(String st1, String st2) {  // cat, crabt
	    	
	    	if(st1 == null || st2 == null || st1.isEmpty() || st2.isEmpty())
	    		return -1;
	    	StringBuilder sb = new StringBuilder();
	    	int longCommonSubs = 0;
	    	
	    	for(int i=0; i<st1.length(); i++) {
	    		
	    		char cst1 = st1.charAt(i);
	    		
	    		for(int j=i; j<st2.length(); j++) {
	    			char cst2 = st2.charAt(j);
	    			
	    			if(cst1 == cst2) {
	    				longCommonSubs++;
	    				sb.append(cst2);
	    				break;
	    			}
	    		}
	    		
	    	}
	    	System.out.println(" mathed char :::: "+sb.toString());
	    	return longCommonSubs;
	        
	    }
	    
	    public static int longestCommonSubsequence1(String st1, String st2) {  // cat, crabt
	    	
	    	if(st1 == null || st2 == null || st1.isEmpty() || st2.isEmpty())
	    		return -1;
	    	StringBuilder sb = new StringBuilder();
	    	int longCommonSubs = 0;
	    	
	    	Stack<Character> stk = new Stack<>();
	    	Set<Character> cset = new LinkedHashSet<>();
	    	for(int i=st1.length()-1; i>=0; i--) {
	    		stk.push(st1.charAt(i));
	    		cset.add(st1.charAt(i));
	    	}
	    	
	    
	    		
			for(int j=0; j<st2.length(); j++) {   // cat, crabt
				char cst2 = st2.charAt(j);
				char cst1 = ' ';
				if(cset.contains(cst2)) {
					cst1 = stk.pop();
					if(cst1 == cst2) {
						longCommonSubs++;
						sb.append(cst2);
					}
				}
				
			}
	    		
	    	
	    	System.out.println(" matched char :::: "+sb.toString());
	    	return longCommonSubs;
	        
	    }


		public static void main(String[] args) {
			
			
			int[] arr = {3,1,3,2,3}; // 7,4,3,0   2,2,2,2,5,6,9
			//System.out.println(" max increasing number sequence :: "+lengthOfLIS(arr));
			
			System.out.println(" longest common sequence ::::: "+longestCommonSubsequence1("cat", "crabt"));
			System.out.println(" longest common sequence ::::: "+longestCommonSubsequence1("abcd", "abcd"));
			System.out.println(" longest common sequence ::::: "+longestCommonSubsequence1("abc", "def"));
			System.out.println(" longest common sequence ::::: "+longestCommonSubsequence1("abc", "abef"));
			System.out.println(" longest common sequence ::::: "+longestCommonSubsequence1("abc", "ac"));
	      
		}

}
