package challenges.allarray;

import java.util.HashSet;
import java.util.Set;

public class FIndLongestUniqueSubString {
	
	public static String getLongSubStrNonRepCharString(String str) {
		if(str == null || str.isEmpty())
			return null;
		String lstr = "";
		
		for(int i=0; i<str.length();i++) {
			StringBuilder sb = new StringBuilder();
			Set<Character> cset = new HashSet<>();
			
			cset.add(str.charAt(i));
			sb.append(str.charAt(i));
			
			for(int j=i+1; j<str.length(); j++) {
				
				if(!cset.add(str.charAt(j))) {
					
					break;
					
				}else {
					sb.append(str.charAt(j));
				}
			}
			lstr = lstr.length()<sb.length() ? sb.toString() : lstr;

		}
		return lstr;
	}
	

	public static void main(String[] args) {
		
		System.out.println(" longest non repeatative sub string :: "+getLongSubStrNonRepCharString("abbcbca"));
	   
    }

}
