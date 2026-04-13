package challenges.datastructure;


public class FIndMaxPathBinaryTree {
	
	private static class Node{
    	private int data;
    	private Node left, right;
    	
    	public Node(int data) {
    		this.data = data;
    	}
    }
    
    public static int maxPathSum(Node root) {
    	if(root == null)
    		return -1;
    	int[] maxi = new int[1];
    	maxi[0] = Integer.MIN_VALUE;
    	
    	maxPath(root, maxi);
    	
    	return maxi[0];
    }

	private static int maxPath(Node root, int[] maxi) {
		
		if(root == null)
			return 0;
		
		int leftMax = Math.max(0, maxPath(root.left, maxi));
		int rightMax = Math.max(0, maxPath(root.right, maxi));
		
		maxi[0] = Math.max(maxi[0], leftMax + rightMax + root.data);
		
		return Math.max(leftMax, rightMax)+root.data;
		
	}

	public static void main(String[] args){
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.left.left = new Node(5);
		root.left.left.right = new Node(6);
		
		
		System.out.println(maxPathSum(root));
		
		
    }

}
