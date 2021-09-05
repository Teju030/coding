class Solution {
    class Pair{
        int r, c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    boolean isValid(boolean [][]visited, int r, int c){
        if( r < 0 || r>=visited.length || c < 0 || c >= visited[0].length)
            return false;
        
        if(visited[r][c])
            return false;
        return true;
    }
    
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        boolean [][]visited = new boolean[rows][cols];
        int islands = 0;
        for(int i = 0; i<rows; i++) {
            for( int j = 0; j<cols; j++) {
                if(isValid(visited, i, j) && grid[i][j] == '1')
                {
                    islands++;
                    DFS(grid, visited, i, j);
                }
            }
        }
        return islands;
    }
    
    public void DFS(char[][] grid, boolean [][]visited, int r, int c){
        
        Stack<Pair> stack = new Stack<Pair>();
        stack.push(new Pair(r, c));
        
        int [][]dir = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            visited[p.r][p.c] = true;
            // visit neighbours
            for( int i =0 ; i< 4; i++){
                int tr = p.r + dir[i][0];
                int tc = p.c + dir[i][1];
                if(isValid(visited,tr, tc) && grid[tr][tc] == '1')
                {
                    stack.push(new Pair(tr, tc));
                }
            }
        }
        
    }
}