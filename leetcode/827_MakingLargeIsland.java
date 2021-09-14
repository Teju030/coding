class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int colors[] = new int[n*m + 2];
        int c = 2;
        for(int i = 0; i< n ; i++){
            for(int j = 0; j< m ; j++){
                colors[c] = DFS(grid, i, j, c);
                c++;
            }
        }
        
        // System.out.println("Colors : " + Arrays.toString(colors));
        // for(int[] a: grid){
        //     System.out.println("Grid : " + Arrays.toString(a));
        // }
        int max_size = 0;
        // Traverse the matrix 
        int [][]dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean flag = false;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < m ; j++){
                
                if(grid[i][j] == 0){
                    flag = true;
                    set = new HashSet<Integer>();
                    for(int []d: dir){
                        //System.out.println("Grid cell : " + (i + d[0]) +"  "+ (j+ d[1]));
                        if(isSafe(grid, i + d[0], j+ d[1])){
                            
                            set.add(grid[i + d[0]][j+ d[1]]);
                        } 
                    }
                    
                   // System.out.println("Set : " + set);
                    int size = 1;
                    for(int s: set){
                        size += colors[s];
                    }
                    max_size = Math.max(max_size, size);
                }
                
            }
        }
        
        max_size = flag ? max_size: n*m;
        
        return max_size;
    }
    public boolean isSafe(int[][] grid, int x, int y){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0)
            return false;
        return true;
    }
    public int DFS(int[][] grid, int x, int y, int color){
        // edge cases 
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
            return 0;
        
        if (grid[x][y] != 1) return 0;
        
        grid[x][y] = color;
        
        int res = 1 + DFS(grid, x + 1, y, color) + 
                    DFS(grid, x - 1, y, color) + 
                    DFS(grid, x, y + 1, color) + 
                    DFS(grid, x, y - 1, color);
        
        return res;
    }
}