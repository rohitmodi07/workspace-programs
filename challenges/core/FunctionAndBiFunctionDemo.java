package challenges.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionAndBiFunctionDemo {
	
public static List<Integer> addAndMultiList(List<Integer> list1, List<Integer> list2, List<Integer> list3){
		
		
		List<Integer> sumList = new ArrayList<>();
		
		for(int i=0; i<list1.size(); i++) {
			
			sumList.add((list1.get(i)+list2.get(i))*list3.get(i));
			
		}
			
		return sumList;
		
	}
	
    public static List<Integer> addAndMultiList1(List<Integer> list1, List<Integer> list2, List<Integer> list3){
		
		
		List<Integer> sumList = new ArrayList<>();
		BiFunction<Integer, Integer, Integer> bf = (a,b) -> a+b;
		
		
		for(int i=0; i<list3.size(); i++) {
			
			int val = i;
			Function<Integer, Integer> fi = (c) -> c*list3.get(val);
			
			sumList.add(bf.andThen(fi).apply(list1.get(i),list2.get(i)));
			
			
		}
			
		return sumList;
		
	}
	
	
	

	public static void main(String[] args) throws InterruptedException {
		
		List<Integer> list1 = Arrays.asList(2, 3, 5);
        List<Integer> list2 = Arrays.asList(3, 5, 7);
        List<Integer> list3 = Arrays.asList(3, 4, 6);
        
        System.out.println(addAndMultiList1(list1, list2, list3));
				
				
		
	}

}
