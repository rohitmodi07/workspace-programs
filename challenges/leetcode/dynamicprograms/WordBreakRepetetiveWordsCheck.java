package leetcode.dynamicprograms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import stages.TestProgram;

public class WordBreakRepetetiveWordsCheck {
	
// word break
	
    public static boolean wordBreak(String st, List<String> wordDict) {
        
    	if(wordDict == null || wordDict.isEmpty() || st == null || st.isEmpty())
    		return false;
    	
    	Set<String> stset = new HashSet<>();
    	
    	int k=0;
    	
    	for(int i=0; i<wordDict.size(); i++) {
    		
    		String st1 = wordDict.get(i);
    		int st1len = st1.length();
    		stset.add(st1);
    		
    		if((i == wordDict.size()-1) && st1.length()<st.subSequence(k, st.length()).length()) {
    			if(stset.contains(st.subSequence(k, st.length()))) {
    				return true;
    			}
    		}
    		
    		String st2 = st.substring(k, k+st1len);
    		
    		System.out.println(" String 1 :::: "+st1);
    		System.out.println(" String 2 :::: "+st2);
    		
    		boolean isSame = checkForSimilarWord(st1, st2);
    		if(!(isSame || stset.contains(st2))) {
    			return false;
    		}
    		System.out.println(" set is :::: "+stset);
    		k = k+st1len;
    		
    	}
    	return true;
    	
    }


	private static boolean checkForSimilarWord(String st1, String substring) {
		if(st1.equals(substring)) {
			return true;
		}
		return false;
	}
	
	public static boolean wordBreakNew(String st, String[] sarr) {
		if(sarr == null || sarr.length<1 || st == null || st.isEmpty())
			return false;
		
		int k=0;
		Set<String> wset = new HashSet<>();
		
		for(int i=0; i<sarr.length; i++) {
			String s1 = sarr[i];
			int s1len = s1.length();
			wset.add(s1);
			
			if(k>=st.length()) {
				break;
			}
			
			String s2 = st.substring(k, k+s1len);
			
			if(!s1.equals(s2)) {
				if(findSameWord(k, st, wset)) {
					return true;
				}
				return false;
			}
			k = k+s1len;
		}
		return true;
	}
	

	private static boolean findSameWord(int currentIndex, String st, Set<String> wset) {
		
		for(String s : wset) {
			if(currentIndex>=st.length()) {
				return true;
			}else if(currentIndex+s.length()>st.length()) {
				return false;
			}
			
			String nextSt = st.substring(currentIndex, currentIndex+s.length());
			System.out.println(" nextSt :: "+nextSt);
			if(!wset.contains(nextSt)) {
				return false;
			}
			currentIndex = currentIndex + s.length();
		}
		return true;
		
	}
	
	public static boolean wordBreakDP(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if ((i + w.length()) <= s.length() &&
                     s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = dp[i + w.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[0];
    }


	public static void main(String[] args) {
		
		TestProgram tp = new TestProgram();
		
		List<String> sarr = Arrays.asList("leet", "code");
		
        //System.out.println(" word break :::: "+wordBreak("leetcode", sarr));
        
        List<String> sarr1 = Arrays.asList("apple", "pen", "ape");
		
        System.out.println(" word break :::: "+wordBreakNew("applepenpen", new String[] {"apple", "pen", "ape"}));
      
	}

}
