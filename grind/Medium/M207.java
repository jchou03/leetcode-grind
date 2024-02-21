package grind.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// runtime: 28%, memory: 68%

public class M207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // the prereqs form a directed graph (represented with adjacency list)
        HashMap<Integer, HashSet<Integer>> adj = new HashMap<Integer, HashSet<Integer>>();
        // determine if there is a cycle using graph exploration (dfs)
        for(int i = 0; i < prerequisites.length; i++){
            int[] cur = prerequisites[i];
            if(!adj.containsKey(cur[1])){
                adj.put(cur[1], new HashSet<Integer>());
            }
            adj.get(cur[1]).add(cur[0]);
        }
        // System.out.println(adj);
        for(int i = 0; i < numCourses; i++){
            if(!dfs(adj, i, new HashSet<Integer>())){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(HashMap<Integer, HashSet<Integer>> adj, int id, Set<Integer> visited){
        // return false if there is a cycle
        if(visited.contains(id)){
            return false;
        }else{
            visited.add(id);
            // System.out.println("visiting: " + id);
            if(adj.containsKey(id)){
                // System.out.println(adj.get(id));
                for(int i : adj.get(id)){
                    // System.out.println("visited" + visited);
                    if(!dfs(adj, i, visited)){
                        return false;
                    }
                }
            }
            visited.remove(id);
            adj.put(id, new HashSet<Integer>()); // magic to optimize for runtime
            return true;
        }
    }
}
