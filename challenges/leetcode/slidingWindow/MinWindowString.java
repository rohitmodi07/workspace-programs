package leetcode.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWindowString {
	
	// minimum window substring
	   /*
	    * Input: s = "OUZODYXAZV", t = "XYZ"    Output: "YXAZ"
	    */
		
		public static String minWindow(String s, String t) {
	        if(s == null || s.isEmpty() || t == null || t.isEmpty())
	        	return "";
	        if(s.equals(t))
	        	return s;
	        char[] c = t.toCharArray();
	        StringBuilder sb = new StringBuilder();
	        
	        Set<Character> cset = new HashSet<>();
	        for(char k : c) {
	        	cset.add(k);
	        }
	        
	        String maxSubS = s;
	        
	     
	        	
	    	Set<Character> cset1 = new HashSet<>();
	    	
	    	for(int j=0; j<s.length()-1; j++) {   // Input: s = "OUZODYXAZV", t = "XYZ"    Output: "YXAZ"
	    		
	    		char cs = s.charAt(j);
	    		
	    		if(cset.contains(cs)) {
	    			cset1.add(cs);
	    			sb.append(cs);
	    			int k = j+1;
	    			while(cset1.size()<t.length() && k<=s.length()-1) {
	    				sb.append(s.charAt(k));
	    				if(cset.contains(s.charAt(k))) {
	    					cset1.add(s.charAt(k));
	    				}
	    				k++;
	    			}
	    			if(maxSubS.length()>sb.length()) {
	    				maxSubS = sb.toString();
	    				sb = new StringBuilder();
	    				cset1 = new HashSet<>();
	    			}
	    			
	    		}
	    	}
	    	
	    	return maxSubS.length()>=t.length() ? maxSubS : "";
	        	
	        	
	    }
		
		public String minWindowNeetCode(String s, String t) {
	        if (t.isEmpty()) return "";

	        Map<Character, Integer> countT = new HashMap<>();
	        Map<Character, Integer> window = new HashMap<>();
	        for (char c : t.toCharArray()) {
	            countT.put(c, countT.getOrDefault(c, 0) + 1);
	        }

	        int have = 0, need = countT.size();
	        int[] res = {-1, -1};
	        int resLen = Integer.MAX_VALUE;
	        int l = 0;

	        for (int r = 0; r < s.length(); r++) {
	            char c = s.charAt(r);
	            window.put(c, window.getOrDefault(c, 0) + 1);

	            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
	                have++;
	            }

	            while (have == need) {
	                if ((r - l + 1) < resLen) {
	                    resLen = r - l + 1;
	                    res[0] = l;
	                    res[1] = r;
	                }

	                char leftChar = s.charAt(l);
	                window.put(leftChar, window.get(leftChar) - 1);
	                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
	                    have--;
	                }
	                l++;
	            }
	        }

	        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
	    }
		
		public static String minWindowNew(String s, String t) {
	        if(s == null || s.isEmpty() || t == null || t.isEmpty() || s.length()<t.length())
	        	return "";
	        
	        Set<Character> cset = new HashSet<>();
	        for(char c : t.toCharArray()) {
	        	cset.add(c);
	        }
	        
	        int k=0;
	        
	        String maxSt = s;
	        
	        for(int i=0; i<s.length(); i++) {
	        	
	        	char c = s.charAt(i);
	        	if(cset.contains(c)) {
	        		int j=i+1;
	        		
	        		Set<Character> tset = new HashSet<>();
	        		StringBuilder sb = new StringBuilder();
	        		
	        		tset.add(c);
	        		sb.append(c);
	        		
	        		while(j<s.length()) {                       // Input: s = "OUZODYXAZV", t = "XYZ"
	        			char c1 = s.charAt(j);
	        			
	        			if(cset.size() == tset.size()) {
	        				maxSt = maxSt.length()>=sb.length() ? sb.toString() : maxSt;
	        				break;
	        			}
	        			
	        			if(cset.contains(c1)) {
	        				tset.add(c1);
	        			}
	        			sb.append(c1);
	        			j++;
	        		}
	        	}
	        }
	        return maxSt;
	    }

		public static void main(String[] args) {
			
			System.out.println(" shortest string which contains all character :::: "+minWindow("OUZODYXAZV", "XYZ"));
			System.out.println(" shortest string which contains all character :::: "+minWindow("XYZ", "XYZ"));
			System.out.println(" shortest string which contains all character :::: "+minWindow("X", "XY"));
	      
		}

}
