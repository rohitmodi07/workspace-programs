package leetcode.slidingWindow;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongSubStringNonRepChar {
	
	// Longest Substring Without Repeating Characters
		/*
		 * Input: s = "zxyzxyz"       Output: 3
		 * Input: s = "xxxx"          Output: 1
		 */
		
		public static int longSubStringWORepChar(String str) {
			if(str == null || str.isEmpty())
				return -1;
			Set<Character> cset = new HashSet<>();
			String lstr = "";
			StringBuilder sb = new StringBuilder();
			int k=0;
			
			for(int i=k; i<str.length(); i++) {
				char c = str.charAt(i);
				if(!cset.contains(c)) {
					cset.add(c);
					sb.append(c);
				}else {
					k = k+1;
					i=k;
					if(lstr.length()<=sb.toString().length()) {
						lstr = sb.toString();
					}
					sb = new StringBuilder();
					cset = new HashSet<>();
				}
			}
			System.out.println(" longest substring without repeating character :::: "+lstr);
			
			return lstr.length();
		}
		
		public static int longUniqueSubString(String st) {  // abcabcbb
			if(st == null || st.isEmpty())
				return -1;
			Set<Character> iset = new LinkedHashSet<>();
			int i=0;
			int j=0;
			
			int maxLen = 0;
			StringBuilder sb = new StringBuilder();
			String lstr = "";
			
			while(i<st.length()) {
				if(!iset.add(st.charAt(i))) {
					j++;
					i = j;
					maxLen = Math.max(maxLen, iset.size());
					for(Character c : iset) {
						sb.append(c);
					}
					if(lstr.length()<sb.length()) {
						lstr = sb.toString();
					}
					iset = new LinkedHashSet<>();
					sb = new StringBuilder();
				}else {
					i++;
				}
			}
			System.out.println(" longest str ::: "+lstr);
			return maxLen;
			
		}
		

		
		

		public static void main(String[] args) {

			
			System.out.println(" longest substring non repeating character :::: "+longSubStringWORepChar("zxyzxyz"));
			
		}

}
