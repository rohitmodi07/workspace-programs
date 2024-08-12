package challenges.allarray;

public class FindLongestPalindrome {
	
public static String getLongestPalindrome(String str) {
		
		if(str.isEmpty())
			return null;
        
        String longstr = "";
        
        for(int i = 0; i < str.length(); i++) {
        	
        	String temp = helper(str, i, i);
        	
        	if(temp.length()>longstr.length()) {
        		longstr = temp;
        	}
        	
        	temp = helper(str, i, i+1);
        	if(temp.length()>longstr.length()) {
        		longstr = temp;
        	}
        }
        
        return longstr;
        
	}
	
	public static String helper(String str, int begin, int end) {
		
		while(begin>=0 && end<=str.length()-1 && str.charAt(begin) == str.charAt(end)) {
			begin--;
			end++;
		}
		
        return str.substring(begin+1, end);
		
		
	}
	    
    public static void main(String[] args) {
    	
    	System.out.println(getLongestPalindrome("babcbabab"));
    }

}
