class Solution {
    int dirs[][] = {
        {0 , 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i<m ; i++){
            for(int j = 0; j<n ; j++){
                if(grid[i][j] == 1){
                    int area = DFS(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
        
    }
    
    public boolean checkWithin(int i, int j, int m, int n){
        if(i<0 || j < 0 || i >=m || j >= n){
            return false;
        }
        return true;
    }
    
    public int DFS(int [][]grid, int i, int j){
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add( new int[] {i, j});
        int area = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        while(!queue.isEmpty()){
            int []curr = queue.remove();
            grid[curr[0]][curr[1]] = -1;
            area++;
            for(int []d: dirs){
                int dx = curr[0] + d[0];
                int dy = curr[1] + d[1];
                if(checkWithin(dx, dy, m, n) && grid[dx][dy] == 1){
                    queue.add(new int[]{dx, dy});
                    grid[dx][dy] = -1;
                }
            }
        }
        return area;
    }
}