
class NQueen
{
    class Position
    { 
        int row, col;
        Position(int r, int c )
        {
            row = r;
            col = c;
        }
        
    }

    Position[] solve(int N)
    {
        Position []queens = new Position[N];
        if(placeQueens(N, 0, queens))
            return queens;
        else
            return new Position[0];
    }
    boolean isSafe(Position queen, int r, int c)
    {
        if(queen.col == c || (queen.row - queen.col) == (r-c) || (queen.row + queen.col) == (r+c))
            return false;
        return true;
    }
    boolean placeQueens(int n, int row, Position []queens)
    {
        System.out.println("\nFor row, n :" + row);
        if(n == row ) return true;
        int col ;
        
        for( col = 0; col< n; col++)
        {
            boolean safeplace = true;
            for( int i = 0 ; i <row; i++)
            {
                if(!isSafe(queens[i], row, col))
                {
                    safeplace = false;
                    break;  
                }
            }
            if(safeplace)
            {
                queens[row] = new Position(row, col);
                if(placeQueens(n, row+1, queens)) return true;
            }
        }
        
        return false;
    }

    public static void main(String []args)
    {
        NQueen nq = new NQueen();
        Position []ans = nq.solve(4);
        System.out.println("Final positions of queens : ");
        for(Position p : ans)
        {
            System.out.println(p.row +"  "+p.col);
        }
    }       
}