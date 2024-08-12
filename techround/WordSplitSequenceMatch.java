package techround;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSplitSequenceMatch {
	
	public static boolean CheckWordCanSplit(List<String> dict, String words) {
		if(dict.size()<1 || words == null)
			return false;
		
		Set<String> dictset = new HashSet<>(dict);
		
		int match = 0;
		int strlen = 0;
		
		for(String word : dictset) {
			
			String str = strlen != words.length() ? words.substring(strlen, word.length()+strlen) : "";
			
			if(word.equals(str)) {
				strlen += word.length();
				match++;
				
			}
		}
		
		return match == dictset.size() ? true : false;
		
		
	}
	
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
	

    private static boolean computeCheck(String source, String destination) {
		char[] c1 = source.toCharArray();
		char[] c2 = destination.toCharArray();
		return Arrays.equals(c1, c2);
	}
	

	public static void main(String[] args) {
		
		List<String> dict = Arrays.asList("leet","code", "etc");
		System.out.println(" words matches dictionary  ::: "+CheckWordCanSplit(dict, "leetcode"));
		
		List<String> dict1 = Arrays.asList("apple","pen");
		System.out.println(" words matches dictionary  ::: "+CheckWordCanSplit(dict1, "applepenapple"));
		
		List<String> dict2 = Arrays.asList("cats","dog","sand","and","cat");
		System.out.println(" words matches dictionary  ::: "+CheckWordCanSplit(dict2, "catsanddog"));
		
	}

}
