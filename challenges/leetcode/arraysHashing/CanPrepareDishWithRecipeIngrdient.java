package leetcode.arraysHashing;

import java.util.Arrays;

public class CanPrepareDishWithRecipeIngrdient {
	
public static boolean[] canPrepareDish(String[] recipes, String[] ingredients) {
		
		if(recipes == null || recipes.length<1 || ingredients == null || ingredients.length<1)
			return new boolean[0];
		
		boolean[] exist = new boolean[recipes.length];
		
		for(int i=0; i<recipes.length; i++) {
			
			exist[i] = doesDishPossible(recipes[i], ingredients);
		}
		
		return exist;
		
	}
    

	private static boolean doesDishPossible(String recipe, String[] ingredients) {
		
		int k=0;
		
		for(int i=0; i<ingredients.length; i++) {
			
			if(k<recipe.length()) {
			
				String st1 = ingredients[i];
				System.out.println(" st1 :::: " +st1);
				System.out.println(" recipe :::: "+recipe);
				
				int len = recipe.length()-k;
				
				if(len<st1.length()) {
					return false;
				}
				
				String st2 = recipe.substring(k, k+st1.length());
				
				if(!st1.equals(st2)) {
					return false;
				}else {
					k = k+st1.length();
				}
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		String[] ingredients = {"flour", "sugar", "egg"};
		String[] recepie = {"floursugar", "flouregg", "random", "sugaregg", "floursugaregg"};
		
		System.out.println(" exist ::: "+Arrays.toString(canPrepareDish(recepie, ingredients)));
      
	}

}
