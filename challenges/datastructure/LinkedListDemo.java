package challenges.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import stages.TestProgram;


public class LinkedListDemo {
	
	private static class Node{
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
	}
	
	// insert end, front, mid, kth index from start, end
	
	public Node insertAtEnd(Node head, int data) {
		if(head == null) {
			head = new Node(data);
			return head;
		}
		Node temp = new Node(data);
		Node cur = head;
		
		while(cur.getNext() != null) {
			cur = cur.getNext();
		}
		cur.setNext(temp);
		return head;
	}
	
	public Node insertAtFront(Node head, int data) {
		if(head == null) {
			head = new Node(data);
			return head;
		}
		Node cur = head;
		Node temp = new Node(data);
		
		temp.setNext(cur);
		
		return temp;
	}
	
	public Node insertAtMid(Node head, int data) { // 1,2,3,4,5,6,7,8
		if(head == null) {
			head = new Node(data);
			return head;
		}
		Node slow = null;
		Node fast = head;
		Node cur = head;
		Node temp = new Node(data);
		
		
		while(fast.getNext() != null) {
			slow = cur;
			fast = fast.getNext().getNext();
			cur = cur.getNext();
		}
		temp.setNext(slow.getNext());
		slow.setNext(temp);
		
		return head;
	}
	
	public Node insertAtKthFirstNode(Node head, int data, int k) {
		
		if(head == null || k<0)
			return null;
		
		Node cur = null;
		Node temp = new Node(data);
		Node tmp = head;
		
		for(int i=0; i<k; i++) {
			if(tmp.getNext() != null) {
				cur = tmp;
				tmp = tmp.getNext();
			}
		}
		temp.setNext(cur.getNext());
		cur.setNext(temp);
		
		return head;
		
	}
	
	public Node insertAtKthLastNode(Node head, int data, int k) {
		
		if(head == null || k<0)
			return null;
		
		Node cur = head;
		Node kthNode = null;
		Node temp = new Node(data);
		Node tmp = head;
		
		for(int i=0; i<k; i++) {
			if(tmp.getNext() != null) {
				kthNode = tmp;
				tmp = tmp.getNext();
			}
		}
		
		while(kthNode.getNext() != null) {
			kthNode = kthNode.getNext();
			cur = cur.getNext();
		}
		
		temp.setNext(cur.getNext());
		cur.setNext(temp);
		
		
		return head;
	}
	
	// remove from front, end, mid, kth first, kth last
	
	public Node removeFromFront(Node head) {
		if(head == null)
			return null;
		Node cur = head;
		Node next = cur.getNext();
		
		return next;
	}
	
	public Node removeFromEnd(Node head) {
		if(head == null)
			return null;
		Node cur = head;
		Node prev = head;
		
		while(cur.getNext() != null) {
			prev = cur;
			cur = cur.getNext();
		}
		prev.setNext(null);
		return head;
	}
	
	public Node removeFromMid(Node head) { // 1,2,3,4,5,6,7,8
		if(head == null)
			return null;
		
		Node slow = null;
		Node tmp = head;
		Node fast = head;
		Node prev = head;
		
		while(fast != null && fast.getNext() != null) {
			prev = slow;
			slow = tmp;
			tmp = tmp.getNext();
			fast = fast.getNext().getNext();
		}
		
		prev.setNext(prev.getNext().getNext());
		return head;
	}
	
	public Node removekthFront(Node head, int k) {
		if(head == null)
			return null;
		
		Node cur = null;
		Node tmp = head;
		
		
		for(int i=0; i<k; i++) {
			if(tmp.getNext() != null) {
				cur = tmp;
				tmp = tmp.getNext();
			}
		}
		cur.setNext(cur.getNext().getNext());
		return head;
	}
	
    public Node removeAtKthLastNode(Node head, int k) {
		
		if(head == null || k<0)
			return null;
		
		
		Node kthNode = null;
		Node tmp = head;
		
		for(int i=0; i<k; i++) {
			if(tmp.getNext() != null) {
				kthNode = tmp;
				tmp = tmp.getNext();
			}
		}
		
		Node cur = null;
		Node temp = head;
		
		while(kthNode.getNext() != null) {
			kthNode = kthNode.getNext();
			cur = temp;
			temp = temp.getNext();
		}
		
		cur.setNext(cur.getNext().getNext());
		
		
		return head;
	}
    
    // move front to last, last to front
    
