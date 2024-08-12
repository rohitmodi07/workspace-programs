package challenges.allarray;

import java.util.Stack;

public class PolishNotationResult {


	public static int findResultFromGivenExppression(String polishnotation) {
	  String notation = "+-*/";
	  Stack<String> stk = new Stack<>();
	 
	  if(polishnotation.isEmpty()) {
	    return 0;
	  }
	  for (int i = 0; i < polishnotation.length(); i++) {
	 
		  String cstr = String.valueOf(polishnotation.charAt(i));
		  if(!notation.contains(cstr)) {
		      stk.push(cstr);
		  }else {
			  int val1 = Integer.parseInt(stk.pop());
			  int val2 = Integer.parseInt(stk.pop());
			 
			  switch(cstr) {
			     
			    case "+" :
			         stk.push(String.valueOf(val1+val2));
			         break;
			   
			    case "-" :
			         stk.push(String.valueOf(val1-val2));
			         break;
			   
			    case "*" :
			         stk.push(String.valueOf(val1*val2));
			         break;
			   
			    case "/" :
			         stk.push(String.valueOf(val2/val1));
			         break;
			   
			    default :
			         System.out.println("invalid operator:::");
			         break;
			  }
		  }
	  }
	  return Integer.parseInt(stk.pop());
	 
	}
	
	public static int findResultFromGivenExppressionInLessThanJAVA8(String polishnotation) {
		  String notation = "+-*/";
		  Stack<String> stk = new Stack<>();
		 
		  if(polishnotation.isEmpty()) {
		    return 0;
		  }
		  for (int i = 0; i < polishnotation.length(); i++) {
		 
			  String cstr = String.valueOf(polishnotation.charAt(i));
			  if(!notation.contains(cstr)) {
			      stk.push(cstr);
			  }else {
				  int val1 = Integer.parseInt(stk.pop());
				  int val2 = Integer.parseInt(stk.pop());
				  
				  int indx = notation.indexOf(cstr);
				  switch(indx) {
				     
				    case 0 :
				         stk.push(String.valueOf(val1+val2));
				         break;
				   
				    case 1 :
				         stk.push(String.valueOf(val1-val2));
				         break;
				   
				    case 2 :
				         stk.push(String.valueOf(val1*val2));
				         break;
				   
				    case 3 :
				         stk.push(String.valueOf(val2/val1));
				         break;
				   
				    default :
				         System.out.println("invalid operator:::");
				         break;
				  }
			  }
		  }
		  return Integer.parseInt(stk.pop());
		 
		}

	public static void main(String[] args) {
	  
		System.out.println(findResultFromGivenExppression("25244/+*+"));
		System.out.println(findResultFromGivenExppressionInLessThanJAVA8("25244/+*+"));

	}

}
