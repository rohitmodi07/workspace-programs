package leetcode.slidingWindow;

import java.util.Arrays;

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
	

	public static void main(String[] args) {

		
		System.out.println(" does contains :::: "+permutationString("abc", "leeecab"));
		System.out.println(" does contains :::: "+permutationString("abc", "lecaabee"));
		
		
	}

}
