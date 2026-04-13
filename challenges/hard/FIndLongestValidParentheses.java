package challenges.hard;

public class FIndLongestValidParentheses {
	
	public static int findMaxValidParentheses(String prts) {
		if(prts == null || prts.length()<1)
			return -1;
		
		int maxlen = 0;
		
		char[] carr = prts.toCharArray();
		
		int i=0;
		int j=carr.length-1;
		int count = 0;
		
		while(i<=j) {
			
			if((carr[i] == '{' && carr[j] == '}') || (carr[i] == '[' && carr[j] == ']') || 
					(carr[i] == '(' && carr[j] == ')')) {
				count++;
				
			}else {
				maxlen = Math.max(maxlen, count);
				count = 0;
			}
			
			i++;
			j--;
			
		}
		
		maxlen = Math.max(maxlen, count);
		
		return maxlen;
		
	}
	

	public static void main(String[] args) {
		
		System.out.println(findMaxValidParentheses("[{([([{()}])})}]"));
		
	}

}