    public Node moveLastToFront(Node head) {
    	if(head == null)
    		return null;
    	Node cur = head;
    	Node last = head;
    	
    	while(last.getNext() != null) {
    		cur = last;
    		last = last.getNext();
    	}
    	cur.setNext(null);
    	last.setNext(head);
    	
    	return last;
    }
    
    public Node moveFrontToLast(Node head) {
    	if(head == null)
    		return null;
    	Node last = head;
    	Node cur = head;
    	
    	while(last.getNext() != null) {
    		last = last.getNext();
    	}
    	
    	Node next = cur.getNext();
    	cur.setNext(null);
    	last.setNext(cur);
    	
    	return next;
    }
    
    public Node reverseNode(Node head) {
    	if(head == null)
    		return head;
    	
    	Node cur = head;
    	Node prev = null;
    	Node next;
    	
    	while(cur != null) {
    		next = cur.getNext();
    		cur.setNext(prev);
    		prev = cur;
    		cur = next;
    	}
    	return prev;
    }
    
    public Node twoSum(Node node1, Node node2) {
    	if(node1 == null || node2 == null)
    		return null;
    	Node temp = new Node(0);
    	Node node3 = temp;
    	
    	int carry=0;
    	
    	while(node1 != null || node2 != null) {
    		
    		int val1 = node1 != null ? node1.getData() : 0;
    		int val2 = node2 != null ? node2.getData() : 0;
    		
    		int sum = val1+val2+carry;
    		
    		node3.setNext(new Node(sum%10));
    		carry = sum/10;
    		
    		node3 = node3.getNext();
    		
    		if(node1 != null) {
    			node1 = node1.getNext();
    		}
    		
    		if(node2 != null) {
    			node2 = node2.getNext();
    		}
    		
    	}
    	if(carry>0) {
    		node3.setNext(new Node(carry));
    	}
    	
    	return temp.getNext();
    }
    
    public Node mergeTwoList(Node node1, Node node2) {
    	if(node1 == null)
    		return node2;
    	if(node2 == null)
    		return node1;
    	
    	Node temp = new Node(-1);
    	Node node3 = temp;
    	
    	while(node1 != null && node2 != null) {
    		if(node1.getData()<node2.getData()) {
    			node3.setNext(node1);
    			node1 = node1.getNext();
    		}else if(node1.getData()>node2.getData()) {
    			node3.setNext(node2);
    			node2 = node2.getNext();
    		}else {
    			node3.setNext(node1);
    			node1 = node1.getNext();
    			node2 = node2.getNext();
    		}
    		node3 = node3.getNext();
    	}
    	node3.setNext(node1 == null ? node2 : node1);
    	
    	return temp.getNext();
    }
    
  //sort a linkedlist
	
	public Node sortLinkedList(Node head) {
		if(head == null)
			return null;
		Node cur = head;
		
		while(cur != null) {
			Node next = cur.getNext();
			Node minNode = cur;
			
			while(next != null) {
				if(next.getData()<minNode.getData()) {
					minNode = next;
				}
				
				next = next.getNext();
			}
			
			int temp = cur.data;
			cur.data = minNode.data;
			minNode.data = temp;
			
			
			cur = cur.getNext();
		}
		cur = head;
		return cur;
	}
	
	public Node sortLinkedList1(Node head) {
		if(head == null)
			return null;
		Node cur = head;
		
		List<Integer> ilist = new ArrayList<>();
		
		while(cur != null) {
			ilist.add(cur.getData());
			cur = cur.getNext();
		}
		
		Collections.sort(ilist);
		System.out.println(" list is :::: "+ilist);
		
		Node temp = new Node(0);
		Node node1 = temp;
		
		for(int val : ilist) {
			Node tmp = new Node(val);
			node1.setNext(tmp);
			node1 = node1.getNext();
		}
		
		return temp.getNext();
	}
	
	//reorder the linkedlist
	
	public Node reorderLinkedList(Node head) { //1,2,3,4     4,3,2,1
		if(head == null)
			return null;
		Node cur = head;
		Node rcur = reverseNode(head);
		
		while(cur != rcur) {
			cur.setNext(rcur);
			cur = cur.getNext();
			rcur = rcur.getNext();
		}
		cur.setNext(null);
		head = cur;
		return head;
	}
	
