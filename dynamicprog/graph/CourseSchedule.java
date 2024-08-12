package dynamicprog.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {
	
	// O(V + E)
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
    	
    	if(numCourses<=0)
    		return false;
    	if(prerequisites == null || prerequisites.length<1)
    		return true;
    	
        // build a graph
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0];
            int to = prerequisite[1];

            if (!graph.containsKey(from)) 
            	graph.put(from, new ArrayList<>());
            
            if (!graph.containsKey(to)) 
            	graph.put(to, new ArrayList<>());

            graph.get(from).add(to);
        }
        
        System.out.println(" graph is ::: "+graph);

        // DFS
        for (Map.Entry<Integer, ArrayList<Integer>> entry : graph.entrySet()) {
            Integer node = entry.getKey();
            Set<Integer> visited = new HashSet<Integer>();
            if (!DFS(graph, node, visited)) {
                return false;
            }
        }
        return true;
    }

    public static Boolean DFS(Map<Integer, ArrayList<Integer>> graph, Integer curr, Set<Integer> visited) {
        if (visited.contains(curr)) 
        	 return false; // Detected a loop! return false

        if (graph.get(curr).isEmpty()) 
        	 return true; // Reached the end

        visited.add(curr);

        for (Integer neighbor : graph.get(curr)) {
            if (!DFS(graph, neighbor, visited)) 
            	return false;
        }

        // we have completed traversing this path.
        // Remove it from the set
        // also set the neighbors to empty so that it reaches line 29 and returns true immediately
        visited.remove(curr);
        graph.put(curr, new ArrayList<>());

        return true;
    }
    
   public static boolean canFinishCourse(int numCourses, int[][] preReq) {
    	
    	if(numCourses<=0)
    		return false;
    	if(preReq == null || preReq.length<1)
    		return true;
    	
    	Map<Integer, List<Integer>> graph = buildGraph(preReq);
    	
    	for(Map.Entry<Integer, List<Integer>> ent : graph.entrySet()) {
    		
    		Set<Integer> visited = new HashSet<>();
    		int key = ent.getKey();
    		
    		if(!depthFirstSearch(graph, key, visited)) {
    			return false;
    		}
    		
    	}
    	
    	return true;
    }
    
    public static Map<Integer, List<Integer>> buildGraph(int[][] preReq){
    	
    	Map<Integer, List<Integer>> mgraph = new HashMap<>();
    	for(int[] pre : preReq) {
    		int from = pre[0];
    		int to = pre[1];
    		
    		if(!mgraph.containsKey(from)) {
    			mgraph.put(from, new ArrayList<>());
    		}
    		if(!mgraph.containsKey(to)) {
    			mgraph.put(to, new ArrayList<>());
    		}
    		
    		mgraph.get(from).add(to);
    	}
    	
    	return mgraph;
    }
    
    

	private static boolean depthFirstSearch(Map<Integer, List<Integer>> graph, int key, Set<Integer> visited) {
		
		if(visited.contains(key)) {
			return false;
		}
		
		if(graph.get(key).isEmpty()) {
			return true;
		}
		
		visited.add(key);
		
		for(int neighbor : graph.get(key)) {
			if(!depthFirstSearch(graph, neighbor, visited)) {
				return false;
			}
		}
		
		visited.remove(key);
		graph.put(key, new ArrayList<>());
		
		return true;
	}

	public static void main(String[] args) {
		int course = 5;
		int[][] prerequisites = {{0,1},{0,2},{1,3},{1,4},{3,4}};
		
		System.out.println(" can finish the course :::: "+canFinishCourse(course, prerequisites));
		
		int course1 = 3;
		int[][] prerequisites1 = {{0,1},{1,2},{2,0}};
		
		System.out.println(" can finish the course :::: "+canFinishCourse(course1, prerequisites1));

	}

}
