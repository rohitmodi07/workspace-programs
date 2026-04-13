package leetcode.stacks;

import java.util.Stack;

public class MinStack {

	private Stack<Integer> stack;
	
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int getMin() {
        return stack.parallelStream().mapToInt(val -> val).min().getAsInt();
    }
    
    public static void main(String[] args) {
		
    	MinStack ms = new MinStack();
    	ms.push(1);
    	ms.push(2);
    	ms.push(3);
    	ms.push(4);
    	
    	System.out.println(" queue is :::: "+ms.stack);
    	
    	ms.pop();
    	System.out.println(" queue is :::: "+ms.stack);
    	
    	System.out.println(" top most value is :::: "+ms.top());
    	
    	System.out.println(" min value is :::: "+ms.getMin());
    	
    	
	}

}
