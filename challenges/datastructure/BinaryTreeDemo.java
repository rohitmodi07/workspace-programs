package challenges.datastructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BinaryTreeDemo {
	
	
	public static class Node{
		Node left;
		Node right;
		int value;
		
		public Node(int value){
			this.value=value;
		}
	}
	
	//Insert node in a tree
	
	public void insertInTree(Node root, int value){
		if(value<root.value){
			if(root.left!=null){
				insertInTree(root.left, value);
			}else{
				root.left=new Node(value);
			}
		}else if(value>root.value){
			if(root.right!=null){
				insertInTree(root.right, value);
			}else{
				root.right=new Node(value);
			}
		}
	}
	
	//preorder traversal
	
	public void preOrder(Node root){
		if(root!=null){
			System.out.println(root.value);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	//inorder traversal
	
	public void inOrder(Node root){
		if(root!=null){
			inOrder(root.left);
			System.out.println(root.value);
			inOrder(root.right);
		}
	}
	
	//postorder traversal
	
	public void postOrder(Node root){
		if(root!=null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.value);
		}
	}
	
	//get the minimum value of node with rec
	
	public int minValRec(Node root){
		if(root.left==null)
			return root.value;
		return minValRec(root.left);
	}
	
	//get the minimum value of node without rec
	
	public int minValWithoutRec(Node root){
		if(root.left==null)
			return root.value;
		Node current = root;
		while(current.left!=null){
			current = current.left;
		}
		return current.value;
	}
	
	//get maximum value of node with rec
	
	public int maxValRec(Node root){
		if(root.right==null)
			return root.value;
		return maxValRec(root.right);
	}
	
	//get maximum value of node without rec
	
	public int maxValWithoutRec(Node root){
		if(root.right==null)
			return root.value;
		Node current = root;
		while(current.right!=null){
			current = current.right;
		}
		return current.value;
	}
	
	//find node in the tree
	
	public boolean findInTree(Node root, int key){
		if(root==null)
			return false;
		return key==root.value ||
				findInTree(root.left, key) ||
				findInTree(root.right, key);
	}
	
	//print all left nodes
	
	public void printAllLeftNode(Node root){
		if(root!=null){
			if(root.left!=null){
				System.out.println(root.left.value);
				printAllLeftNode(root.left);
			}
			printAllLeftNode(root.right);
		}
	}
	
	//Print all right Nodes
	
	public void printAllRightNodes(Node root){
		if(root!=null){
			if(root.right!=null){
				System.out.println(root.right.value);
				printAllLeftNode(root.right);
			}
			printAllLeftNode(root.left);
		}
	}
	
	//print each level of nodes
	
	public void printEachLevelNodes(Node root){
		if(root!=null){
			int h = height(root);
			for(int i=0;i<=h;i++){
				System.out.println(root.value);
				printLevel(root,i);
			}
		}
	}

	
	
	private void printLevel(Node root, int i) {
		if(i==1){
			System.out.println(root.value);
		}else{
			printLevel(root.left, i-1);
			printLevel(root.right, i-1);
		}
		
	}

	private int height(Node root) {
		return 1+Math.max(height(root.left), height(root.right));
	}
	
	//Delete a Node
	
	public Node deleteNode(Node root, int key){
		if(root==null)
			return null;
		if(key<root.value){
			root.left=deleteNode(root.left, key);
		}else if(key>root.value){
			root.right=deleteNode(root.right, key);
		}else{
			if(root.left==null){
				return root.right;
			}
			if(root.right==null){
				return root.left;
			}
			
			root.value = minVal(root.right);
			
			root.right = deleteNode(root.right, root.value);
		}
		return root;
	}

	private int minVal(Node right) {
		int minv = right.value;
		while(right.left!=null){
			minv = right.left.value;
			right = right.left;
		}
		return minv;
	}
	
	boolean isBST(Node root)  {

        return isBSTUtil(root, Integer.MIN_VALUE,
                               Integer.MAX_VALUE);
    }

    // Returns true if the given tree is a BST and its
      //values are >= min and <= max. 
    boolean isBSTUtil(Node root, int min, int max)
    {
         //an empty tree is BST 
        if (root == null)
            return true;

        // false if this node violates the min/max constraints 
        if (root.value < min || root.value > max)
            return false;

        // otherwise check the subtrees recursively
       // tightening the min/max constraints 
        // Allow only distinct values
        return (isBSTUtil(root.left, min, root.value-1) &&
                isBSTUtil(root.right, root.value+1, max));
    }
    
    public int findTheMaxDepth(Node root) {
		return height(root);
	}
	
	
	
	public boolean isSameTree(Node root1, Node root2) {
		
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		if(root1.value != root2.value)
			return false;
		return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
	
	public Node flipTree(Node root) {
		if(root == null)
			return null;
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		flipTree(root.left);
		flipTree(root.right);
		return root;
	}
	
	public static void printInSpiral(Node root) {
		if(root == null)
			return;
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		boolean visited = false;
		
		while(!stack.isEmpty()) {
			
			Stack<Node> tempstk = new Stack<Node>();
			while(!stack.isEmpty()) {
				Node node = stack.pop();
				System.out.println(node.value);
				if(!visited) {
					if(node.left != null) {
						tempstk.push(node.left);
					}
					if(node.right != null) {
						tempstk.push(node.right);
					}
				}else {
					if(node.right != null) {
						tempstk.push(node.right);
					}
					if(node.left != null) {
						tempstk.push(node.left);
					}
				}
			}
			visited = !visited;
			stack = tempstk;
			
		}
		
		
	}
	
	public void printSpiralForm(Node root) {
		if(root == null)
			return;
		
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		
		s1.push(root);
		
		while(!s1.isEmpty() || !s2.isEmpty()) {
			
			while(!s1.isEmpty()) {
				Node temp = s1.pop();
				System.out.println(temp.value + " ");
				
				if(temp.left != null) {
					s2.push(temp.left);
				}
				if(root.right != null) {
					s2.push(temp.right);
				}
			}
			
			while(!s2.isEmpty()) {
				Node temp = s2.pop();
				System.out.println(temp.value + " ");
				
				if(temp.left != null) {
					s1.push(temp.left);
				}
				if(root.right != null) {
					s1.push(temp.right);
				}
			}
			
		}
		
	}
	
	//serialize and de-serialize the binary tree
	
		public String serialize(Node node) {
			
			StringBuilder sb = new StringBuilder();
		
			return buildString(node, sb);
			
		}

		private String buildString(Node node, StringBuilder sb) {
			if(node == null) {
				sb.append("#").append(",");
			}else {
				sb.append(node.value).append(",");
				buildString(node.left, sb);
				buildString(node.right, sb);
			}
			
			return sb.toString();
			
		}
		
		public Node deserialize(String str) {
			
			Queue<String> qnodes = new LinkedList<>();
			qnodes.addAll(Arrays.asList(str.split(",")));
			
			return buildNodes(qnodes);
			
		}

		private Node buildNodes(Queue<String> qnodes) {
			
			String val = qnodes.poll();
			
			if("#".equals(val)) {
				return null;
			}else {
				Node node = new Node(Integer.valueOf(val));
				node.left = buildNodes(qnodes);
				node.right = buildNodes(qnodes);
				return node;
			}
		}
		
		public static void main(String[] args) {
			
		}

}
