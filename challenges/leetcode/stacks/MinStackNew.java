package leetcode.stacks;

import java.util.Stack;

public class MinStackNew {

	
	private Stack<Integer> stk;
	private Stack<Integer> minStk;
	
	public MinStackNew() {
		this.stk = new Stack<>();
		this.minStk = new Stack<>();
	}
	
	public void push(int val) {
		stk.push(val);
		
		if(minStk.isEmpty() || val<minStk.peek()) {
			minStk.push(val);
		}
	}
	
	public int pop() {
		if(stk.peek() == minStk.peek()) {
			minStk.pop();
		}
		return stk.pop();
	}
	
	public int top() {
		return stk.peek();
	}
	
	public int getMin() {
		return minStk.peek();
	}
	
}
