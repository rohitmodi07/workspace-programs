package challenges.allarray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class MergeAndRemoveDepInArr {
	
    public static int[] removeDup(int[] arr1, int[] arr2) {
		
		Stream<Integer> a1 = Arrays.stream(arr1).boxed();
		Stream<Integer> a2 = Arrays.stream(arr2).boxed();
		
		int[] newArr = Stream.concat(a1, a2).distinct().mapToInt(Integer :: intValue).toArray();
		
		return newArr;
		
	}
	
    public static Integer[] removeDup1(int[] arr1, int[] arr2) {
		
		Set<Integer> hset = new HashSet<>();

        for(int i=0; i<arr1.length; i++) {
        	hset.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++) {
        	hset.add(arr2[i]);
        }
        Integer[] newarr = new Integer[hset.size()];
		
		return hset.toArray(newarr);
		
	}
	

	public static void main(String[] args) {
		int[] narr = {2,4,5,6,1};
		
		int[] arr1 = {1,2,3,4,5,6,7,8};
		int[] arr2 = {5,6,7,8,9,10,11,12};
		
	    System.out.println("new array ::: "+Arrays.toString(removeDup(arr1, arr2)));
	    System.out.println("new array diff style ::: "+Arrays.toString(removeDup1(arr1, arr2)));
		
    }

}
