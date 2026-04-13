package challenges.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class SerializeDeserializeNonBST {
	
	private static class Node {
		private int value;
		private List<Node> childNode;
		
		public Node(int value) {
			this.value = value;
			this.childNode = new ArrayList<>();
		}
		
		public Node(int value, List<Node> childNodes) {
			this.value = value;
			this.childNode = childNodes;
		}
	}
	
	public static String serializeTree(Node root) {
		if(root == null)
			return null;
		
		StringBuilder sb = new StringBuilder();
		
		return buildString(root, sb);
		
	}

	private static String buildString(Node root, StringBuilder sb) {
		
		sb.append(root.value).append(",");
		sb.append(root.childNode.size()).append(",");
		
		for(Node nd : root.childNode) {
			buildString(nd, sb);
		}
		
		return sb.toString();
	}
	
	public static Node deserializeString(String data) {
		if(data == null || data.isEmpty())
			return null;
		
		Queue<String> nodequeue = new LinkedList<>(Arrays.asList(data.split(",")));
		
		return buildTree(nodequeue);
	}

	private static Node buildTree(Queue<String> nodequeue) {
		
		int val = Integer.parseInt(nodequeue.poll());
		int size = Integer.parseInt(nodequeue.poll());
		
		Node node = new Node(val, new ArrayList<>(size));
		
		for(int i=0; i<size; i++) {
			node.childNode.add(buildTree(nodequeue));
		}
		
		return node;
	}

	public static void main(String[] args){
		
		 // Level 3
	    Node node5 = new Node(5, new ArrayList<>());
	    Node node6 = new Node(6, new ArrayList<>());

	    // Level 2
	    List<Node> childrenOf3 = new ArrayList<>();
	    childrenOf3.add(node5);
	    childrenOf3.add(node6);
	    Node node3 = new Node(3, childrenOf3);

	    Node node2 = new Node(2, new ArrayList<>());
	    Node node4 = new Node(4, new ArrayList<>());

	    // Level 1 (Root)
	    List<Node> rootChildren = new ArrayList<>();
	    rootChildren.add(node3);
	    rootChildren.add(node2);
	    rootChildren.add(node4);
	    Node root = new Node(1, rootChildren);

	    String serialized = serializeTree(root);
	    System.out.println("Serialized: " + serialized); 
	    // Output: 1,3,3,2,5,0,6,0,2,0,4,0
		
		
    }

}
