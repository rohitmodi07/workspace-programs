package leetcode.arraysHashing;

public class LongestCommonPrefix {
	
	/*
     * Input: strs = ["bat","bag","bank","band"]

       Output: "ba"
       
       Input: strs = ["dance","dag","danger","damage"]

       Output: "da"
     */

    public static String longestCommonPrefix(String[] sarr) {
        
    	if(sarr == null || sarr.length<1)
    		return "";
    	
    	String st = sarr[0];
    	int n = sarr.length-1;
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i=0; i<st.length(); i++) {    // "bat","bag","bank","band"
    		
    		char c1 = st.charAt(i);
    		int cnt = 0;
    		
    		for(int j=1; j<sarr.length; j++) {
    			
    			String st1 = sarr[j];
    			
    			if(i>st1.length()-1) {
    				continue;
    			}
    			
    			char c2 = sarr[j].charAt(i);
    			
    			if(c1 == c2) {
    				cnt++;
    			}else {
    				if(cnt == 0) {
    					return "";
    				}
    			}
    			
    		}
    		if(cnt == n) {
    			sb.append(c1);
    		}
    		
    	}
    	
    	return sb.toString();
    	
    }


    public static String longestCommonPrefixNew(String[] sarr) {
    	
    	if(sarr == null || sarr.length<1)
    		return "";
    	
    	for(int i=0; i<sarr.length; i++) {
    		
    		for(String s : sarr) {
    			
    			if(i == s.length() || s.charAt(i) != sarr[0].charAt(i)) {
    				return s.substring(0, i);
    			}
    			
    		}
    		
    	}
    	
    	return "";
    	
    }

    
	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4,5,6};
		
		String[] sarr = {"dance","dan","danger","danage"};
		System.out.println(longestCommonPrefixNew(sarr));
		
	}

}
