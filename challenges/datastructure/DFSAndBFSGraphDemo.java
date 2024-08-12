package challenges.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DFSAndBFSGraphDemo {
	
	private static class Node{
		private int data;
		private boolean visited;
		private List<Node> seenNode;
		
		public Node(int data) {
			this.data = data;
			seenNode = new ArrayList<>();
		}

		public List<Node> getSeenNode() {
			return seenNode;
		}

		public void setSeenNode(List<Node> seenNode) {
			this.seenNode = seenNode;
		}
		
		public void addInSeenList(Node node){
		    this.seenNode.add(node);
		}
	}
	
	//depth first search
	
	public void DFSInGraph(Node node) {
		Stack<Node> stk = new Stack<>();
		
		stk.push(node);
		
		while(!stk.isEmpty()) {
			Node nod = stk.pop();
			if(!nod.visited) {
				nod.visited = true;
				nod.getSeenNode().add(nod);
			}
			List<Node> lst = nod.getSeenNode();
			for(Node nd : lst) {
				if(nd!=null && !nd.visited) {
					stk.push(nd);
				}
			}
		}
	}
	
	public void BFSInGraph(Node node) {
		Queue<Node> lqueue = new LinkedList<>();
		
		lqueue.add(node);
		
		while(!lqueue.isEmpty()) {
			Node nod = lqueue.poll();
			if(!nod.visited) {
				nod.visited = true;
				
			}
			
			List<Node> lst = nod.getSeenNode();
			for(Node nd : lst) {
				if(nd!=null && !nd.visited) {
					lqueue.add(nd);
				}
			}
		}
	}	
	

	public static void main(String[] args) {
		
		DFSAndBFSGraphDemo dbd = new DFSAndBFSGraphDemo();
		Node node10 = new Node(10);
		Node node20 = new Node(20);
		Node node30 = new Node(30);
		Node node40 = new Node(40);
		
		node40.addInSeenList(node20);
		node10.addInSeenList(node40);
		node20.addInSeenList(node30);

	}

}
