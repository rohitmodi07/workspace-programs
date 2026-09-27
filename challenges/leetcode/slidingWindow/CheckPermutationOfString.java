package leetcode.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckPermutationOfString {
	
	public static boolean permutationString(String s1, String s2) {
		if(s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty())
			return false;
		
		char[] c1 = s1.toCharArray();
		Arrays.sort(c1);
		
		int i=0;
		int size = s1.length();
		
		while(i<s2.length()-(size-1)) {
			String st = s2.substring(i, i+size);
			System.out.println(" st :::: "+st);
			char[] c2 = st.toCharArray();
			Arrays.sort(c2);
			
			if(Arrays.equals(c1, c2)) {
				return true;
			}
			i++;
		}
		
		return false;
	}
	
	public static boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s1.isBlank() || s2 == null || s2.isBlank() || s1.length()>s2.length())
        	return false;
        
        List<String> clist = new ArrayList<>();
        
        for(char c : s1.toCharArray()) {
        	clist.add(c+"");
        }
        
        int k=0;
        
        for(int i=0; i<s2.length(); i++) { // Input: s1 = "abc", s2 = "lecabee"
        	
        	String c = String.valueOf(s2.charAt(i));
        	
        	if(clist.contains(c)) {
        		
        		int j=i;
        		int p=i+s1.length();
        		
        		List<String> templist = new ArrayList<>();
        		templist.addAll(clist);
        		
        		
        		while(j<p) {
        			String c1 = String.valueOf(s2.charAt(j));
        			if(templist.contains(c1)) {
        				templist.remove(c1);
        			}
        			System.out.println(templist);
        			j++;
        		}
        		if(templist.isEmpty()) {
        			return true;
        		}
        		
        	}
        	
        }
        
        return false;
    }
	
	public static boolean checkInclusionNew(String s1, String s2) {
        if(s1 == null || s1.isBlank() || s2 == null || s2.isBlank() || s1.length()>s2.length())
        	return false;
        
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        int k=0;
        
        int len = s2.length()-s1.length();
        
        for(int i=0; i<len; i++) {    // Input: s1 = "abc", s2 = "lecabee"
        	
        	String temp = s2.substring(i, i+c1.length);
        	char[] c2 = temp.toCharArray();
        	Arrays.sort(c2);
        	
        	if(Arrays.equals(c1, c2)) {
        		return true;
        	}
        	
        }
        return false;
    }
	

	public static void main(String[] args) {

		
		System.out.println(" does contains :::: "+permutationString("abc", "leeecab"));
		System.out.println(" does contains :::: "+permutationString("abc", "lecaabee"));
		
		
	}

}
