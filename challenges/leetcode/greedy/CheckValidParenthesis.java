package leetcode.greedy;


public class CheckValidParenthesis {
	
	public static boolean checkValidParenthesis(String st) {
		if(st == null || st.isEmpty())
			return false;
		
		int i=0;
		int j=st.length()-1;
		
		while(i<=j) {
			char c1 = st.charAt(i);
			char c2 = st.charAt(j);
			
			if((c1 == '(' && c2 == ')') || (c1 == '(' && c2 == '*') || (i == j && c1 == '*')) {
				i++;
				j--;
				continue;
			}else {
				return false;
			}
			
		}
		
		return true;
	}

	public static void main(String[] args) throws InterruptedException {
		
		
		System.out.println(checkValidParenthesis("(((**"));
		System.out.println(checkValidParenthesis("(((*))"));
		System.out.println(checkValidParenthesis("((*)"));
		
	}

}
