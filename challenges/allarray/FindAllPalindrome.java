package challenges.allarray;

public class FindAllPalindrome {
	
public static int getAllPossiblePalindrom(String str) {
		
		if(str.isEmpty())
			return 0;
        
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
        	
        	count += helper(str, i, i);
        	count += helper(str, i, i+1);
        }
        
        return count;
        
	}
	
	public static int helper(String str, int begin, int end) {
		
		int count = 0;
		
		while(begin>=0 && end<=str.length()-1 && str.charAt(begin) == str.charAt(end)) {
			begin--;
			end++;
			count++;
		}
		return count;
		
	}
	    
    public static void main(String[] args) {
    	
    	System.out.println(getAllPossiblePalindrom("aaa"));
    	System.out.println(getAllPossiblePalindrom("abc"));
    }

}
