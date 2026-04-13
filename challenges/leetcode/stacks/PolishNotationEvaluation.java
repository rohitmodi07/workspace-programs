package leetcode.stacks;

import java.util.Stack;

public class PolishNotationEvaluation {
	
	public static int eveluatePolishNotation(String[] sarr) {
		if(sarr == null || sarr.length<1)
			return -1;
		Stack<String> st = new Stack<>();
		String ops = "+-*/";
		
		for(int i=0; i<sarr.length; i++) {
			String val = sarr[i];
			if(!ops.contains(val)) {
				st.push(val);
			}else {
				
				switch(val) {
				
				case "+": 
					
					st.push(String.valueOf(Integer.parseInt(st.pop())+Integer.parseInt(st.pop())));
					break;
					
				case "-": 
					int val1 = Integer.parseInt(st.pop());
					int val2 = Integer.parseInt(st.pop());
					st.push(String.valueOf(val2-val1));
					break;
					
				case "*": 
					st.push(String.valueOf(Integer.parseInt(st.pop())*Integer.parseInt(st.pop())));	
					break;
					
				case "/": 
					int val3 = Integer.parseInt(st.pop());
					int val4 = Integer.parseInt(st.pop());
					st.push(String.valueOf(val4/val3));	
					break;
					
				default:
					System.out.println(" operation not supported ");
				}
				
			}
			
			
			
		}
		return Integer.parseInt(st.pop());
	
	}
    

	public static void main(String[] args) {

		String[] sarr = {"1","2","+","3","*","4","-"};
		
		System.out.println(" result of polish notation ::: "+eveluatePolishNotation(sarr));
		
	}

}
