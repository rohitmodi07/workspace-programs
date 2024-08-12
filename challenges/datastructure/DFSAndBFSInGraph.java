package challenges.datastructure;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class DFSAndBFSInGraph {
	private static class Node{
		int data;
		boolean visited;
		List<Node> seenList;

		public Node(int data) {
		  this.data = data;
		  this.seenList = new ArrayList<>();
		}

		public List<Node> getSeenList(){
		  return this.seenList;
		}

		public void setSeenList(List<Node> seenList) {
		  this.seenList = seenList;
		}

		public void addInList(Node node) {
		  this.seenList.add(node);
		}

	}

		//following method is used for depth first search in graph

	public void depthFirstSearch(Node node) {
		Stack<Node> stk = new Stack<>();
		stk.push(node);

		while(!stk.isEmpty()) {
			Node nd = stk.pop();
	
			if(!nd.visited) {
			  nd.visited = true;
			}
			List<Node> listnode = nd.getSeenList();
			for (Node n : listnode) {
			  if(n!=null && !n.visited) {
			    stk.push(n);
			  }
		    }
		}
	}

		//following method is used for breadth first search in graph

	public void breadthFirstSearch(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		while(!queue.isEmpty()) {
			Node nd = queue.poll();
			if(!nd.visited) {
			  nd.visited = true;
			}
	
			List<Node> listnode = nd.getSeenList();
			for (Node n : listnode) {
				if(n!=null && !n.visited) {
				  queue.add(n);
				}
			}
		}
	}

	public static void main(String[] args) {
		DFSAndBFSInGraph dbdemo = new DFSAndBFSInGraph();

		Node node40 =new Node(40);
		        Node node10 =new Node(10);
		        Node node20 =new Node(20);
		        Node node30 =new Node(30);
		        Node node60 =new Node(60);
		        Node node50 =new Node(50);
		        Node node70 =new Node(70);
		       
		        node40.addInList(node10);
		        node20.addInList(node70);

	}

}
