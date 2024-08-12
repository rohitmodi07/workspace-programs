package techround;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class CustomStack {
	
	private List<Integer> numlist;
	private int size;
	
	public CustomStack(int size) {
		this.size = size;
		this.numlist = new LinkedList<>();
	}
	
	
	//stack, push, pop, peak 
	
	public boolean push(int value) {  //1,2,3,4,5,6
		
		numlist.add(value);
		return true;
		
	}
	
	public boolean pop() {
		numlist.remove(numlist.size()-1);
		return true;
	}
	
	public int peak() {
		return numlist.get(numlist.size()-1);
	}

	public static void main(String[] args) {
		
		CustomStack customeStk = new CustomStack(10);
		customeStk.push(1);
		customeStk.push(2);
		customeStk.push(3);
		customeStk.push(4);
		customeStk.push(5);
		
		System.out.println(customeStk.numlist);
		
		System.out.println(customeStk.pop());
		
		System.out.println(customeStk.numlist);
		
		System.out.println(customeStk.peak());
		
		
		

	}

}
