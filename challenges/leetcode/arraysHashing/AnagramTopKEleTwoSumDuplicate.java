package leetcode.arraysHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class AnagramTopKEleTwoSumDuplicate {
	
	// valid anagram, group anagram
	
		public static boolean validAnagram(String str1, String str2) {
			if(str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty() || str1.length() != str2.length())
				return false;
			
			char[] c1 = str1.toCharArray();
			char[] c2 = str2.toCharArray();
			
			Arrays.sort(c1);
			Arrays.sort(c2);
			
			return Arrays.equals(c1, c2);
				
		}
		
		public static List<List<String>> groupAnagram(String[] sarr){
			if(sarr == null || sarr.length<1)
				return new ArrayList<>();
			
			List<List<String>> groupAnagramList = new ArrayList<>();
			
			for(int i=0; i<sarr.length; i++) {
				String st1 = sarr[i];
				
				boolean doesExist = groupAnagramList.stream().anyMatch(lst -> lst.contains(st1));
				if(doesExist) {
					continue;
				}
				
				char[] c1 = st1.toCharArray();
				
				Arrays.sort(c1);
				
				List<String> lt = new ArrayList<>();
				lt.add(st1);
				
				for(int j=i+1; j<sarr.length; j++) {
					String st2 = sarr[j];
					char[] c2 = st2.toCharArray();
					
					Arrays.sort(c2);
					
					if(Arrays.equals(c1, c2)) {
						lt.add(st2);
					}
				}
				groupAnagramList.add(lt);
			}
			return groupAnagramList;
		}
		
		// two sum
		
		public static List<List<Integer>> twoSum(int[] nums, int target){ // 1,2,5,7,9  12 , 11-0 10-1 7-2 
			if(nums == null || nums.length<1)
				return new ArrayList<>();
			
			Map<Integer, Integer> numMap = new HashMap<>();
			List<List<Integer>> grpIndex = new ArrayList<>();
			
			for(int i=0; i<nums.length; i++) {
				if(!numMap.containsKey(nums[i])) {
					numMap.put(target-nums[i], i);
				}else {
					List<Integer> lst = new ArrayList<>();
					lst.add(numMap.get(nums[i]));
					lst.add(i);
					
					grpIndex.add(lst);
				}
			}
			return grpIndex;
		}
		
		// contains duplicates
		
		public static boolean containsDuplicate(int[] nums) {
			if(nums == null || nums.length<1)
				return false;
			
			int i=0;
			int j = nums.length-1;
			
			Set<Integer> numset = new HashSet<>();
			
			while(i<j) {
				if(!(numset.add(nums[i]) && numset.add(nums[j]))) {
					return true;
				}
				i++;
				j--;
			}
			return false;
		}
		
		// top k elements
		/*
		 * Input: nums = [1,2,2,3,3,3], k = 2  Output: [2,3]

		 */
		
		public static List<Integer> topKElements(int[] nums, int k){  // 1,2,2,2,3,3,3,3,4,4
			if(nums == null || nums.length<1)
				return new ArrayList<>();
			Map<Integer, Integer> hmap = new HashMap<>();
			
			for(int i=0; i<nums.length; i++) {
				hmap.put(nums[i], hmap.getOrDefault(nums[i], 0)+1);
			}
			
			System.out.println(" before sort ::: "+hmap);
			
			Map<Integer, Integer> sortBasedOnValue = hmap.entrySet().stream().sorted(Map.Entry.comparingByValue())
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)->e2, LinkedHashMap::new));
			
			System.out.println(" after sort ::: "+sortBasedOnValue);
			
		   
			Stack<Integer> stk = new Stack<>();
			List<Integer> lst = new ArrayList<>();
			
			for(Map.Entry<Integer, Integer> entry : sortBasedOnValue.entrySet()) {
				stk.push(entry.getKey());
			}
			
			while(k>0) {
				lst.add(stk.pop());
				k--;
			}
			
			
			return lst;
			
		}
		
		public static List<Integer> topKFreqNumbers(int[] nums, int k) { 
			if(nums == null || nums.length<1)
				return new ArrayList<>();
			
			Map<Integer, Integer> nummap = new HashMap<>();
			//Arrays.sort(nums);
			
			for(int i=0; i<nums.length; i++) {
				nummap.put(nums[i], nummap.getOrDefault(nums[i], 0)+1);
			}
			
			List<Integer> ilist = new ArrayList<>();
			
			Map<Integer, Integer> sortedMap = nummap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(
					Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)->e2, LinkedHashMap::new));
			
			System.out.println(sortedMap);
			
			int count=0;
			
			for(Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
				
				if(count >=sortedMap.size()-k) {
					ilist.add(entry.getKey());
				}
				count++;
				
			}
			
			return ilist;
			
		}

		public static void main(String[] args) {
			
			int[] nums = {7,7};
			System.out.println(" top K Elements :::: "+topKElements(nums, 1));
			
		}

}
