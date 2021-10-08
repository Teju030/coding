class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean []visited = new boolean[numCourses];
        boolean []exploring = new boolean[numCourses];
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i = 0 ; i<prerequisites.length; i++){
            int x = prerequisites[i][0]; 
            int y = prerequisites[i][1];

            if(adjList.containsKey(x)){
                adjList.get(x).add(y);
            }
            else{
                adjList.put(x, new ArrayList<Integer>());
                adjList.get(x).add(y);
            }
        }
        
        for(int i = 0 ; i<numCourses; i++){
            if(!visited[i]){
                boolean tmp = DFS(adjList, i, visited, exploring, stack);
                if(tmp) return new int[0];
            }
            
        }
        
        int[] res = new int[numCourses];
        int c = numCourses-1;
        while(!stack.isEmpty()){
            int tmp = stack.pop();
            res[c] = tmp;
            c--;
        }
        return res;
        
    }
    
    public boolean DFS(HashMap<Integer, List<Integer>> adjList, int start, boolean[]visited, boolean []exploring, Stack<Integer>stack){

        // get neighbors
        exploring[start] = true;
        for(Integer neighbor: adjList.getOrDefault(start, new ArrayList<>())){
            if(exploring[neighbor]){
                return true;
            }
            
            if(!visited[neighbor]){
                exploring[neighbor] = true;
                boolean tmp = DFS(adjList, neighbor, visited, exploring, stack);
                if(tmp) return tmp;
                exploring[neighbor] = false;
                visited[neighbor] = true;
            }

        }
        exploring[start] = false;
        visited[start] = true;
        stack.push(start);
        return false;
                 
    }
    
    
}