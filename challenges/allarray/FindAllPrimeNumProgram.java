package challenges.allarray;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FindAllPrimeNumProgram {

	private static boolean isPrime(int num) {
		if(num<=2)
			return false;
		
		for (int i = 2; i <= num/2; i++) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static Object[] findAllPrimeNumbers(int num) {
		if(num<1)
			return null;
		List<Integer> lst = new ArrayList<>();
		for (int i = 1; i <= num; i++) {
			if(i == 1 || i == 2)
				continue;
			boolean isPrime = true;
			for (int j = 2; j <= i/2; j++) {
				if(i%j == 0) {
					isPrime = false;
				}
			}
			if(isPrime) {
				lst.add(i);
			}
		}
		return lst.toArray();
	}
	
	private static Object[] findAllPrimeNumbersWithinGivenRange(int start, int end) {
		if(start<1 || end<1 || start>end)
			return null;
		List<Integer> lst = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			if(i == 1 || i == 2)
				continue;
			boolean isPrime = true;
			for (int j = 2; j <= i/2; j++) {
				if(i%j == 0) {
					isPrime = false;
				}
			}
			if(isPrime) {
				lst.add(i);
			}
		}
		return lst.toArray();
	}
	
	private static Object[] findAllPrimeNumbersWithinGivenRangeExcludeGivenNum(int start, int end) {
		if(start<1 || end<1 || start>end)
			return null;
		List<Integer> lst = new ArrayList<>();
		for (int i = start; i < end; i++) {
			if(i == 1 || i == 2)
				continue;
			boolean isPrime = true;
			for (int j = 2; j <= i/2; j++) {
				if(i%j == 0) {
					isPrime = false;
				}
			}
			if(isPrime) {
				if(i!=start) {
				  lst.add(i);
				}
			}
		}
		return lst.toArray();
	}

	public static void main(String[] args) {
		System.out.println(isPrime(3));
		System.out.println(isPrime(4));
		System.out.println(isPrime(9));
		System.out.println(isPrime(13));
		
		System.out.println(Arrays.toString(findAllPrimeNumbers(10)));
		
		System.out.println(Arrays.toString(findAllPrimeNumbersWithinGivenRange(8,17)));
		
		System.out.println(Arrays.toString(findAllPrimeNumbersWithinGivenRangeExcludeGivenNum(5,17)));
	}

}
