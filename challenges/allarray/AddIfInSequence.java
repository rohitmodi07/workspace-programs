package challenges.allarray;

import java.util.Stack;

public class AddIfInSequence {
	private Stack<Integer> stk;

	public AddIfInSequence(Stack<Integer> stk) {
	  this.stk = stk;
	}

	public String checkTheSequence(int item) {
	    if(item<0)
	       return null;
		if(stk.isEmpty()) {
		   stk.push(item);
		   return "number "+item+" successfully added ";
		}
		int val = stk.peek();
		if(item == (val+1)) {
		   stk.push(item);
		}else {
		  return "number "+item+ " not in sequence";
		}
		return "number "+item+" successfully added ";
	}

	public static void main(String[] args) {
		

		Stack<Integer> stk = new Stack<>();
		AddIfInSequence asn = new AddIfInSequence(stk);
	
		System.out.println(asn.checkTheSequence(4));
	
		System.out.println(asn.checkTheSequence(5));
	
	
		System.out.println(asn.checkTheSequence(6));
	
		System.out.println(asn.checkTheSequence(8));
	
		System.out.println(asn.checkTheSequence(9));
		System.out.println("Final stack ::::::::"+asn.stk);

	}
	

}
