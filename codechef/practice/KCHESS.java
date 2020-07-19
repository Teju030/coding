import java.util.*;

class KCHESS
{
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int [][]knights = new int[n][2];
            for(int i=0; i<n ;i++)
            {
                knights[i][0] = sc.nextInt();
                knights[i][1] = sc.nextInt();
            }
            
            int []king = new int[2];
            king[0] = sc.nextInt();
            king[1] = sc.nextInt();

            int [][]k_moves = {
                { -1,-1} , { -1, 0}, { -1, 1},
                { 0, -1} , { 0, 0}, { 0, 1},
                { 1, -1} , { 1, 0}, { 1, 1}
            };
            for( int i=0; i< k_moves.length; i++)
            {   
                k_moves[i][0] = king[0] + k_moves[i][0];
                k_moves[i][1] = king[1] + k_moves[i][1];
            }
            int atk = 0;
            for(int i=0; i<k_moves.length; i++)
            {
                for(int j =0; j<n ; j++)
                {
                    if((Math.abs(k_moves[i][0] - knights[j][0]) == 1 && Math.abs(k_moves[i][1] - knights[j][1]) == 2)  ||
                    (Math.abs(k_moves[i][0] - knights[j][0]) == 2 && Math.abs(k_moves[i][1] - knights[j][1]) == 1) 
                    )
                    {
                        atk++;
                        break;
                    }
                }
            }
            if(atk == 9)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}