import java.util.*;

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i=0, j=0;
        if (A.length == 0 || B.length == 0 )
        {
            return new int[0][0];
        }
        ArrayList< ArrayList<Integer>> res = new ArrayList<ArrayList <Integer>>();
        while(i<A.length && j<B.length)
        {
            //System.out.println("For i  and j "+i+", "+j);
            
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int first = Math.max( A[i][0], B[j][0]);
            int sec = Math.min( A[i][1], B[j][1]);
            if( first <= sec)
            {
                temp.add(first);
                temp.add(sec);
                res.add(temp);
            }
            
            //System.out.println("Temp"+temp);
            if ( A[i][1] < B[j][1])
            {
                i++;
               // if((i<A.length && j<B.length) &&  (B[j][1] < A[i][0]))
               // {
               //     j++;
               // }
            }
            else{
                j++;
               // if( (i<A.length && j<B.length) && (A[j][1] < B[i][0]))
               // {
               //     i++;
               // }
            }
        }

        // Convert arraylist to int [][]
        int [][]resarr = new int[res.size()][2];
        for(int k = 0; k< res.size(); k++)
        {
            ArrayList<Integer> t = res.get(k);
            resarr[k][0] = (int)t.get(0);
            resarr[k][1] = (int)t.get(1);

        }
        return resarr;
    }

}

public class IntervalIntersection
{
    public static void main(String []args)
    {
        Solution s  =  new Solution();
        // int [][]res = s.intervalIntersection(A, B);
        // System.out.print("[");
        // for(int []i: res)
        // {
        //     System.out.print(" ["+i[0]+","+i[1]+"] ");
        // }
        /* 
        A = [[1,3],[5,9]]      B = []
         A = [[0,2],[5,10],[13,23],[24,25]]
         B = [[1,5],[8,12],[15,24],[25,26]]

         A [[3,10]]
        [[5,10]]
        */
        int [][]A = {{3,10}};
        //{ {0,2}, {5,10}, {13, 23}, {24,25}};
        int [][]B = {{5,10}};
        //{ {1,5}, {8,12}, {15, 24}, {25,26}};
        //ArrayList< ArrayList<Integer>> res = s.intervalIntersection( A , B);
        int[][] res = s.intervalIntersection( A , B);
        for(int k = 0; k<res.length; k++)
        {
            System.out.println(res[k][0]+" , "+res[k][1]);
        }
        
    }
}