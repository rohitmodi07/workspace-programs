package leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class LargestSmallestConnectedGraph {
	
   public static int largestComponent(int n, int[][] graph) {
		
		if(n<1 || graph == null || graph.length<1)
			return 0;
		
		int maxc = Integer.MAX_VALUE;
		
		Map<Integer, List<Integer>> gmap = buildMap(graph);
		System.out.println(" gmap :- "+gmap);
		
        Set<Integer> visited = new HashSet<>();
		
		for(Map.Entry<Integer, List<Integer>> et : gmap.entrySet()) {
			
			int key = et.getKey();
			
			if(explorer1(gmap, key, visited)) {
				maxc = Math.min(maxc, visited.size());
				visited = new HashSet<>();
			}
			
		}
		
		return maxc;
		
		
	}
	
    public static int smallestComponent(int n, int[][] graph) {
		
		if(n<1 || graph == null || graph.length<1)
			return 0;
		
		int maxc = Integer.MAX_VALUE;
		
		Map<Integer, List<Integer>> gmap = buildMap(graph);
		System.out.println(" gmap :- "+gmap);
		
        Set<Integer> visited = new HashSet<>();
		
		for(Map.Entry<Integer, List<Integer>> et : gmap.entrySet()) {
			
			int key = et.getKey();
			
			if(explorer1(gmap, key, visited)) {
				maxc = Math.min(maxc, visited.size());
				visited = new HashSet<>();
			}
			
		}
		
		return maxc;
		
		
	}
	
    private static boolean explorer1(Map<Integer, List<Integer>> gmap, int key, Set<Integer> visited) {
		
		if(visited.contains(key))
			return false;
		
		visited.add(key);
		
		for(int neigh : gmap.get(key)) {
			explorer1(gmap, neigh, visited);
		}
		
		return true;
	}
    
    public static int largestComponent1(int n, int[][] graph) {
		
		if(n<1 || graph == null || graph.length<1)
			return 0;
		
		int maxc = 0;
		
		Map<Integer, List<Integer>> gmap = buildMap(graph);
		System.out.println(" gmap :- "+gmap);
		
        Set<Integer> visited = new HashSet<>();
		
		for(Map.Entry<Integer, List<Integer>> et : gmap.entrySet()) {
			
			int key = et.getKey();
			
			int size = explorer2(gmap, key, visited);
			
			maxc = maxc>size ? maxc : size;
			
		}
		
		return maxc;
		
		
	}
	
    private static int explorer2(Map<Integer, List<Integer>> gmap, int key, Set<Integer> visited) {
		
		if(visited.contains(key))
			return 0;
		
		visited.add(key);
		
		int size = 1;
		
		for(int neigh : gmap.get(key)) {
			size += explorer2(gmap, neigh, visited);
		}
		
		return size;
	}


	private static Map<Integer, List<Integer>> buildMap(int[][] graph) {
		
		Map<Integer, List<Integer>> gmap = new HashMap<>();
		
		for(int[] g : graph) {
			
			int from = g[0];
			int to = g[1];
			
			if(!gmap.containsKey(from)) {
				gmap.put(from, new ArrayList<>());
			}
			
			if(!gmap.containsKey(to)) {
				gmap.put(to, new ArrayList<>());
			}
			
			gmap.get(from).add(to);
			gmap.get(to).add(from);
		}
		
		return gmap;
	}


	public static void main(String[] args) {  
		
		
		int[][] graph = {{0,1},{1,2},{2,3},{4,5}, {5,6}};
		
		System.out.println(largestComponent(7, graph));
		
    }

}
