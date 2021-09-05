class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] a = new int[n+1];
        int []b = new int[n+1];
        
        for(int i =0; i<trust.length; i++){
            int []tmp = trust[i];
            a[tmp[0]]++;
            b[tmp[1]]++;
        }
        
        int judge = 0;
        
        for( int i = 1; i < a.length; i++)
        {
            if(a[i]==0)
            {
                judge = i;
            }
        }
        if(b[judge] != n-1)
            return -1;
        return judge;
    }
}