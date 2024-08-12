package challenges.allarray;

import java.util.ArrayList;
import java.util.List;

public class WordCheck {
	
	public static String WordSplit(String[] strArr) {
	    // code goes here
	    if(strArr.length<1){
	      return null;
	    }

	    String word = strArr[0];
	    List<String> hlist = new ArrayList<>();

	    for(int i=1; i<strArr.length; i++){
	       hlist.add(strArr[i]);
	    }
	    System.out.println(hlist);
	    System.out.println(word);
	    StringBuilder sb = new StringBuilder();
	    
	    String[] strar = hlist.get(0).split(",");

	    if(wordBreak(word, strar, 0, sb)) {
	    	return sb.toString();
	    }
	    String newstr = sb.toString();
	    return newstr.substring(0, newstr.length()-1);
	  }

	  public static boolean wordBreak(String word, String[] strar, int start, StringBuilder sb){
		  System.out.println("in this method");
          
	     for(int i=0; i<strar.length; i++){
	    	System.out.println("in this method 2");
	        int len = strar[i].length();
	        int end = start + len;
            
	        if(end>word.length()){
	          continue;
	        }
	        
	        if(word.substring(start, start+len).equals(strar[i])){
	        	sb.append(strar[i]);
	            sb.append(",");
	        	
	            if(wordBreak(word, strar, start+len, sb)) {
	            	return true;
	            }  
	           
	        }
	    }
	    System.out.println(sb);
	    return false;

	  }

	  public static void main (String[] args) {  
	    // keep this function call here     
	    String[] str = {"hellocat","apple,bat,cat,goodbye,hello,yellow,why"};
	    System.out.print(WordSplit(str)); 
	  }

}
