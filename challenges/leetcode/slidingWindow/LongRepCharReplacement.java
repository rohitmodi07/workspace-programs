package leetcode.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongRepCharReplacement {
	
	// Longest Repeating Character Replacement
		/*
		 * Input: s = "XYYX", k = 2           Output: 4
		 * Input: s = "AAABABB", k = 1        Output: 5
		 */
		
		public static int longRepCharSubString(String str, int k) {
			if(str == null || str.isEmpty())
				return -1;
			
			Set<Character> cset = new HashSet<>();
			StringBuilder sb = new StringBuilder();
			int res = 0;
			
			for(char c : str.toCharArray()) {
				cset.add(c);
			}
			
			System.out.println(" cset is :::: "+cset);
			
			for(char c : cset) { // Input: s = "AAABABB", k = 1        Output: 5
				
				int cnt = 0;
				int left=0;
				
				System.out.println(" c :::: "+c);
				
				for(int i=0; i<str.length(); i++) {
					
					if(str.charAt(i) == c) {
						cnt++;
					}
					
					System.out.println(" i :::: "+i);
					System.out.println(" count :::: "+cnt);
					System.out.println(" left :::: "+left);
					System.out.println(" condition value ::: "+((i-left+1)-cnt));
					
					while((i-left+1)-cnt > k) {
						if(str.charAt(left) == c) {
							cnt--;
						}
						left++;
					}
					
					res = Math.max(res, i-left+1);
					
				}
				
			}
		
			return res;
		}
		
		public static int longRepCharRepl(String str, int k) {
			if(str == null || str.isEmpty())
				return -1;
			
			int res = 0;
			int left = 0;
			
			int maxFrq = 0;
			
			Map<Character, Integer> nmap = new HashMap<>();
			
			for(int r=0; r<str.length(); r++) {
				char c = str.charAt(r);
				nmap.put(c, nmap.getOrDefault(c, 0)+1);
				
				maxFrq = Math.max(maxFrq, nmap.get(c));
				
				while((r-left+1) - maxFrq > k) {
					nmap.put(str.charAt(left), nmap.get(str.charAt(left))-1);
					left++;
				}
				
				res = Math.max(res, r-left+1);
				
			}
			return res;
		}
		
		

		public static void main(String[] args) {

			int[] nums = {10,1,5,6,7,1};
			
			System.out.println(" longest substring repeating character :::: "+longRepCharRepl("XYYX", 2));
			
		}

}
