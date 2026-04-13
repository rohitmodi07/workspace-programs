package leetcode.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RedundantConnection {
	
	public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            boolean[] visit = new boolean[n + 1];

            if (dfs(u, -1, adj, visit)) {
                return edge;
            }
        }
        return new int[0];
    }

    private boolean dfs(int node, int parent, 
                        List<List<Integer>> adj, boolean[] visit) {
        if (visit[node]) {
            return true;
        }

        visit[node] = true;
        for (int nei : adj.get(node)) {
            if (nei == parent) {
                continue;
            }
            if (dfs(nei, node, adj, visit)) {
                return true;
            }
        }
        return false;
    }
    
    public static int[] findRedundantConnectionNew(int[][] edges) {
    	
    	if(edges == null || edges.length<1)
    		return null;
    	
    	Map<Integer, List<Integer>> emap = new LinkedHashMap<>();
    	
    	for(int[] e : edges) {
    		int from = e[0];
    		int to = e[1];
    		
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
    	System.out.println(emap);
    	
    	Set<Integer> iset = new HashSet<>();
    	
    	for(Map.Entry<Integer, List<Integer>> et : emap.entrySet()) {
    		
    		List<Integer> lst = et.getValue();
    		
    		for(int v : lst) {
    			if(!iset.add(v)) {
    				return new int[] {et.getKey(), et.getValue().get(0)};
    			}
    		}
    		
    	}
    	
    	return null;
        
    }



	public static void main(String[] args) throws InterruptedException {
		
		int[][] graph = {{1,2},{1,3},{2,4},{3,4}};
		RedundantConnection rd = new RedundantConnection();
		System.out.println(Arrays.toString(rd.findRedundantConnection(graph)));
		
		int[][] edges = {{1,2},{1,3},{3,4},{2,4}};
		System.out.println(Arrays.toString(findRedundantConnectionNew(edges)));
		  
		int[][] edges1 = {{1,2},{1,3},{1,4},{3,4},{4,5}};
		System.out.println(Arrays.toString(findRedundantConnectionNew(edges1)));
		
	}

}
