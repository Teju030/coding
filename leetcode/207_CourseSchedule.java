class Solution {
    HashMap<Integer, ArrayList<Integer>> edges;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new HashMap<>();
        
        // Adding edges in graph
        for(int i = 0; i<prerequisites.length; i++){
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            if(!edges.containsKey(course)){
                edges.put(course, new ArrayList<Integer>());
            }
            edges.get(course).add(prereq);
        }
        
        // now interate over all the element in graph
        
        
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> exploring = new HashSet<>();
        
        for(int i = 0 ; i<numCourses; i++){
            if(!visited.contains(i)){
                if(isCyclic(i, visited, exploring)){
                    return false;
                }
            }
        }
        
        return true;
        
    }
    public boolean isCyclic(int course, HashSet<Integer> visited, HashSet<Integer> exploring){
        if(exploring.contains(course))
            return true;
        if(visited.contains(course))
            return false;
        
        exploring.add(course);
        
        ArrayList<Integer> prereqs = edges.get(course);
        if(prereqs != null){
            for(int prereq: prereqs){
                if(!visited.contains(prereq))
                {
                    if(isCyclic(prereq, visited, exploring))
                        return true;
                }
            }
        }
        exploring.remove(course);
        visited.add(course);
        return false;
    }
}