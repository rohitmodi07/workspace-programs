package leetcode.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	
	public static int minNumSeqTranformWord(String bWord, String eWord, String[] wordList) {
		if(bWord.isEmpty() || eWord.isEmpty() || wordList == null || wordList.length<1)
			return -1;
		
		int len = 0;
		boolean doesMatch = false;
		
		for(String st : wordList) {
			char[] carr = st.toCharArray();
			int count = 0;
			
			for(char c : carr) {
				if(bWord.contains(c+"")) {
					count++;
				}
				if(count >= bWord.length()-1) {
					bWord = st;
					len++;
				}
			}
			if(bWord.equals(eWord)) {
				doesMatch = true;
				break;
			}
		}
		
		if(doesMatch) {
			return len;
		}
		
		return 0;
		
	}
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;
        Set<String> words = new HashSet<>(wordList);
        int res = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        
        while (!q.isEmpty()) {
            res++;
            for (int i = q.size(); i > 0; i--) {
                String node = q.poll();
                if (node.equals(endWord)) return res;
                for (int j = 0; j < node.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == node.charAt(j)) continue;
                        String nei = node.substring(0, j) + c + node.substring(j + 1);
                        if (words.contains(nei)) {
                            q.offer(nei);
                            words.remove(nei);
                        }
                    }
                }
            }
        }
        return 0;
    }
	
	


	public static void main(String[] args) throws InterruptedException {
		
		String beginWord = "cat";
		String endWord = "sag";
		
		String[] wordList = {"bat", "bag", "sag", "dag", "dot"};
		String[]wlist = {"bat","bag","sat","dag","dot"};
		
		System.out.println(" sequence length :::: "+minNumSeqTranformWord(beginWord, endWord, wordList));
		System.out.println(" sequence length :::: "+minNumSeqTranformWord(beginWord, endWord, wlist));
		
	}

}
