import java.util.*;

class Chess
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int k = sc.nextInt();
            int [][]board = new int[8][8];
            for(int i = 0 ; i<8; i++)
            {
                for(int j =0 ; j< 8 ; j++)
                {
                    if( k==0 )
                        break;
                    board[i][j] = 1;
                    k--;
                }
                if(k==0)
                    break;
            }
            // print board
            // 1 - > free cell
            // 0 -> blocked
            for(int i = 0 ; i<8; i++)
            {
                for(int j =0 ; j< 8 ; j++)
                {
                    if(i==0 && j==0)
                        System.out.print("O");
                    else if( board[i][j] == 1)
                    {
                        System.out.print(".");
                    }
                    else
                        System.out.print("X");
                }
                System.out.println();
            }

            //System.out.println();
        }
    }
}