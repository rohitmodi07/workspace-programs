package leetcode.stacks;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	
	public static List<String> generateParenthesis(int n) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            res.add(new ArrayList<>());
        }
        res.get(0).add("");

        for (int k = 0; k <= n; k++) {
            for (int i = 0; i < k; i++) {
                for (String left : res.get(i)) {
                    for (String right : res.get(k - i - 1)) {
                        res.get(k).add("(" + left + ")" + right);
                    }
                }
            }
        }

        return res.get(n);
    }
    

	public static void main(String[] args) {

		System.out.println(" temps ::::: "+generateParenthesis(2));
		
	}

}
