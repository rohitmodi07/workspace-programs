package leetcode.stacks;

import java.util.Stack;

public class ValidParentheses {
	
	public static boolean validParentheses(String st) {
		if(st == null || st.isEmpty())
			return false;
		
		Stack<Character> stk = new Stack<>();
		
		for(int i=0; i<st.length(); i++) {
			char c = st.charAt(i);
			if('{' == c || '[' == c || '(' == c) {
				stk.push(c);
			}
			if(('}' == c && '{' == stk.peek()) || (']' == c && '[' == stk.peek()) || (')' == c && '(' == stk.peek())) {
				stk.pop();
			}
		}
		return stk.size() == 0;
	}
	
	

	public static void main(String[] args) {

		System.out.println(" valid parentheses :::: "+validParentheses("{[]}"));
		System.out.println(" valid parentheses :::: "+validParentheses("{}[]"));
		System.out.println(" valid parentheses :::: "+validParentheses("{[(]}"));
		System.out.println(" valid parentheses :::: "+validParentheses("{[("));
		
	}

}
