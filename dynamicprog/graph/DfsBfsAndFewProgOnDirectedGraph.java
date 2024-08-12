package dynamicprog.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;



public class DfsBfsAndFewProgOnDirectedGraph {
	
	private static class Node{
		   private int data;
		   private List<Node> adjacencyList;
		   
		   
		   public Node(int data) {
			   this.data = data;
			   this.adjacencyList = new ArrayList<>();
			   
		   }
		   
		   public void addInList(Node node) {
			   this.adjacencyList.add(node);
		   }
		   
		   public List<Node> getAdjacencyList(){
			   return this.adjacencyList;
		   }
	   }
	   
	   public static void depthFirstSearchDirected(Node node) {
		   Stack<Node> stk = new Stack<>();
		   
		   stk.push(node);
		   
		   while(!stk.isEmpty()) {
			   Node nod = stk.pop();
			   
			   System.out.println(" node :: "+nod.data);
			   
			   for(Node nd : nod.getAdjacencyList()) {
				   stk.push(nd);
			   }
			   
		   }
	   }
	   
	   
	   
	   public static void depthFirstSearchDirectedRec(Node node) {
		   
		   System.out.println(" node :: "+node.data);
		   
		   for(Node nd : node.getAdjacencyList()) {
			   depthFirstSearchDirectedRec(nd);
		   }
	   }
	   
	   public static void breadthFirstSearchDirected(Node node) {
		   Queue<Node> stk = new LinkedList<>();
		   
		   stk.add(node);
		   
		   while(!stk.isEmpty()) {
			   Node nod = stk.poll();
			   
			   System.out.println(" node :: "+nod.data);
			   
			   for(Node nd : nod.getAdjacencyList()) {
				   stk.add(nd);
			   }
			   
		   }
	   }
	   
	   //check if we can traverse from source to destination
	   
	   public static boolean checkTheTraversal(Node source, Node destination) {
		   
		   Stack<Node> stk = new Stack<>();
		   stk.push(source);
		   
		   while(!stk.isEmpty()) {
			   Node node = stk.pop();
			   
			   if(node.data == destination.data) {
				   return true;
			   }
			   
			   for(Node nd : node.getAdjacencyList()) {
				   stk.push(nd);
			   }
			   
		   }
		   return false;
		   
	   }
	   
	   //check if graph contains a loop
	   
	   public static boolean checkTheLoop(Node source) {
		   
		   Stack<Node> stk = new Stack<>();
		   stk.push(source);
		   
		   Set<Node> hset = new HashSet<>();
		   
		   while(!stk.isEmpty()) {
			   Node node = stk.pop();
			   
			   
			   if(hset.add(node)) {
				   for(Node nd : node.getAdjacencyList()) {
					   stk.push(nd);
				   }
			   }else {
				   return true;
			   }
			   
		   }
		   return false;
		   
	   }
		

		public static void main(String[] args) { 
			
			Node node10 = new Node(10);
			Node node20 = new Node(20);
			Node node30 = new Node(30);
			Node node40 = new Node(40);
			Node node50 = new Node(50);
			
			node10.adjacencyList.add(node20);
			node10.adjacencyList.add(node30);
			
			node20.adjacencyList.add(node40);
			
			
			node30.adjacencyList.add(node50);
			
			//depthFirstSearchDirectedRec(node10);
			
			//System.out.println(checkTheTraversal(node10, node40));
			
			//System.out.println(checkTheTraversal(node20, node30));
			
			
			Node node1 = new Node(1);
			Node node2 = new Node(2);
			Node node3 = new Node(3);
			Node node4 = new Node(4);
			Node node5 = new Node(5);
			
			node1.adjacencyList.add(node2);
			node1.adjacencyList.add(node3);
			
			node2.adjacencyList.add(node4);
			
			
			node3.adjacencyList.add(node5);
			
			node5.adjacencyList.add(node1);
			
			System.out.println(checkTheLoop(node1));
			
	    }

}
