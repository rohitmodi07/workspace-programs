package challenges.allarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeatingTogetherSeats {
	
	public static int SeatingStudents(int[] arr) {
	    // code goes here 
	    if(arr.length<1){
	        return 0;
	    }
	    List<Integer> occupiedSeatList = new ArrayList<>();    
	    for(int i=1;i<arr.length; i++){
	       occupiedSeatList.add(arr[i]);
	    } 

	    List<Integer> leftList = new ArrayList<>();
	    List<Integer> rightList = new ArrayList<>();

	    int numOfDesk = arr[0]; 
	    List<List<Integer>> seatOccupyList = new ArrayList<>();

	    for(int i=1;i<=numOfDesk; i++){
	      if(!occupiedSeatList.contains(i)){
	        if(i%2 == 0){
	            rightList.add(i); 
	        }else{
	            leftList.add(i);
	        }

	      }
	    }

	    for(int i=0; i<leftList.size()-1; i++){
	      int num1 = leftList.get(i);
	      int num2 = leftList.get(i+1);
	        if((num2-num1) == 2){
	           List<Integer> intlist = Arrays.asList(num1, num2);
	           seatOccupyList.add(intlist);
	        }
	    }
	    

	    for(int i=0; i<rightList.size()-1; i++){
	      int num1 = rightList.get(i);
	      int num2 = rightList.get(i+1);
	        if((num2-num1) == 2){
	           List<Integer> intlist = Arrays.asList(num1, num2);
	           seatOccupyList.add(intlist);
	        }
	    }
	    
	    System.out.println(seatOccupyList);
	    
	    int l = 0;
	    int k = 0;
	    int size = 0;
	    if(rightList.size()<leftList.size()){
	        size = rightList.size();
	    }else{
	       size = leftList.size();
	    }
	    while(size>0){
	       int num1 = rightList.get(l);
	       int num2 = leftList.get(k);
	       int num = num1-num2;
	       if(num == 1){
	          List<Integer> intlist = Arrays.asList(num1, num2);
	          seatOccupyList.add(intlist);
	          l++;
	          k++;
	       }else if(num>1){
	          l++;
	       }else if(num<1){
	          k++;
	       }
	       size--;
	    }           
	               
	    return seatOccupyList.size();
	  }
	
	public static int SeatingStudentTogether(int[] arr) {
		
		if(arr.length<1){
	        return 0;
	    }
	    List<Integer> occupiedSeatList = new ArrayList<>();    
	    for(int i=1;i<arr.length; i++){
	       occupiedSeatList.add(arr[i]);
	    } 
	    
	    int numOfDesk = arr[0];
	    List<Integer> nonOccupiedSeatList = new ArrayList<>();  
	    
	    for (int i = 1; i <= numOfDesk; i++) {
			if(!occupiedSeatList.contains(i)) {
				nonOccupiedSeatList.add(i);
			}
		}
	    
	    
	    int count = 0;
	    
	     for(int i=0; i<nonOccupiedSeatList.size(); i++) {
	    	 for (int j = i+1; j < nonOccupiedSeatList.size(); j++) {
				int num = nonOccupiedSeatList.get(j)-nonOccupiedSeatList.get(i);
				
				if(nonOccupiedSeatList.get(j)%2 == 0 && nonOccupiedSeatList.get(i)%2 ==0 && num == 2) {
					count++;
				}else if((nonOccupiedSeatList.get(j)%2 == 1 && num == 2) || (nonOccupiedSeatList.get(j)%2 == 0 && num == 1)) {
					count++;
				}
			}
	     }
	     return count;
	}

	public static void main(String[] args) {
		
		int[] arr = {12,2,6,7,11};
		
		System.out.println(SeatingStudentTogether(arr));
		
        int[] arr1 = {12,2,5,10};
		
		System.out.println(SeatingStudentTogether(arr1));

	}

}
