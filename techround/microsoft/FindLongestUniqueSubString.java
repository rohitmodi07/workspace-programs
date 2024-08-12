package techround.microsoft;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindLongestUniqueSubString {
	
	//sliding window approach
	
	public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while(j < s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if(map.size() == j - i + 1){
                max = Math.max(max, j - i + 1);
                j++;
            }
            else if(map.size() < j - i + 1){
                while(map.size() < j - i + 1){
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                    i++;
                }
                j++;
            }
        }
        return max;
    }
	
	public static String getTheLongestUniqueSubString(String str) {
		 if(str == null || str.length()<1)
			 return "";
		 
		 String uniqueSunString = "";
		 
		 for (int i = 0; i < str.length(); i++) {
			Set<Character> hset = new HashSet<>();
			StringBuffer sb = new StringBuffer();
			
			hset.add(str.charAt(i));
			sb.append(str.charAt(i));
			
			for (int j = i+1; j < str.length(); j++) {
				if(hset.contains(str.charAt(j))) {
					break;
				}else {
					hset.add(str.charAt(j));
					sb.append(str.charAt(j));
				}
			}
			
			if(uniqueSunString.length()<sb.length()) {
				uniqueSunString = sb.toString();
			}
			
		}
		 
		 return uniqueSunString;
	}
	

	public static void main(String[] args) {
		                       
		System.out.println(" running -----");
		System.out.println(getTheLongestUniqueSubString("abcadaba"));
		
		System.out.println(getTheLongestUniqueSubString("bbbb"));
		
	}

}
