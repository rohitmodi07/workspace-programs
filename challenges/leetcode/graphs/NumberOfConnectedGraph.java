package leetcode.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumberOfConnectedGraph {
	
	//[[0,1],[1,2],[3,4]]    
	
		public static int numOfConnectedGraph(int n, int[][] graph) {
			if(n<1 || graph == null || graph.length<1)
				return -1;
			
			int numOfGraph = 0;
			
			Arrays.sort(graph, (a,b) -> Integer.compare(a[0], b[0]));
			int val = -1;
			
			for(int[] g : graph) {
				if(val == -1) {
					val = g[1];
				}
				if(val == g[0]) {
					val = g[1];
				}else {
					numOfGraph++;
					val = g[1];
				}
			}
			return numOfGraph;
			
		}
		
		/*
		 * n = 5, edges = [[0,1],[1,2],[3,4]]

	      Output: 2
		 */
		
		public static int numOfConnectedGraph1(int n, int[][] graph) {
			
			if(n<1 || graph == null || graph.length<1)
				return 0;
			
			int count = 0;
			
			Map<Integer, List<Integer>> gmap = buildMap(graph);
			System.out.println(" gmap :- "+gmap);
			
			Set<Integer> visited = new HashSet<>();
			
			for(Map.Entry<Integer, List<Integer>> et : gmap.entrySet()) {
				
				int key = et.getKey();
				
				if(explorer(gmap, key, visited)) {
					count++;
				}
				
			}
			
			return count;
			
		}


		private static boolean explorer(Map<Integer, List<Integer>> gmap, int key, Set<Integer> visited) {
			
			if(visited.contains(key))
				return false;
			
			visited.add(key);
			
			for(int neigh : gmap.get(key)) {
				explorer(gmap, neigh, visited);
			}
			
			return true;
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


		public static void main(String[] args){
			
			int[][] graph = {{0, 1}, {1, 2}, {3, 4},{4,5}, {6,7}};
			
			System.out.println(numOfConnectedGraph(5, graph));
	    }

}
