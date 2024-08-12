package techround;


public class AddingTwoLinkedList {

	private static class Node {
		Node next;
		int val;
		
		public Node(int val) {
		  this.val = val;
		}
		
		public Node getNext() {
		  return next;
		}
		
		public void setNext(Node next) {
		  this.next = next;
		}
		
		public int getVal() {
		  return val;
		}
		
		public void setVal(int val) {
		  this.val = val;
		}
	
	}
	static Node head;
	
	//insert a node in linked list
	
	public boolean insertItemInLinkedList(int val) {
		if(val<=0)
		   return false;
		if(head == null) {
		  head = new Node(val);
		  return true;
		}
		Node temp = new Node(val);
		Node cur = head;
		while(cur.getNext()!=null) {
		  cur = cur.getNext();
		}
		cur.setNext(temp);
		return true;
	
	}
	
	//reverse the linked list
	
	public Node reverseLinkedList(Node head) {
		if(head == null)
		   return null;
		Node cur = head;
		Node next = null;
		Node prev = null;
		
		while(cur!=null) {
			next = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = next;
		}
		head = prev;
		return head;
	}
	
	//add two linked list
	public Node addTwoLinkedList(Node node1, Node node2) {
		Node temp = new Node(0);
		Node node3 = temp;
		int carry = 0;
		
		while(node1!=null || node2!=null) {
			int val1 = node1!=null ? node1.getVal() : 0;
			int val2 = node2!=null ? node2.getVal() : 0;
			
			int sum = val1 + val2 + carry;
			
			carry = sum/10;
			int digit = sum%10;
			Node tmp = new Node(digit);
			node3.setNext(tmp);
			node3 = node3.getNext();
			
			if(node1!=null)
			   node1 = node1.getNext();
			if(node2!=null)
			   node2 = node2.getNext();
			
		}
		if(carry>0) {
			Node tmp = new Node(carry);
			node3.setNext(tmp);
		}
		return temp;
	}
	
	//add two linked list
	public Node addTwoLinkedListAfterReversing(Node node1, Node node2) {
		Node temp = new Node(0);
		Node node3 = temp;
		int carry = 0;
		node1 = reverseLinkedList(node1);
		node2 = reverseLinkedList(node2);
		
		while(node1!=null || node2!=null) {
			int val1 = node1!=null ? node1.getVal() : 0;
			int val2 = node2!=null ? node2.getVal() : 0;
			
			int sum = val1 + val2 + carry;
			
			carry = sum/10;
			int digit = sum%10;
			Node tmp = new Node(digit);
			node3.setNext(tmp);
			node3 = node3.getNext();
			
			if(node1!=null)
			   node1 = node1.getNext();
			if(node2!=null)
			   node2 = node2.getNext();
			
		}
		if(carry>0) {
		  Node tmp = new Node(carry);
		  node3.setNext(tmp);
		}
		return temp;
	}
	
	public static void main(String[] args) {
	
	//following code is for 1st way of adding two numbers, numbers are 743 and 321, but the list passed with numbers in reverse order 347 and 123
	// sum should be 1064
	
		head = new Node(3);
		AddingTwoLinkedList ll = new AddingTwoLinkedList();
		ll.insertItemInLinkedList(4);
		ll.insertItemInLinkedList(7);
		
		Node node1 = head;
		
		head = new Node(1);
		ll.insertItemInLinkedList(2);
		ll.insertItemInLinkedList(3);
		
		Node node2 = head;
		
		Node tempo = ll.addTwoLinkedList(node1, node2);
		StringBuffer sbuf = new StringBuffer();
		while(tempo.getNext()!=null) {
		
			tempo = tempo.getNext();
			sbuf.append(tempo.getVal());
		}
		System.out.println(sbuf.reverse().toString());
			
		//following code is for 2nd way of adding two numbers, here numbers and list both contains number 347 and 123 in the same 
		//order, to find the sum we have to reverse the list and then perform addition, sum should be 470
			
		head = new Node(3);
			
		ll.insertItemInLinkedList(4);
		ll.insertItemInLinkedList(7);
			
		Node node3 = head;
			
		head = new Node(1);
		ll.insertItemInLinkedList(2);
		ll.insertItemInLinkedList(3);
			
		Node node4 = head;
			
		Node tempor = ll.addTwoLinkedListAfterReversing(node3, node4);
		StringBuffer sbuff = new StringBuffer();
		while(tempor.getNext()!=null) {
			tempor = tempor.getNext();
			sbuff.append(tempor.getVal());
		}
		System.out.println(sbuff.reverse().toString());
	
	}

}
