package challenges.datastructure;

import java.util.Set;
import java.util.Stack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LinkedListNewDemoTest {
	
	private static class Node{
		Node next;
		int data;
		
		public Node(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}
		
	}
	
	//insert in the linked list
	
	public void insertInLinkedList(Node head, int data) {
		if(data<1)
			return;
		if(head == null) {
			head = new Node(data);
			return;
		}
		Node temp = new Node(data);
		Node cur = head;
		while(cur.getNext()!=null) {
			cur = cur.getNext();
		}
		cur.setNext(temp);
	}
	
	//insert at the particular position in linkedlist
	
	public Node insertAtPartPosInLL(Node head, int data, int index) {
		if(data<1 || index<0)
			return null;
		if(head == null) {
			head = new Node(data);
			return head;
		}
		Node temp = new Node(data);
		Node cur = head;
		
		for(int i=0; i<index; i++) {
			if(cur.getNext()!=null) {
				cur = cur.getNext();
			}else {
				return null;
			}
		}
		temp.setNext(cur.getNext());
		cur.setNext(temp);
		
		return cur;
	}
	
	// find a key in the linkedlist
	
	public boolean findtheKey(Node head, int key) {
		if(head == null || key<0)
			return false;
		Node cur = head;
		while(cur!=null) {
			if(key == cur.getData()) {
				return true;
			}
			cur = cur.getNext();
		}
		return false;
	}
	
	//get node value from the specified position
	
	public int getNodeVal(Node head, int index) {
		if(head == null || index<0)
			return 0;
		Node cur = head;
		for(int i=0; i<=index; i++) {
			if(cur.getNext()!=null) {
				cur = cur.getNext();
			}else { 
				return 0;
			}
		}
		return cur.getData();
	}
	
	//remove a node from a particular index
	
	public boolean removeNode(Node head, int index) {
		if(head == null || index<0)
			return false;
		Node cur = head;
		for (int i = 0; i < index; i++) {
			if(cur.getNext()!=null) {
				cur = cur.getNext();
			}else {
				return false;
			}
		}
		cur.setNext(cur.getNext().getNext());
		return true;
		
	}
	
	//find the intersection point of two linkedlist
	
	public Node getTheIntersectionPoint(Node node1, Node node2) {
		if(node1 == null || node2 == null)
			return null;
		Set<Node> hset = new HashSet<>();
		while(node1!=null) {
			hset.add(node1);
			node1 = node1.getNext();
		}
		
		while(node2!=null) {
			if(hset.contains(node2.getNext())) {
				return node2;
			}
			hset.add(node2);
			node2 = node2.getNext();
		}
		return null;
		
	}
	
	//find the nth last Node
	
	public Node getTheKthNodeFromLast(Node head, int k) {
		if(head == null || k<0)
			return null;
		Node kthNode = head;
		Node cur = head;
		
		for(int i=0; i<k; i++) {
			if(kthNode.getNext()!=null) {
				kthNode = kthNode.getNext();
			}else {
				return null;
			}
			
		}
		while(kthNode.getNext()!=null) {
			cur = cur.getNext();
			kthNode = kthNode.getNext();
		}
		return cur;
	}
	
	//find the middle node
	
	public Node findtheMiddleNode(Node head) {
		if(head == null)
			return null;
		Node slow = head;
		Node fast = head;
		
		while(fast.getNext()!=null) {
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		return slow;
	}
	
	// addition of two linkedlist
	
	public Node addTwoLinkedList(Node node1, Node node2) {
		if(node1 == null || node2 == null)
			return null;
		Node temp = new Node(0);
		Node node3 = temp;
		int carry = 0;
		while(node1!=null || node2!=null) {
			int val1 = node1!=null ? node1.getData() : 0;
			int val2 = node2!=null ? node2.getData() : 0;
			
			int sum = val1+val2+carry;
			
			carry = sum/10;
			Node tmp = new Node(sum%10);
			node3.setNext(tmp);
			node3 = node3.getNext();
			
			if(node1!=null) {
				node1 = node1.getNext();
			}
			
			if(node2!=null) {
				node2 = node2.getNext();
			}
		}
		if(carry>0) {
			Node tmp = new Node(carry);
			node3.setNext(tmp);
		}
		return temp.getNext();
	}
	
	//merge two sorted linkedlist
	
	public Node mergeSOrtedList(Node node1, Node node2){
		Node node3;
		Node temp = new Node(0);
		node3 = temp;
		
		while(node1 != null || node2 != null) {
			int val1 = node1 != null ? node1.getData() : 0;
			int val2 = node2 != null ? node2.getData() : 0;
			
			if(val1 > val2) {
				Node tmp2 = new Node(val2);
				node3.setNext(tmp2);
				
				if(node2 != null)
					node2 = node2.getNext();
				
				
			} else if(val1 < val2) {
				Node tmp1 = new Node(val1);
				node3.setNext(tmp1);

				if(node1 != null)
					node1 = node1.getNext();
				
			}else {
				Node tmp1 = new Node(val1);
				Node tmp2 = new Node(val2);
				
				tmp1.setNext(tmp2);
				node3.setNext(tmp1);
				node3 = node3.getNext();
				
				if(node1 != null)
					node1 = node1.getNext();
				if(node2 != null)
					node2 = node2.getNext();
				
			}
			node3 = node3.getNext();
			
		}
		
		return node3;
		
	}
	
	public Node mergeTwoLinkedList(Node node1, Node node2) {
		
		if(node1 != null && node2 != null) {
			if(node1.getData() < node2.getData()) {
				
				node1.setNext(mergeTwoLinkedList(node1.getNext(), node2));
				return node1;
				
			}else {
				node2.setNext(mergeTwoLinkedList(node1, node2.getNext()));
				return node2;
			}
			
		}
		
		if(node1 == null)
			return node2;
		return node1;
		
	}
	
	public Node merger(Node node1, Node node2) {
		Node temp = new Node(-1);
		Node node3 = temp;
		
		while(node1 != null && node2 != null) {
			if(node1.getData() <= node2.getData()) {
				node3.setNext(node1);
				node1 = node1.getNext();
			}else {
				node3.setNext(node2);
				node2 = node2.getNext();
			}
			
			node3 = node3.getNext();
		}
		
		node3.setNext(node1 == null ? node2 : node1);
		return temp.getNext();
	}

	//move last node to first
	
	public void moveLastToFirst(Node head) {
		if(head == null)
			return;
		Node last = head;
		Node secLast = head;
		
		while(last.getNext()!=null) {
			secLast = last;
			last = last.getNext();
		}
		secLast.setNext(null);
		last.setNext(head);
		head = last;
	}
	
	//reverse the linkedlist
	
	public Node reverseLinkedList(Node head) {
		Node prev = null;
		Node cur = head;
		Node next;
		
		while(cur!=null) {
			next = cur.getNext();
			cur.setNext(prev);
			prev = cur;
			cur = next;
		}
		return prev;
	}
	
	//remove duplicates from the linked list 1,2,4,5,2,2,5,4,4,4,9
	
	public Node removeDuplicates(Node head) {
		if(head == null)
			return null;
		Node cur = head;
		Set<Node> hset = new HashSet<>();
		Node prev = head;
		
		while(cur.getNext()!=null) {
			if(!hset.contains(cur)) {
				hset.add(cur);
				cur = cur.getNext();
				prev.setNext(cur);
				prev = cur;
			}else {
				cur = cur.getNext();
			}
			
		}
		head = prev;
		
		reverseLinkedList(prev);
		
		return head;
	}
	
	public void push(Node head, int data) {
		if(head == null) {
			head = new Node(data);
			return;
		}
		Node cur = head;
		Node temp = new Node(data);
		while(cur.getNext() != null) {
			cur = cur.getNext();
		}
		
		cur.setNext(temp);
	}
	
	public Node peek(Node head, int data) {
		Node cur = head;
		while(cur.getNext() != null) {
			if(cur.getData() == data) {
				return cur;
			}
			cur = cur.getNext();
		}
		return null;
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
	
	public void display(Node node) {
		
		while(node != null) {
			System.out.println(node.getData());
			node = node.getNext();
		}
			
		
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
		
		//merge two sorted list
		
		public Node mergeSortedList(Node node1, Node node2) {
			
			Node temp = new Node(0);
			Node node3 = temp;
			
			while(node1 != null || node2 != null) {
				int val1 = node1 != null ? node1.getData() : 0;
				int val2 = node2 != null ? node2.getData() : 0;
				
				if(val1>val2) {
					Node tmp = new Node(val2);
					node3.setNext(tmp);
					if(node2.getNext() != null) {
						node2 = node2.getNext();
					}
				}else if(val1<val2) {
					Node tmp = new Node(val1);
					node3.setNext(tmp);
					if(node1.getNext() != null) {
						node1 = node1.getNext();
					}
				}else {
					if(val1 != 0 && val2 != 0) {
						Node tmp1 = new Node(val1);
						Node tmp2 = new Node(val2);
						tmp1.setNext(tmp2);
						node3.setNext(tmp1);
					}
				}
				node3 = node3.getNext();
			}
			return temp.getNext();
		}
		
	    public Node mergeSortedListRemoveDup(Node node1, Node node2) {
			
			Node temp = new Node(0);
			Node node3 = temp;
			
			while(node1 != null || node2 != null) {
				int val1 = node1 != null ? node1.getData() : 0;
				int val2 = node2 != null ? node2.getData() : 0;
				
				if(val1>val2) {
					Node tmp = new Node(val2);
					node3.setNext(tmp);
					if(node2 != null) {
						node2 = node2.getNext();
					}
				}else if(val1<=val2) {
					Node tmp = new Node(val1);
					node3.setNext(tmp);
					if(node1 != null) {
						node1 = node1.getNext();
					}
				}
				node3 = node3.getNext();
			}
			return temp.getNext();
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
				merge(listOfNodes.get(start), listOfNodes.get(end));
			}
			
			int mid = start + (end - start)/2;
			
			Node left = mergeList(listOfNodes, start, mid);
			Node right = mergeList(listOfNodes, mid + 1, end);
			
			return merge(left, right);
			
		}

		private Node merge(Node node1, Node node2) {
			
			Node temp = new Node(-1);
			Node node3 = temp;
			
			while(node1 != null && node2 != null) {
				if(node1.getData() <= node2.getData()) {
					node3.setNext(node1);
					node1 = node1.getNext();
				}else {
					node3.setNext(node2);
					node2 = node2.getNext();
				}
				node3 = node3.getNext();
			}
			if(!(node1 == null && node2 == null)) {
			   node3.setNext(node1 == null ? node2 : node1);
			}
			return temp.getNext();
			
		}
		
		//remove kth node from end of the list
		
		public boolean removeKthNodeFromEnd(Node head, int k) { // 1,2,3,4,5,6,7,8
			if(head == null)
				return false;
			Node cur = head;
			Node kthNode = head;
			
			for(int i=0; i<=k; i++) {
				if(kthNode.getNext() != null) {
					kthNode = kthNode.getNext();
				}else {
					return false;
				}
			}
			
			while(kthNode.getNext() != null) {
				cur = cur.getNext();
				kthNode = kthNode.getNext();
			}
			cur.setNext(cur.getNext().getNext());
			cur = head;
			return true;
		}
		
		//reorder the linkedlist
		
		public Node reorderLinkedList(Node head) { //1,2,3,4     4,3,2,1
			if(head == null)
				return null;
			Node cur = head;
			Node rcur = reverseLinkedList(head);
			
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
		
		//short a linkedlist
		
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
	
	
	
	public static void main(String[] args) {
		LinkedListNewDemoTest lnd = new LinkedListNewDemoTest();
		Node head = new Node(10);
		lnd.insertInLinkedList(head, 20);
		lnd.insertInLinkedList(head, 40);
		lnd.insertInLinkedList(head, 30);
		lnd.insertInLinkedList(head, 15);
		lnd.insertInLinkedList(head, 50);
		lnd.insertInLinkedList(head, 30);
		lnd.insertInLinkedList(head, 30);
		lnd.insertInLinkedList(head, 15);
		
		Node node = lnd.removeDuplicates(head);
		while(node!=null) {
			System.out.println(node.getData());
			node = node.getNext();
		}
		

	}

}
