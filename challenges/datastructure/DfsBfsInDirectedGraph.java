package challenges.datastructure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;



public class DfsBfsInDirectedGraph {
	
	private static class Node {
		private int data;
		private List<Node> adjList;
		
		public Node(int data) {
			this.data = data;
			this.adjList = new ArrayList<>();
		}
	}
	
	public static void depth1stSearchDirectedGraph(Node node) {
		
		if(node == null)
			return;
		
		Stack<Node> stk = new Stack<>();
		stk.push(node);
		
		while(!stk.isEmpty()) {
			Node nod = stk.pop();
			
			System.out.println(nod.data);
			
			for(Node nd : nod.adjList) {
				stk.push(nd);
			}
		}
		
	}
	
    public static void breadth1stSearchDirectedGraph(Node node) {
		
		if(node == null)
			return;
		
		Queue<Node> stk = new LinkedList<>();
		stk.add(node);
		
		while(!stk.isEmpty()) {
			Node nod = stk.poll();
			
			System.out.println(nod.data);
			
			for(Node nd : nod.adjList) {
				stk.add(nd);
			}
		}
		
	}
	
    public static boolean doesPathExistDirectedGraph(Node src, Node dest) {
		
		if(src == null || dest == null)
			return false;
		
		Stack<Node> stk = new Stack<>();
		stk.push(src);
		
		while(!stk.isEmpty()) {
			Node nod = stk.pop();
			
			System.out.println(nod.data);
			
			if(nod.data == dest.data) {
				return true;
			}
			
			for(Node nd : nod.adjList) {
				stk.push(nd);
			}
		}
		
		return false;
		
	}
    
    public static boolean doesPathExistDirectedGraphRec(Node src, Node dest) {
		
		if(src == null || dest == null)
			return false;
		
		if(src == dest)
			return true;
			
		for(Node nd : src.adjList) {
			if(doesPathExistDirectedGraphRec(nd, dest)) {
				return true;
			}
		}
		
		return false;
		
	}
   
   public static boolean shortestPathExistDirectedGraph(Node src, Node dest) {
		
		if(src == null || dest == null)
			return false;
		
		Stack<Node> stk = new Stack<>();
		stk.push(src);
		
		Set<Integer> slist = new HashSet<>();
		
		Set<Integer> slist1 = new HashSet<>();
		slist1.add(src.data);
		
		
		while(!stk.isEmpty()) {
			Node nod = stk.pop();
			
			System.out.println(nod.data);
			slist1.add(nod.data);
			
			if(nod.data == dest.data) {
				
				if(slist.isEmpty()) {
					slist = slist1;
				}else if(slist.size()>slist1.size()) {
					slist = slist1;
					slist.add(src.data);
				}
				
				slist1 = new HashSet<>();
				
			}
			
			for(Node nd : nod.adjList) {
				stk.push(nd);
			}
		}
		System.out.println(slist);
		if(slist.size() == 0) {
			return false;
		}
		
		return true;
		
	}
	


	public static void main(String[] args) {  
		
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		
		Node node6 = new Node(6);
		
		node1.adjList.add(node2);
		//node2.adjList.add(node1);
		
		node1.adjList.add(node3);
		//node3.adjList.add(node1);
		
		node2.adjList.add(node4);
		//node4.adjList.add(node2);
		
		node3.adjList.add(node5);
		node5.adjList.add(node4);
		//node5.adjList.add(node3);
		
		node6.adjList.add(node5);
		
		System.out.println(shortestPathExistDirectedGraph(node1, node6));
		
    }

}