	public Node reorderLL(Node head) {
		if(head == null)
			return null;
		Node cur = head;
		Node cur1 = head;
		Stack<Node> st = new Stack<>();
		
		while(cur.getNext() != null) {
			st.push(cur);
			cur = cur.getNext();
		}
		
		while(cur1 != st.peek()) {
			cur1.setNext(st.pop());
			cur1 = cur1.getNext();
		}
		cur1.setNext(null);
		
		head = cur1;
		return head;
		
		
	}
	
	//merge a list of linkedlist
    
    public Node mergeListOfLinkedList(List<Node> listOfNodes) {
    	
    	if(listOfNodes.isEmpty())
    		return null;
    	
    	return mergeList(listOfNodes, 0, listOfNodes.size()-1);
    	
    }
	

	private Node mergeList(List<Node> listOfNodes, int start, int end) {
		
		if(start == end) {
			return listOfNodes.get(start);
		}
		
		if(start + 1 == end) {
			return mergeTwoList(listOfNodes.get(start), listOfNodes.get(end));
		}
		
		int mid = start + (end - start)/2;
		
		Node left = mergeList(listOfNodes, start, mid);
		Node right = mergeList(listOfNodes, mid + 1, end);
		
		return mergeTwoList(left, right);
		
	}
	
	//detect cycle in the list
	
	public boolean cycleInLinkedList(Node head) {
		if(head == null)
			return false;
		Node slow = head;
		Node fast = head;
		
		while(fast != null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	public boolean findCycleInLinkedList(Node head) {
		if(head == null)
			return false;
		Node cur = head;
		Set<Node> nset = new HashSet<>();
		
		while(cur != null) {
			if(!nset.add(cur)) {
				return true;
			}
			cur = cur.getNext();
		}
		return false;
	}
	
	public Node removeDuplicates(Node head) {
		if(head == null)
			return null;
		Node cur = head;
		Set<Node> hset = new HashSet<>();
		Node prev = null;
		
		while(cur.getNext()!=null) {
			if(!hset.contains(cur)) {
				hset.add(cur);
				prev = cur;
				cur = cur.getNext();
			}else {
				cur = cur.getNext();
				prev.setNext(cur);
			}
			
		}
		head = prev;
		
		reverseNode(prev);
		
		return head;
	}
	
    public Node remove(Node head, int data) {  //1,2,3,4,5,6
		
		if(head == null)
			return null;
		
		Node cur = head;
		Node prev = null;
		
		boolean doesHaveMatch = false;
		
		while(cur != null) {
			if(cur.getData() == data) {             //4
				prev.setNext(cur.getNext());
				cur = cur.getNext();                //4
				doesHaveMatch = true;
			}
			
			prev = cur;                    //1,2,4
			cur = cur.getNext();           //2,3,5
			
		}
		
		if(!doesHaveMatch)
			return null;
		
		System.out.println("prev value: " +prev.getData());
		
		prev = head;
		System.out.println("head value ::: "+prev.getData());
		return head;
		
	}
	
	
	
	
	public void displayNode(Node head) {
		if(head == null)
			return;
		Node cur = head;
		while(cur != null) {
			System.out.println(cur.getData());
			cur = cur.getNext();
		}
	}
	

	public static void main(String[] args){
		
		LinkedListDemo tp = new LinkedListDemo();
		
        Node head = new Node(2);
        tp.insertAtEnd(head, 5);
        tp.insertAtEnd(head, 7);
        tp.insertAtEnd(head, 8);	
        
        Node temp = tp.insertAtFront(head, 1);
        
        Node newt = tp.insertAtMid(temp, 3);
        
        Node kthNbFront = tp.insertAtKthFirstNode(newt, 4, 3);
        
        Node kthNdEnd = tp.insertAtKthLastNode(kthNbFront, 6, 3);
        
        //tp.displayNode(kthNdEnd);
        
        Node rfront = tp.removeAtKthLastNode(kthNdEnd, 3);
        
        Node kthNdEnd1 = tp.insertAtKthLastNode(kthNbFront, 6, 3);
        
        //Node movelast = tp.moveFrontToLast(kthNdEnd1);
        
        Node revNode = tp.reverseNode(kthNdEnd1);
        
        //tp.displayNode(revNode);
        
        Node node1 = new Node(6);   // 56
        tp.insertAtEnd(node1, 5);
        
        Node node2 = new Node(6);   // 56
        tp.insertAtEnd(node2, 5);
        
        Node sum = tp.twoSum(node1, node2);
        
        tp.displayNode(sum);     // 211
        
       
    }

}
