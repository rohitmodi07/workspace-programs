package techround.microsoft;

import java.util.HashMap;


public class CloneListWithArbitraryPointer {
	
	private static class Node {
		private int data;
		private Node next;
		private Node arbit;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
			this.arbit = null;
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

		public Node getArbit() {
			return arbit;
		}

		public void setArbit(Node arbit) {
			this.arbit = arbit;
		}
		
	}
	
	static Node cloneLinkedList(Node head)
	  {
	    // Map to store the mapping of
	    // old nodes with new ones
	    HashMap<Node, Node> mp = new HashMap<>();
	    Node temp, nhead;
	 
	    // Duplicate of the first node
	    temp = head;
	    nhead = new Node(temp.getData());
	    mp.put(temp, nhead);
	 
	    // Loop to create duplicates of nodes
	    // with only next pointer
	    while (temp.getNext() != null) {
	      nhead.setNext(new Node(temp.getNext().getData()));
	      temp = temp.getNext();
	      nhead = nhead.getNext();
	      mp.put(temp, nhead);
	    }
	    temp = head;
	 
	    // Loop to clone the arbit pointers
	    while (temp != null) {
	      mp.get(temp).setArbit(mp.get(temp.getArbit()));
	      temp = temp.next;
	    }
	 
	    // Return the head of the clone
	    return mp.get(head);
	  }
	 
	  static void printList(Node head)
	  {
	    System.out.print(head.getData() + "(" + head.getArbit().getData()
	                     + ")");
	    head = head.getNext();
	    while (head != null) {
	      System.out.print(" -> " + head.getData() + "("
	                       + head.getArbit().getData() + ")");
	      head = head.getNext();
	    }
	    System.out.println();
	  }
	 
	  public static void main(String[] args)
	  {
	    // Creating a linked list with random pointer
	    Node head = new Node(1);
	    head.next = new Node(2);
	    head.next.next = new Node(3);
	    head.next.next.next = new Node(4);
	    head.next.next.next.next = new Node(5);
	    head.arbit = head.next.next;
	    head.next.arbit = head;
	    head.next.next.arbit = head.next.next.next.next;
	    head.next.next.next.arbit = head.next.next;
	    head.next.next.next.next.arbit = head.next;
	 
	    // Print the original list
	    System.out.println("The original linked list:");
	    printList(head);
	 
	    // Function call
	    Node sol = cloneLinkedList(head);
	 
	    System.out.println("The cloned linked list:");
	    printList(sol);
	  }

}
