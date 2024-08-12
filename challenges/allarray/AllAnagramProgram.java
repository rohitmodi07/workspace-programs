package challenges.allarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllAnagramProgram {
	
public static boolean isAnagram(String str1, String str2) {
		
		char[] c = str1.toCharArray();
		char[] d = str2.toCharArray();
		
		Arrays.sort(c);
		Arrays.sort(d);
		
		return Arrays.equals(c, d);
		
	}
	
	public static List<List<String>> getAnagramList(String[] arr){
		
		List<List<String>> list = new ArrayList<List<String>>();
		
		for(int i = 0; i < arr.length; i++){
			
			String str = arr[i];
			
			if(list.stream().anyMatch((lst) -> lst.contains(str))){
                continue;
            }
			
            char[] c = arr[i].toCharArray();
            Arrays.sort(c);
            
            
            
            List<String> l = new ArrayList<String>();
            l.add(arr[i]);
            
            for(int j = i+1; j < arr.length; j++){
            	
                char[] d = arr[j].toCharArray();
                Arrays.sort(d);
                
                if(Arrays.equals(c, d) && arr[i] != arr[j]){
                    
                    l.add(arr[j]);
                }           
            }
            list.add(l);
		}
		
		return list;
	}
	    
	    
    public static void main(String[] args) throws InterruptedException {
    	
    	System.out.println(isAnagram("rat", "art"));
    	
    	System.out.println(isAnagram("tea", "eat"));
    	
    	System.out.println(isAnagram("see", "she"));
    	
    	String[] arr = {"rat", "art", "eat", "she", "tea", "ate"};
    	
    	System.out.println(getAnagramList(arr));
    	
    }

}
