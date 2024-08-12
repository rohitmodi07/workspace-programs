package dynamicprog;

import java.util.Arrays;

public class WordDictionaryCheck {
	
	//Input: s = "leetcode", wordDict = ["leet","code"]
	
		public static boolean wordDicHasWord(String str, String[] wordDict) {
			
			if(str == null || str.isEmpty() || wordDict.length<1)
				return false;
			boolean stopProcessing = true;
			int j=0;
			for(int i=0; i<wordDict.length; i++) {
				
				String st = wordDict[i];
				System.out.println(" substring ::: "+str.substring(j, st.length()+j));
				stopProcessing = computeCheck(st, str.substring(j, st.length()+j));
				if(stopProcessing) {
					j = st.length();
				}else {
					return false;
				}
				
			}
			
			return true;
			
		}
		
		public static boolean findWordsInDictionary(String str, String[] words) {
			if(str == null || str.isEmpty() || words.length<1)
				return false;
			int match = 0;
			int strlen = 0;
			
			for(String word : words) {
				String st = strlen != str.length() ? str.substring(strlen, word.length()+strlen) : "";
				
				if(word.equals(st)) {
					strlen = strlen + word.length();
					match++;
				}
			}
			return match == words.length ? true : false;
		}
		

	    private static boolean computeCheck(String source, String destination) {
			char[] c1 = source.toCharArray();
			char[] c2 = destination.toCharArray();
			return Arrays.equals(c1, c2);
		}


		public static void main(String[] args) {
	    	
			String[] sarr = {"leet", "code"};
	    	
			System.out.println(" does dictionary has words :::: "+wordDicHasWord("leetcode", sarr));
			
	        String[] sarr1 = {"apple", "pen"};
	    	
			System.out.println(" does dictionary has words :::: "+wordDicHasWord("applepen", sarr1)); 
	    	
	        
	    }

}
