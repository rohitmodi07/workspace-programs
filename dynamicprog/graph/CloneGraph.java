package dynamicprog.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CloneGraph {
	
	  private static class Node {
		   private int value;
		   private List<Node> neighborNodes;
		   
		   public Node(int value) {
			   this.value = value;
			   this.neighborNodes = new ArrayList<>();
		   }
	   }
	   
	   public static Node cloneGraph(Node node) {
	       if(node == null)
	    	   return null;
	       Map<Node, Node> cloneMap = new HashMap<>();
	       
	       return cloneGraph(node, cloneMap);
	   }
	   
	   public static Node cloneGraph(Node node, Map<Node, Node> cloneMap) {
		   
		   Node newNode = new Node(node.value);
		   cloneMap.put(node, newNode);
		   
		   for(Node nd : node.neighborNodes) {
			   if(!cloneMap.containsKey(nd)) {
				   newNode.neighborNodes.add(cloneGraph(nd, cloneMap));
			   }else {
				   newNode.neighborNodes.add(nd);
			   }
		   }
		   
		   return newNode;
	   }
	   

		public static void main(String[] args) { 
			
			int[][] arr = {{2,4},{1,3},{2,4},{1,3}};
			
			Node node1 = new Node(1);
			Node node2 = new Node(2);
			Node node3 = new Node(3);
			Node node4 = new Node(4);
			
			node1.neighborNodes.add(node2);
			node1.neighborNodes.add(node4);
			
			node2.neighborNodes.add(node1);
			node2.neighborNodes.add(node3);
			
			node3.neighborNodes.add(node2);
			node3.neighborNodes.add(node4);
			
			node4.neighborNodes.add(node1);
			node4.neighborNodes.add(node3);
			
			
			
	    }

}
