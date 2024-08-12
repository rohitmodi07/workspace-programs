package challenges.allarray;


public class MergeTwoLinkedList {
	
	private static class Node{
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
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
		
		
	}
	
	//merge two linkedlists
	
	
	public static Node merge(Node node1, Node node2) {
		
		Node temp = new Node(0);
		Node node3 = temp;
		
		while(node1 != null || node2 != null) {
			int val1 = node1 != null ? node1.getData() : 0;
			int val2 = node2 != null ? node2.getData() : 0;
			
			if(val1>val2) {
				
				Node tmp = new Node(val2);
				
				node3.setNext(tmp);
				node3 = node1.getNext();
				if(node2 != null)
					node2 = node2.getNext();
			}else if(val1<val2) {
                Node tmp = new Node(val1);
				
				node3.setNext(tmp);
				node3 = node1.getNext();
				if(node1 != null)
					node1 = node1.getNext();
			}else {
				Node tmp = new Node(val1);
				node3.setNext(tmp);
				node3 = node1.getNext();
				if(node2 != null)
					node2 = node2.getNext();
				
				tmp = new Node(val2);
				node3.setNext(tmp);
				node3 = node1.getNext();
				if(node1 != null)
					node1 = node1.getNext();
			}
			
		}
		temp = node3;
		return temp;
	}
	
	public Node mergeTwoLists(Node list1, Node list2) { // 1,2,3,4  -> list1 and 2,5,6 -> list2

        if(list1!=null && list2!=null){
          if(list1.getData()<list2.getData()){
              list1.setNext(mergeTwoLists(list1.getNext(),list2));
              return list1;
          }else{
              list2.setNext(mergeTwoLists(list1,list2.getNext()));
              return list2;
          }
        }
        if(list1==null)
            return list2;
        return list1;
    }
	    
    public static void main(String[] args) {
    	
    	int[] arr = {2,7,11,13};
    	
	
    }

}
