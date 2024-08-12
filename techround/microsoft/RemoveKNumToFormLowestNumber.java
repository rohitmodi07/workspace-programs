package techround.microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoveKNumToFormLowestNumber {
	
	public static String getMinumimFormedNum(String str, int k) {
		if(str == null || str.isEmpty())
			return "";
		
		char[] carr = str.toCharArray();
		
		int i=0;
		List<Integer> intlist = new ArrayList<>();
		
		while(i<carr.length) {
			
			StringBuilder sb = new StringBuilder();
			
			if(i>0) {
				for(int l=0; l<i; l++) {
					sb.append(carr[l]);
				}
			}
			
			int val = i+k;
			
			while(val<carr.length) {
				sb.append(carr[val]);
				val++;
			}
			
			i++;
			
			intlist.add(Integer.valueOf(sb.toString()));
			
		}
		
		Collections.sort(intlist);
		
		return String.valueOf(intlist.get(0));
	}
	

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println(" min num :::: "+getMinumimFormedNum("132", 1));
		
	}

}
