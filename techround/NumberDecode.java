package techround;

public class NumberDecode {
	
	public static int numDecodings(String s) {
	     int n = s.length(), oneStep = 1, twoStep = 0;
		 if(n==0 || s.charAt(0)=='0') 
			 return 0;
		 for(int i=1;i<n;i++){
			  int oneDigit = Character.getNumericValue(s.charAt(i));
			  int twoDigit = Character.getNumericValue(s.charAt(i-1))*10 + oneDigit;
	          int curStep = 0;
	          
			  if(oneDigit != 0) 
				  curStep+=oneStep; 
			  if(twoDigit >=10 && twoDigit <= 26){
					if(i<2) curStep++; // two step is not evaluated until after 2 steps
					else curStep+=twoStep;
				}
	            twoStep = oneStep;
	            oneStep = curStep;
			}	
			return oneStep;
	}
	
	public static int numDecodings1(String s) {
       if (s == null || s.length() == 0) {
           return 0;
       }
       int n = s.length();
       int[] dp = new int[n + 1];
       dp[0] = 1;
       dp[1] = s.charAt(0) != '0' ? 1 : 0;
       for (int i = 2; i <= n; i++) {
           int first = Integer.valueOf(s.substring(i - 1, i));
           int second = Integer.valueOf(s.substring(i - 2, i));
           if (first >= 1 && first <= 9) {
              dp[i] += dp[i-1];  
           }
           if (second >= 10 && second <= 26) {
               dp[i] += dp[i-2];
           }
       }
       return dp[n];
   }
	
	public static void main(String[] args) {
		
		System.out.println(numDecodings("126"));
		
	}

}
