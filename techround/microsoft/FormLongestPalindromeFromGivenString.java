package techround.microsoft;

import java.util.HashMap;
import java.util.Map;

public class FormLongestPalindromeFromGivenString {
	
	public static int longestPalindrome(String[] words) {

        Map<String, Integer> m= new HashMap<>();

        int ans=0, free_equal=0;

        for( String x: words){

            if(  x.charAt(0)==x.charAt(1)){

                if(m.getOrDefault( x,0)>0){
                    m.put(x,0);
                    free_equal--;

                    ans+=4;
                }
                else{
                    m.put(x,1);
                    free_equal++;
                }
            }
            else {
// if x= ab search for ba, otherwise if x=ba then search for ab
                     String search_key= x.charAt(1)+""+x.charAt(0);
                    if( m.getOrDefault( search_key,0)>0){
                        m.put(search_key,m.get(search_key)-1);

                        ans+=4;
                    }
                    else{
                         m.put(x,m.getOrDefault( x,0)+1);
                    }
                }
              
            }


            if( free_equal>0) ans+=2;

            return ans;
        }
	
	public static void main(String[] args) {
		
		System.out.println(" longest palindrome :::: "+longestPalindrome(new String[] {"cl", "ty", "yt", "lc"}));
	}

}
