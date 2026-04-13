package leetcode.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ValidGraph {
	
	// valid graph
		/*
		 * Input:
			n = 5
			edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
			
			Output:
			true

		 */
		
		public static boolean validGraph(int n, int[][] graph) {
			if(graph == null || graph.length<1)
				return false;
			if(graph.length>n-1)
				return false;
			
			List<List<Integer>> nodelist = new ArrayList<>();
			
			for(int i=0; i<n; i++) {
				nodelist.add(new ArrayList<>());
			}
			
			for(int[] g : graph) {
				nodelist.get(g[0]).add(g[1]);
				nodelist.get(g[1]).add(g[0]);
			}
			
			System.out.println(" nodelist :::: "+nodelist);
			
			Set<Integer> visit = new HashSet<>();
			if(!depth1stSearch(0, -1, visit, nodelist)) { // check if depth first search make you reach the leaf node
				return false;
			}
			
			return visit.size() == n;

		}
	    


		private static boolean depth1stSearch(int node, int parent, Set<Integer> visit, List<List<Integer>> nodelist) {
			
			if(visit.contains(node)) {   // loop detected hence return false
				return false;
			}
			
			visit.add(node);     // add node in visited list
			
			for(int nei : nodelist.get(node)) {  // go through each node from the list
				
				if(nei == parent) {   //  while backtracking if find visited node again just continue
					continue;
				}
				
				if(!depth1stSearch(nei, node, visit, nodelist)) {
					return false;
				}
			}
			return true;
		}
		
		// other solution
		
		/*
		 * 0 -> 1
		   1 -> 2,3,4
		   2 -> 3
		 */
		public static boolean isValidGraph(int n, int[][] graph) {
			if(n<1 || graph == null || graph.length<1)
				return false;
			
			Map<Integer, List<Integer>> nmap = buildMap(graph);
			
			System.out.println(nmap);
			
		    List<Integer> checkList = new ArrayList<>();
		    
		    for(Map.Entry<Integer, List<Integer>> ent : nmap.entrySet()) {
		    	
		    	List<Integer> mlist = ent.getValue();
		    	for(int v : mlist) {
		    		if(!checkList.contains(v)) {
		    			checkList.add(v);
		    		}else {
		    			return false;
		    		}
		    	}
		    	
		    }
			
			
			return true;
		}


		private static Map<Integer, List<Integer>> buildMap(int[][] graph) {
			
			Map<Integer, List<Integer>> nmap = new HashMap<>();
			for(int[] g : graph) {
				int from = g[0];
				int to = g[1];
				
				if(nmap.containsKey(from)) {
					List<Integer> ilist = nmap.get(from);
					ilist.add(to);
					nmap.put(from, ilist);
				}else {
					List<Integer> ilist = new ArrayList<>();
					ilist.add(to);
					nmap.put(from, ilist);
				}
			}
			
			return nmap;
		}

		public static boolean validTree(int n, int[][] edges) {
			
			if(n<1 || edges == null || edges.length<1 || edges.length>=n)
				return false;
			
			Arrays.sort(edges, (a,b) -> Integer.compare(a[0], b[0]));
			
			Map<Integer, List<Integer>> emap = new HashMap<>();
			
			for(int[] mat : edges) {
				int from = mat[0];
				int to = mat[1];
				
				if(!emap.containsKey(from)) {
					List<Integer> ilist = new ArrayList<>();
					ilist.add(to);
					emap.put(from, ilist);
				}else {
					List<Integer> ilist = emap.get(from);
					ilist.add(to);
					emap.put(from, ilist);
				}
			}
			
			Set<Integer> nset = new HashSet<>();
			
			for(Map.Entry<Integer, List<Integer>> et : emap.entrySet()) {
				
				List<Integer> nlist = et.getValue();
				for(int i : nlist) {
					if(!nset.add(i)) {
						return false;
					}
				}
				
			}
			return true;

	    }


		public static void main(String[] args) {

			
	        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4} };
			
	        System.out.println(" is valid graph :::: "+validGraph(5, edges));
	        
			
		    System.out.println(validTree(5, edges));
		    
	        int[][] edges1 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
			
		    System.out.println(validTree(5, edges1));
			
			
		}

}
