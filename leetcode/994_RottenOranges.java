class Solution {
    public int orangesRotting(int[][] grid) {
        
        int minutes = 0;
        Queue<int[]> queue = getRottenOranges(grid);
      //  boolean [][]visited = new boolean[grid.length][grid[0].length];
        int dir[][] = { {0, 1} , {1, 0}, {0, -1}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s = 0; s<size; s++){
                int []curr = queue.remove();
                grid[curr[0]][curr[1]] =-2;
                
                for(int []d : dir){
                    int dx = curr[0] + d[0];
                    int dy = curr[1] + d[1];
                    
                    if(checkWithin(dx, dy, m, n) && grid[dx][dy] == 1){
                        queue.add(new int[]{dx, dy});
                        grid[dx][dy] = -2;
                    }
                }
                
                if(s == size-1){
                    minutes++;
                }
            }
            
        }
        int check = checkIfAllRotten(grid);
        if( check == 2){
            return minutes-1;
        }
        else if(check == 0)
        {
            return 0;
        }
        return -1;
    }
    
    public boolean checkWithin(int x , int y, int m, int n){
        if(x<0 || y < 0 || x >= m || y >= n){
            return false;
        }
        return true;
    }
    public int checkIfAllRotten(int [][]grid){
        int empty = 0;
        int total = grid.length * grid[0].length;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                
                if(grid[i][j] == 1){
                    return 1;
                }
                else if(grid[i][j] == 0){
                    empty++;
                }
                
            }
        }
        if(empty == total){
            return 0;
        }
        return 2;
    }
    
    public Queue<int[]> getRottenOranges(int [][]grid){
        Queue<int[]> rotten = new LinkedList<int[]>();
        
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                
                if(grid[i][j] == 2){
                    rotten.add(new int[]{i, j});
                }
            }
        }
        return rotten;
    }
}