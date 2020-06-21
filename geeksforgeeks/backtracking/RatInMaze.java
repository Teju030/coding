class RatInMaze
{
    int maze[][];
    int path[][];
    RatInMaze(int [][]maze)
    {
        this.maze = maze;
        path = new int[maze.length][maze.length];
    }
    boolean move(int i, int j)
    {
        if( i == maze.length-1 && j == maze.length-1)
        {   path[i][j] = 1;
            return true;
        }
        if(!isSafe(i, j ))  return false;
        path[i][j] = 1;
        if(move(i, j+1)) return true;
        else if(move(i+1, j)) return true;
        path[i][j] = 0;
        return false;
    }
    boolean isSafe(int i, int j)
    {
        if(i>=maze.length || j >= maze.length)
            return false;
        else if(maze[i][j] == 0)
            return false;
        return true;
    }
    void printPath()
    {
        for( int i = 0; i< path.length; i++)
        {
            for(int j=0; j<path.length; j++)
                System.out.print(path[i][j]+ " ");
            System.out.println();
        }                
    }
    public static void main(String []args)
    {
        int m[][] = {
            {2, 1, 0, 0},
            {3, 0, 0, 1},
            {0, 1, 0, 1},
            {1, 1, 1, 1}
        };

        RatInMaze r = new RatInMaze(m);
        boolean res = r.move(0,0);
        if(res)
        {
            r.printPath();
        }
        else    
            System.out.println("No path availble");
    }
}